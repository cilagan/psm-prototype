package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.pdfbox.util.PDFTextStripper;


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
	

	private static boolean isDocumentEncrypted(PDDocument document)

	{
		boolean returnValue = false;

		if (document.isEncrypted())
			returnValue = true;
		else
			returnValue = false;

		return returnValue;

	}

	
	

	public static String extractTextFromPDF(ByteArrayInputStream stream)

	{

		PDFTextStripper stripper;
		String text = null;
		try {
			PDDocument document = PDDocument.load(stream);
			
			PDDocumentInformation info = document.getDocumentInformation();
			System.out.println( "Page Count=" + document.getNumberOfPages() );
			System.out.println( "Title=" + info.getTitle() );
			System.out.println( "Author=" + info.getAuthor() );
			System.out.println( "Subject=" + info.getSubject() );
			System.out.println( "Keywords=" + info.getKeywords() );
			System.out.println( "Creator=" + info.getCreator() );
			System.out.println( "Producer=" + info.getProducer() );
			System.out.println( "Creation Date=" + info.getCreationDate() );
			System.out.println( "Modification Date=" + info.getModificationDate());
			System.out.println( "Trapped=" + info.getTrapped() );   
			
			stripper = new PDFTextStripper();

			text = stripper.getText(document);
			System.out.println("PDF ** text length" + text.length());
			if (text.length() <= 3) {
				System.out
						.println("**^^^^^^^^^^^^^^ PDD documentText is empty ^^^^^^^^^^^^^ *****:"
								+ text);
			}
			System.out.println("** PDD document *****:" + text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return text;

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
	public static ByteArrayOutputStream CreateEntireProposal(String tempPropId,ByteArrayOutputStream baos,ByteArrayOutputStream projDesc,ByteArrayOutputStream dmpPlan,
			ByteArrayOutputStream caps,ByteArrayOutputStream bs,ByteArrayOutputStream ment){

		String fileName = "C:\\GeneratedPdfs\\"+tempPropId+".pdf";
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
			
			int pdPageCount = 0;
			int dmpPageCount = 0;
			int capsPageCount = 0;
			int bsPageCount = 0;
			int mentPageCount = 0;
			

			//				ByteArrayOutputStream dmp = docServiceDao.viewDocument(tempPropId, SectionType.DATA_MANAGEMENT_PLAN);

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
			

			generateLeftNavigation(document, pdTitle, pdPageCount,dmpTitle,dmpPageCount ,capsTitle, capsPageCount,bsTitle,bsPageCount, mentTitle,mentPageCount);

			document.save(ba);

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
	
	private static int getPageCount(byte[] pd){
		PDDocument document = null;
		ByteArrayInputStream inp = new ByteArrayInputStream(pd);
		int pdPageCount = 0;
		try {
			document = PDDocument.load(inp);
			PDDocumentInformation info = document.getDocumentInformation();
			pdPageCount = document.getNumberOfPages();
			System.out.println("PDFUtility.getPageCount() title : "+info.getTitle()+"-- No of Pages : "+pdPageCount);
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
	
	private static void generateLeftNavigation(PDDocument document,String pdTitle, int pdPageCount,String dmpTitle, int dmpPageCount ,String capsTitle, int capsPageCount,
			String bsTitle,int bsPageCount, String mentTitle,int mentPageCount){
		//generateLeftNavigation(document, pdTitle, pdPageCount,dmpTitle,dmpPageCount ,capsTitle, capsPageCount,bsTitle,bsPageCount, mentTitle,mentPageCount);
		PDDocumentOutline outline =  new PDDocumentOutline();
		document.getDocumentCatalog().setDocumentOutline( outline );
		PDOutlineItem pagesOutline = new PDOutlineItem();
		pagesOutline.setTitle( "Contents of Proposal" );
		outline.appendChild( pagesOutline );
		List pages = document.getDocumentCatalog().getAllPages();

		PDPage page = (PDPage)pages.get(0);
		PDPageFitWidthDestination dest = new PDPageFitWidthDestination();

		dest.setPage( page );
		PDOutlineItem bookmark = new PDOutlineItem();
		bookmark.setDestination(dest);
		bookmark.setTitle("Project Description");
		pagesOutline.appendChild(bookmark);
		
		page = (PDPage)pages.get(pdPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination(dest);
		bookmark.setTitle("Data Management Plan");
		pagesOutline.appendChild(bookmark);
		
		
		// cp
		page = (PDPage)pages.get(pdPageCount+dmpPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination(dest);
		bookmark.setTitle("Current and Pending");
		pagesOutline.appendChild(bookmark);
		
		//bio
		page = (PDPage)pages.get(pdPageCount+dmpPageCount+capsPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination(dest);
		bookmark.setTitle("Bio Sketches");
		pagesOutline.appendChild(bookmark);
		
		//mentoring	
		page = (PDPage)pages.get(pdPageCount+dmpPageCount+capsPageCount+bsPageCount);
		dest = new PDPageFitWidthDestination();
		dest.setPage( page );
		bookmark = new PDOutlineItem();
		bookmark.setDestination(dest);
		bookmark.setTitle("Mentoring Plan");
		pagesOutline.appendChild(bookmark);
		pagesOutline.openNode();
		outline.openNode();

	}
	
	
}
	
		
	

