package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
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
	


}
