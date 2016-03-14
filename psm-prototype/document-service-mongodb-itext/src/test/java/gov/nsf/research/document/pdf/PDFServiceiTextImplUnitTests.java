package gov.nsf.research.document.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.pdf.PDFService;
import gov.nsf.research.document.service.pdf.PDFServiceiTextImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
public class PDFServiceiTextImplUnitTests {

	
	private final String SAMPLE_PDF_TEXT = "Hello World!";
	
	private PDFService pdfService;
	
	@Before
	public void init(){
		pdfService = new PDFServiceiTextImpl();
	}
	
	@Test
	public void createPDFDocumentFromTextTest() throws IOException {
		ByteArrayOutputStream output = pdfService.createPDF(SAMPLE_PDF_TEXT);
		
		OutputStream fos;
		fos = new FileOutputStream("src/test/resources/testpdfs/itext/generated_pdf_from_text.pdf");
		output.writeTo(fos);
		output.close();
		
		
	}
	
	@Test
	public void stampPDFDocumentTest() throws IOException {
		
		ByteArrayOutputStream output = pdfService.createPDF(SAMPLE_PDF_TEXT);
		String isoTimestampFormat = "YYYY/MM/dd HH:mm:ss";
		
		output = pdfService.stampPDF(output, new SimpleDateFormat(isoTimestampFormat).format(new Date()));
		OutputStream fos;
		fos = new FileOutputStream("src/test/resources/testpdfs/itext/stamped_pdf.pdf");
		output.writeTo(fos);
		output.close();
	}
}
