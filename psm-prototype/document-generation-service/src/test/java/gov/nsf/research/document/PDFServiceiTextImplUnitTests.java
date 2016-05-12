package gov.nsf.research.document;

import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.PDFService;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
@WebAppConfiguration
public class PDFServiceiTextImplUnitTests {

	@Autowired
	PDFService pDFService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void createPDFDocumentFromTextTest() throws IOException {
		
		//System.out.println("value"+pDFService.createPDF(SectionType.PROJ_SUMM,"7664607"));
		
	   ByteArrayOutputStream output = pDFService.createPDF(SectionType.BIO_SKETCHES,"0000008");
		
		OutputStream fos;
		fos = new FileOutputStream("C:/PDFs/Psummary.pdf");
		output.writeTo(fos);
		output.flush();
		output.close();
		
		
		
		
		
	}
	
	
	
	
}
