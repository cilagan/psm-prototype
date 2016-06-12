package gov.nsf.research.document.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.pdf.PDFUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
public class PDFUtilityUnitTests {

	private final String SAMPLE_PDF_TEXT = "Hello World!";
	
	
	@Test
	public void createPDFDocumentFromTextTest() throws IOException {
		ByteArrayOutputStream output = PDFUtility.createPDFDocumentFromText(SAMPLE_PDF_TEXT);
		
		OutputStream fos;
		fos = new FileOutputStream("src/test/resources/testpdfs/pdfbox/projsumtest1.pdf");
		output.writeTo(fos);
		output.close();
		
		
	}
	
	@Test
	public void stampPDFDocumentTest() throws IOException{
		ByteArrayOutputStream output = PDFUtility.createPDFDocumentFromText(SAMPLE_PDF_TEXT);
		output = PDFUtility.stampPDFTimestamp(output);
		
		OutputStream fos;
		fos = new FileOutputStream("src/test/resources/testpdfs/pdfbox/stampedPDf.pdf");
		output.writeTo(fos);
		output.close();
	}

}
