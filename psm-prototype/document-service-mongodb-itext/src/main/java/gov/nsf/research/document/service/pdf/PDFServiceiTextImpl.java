package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfCopy.PageStamp;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import gov.nsf.research.document.service.model.PDFDocument;
import gov.nsf.research.document.service.model.SectionType;

public class PDFServiceiTextImpl implements PDFService {

	@Override
	public PDFDocument validatePDFDocument(ByteArrayInputStream inputStream,
			String tempPropId) {

		PdfReader reader = null;
		PDFDocument pDFDocument = null;
		int length = 0;

		try {
			pDFDocument = new PDFDocument();
			reader = new PdfReader(inputStream);

			if (reader.isEncrypted()) {

				pDFDocument.setPDFEncrypted(true);
				pDFDocument.setPdfErrorMessage("TempPropID:"+tempPropId+" Error: Uploaded PDF Document is Encrypted.");
			} else {
				length = PdfTextExtractor.getTextFromPage(reader, 1).length();

				if (length <= 1) {

					pDFDocument.setImageOnly(true);
					pDFDocument.setPdfErrorMessage("TempPropID:"+tempPropId+" Error: Uploaded PDF Document has only image.");
				}
			}

		}

		catch (BadPasswordException e) {
			pDFDocument.setPDFPasswordProteced(true);
			pDFDocument.setPdfErrorMessage("TempPropID:"+tempPropId+" Error: Uploaded PDF Document is password protected.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pDFDocument;
	}

	@Override
	public ByteArrayOutputStream createPDF(String text) {
		System.out.println("PDFServiceiTextImpl.createPDF()");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, outputStream);
			document.open();
			document.add(new Paragraph(text));
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return outputStream;

	}

	@Override
	public ByteArrayOutputStream CreateEntireProposal(String tempPropId,
			List<ByteArrayOutputStream> baosList) {
		System.out.println("PDFServiceiTextImpl.CreateEntireProposal()");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		Document document = new Document();
		// savetoLocal(baosList);

		PdfWriter writer = null;
		PdfReader reader = null;
		try {
			writer = PdfWriter.getInstance(document, baos);

			document.open();
			PdfContentByte cb = writer.getDirectContent();
			for (ByteArrayOutputStream ba : baosList) {

				reader = new PdfReader(ba.toByteArray());

				for (int i = 1; i <= reader.getNumberOfPages(); i++) {
					document.newPage();
					PdfImportedPage page = writer.getImportedPage(reader, i);
					cb.addTemplate(page, 0, 0);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// outputStream.flush();
		document.close();
		// outputStream.close();
		return baos;
	}
	
	public ByteArrayOutputStream CreateEntireProposal(Map<String, PdfReader> filesToMerge) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		Map<Integer, String> toc = new TreeMap<Integer, String>();
		try{
			Document document = new Document();
			PdfCopy copy = new PdfCopy(document, baos);
			PageStamp stamp;
			document.open();
			int n;
			int pageNo = 0;
			PdfImportedPage page;
			Chunk chunk;
			for (Map.Entry<String, PdfReader> entry : filesToMerge.entrySet()) {
				n = entry.getValue().getNumberOfPages();
				System.out.println("------>"+n);
				toc.put(pageNo + 1, entry.getKey());
				for (int i = 0; i < n; ) {
					pageNo++;
					page = copy.getImportedPage(entry.getValue(), ++i);
					stamp = copy.createPageStamp(page);
					chunk = new Chunk(String.format("Page %d", pageNo));
					if (i == 1)
						chunk.setLocalDestination("p" + pageNo);
					ColumnText.showTextAligned(stamp.getUnderContent(),
							Element.ALIGN_RIGHT, new Phrase(chunk),
							559, 810, 0);
					stamp.alterContents();
					copy.addPage(page);
				}
			}

			ByteArrayOutputStream tc = createTOC();
			
			PdfReader reader = new PdfReader(tc.toByteArray());
			page = copy.getImportedPage(reader, 1);
			stamp = copy.createPageStamp(page);
			Paragraph p;
			PdfAction action;
			PdfAnnotation link;
			float y = 770;
			ColumnText ct = new ColumnText(stamp.getOverContent());
			ct.setSimpleColumn(36, 36, 559, y);
			for (Map.Entry<Integer, String> entry : toc.entrySet()) {
				p = new Paragraph(entry.getValue());
				p.add(new Chunk(new DottedLineSeparator()));
				p.add(String.valueOf(entry.getKey()));
				ct.addElement(p);
				ct.go();
				action = PdfAction.gotoLocalPage("p" + entry.getKey(), false);
				link = new PdfAnnotation(copy, 36, ct.getYLine(), 559, y, action);
				stamp.addAnnotation(link);
				y = ct.getYLine();
			}
			ct.go();
			stamp.alterContents();
			copy.addPage(page);
			document.close();
			for (PdfReader r : filesToMerge.values()) {
				r.close();
			}
			reader.close();

			reader = new PdfReader(baos.toByteArray());
			n = reader.getNumberOfPages();
			reader.selectPages(String.format("%d, 1-%d", n, n-1));
			PdfStamper stamper = new PdfStamper(reader, baos);
			stamper.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return baos;

	}
	
	/**
	 * This method will create table of Contents
	 * @return
	 */
    private ByteArrayOutputStream createTOC(){
    	ByteArrayOutputStream toc = new ByteArrayOutputStream();
    	try{
    		Document document1 = new Document();
     		PdfWriter.getInstance(document1,toc);
    		document1.open();
    		Paragraph p1 = new Paragraph("Table of Contents");
    		document1.add(p1);
    		document1.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return toc;
    }
    
    private ByteArrayOutputStream createTableOfContentsC(Map<SectionType, ByteArrayOutputStream> filesToMerge){
    	ByteArrayOutputStream toc = new ByteArrayOutputStream();
    	try{
    		Document document1 = new Document();
     		PdfWriter.getInstance(document1,toc);
    		document1.open();
    		Paragraph p = new Paragraph("Table of Contents");
    		p.setAlignment(Element.ALIGN_CENTER);
    		p.setSpacingAfter(25);
    		document1.add(p);
    		
    		ByteArrayOutputStream pd = filesToMerge.get(SectionType.PROJECT_DESCRIPTION);
    		ByteArrayOutputStream dmp = filesToMerge.get(SectionType.DATA_MANAGEMENT_PLAN);//
    		ByteArrayOutputStream cp = filesToMerge.get(SectionType.CURR_PEND_SUPPORT);
    		ByteArrayOutputStream bio = filesToMerge.get(SectionType.BIO_SKETCHES);
    		ByteArrayOutputStream mp = filesToMerge.get(SectionType.MENTOR_PLAN);
    		ByteArrayOutputStream pj = filesToMerge.get(SectionType.PROJ_SUMM);
    		
    		//Pull the rest of Titles
    		Paragraph p1 = getParagraph(pd,  "1. Project Desccription");
    		Paragraph p2 = getParagraph(dmp, "2. Data Management");
    		Paragraph p3 = getParagraph(cp,  "3. Current and Pending");
    		Paragraph p4 = getParagraph(bio, "4. Bio Sketches");
    		Paragraph p5 = getParagraph(mp,  "5. Mentoring Plan");
    		Paragraph p6 = getParagraph(pj,  "6. Project Summary");
    		document1.add(p1);
    		document1.add(p2);
    		document1.add(p3);
    		document1.add(p4);
    		document1.add(p5);
    		document1.add(p6);
    		
    		document1.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return toc;
    }
    
    private Paragraph getParagraph(ByteArrayOutputStream ba, String title){
		
    	Paragraph p = null;
    	int noPages = 0;
    	
    	try {
			PdfReader reader = new PdfReader(ba.toByteArray());
			noPages = reader.getNumberOfPages();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	p = new Paragraph(title);
    	p.add(new Chunk(new DottedLineSeparator()));
    	p.add(String.valueOf(noPages));
		p.setAlignment(Element.ALIGN_LEFT);
		p.setSpacingAfter(10);
    	return p;
    	
    }
    
    public ByteArrayOutputStream CreateEntireProposalWithBookMarks(Map<SectionType, ByteArrayOutputStream> filesToMerge){

    	System.out.println("PDFServiceiTextImpl.CreateEntireProposalWithBookMarks()-- Creating Entire Proposal with BookMarks");
    	ByteArrayOutputStream baos = null;
    	try{
    		Document document = new Document();
    		 baos = new ByteArrayOutputStream();
    		PdfCopy copy = new PdfCopy(document, baos);
    		document.open();

    		ArrayList<HashMap<String, Object>> outlines = new ArrayList<HashMap<String, Object>>();

    		// add the first outline element
    		HashMap<String, Object> title = new HashMap<String, Object>();
    		title.put("Title", "Proposal Sections");
    		outlines.add(title);

    		
    		//We can Call TOC and append it.
    		
    		ByteArrayOutputStream toc = createTableOfContentsC(filesToMerge);
    		PdfReader tocReader = new PdfReader(toc.toByteArray());
    		copy.addDocument(tocReader);
    		int page = 1;
    		ArrayList<HashMap<String, Object>> kids = new ArrayList<HashMap<String, Object>>();
    		HashMap<String, Object> tc = new HashMap<String, Object>();
    		tc.put("Title", "Table Of Contents");
    		tc.put("Action", "GoTo");
    		tc.put("Page", String.format("%d Fit",page));
    		kids.add(tc);
    		title.put("Kids", kids);
    		// update page count
    		page += tocReader.getNumberOfPages();
    		
    		// add the pd pdf
       		ByteArrayOutputStream pd = filesToMerge.get(SectionType.PROJECT_DESCRIPTION);

    		PdfReader reader1 = new PdfReader(pd.toByteArray());
    		copy.addDocument(reader1);
    		HashMap<String, Object> rc = new HashMap<String, Object>();
    		rc.put("Title", "Project Description");
    		rc.put("Action", "GoTo");
    		rc.put("Page", String.format("%d Fit",page));
    		kids.add(rc);
    		title.put("Kids", kids);
    		// update page count
    		page += reader1.getNumberOfPages();

    		// add the dmp document
    		ByteArrayOutputStream dmp = filesToMerge.get(SectionType.DATA_MANAGEMENT_PLAN);
    		PdfReader reader2 = new PdfReader(dmp.toByteArray());
    		copy.addDocument(reader2);
    		// add the second outline element as a kid of the first one
    		//        ArrayList<HashMap<String, Object>> kids = new ArrayList<HashMap<String, Object>>();
    		HashMap<String, Object> link1 = new HashMap<String, Object>();
    		link1.put("Title", "Data Managemennt Plan");
    		link1.put("Action", "GoTo");
    		link1.put("Page", String.format("%d Fit", page));
    		kids.add(link1);
    		title.put("Kids", kids);
    		// update page count
    		page += reader2.getNumberOfPages();


    		// add the third document
    		ByteArrayOutputStream cp = filesToMerge.get(SectionType.CURR_PEND_SUPPORT);
    		PdfReader reader3 = new PdfReader(cp.toByteArray());
    		copy.addDocument(reader3);
    		// add the third outline element to the root
    		HashMap<String, Object> link2 = new HashMap<String, Object>();
    		link2.put("Title", "Current Pending");
    		link2.put("Action", "GoTo");
    		link2.put("Page", String.format("%d Fit", page));
    		kids.add(link2);
    		title.put("kids", kids);
    		// update page count
    		page += reader3.getNumberOfPages();
    		
    		// add the 4th document
    		ByteArrayOutputStream bio = filesToMerge.get(SectionType.BIO_SKETCHES);
    		PdfReader reader4 = new PdfReader(bio.toByteArray());
    		copy.addDocument(reader4);
    		// add the third outline element to the root
    		HashMap<String, Object> link4 = new HashMap<String, Object>();
    		link4.put("Title", "Bio Sketches");
    		link4.put("Action", "GoTo");
    		link4.put("Page", String.format("%d Fit", page));
    		kids.add(link4);
    		title.put("kids", kids);
    		// update page count
    		page += reader4.getNumberOfPages();
    		
    		// add the 5th document
    		ByteArrayOutputStream mp = filesToMerge.get(SectionType.MENTOR_PLAN);
    		PdfReader reader5 = new PdfReader(mp.toByteArray());
    		copy.addDocument(reader5);
    		// add the third outline element to the root
    		HashMap<String, Object> link5 = new HashMap<String, Object>();
    		link5.put("Title", "Mentoring Plan");
    		link5.put("Action", "GoTo");
    		link5.put("Page", String.format("%d Fit", page));
    		kids.add(link5);
    		title.put("kids", kids);    		// update page count
    		page += reader5.getNumberOfPages();
    		
    		// add the 6th document
    		ByteArrayOutputStream pj = filesToMerge.get(SectionType.PROJ_SUMM);
    		PdfReader reader6 = new PdfReader(pj.toByteArray());
    		copy.addDocument(reader6);
    		// add the third outline element to the root
    		HashMap<String, Object> link6 = new HashMap<String, Object>();
    		link6.put("Title", "Project Summary");
    		link6.put("Action", "GoTo");
    		link6.put("Page", String.format("%d Fit", page));
    		kids.add(link6);
    		title.put("kids", kids);

    		// add the outlines
    		copy.setOutlines(outlines);
    		// close the document
    		document.close();
    		reader1.close();
    		reader2.close();
    		reader3.close();
    		reader4.close();
    		reader5.close();
    		reader6.close();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return baos;

    }
	
	
	/**
	 * This method will instantiate a PDDocument from a ByteArrayOutputStream 
	 * and add a timestamp to the first page
	 * @param  srcDocStream
	 * @param  stampText
	 * @throws IOException 
	 * @throws DocumentException 
	 * @throws COSVisitorException 
	 * 
	 */
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, String stampText) {
	
		PdfReader reader = null;
		PdfStamper stamper = null;
		try {
			reader = new PdfReader(srcDocStream.toByteArray());
			stamper = new PdfStamper(reader, srcDocStream);
			
			Rectangle rect = reader.getPageSize(1);
			PdfContentByte canvas = stamper.getOverContent(1);
			
			//TODO: Formatting options should be standardized/read from property file
			Phrase stampPhrase = new Phrase(stampText, new Font(FontFamily.HELVETICA, 12, 0, BaseColor.RED));
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, stampPhrase, rect.getLeft(35), rect.getTop(30), 0);
			
			
			stamper.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return srcDocStream;
	}

}
