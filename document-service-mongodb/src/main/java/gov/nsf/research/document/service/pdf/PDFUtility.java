package gov.nsf.research.document.service.pdf;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitWidthDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.util.Overlay;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.pdmodel.common.PDMetadata;


public class PDFUtility {

	public static OutputStream concatenateDocuments(List<ByteArrayOutputStream> outputStreamList){

		PDFMergerUtility pmUtility = new PDFMergerUtility();
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		pmUtility.setDestinationStream(output);

		for(ByteArrayOutputStream baos : outputStreamList){
			pmUtility.addSource(convertToInputStream(baos));
		}

		try {
			pmUtility.mergeDocuments();
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//prepareBookMarksForPDF(convertToInputStream(output));
		return output;
	}

	private static ByteArrayInputStream convertToInputStream(ByteArrayOutputStream outputStream){
		return new ByteArrayInputStream(outputStream.toByteArray());
	}



	public static String printPDFMetaData(ByteArrayInputStream stream)

	{

		PDDocument document = null;


		try {
			document = PDDocument.load(stream);

			PDMetadata metadata = new PDMetadata(document);

			//System.out.println("**"+metadata.toString());


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				document.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally
		{
			try {
				document.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}



	public  static boolean validatePDFDocument(ByteArrayInputStream stream, String tempPropId)

	{

		PDFTextStripper stripper;
		String text = null;
		PDDocument document = null;

		boolean isValidPDF = true;

		try {
			document = PDDocument.load(stream);

			if(document.isEncrypted())
			{
			isValidPDF = false;
			System.out.println("Error Message: ( Temp Prop Id:"+tempPropId+ " PDF Document is password Protected or encrypted"	);
			}
			//Check if document has an image or empty text
			stripper = new PDFTextStripper();
			text = stripper.getText(document);
			//System.out.println("PDF ** text length" + text.length());
			
			if(!document.isEncrypted())
			{
				if (text.length() <= 3) {
					isValidPDF = false;
					System.out.println("Error Message: ( Temp Prop Id:"+tempPropId+ " PDF Document has an image only"	);
				}
			}
			
			
			

			/*
			 * PDDocumentInformation info = document.getDocumentInformation();
			 * System.out.println( "Page Count=" + document.getNumberOfPages()
			 * ); System.out.println( "Title=" + info.getTitle() );
			 * System.out.println( "Author=" + info.getAuthor() );
			 * System.out.println( "Subject=" + info.getSubject() );
			 * System.out.println( "Keywords=" + info.getKeywords() );
			 * System.out.println( "Creator=" + info.getCreator() );
			 * System.out.println( "Producer=" + info.getProducer() );
			 * System.out.println( "Creation Date=" + info.getCreationDate() );
			 * System.out.println( "Modification Date=" +
			 * info.getModificationDate()); System.out.println( "Trapped=" +
			 * info.getTrapped() );
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				document.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

			if (document != null) {
				try {
					document.close();
					// stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isValidPDF;

	}



	public static ByteArrayOutputStream createPDFDocumentFromText( String text)
	{
		//file.writeTo(outputStream);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


		PDDocument doc = null;
		try
		{
			doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(doc, page);

			PDFont pdfFont = PDType1Font.HELVETICA;
			float fontSize = 12;
			float leading = 1.5f * fontSize;

			PDRectangle mediabox = page.findMediaBox();
			float margin = 72;
			float width = mediabox.getWidth() - 2*margin;
			float startX = mediabox.getLowerLeftX() + margin;
			float startY = mediabox.getUpperRightY() - margin;


			List<String> lines = new ArrayList<String>();
			int lastSpace = -1;
			while (text.length() > 0)
			{
				int spaceIndex = text.indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = text.length();
				String subString = text.substring(0, spaceIndex);
				float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
				//System.out.printf("'%s' - %f of %f\n", subString, size, width);
				if (size > width)
				{
					if (lastSpace < 0)
						lastSpace = spaceIndex;
					subString = text.substring(0, lastSpace);
					lines.add(subString);
					text = text.substring(lastSpace).trim();
					// System.out.printf("'%s' is line\n", subString);
					lastSpace = -1;
				}
				else if (spaceIndex == text.length())
				{
					lines.add(text);
					// System.out.printf("'%s' is line\n", text);
					text = "";
				}
				else
				{
					lastSpace = spaceIndex;
				}
			}

			contentStream.beginText();
			contentStream.setFont(pdfFont, fontSize);
			contentStream.moveTextPositionByAmount(startX, startY);
			for (String line: lines)
			{
				contentStream.drawString(line);
				contentStream.moveTextPositionByAmount(0, -leading);
			}
			contentStream.endText();
			contentStream.close();

			doc.save(outputStream);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (doc != null)
			{
				try {
					doc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return outputStream;
	}


	/**
	 * This Method will Create Entire  Proposal and Generates LeftSide Navigation.
	 * @param tempPropId
	 * @param baos
	 * @param projDesc
	 * @param dmpPlan
	 */
	public static ByteArrayOutputStream CreateEntireProposal(String tempPropId, ByteArrayOutputStream toc, ByteArrayOutputStream baos,ByteArrayOutputStream projDesc,ByteArrayOutputStream dmpPlan,
			ByteArrayOutputStream caps,ByteArrayOutputStream bs,ByteArrayOutputStream ment, ByteArrayOutputStream projsumm){

		ByteArrayOutputStream ba = new ByteArrayOutputStream();

		PDDocument document = null;

		try
		{

			ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());
			document = PDDocument.load(in);


			//				ByteArrayOutputStream pd = docServiceDao.viewDocument(tempPropId, SectionType.PROJECT_DESCRIPTION);
			String pdTitle = "Project Description";
			String dmpTitle = "Data Management Plan";
			String capsTitle = "Current & Pending Support";
			String mentTitle = "Mentoring Plan";
			String bsTitle = "Bio Sketches";

			int tc = 0;
			int pdPageCount = 0;
			int dmpPageCount = 0;
			int capsPageCount = 0;
			int bsPageCount = 0;
			int mentPageCount = 0;
			int projsummPageCount = 0;


			//				ByteArrayOutputStream dmp = docServiceDao.viewDocument(tempPropId, SectionType.DATA_MANAGEMENT_PLAN);

			if (toc.toByteArray().length > 0 ){
				tc = getPageCount(toc.toByteArray());
			}

			if (projDesc.toByteArray().length > 0 ){
				pdPageCount = getPageCount(projDesc.toByteArray());
			}

			if (dmpPlan.toByteArray().length > 0 ){
				dmpPageCount = getPageCount(dmpPlan.toByteArray());
			}
			if (caps.toByteArray().length > 0 ){
				capsPageCount = getPageCount(caps.toByteArray());
			}
			if (bs.toByteArray().length > 0 ){
				bsPageCount = getPageCount(bs.toByteArray());
			}
			if (ment.toByteArray().length > 0 ){
				mentPageCount = getPageCount(ment.toByteArray());
			}
			if (projsumm.toByteArray().length > 0 ){
				projsummPageCount = getPageCount(projsumm.toByteArray());
			}

			//System.out.println("PDFUtility.CreateEntireProposal() tc ["+tc+"] &&  pdPageCount ["+pdPageCount+"] &&  dmpPageCount ["+dmpPageCount+"] &&  capsPageCount ["+capsPageCount+"] &&  bsPageCount ["+bsPageCount+"] &&  bsPageCount ["+bsPageCount+"]");

			generateLeftNavigation(document, tc, pdTitle, pdPageCount,dmpTitle,dmpPageCount ,capsTitle, capsPageCount,bsTitle,bsPageCount, mentTitle,mentPageCount, projsummPageCount);

			document.save(ba);
			document.close();
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		finally{
			if( document != null )
			{
				try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
		return ba;
	}


	/**
	 * This method returns page count.
	 * @param pd
	 * @return
	 */
	private static int getPageCount(byte[] pd){
		PDDocument document = null;
		ByteArrayInputStream inp = new ByteArrayInputStream(pd);
		int pdPageCount = 0;
		try {
			document = PDDocument.load(inp);
			PDDocumentInformation info = document.getDocumentInformation();
			pdPageCount = document.getNumberOfPages();
			//System.out.println("PDFUtility.getPageCount() title : "+info.getTitle()+"-- No of Pages : "+pdPageCount);
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				document.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pdPageCount;
	}


	/**
	 * This Method creates Left Navigation/BookMarks.
	 * @param document
	 * @param tc
	 * @param pdTitle
	 * @param pdPageCount
	 * @param dmpTitle
	 * @param dmpPageCount
	 * @param capsTitle
	 * @param capsPageCount
	 * @param bsTitle
	 * @param bsPageCount
	 * @param mentTitle
	 * @param mentPageCount
	 */
	private static void generateLeftNavigation(PDDocument document,int tc,String pdTitle, int pdPageCount,String dmpTitle, int dmpPageCount ,String capsTitle, int capsPageCount,
			String bsTitle,int bsPageCount, String mentTitle,int mentPageCount, int projsummPageCount){
		//generateLeftNavigation(document, pdTitle, pdPageCount,dmpTitle,dmpPageCount ,capsTitle, capsPageCount,bsTitle,bsPageCount, mentTitle,mentPageCount);
		PDDocumentOutline outline =  new PDDocumentOutline();
		document.getDocumentCatalog().setDocumentOutline( outline );
		PDOutlineItem pagesOutline = new PDOutlineItem();
		pagesOutline.setTitle( "Contents of Proposal" );
		outline.appendChild( pagesOutline );
		List pages = document.getDocumentCatalog().getAllPages();
		//System.out.println("PDFUtility.generateLeftNavigation() Total No of Pages : "+pages.size());

		PDPage page = (PDPage)pages.get( 0 );
		PDPageFitWidthDestination dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		PDOutlineItem bookmark = new PDOutlineItem();
		bookmark.setDestination( dest );
		bookmark.setTitle("Table of Contents");
		pagesOutline.appendChild( bookmark );


		//4.pd
		page = (PDPage)pages.get(tc);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination( dest );
		bookmark.setTitle(pdTitle);
		pagesOutline.appendChild( bookmark );

		//dmp
		page = (PDPage)pages.get(tc+pdPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination( dest );
		bookmark.setTitle(dmpTitle);
		pagesOutline.appendChild( bookmark );

		//cp
		page = (PDPage)pages.get(tc+pdPageCount+dmpPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination( dest );
		bookmark.setTitle(capsTitle);
		pagesOutline.appendChild( bookmark );

		//bs
		page = (PDPage)pages.get(tc+pdPageCount+dmpPageCount+capsPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination( dest );
		bookmark.setTitle(bsTitle);
		pagesOutline.appendChild( bookmark );

		//ment
		page = (PDPage)pages.get(tc+pdPageCount+dmpPageCount+capsPageCount+bsPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination( dest );
		bookmark.setTitle(mentTitle);
		pagesOutline.appendChild( bookmark );
		pagesOutline.openNode();
		outline.openNode();


		// proj summ
		page = (PDPage) pages.get(tc + pdPageCount + dmpPageCount+ capsPageCount + bsPageCount+ mentPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage(page);
		bookmark = new PDOutlineItem();
		bookmark.setDestination(dest);
		bookmark.setTitle("Project Summary");
		pagesOutline.appendChild(bookmark);
		pagesOutline.openNode();
		outline.openNode();

	}


		/**
		 * This Method creates table of Contents.
		 * @param tempPropId
		 * @param projDesc
		 * @param dmpPlan
		 * @param caps
		 * @param bs
		 * @param ment
		 * @return
		 * @throws IOException
		 * @throws COSVisitorException
		 */
	public static ByteArrayOutputStream createTOC(String tempPropId, ByteArrayOutputStream projDesc,ByteArrayOutputStream dmpPlan,ByteArrayOutputStream caps,ByteArrayOutputStream bs,ByteArrayOutputStream ment,ByteArrayOutputStream projsumm) throws IOException, COSVisitorException
	{
		// the document
		ByteArrayOutputStream toc = new ByteArrayOutputStream();
		PDDocument doc = null;
		float leading = 1.5f * 10;
		//System.out.println(" PDFUtility.createTOC()-- Generating TOC -----");

		int pdPageCount = getPageCount(projDesc.toByteArray());
		int dmpPageCount = getPageCount(dmpPlan.toByteArray());
		int cpPageCount = getPageCount(caps.toByteArray());
		int bsPageCount = getPageCount(bs.toByteArray());
		int mentPageCount = getPageCount(ment.toByteArray());
		int projsummPageCount = getPageCount(projsumm.toByteArray());

		try
		{
			doc = new PDDocument();



			PDPage page = new PDPage();
			doc.addPage( page );
			PDFont font = PDType1Font.HELVETICA_BOLD;

			PDPageContentStream contentStream = new PDPageContentStream(doc, page);
			contentStream.beginText();
			contentStream.setFont( font, 14 );
			contentStream.moveTextPositionByAmount( 220, 750 );
			contentStream.drawString("TABLE OF CONTENTS");
			contentStream.endText();

			//For font size and page formatting specifications, see GPG section II.B.2.
			contentStream.drawLine(40, 740, 600, 740);

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 8 );
			contentStream.moveTextPositionByAmount( 40, 730 );
			contentStream.drawString("For font size and page formatting specifications, see GPG section II.B.2.");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA_BOLD, 10 );
			contentStream.moveTextPositionByAmount( 430, 710 );
			contentStream.drawString("Total No.of");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA_BOLD, 10 );
			contentStream.moveTextPositionByAmount( 430, 700 );
			contentStream.drawString("Pages");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA_BOLD, 10 );
			contentStream.moveTextPositionByAmount( 500, 710 );
			contentStream.drawString("Page No.*");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA_BOLD, 10 );
			contentStream.moveTextPositionByAmount( 500, 700 );
			contentStream.drawString("(Optional)*");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 40, 680 );
			contentStream.drawString("Cover Sheet for Proposal to the National Science Foundation");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 650 );
			contentStream.drawString("Table of Contents");
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 650 );
			contentStream.drawString("1");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 650 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 648, 470, 648);
			contentStream.drawLine(500, 648, 540, 648);

			//proj summary
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 620 );
			contentStream.drawString("Project Summary (not to exceed 1 page)");//
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 620 );
			contentStream.drawString(String.valueOf(projsummPageCount));
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 620 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 618, 470, 618);
			contentStream.drawLine(500, 618, 540, 618);
			//

			//loop and print text
			List<String> lines = new ArrayList<String>();
			lines.add("Project Description (Including Results from Prior");
			lines.add("NSF Support) (not to exceed 15 pages) (Exceed only if allowed by a");
			lines.add("specific program announcement/solicitation or if approved in");
			lines.add("advance by the appropriate NSF Assistant Director or designee)");

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 590 );
			for (String line: lines)
			{
//				System.out.printf("'%s'\n", line);
				contentStream.drawString(line);
				contentStream.moveTextPositionByAmount(0, -leading);
			}
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 590 );
			contentStream.drawString(String.valueOf(pdPageCount));
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 590 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 588, 470, 588);
			contentStream.drawLine(500, 588, 540, 588);
			//

			//Ref cited
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 520 );
			contentStream.drawString("References Cited");
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 520 );
			contentStream.drawString("");	//Need to pass pageCount
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 520 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 518, 470, 518);
			contentStream.drawLine(500, 518, 540, 518);
			//


			//Bio Sketches
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 490 );
			contentStream.drawString("Biographical Sketches (Not to exceed 2 pages each)");
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 490 );
			contentStream.drawString(String.valueOf(bsPageCount));
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 490 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 488, 470, 488);
			contentStream.drawLine(500, 488, 540, 488);
			//

			//budg
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 460 );
			contentStream.drawString("Budget(Plus up to 3 pages of budget justification)");
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 460 );
			contentStream.drawString("");	//Need to pass pageCount
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 460 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 458, 470, 458);
			contentStream.drawLine(500, 458, 540, 458);
			//

			//cp
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 430 );
			contentStream.drawString("Current and Pending Support");
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 430 );
			contentStream.drawString(String.valueOf(cpPageCount));	//Need to pass pageCount
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 430 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 428, 470, 428);
			contentStream.drawLine(500, 428, 540, 428);
			//

			//Facilities, Equipment and Other Resources
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 400 );
			contentStream.drawString("Facilities, Equipment and Other Resourcest");
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 400 );
			contentStream.drawString("");	//Need to pass pageCount
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 400 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 398, 470, 398);
			contentStream.drawLine(500, 398, 540, 398);
			//

			//loop and print text --Special Information/Supplementary Documents
			List<String> lines3 = new ArrayList<String>();
			lines3.add("Special Information/Supplementary Documents");
			lines3.add("(Data Management Plan, Mentoring Plan");
			lines3.add("and Other Supplementary Documents)");

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			float yy = 450f;
			contentStream.moveTextPositionByAmount( 70, 370 );
			for (String line3: lines3)
			{
//				System.out.printf("'%s'\n", line3);
				contentStream.drawString(line3);
				yy = yy-10;
				contentStream.moveTextPositionByAmount(0, -leading);
			}
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 370 );
			contentStream.drawString(String.valueOf(dmpPageCount+mentPageCount));
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 370 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 368, 470, 368);
			contentStream.drawLine(500, 368, 540, 368);
			//


			//loop and print text -- Appendix
			List<String> lines4 = new ArrayList<String>();
			lines4.add("Appendix (List below. )");
			lines4.add("(Include only if allowed by a specific program announcement/");
			lines4.add("solicitation or if approved in advance by the appropriate NSF");
			lines4.add("Assistant Director or designee)");
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 300 );
			for (String line4: lines4)
			{
				//System.out.printf("'%s'\n", line4);
				contentStream.drawString(line4);
				contentStream.moveTextPositionByAmount(0, -leading);
			}
			contentStream.endText();

			//Add PageCount and under lines
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 450, 300 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 520, 300 );
			contentStream.drawString("");
			contentStream.endText();

			contentStream.drawLine(430, 290, 470, 290);
			contentStream.drawLine(500, 290, 540, 290);
			//


			//Appendix Items:
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			contentStream.moveTextPositionByAmount( 70, 230 );
			contentStream.drawString("Appendix Items:");
			contentStream.endText();
			//


			List<String> lines5 = new ArrayList<String>();
			lines5.add("*Proposers may select any numbering mechanism for the proposal. The entire proposal however, must be paginated.");
			lines5.add("Complete both columns only if the proposal is numbered consecutively.");
			contentStream.beginText();
			contentStream.setFont( PDType1Font.HELVETICA, 10 );
			//            float y4 = 420;
			contentStream.moveTextPositionByAmount( 40, 100 );
			for (String line4: lines5)
			{
//				System.out.printf("'%s'\n", line4);
				contentStream.drawString(line4);
				contentStream.moveTextPositionByAmount(0, -leading);
			}
			contentStream.endText();
			contentStream.drawLine(40, 80, 600, 80);


			contentStream.close();
			PDDocumentInformation info = new PDDocumentInformation();
			info.setTitle("Proposal # "+tempPropId);
			doc.setDocumentInformation(info);
			doc.save( toc);
		}
		finally
		{
			if( doc != null )
			{
				doc.close();
			}
		}
		return toc;
	}

	
	/**
	 * This method will add an ISO8601 timestamp to the top of a PDF document
	 * @param  srcDocStream
	 */
	public static ByteArrayOutputStream stampPDFTimestamp(ByteArrayOutputStream srcDocStream){
		
		ByteArrayOutputStream stampedDocStream = new ByteArrayOutputStream();
		
		//TODO: Add this to properties file
		String isoTimestampFormat = "YYYY/MM/dd HH:mm:ss";
		
		try {
			stampedDocStream = stampPDF(srcDocStream, new SimpleDateFormat(isoTimestampFormat).format(new Date()));
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stampedDocStream;
	}
	
	
	/**
	 * This method will instantiate a PDDocument from a ByteArrayOutputStream 
	 * and add a timestamp to the first page
	 * @param  srcDocStream
	 * @param  stampText
	 * @throws IOException 
	 * @throws COSVisitorException 
	 * 
	 */
	private static ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, String stampText) throws IOException, COSVisitorException {
		
		ByteArrayOutputStream stampedDocStream = new ByteArrayOutputStream();

		PDDocument srcDocument = null;

		//TODO: Move hardcoded config values to a properties file
        float margin = 72;
        int fontSize = 12;
        PDFont font = PDType1Font.getStandardFont("Helvetica");
        Color fontColor = Color.RED;
        
		ByteArrayInputStream in = new ByteArrayInputStream(srcDocStream.toByteArray());
		srcDocument = PDDocument.load(in);
		
		 // get list of pages
        List allPages = srcDocument.getDocumentCatalog().getAllPages();
        
        //stamp the first page only
        //TODO: Need to determine actual logic for PDF stamping for development
        PDPage page = (PDPage)allPages.get(0);
        
        PDRectangle pageSize = page.findMediaBox();

		float startX = pageSize.getLowerLeftX() + margin;
		float startY = pageSize.getUpperRightY() - 50;
			
    	// if we want to set the string width - we don't need to in this case
        //float stringWidth = font.getStringWidth(stampText) * fontSize / 1000f;
        
        PDPageContentStream contentStream = new PDPageContentStream(srcDocument, page, true, true, true);
        contentStream.beginText();

        //set stampText formatting options
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(fontColor);
        contentStream.setTextTranslation(startX, startY);
        
        //stamp the document
        contentStream.drawString(stampText);

        contentStream.endText();
        contentStream.close();
        
        srcDocument.save(stampedDocStream);
        srcDocument.close();
        
        return stampedDocStream;
	}
	

}




