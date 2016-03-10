package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfCopy.PageStamp;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDFServiceiTextImpl implements PDFService {

	@Override
	public boolean validatePDFDocument(ByteArrayInputStream inputStream,
			String tempPropId) {
		boolean isValidPDF = true;
		PdfReader reader = null;
		int length = 0;
		System.out.println("PDFServiceiTextImpl.validatePDFDocument()");

		try {
			reader = new PdfReader(inputStream);
			System.out.println("****reader.isEncrypted()...."	+ reader.isEncrypted());
			if (reader.isEncrypted()) {
				isValidPDF = false;
				System.out.println(" PDF Document is password protected:"	+ length);
			} else {
				length = PdfTextExtractor.getTextFromPage(reader, 1).length();

				if (length <= 1) {
					isValidPDF = false;
					System.out.println(" PDF Document is empty:" + length);
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return isValidPDF;
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
		System.out.println("MergeWithToc2.createPdf()");
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

}
