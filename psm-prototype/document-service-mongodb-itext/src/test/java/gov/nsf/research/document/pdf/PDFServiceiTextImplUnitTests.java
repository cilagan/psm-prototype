package gov.nsf.research.document.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.nsf.resarch.document.service.util.EditorTextConversionUtil;
import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.model.EditorText;
import gov.nsf.research.document.service.model.proposal.ProjectSummary;
import gov.nsf.research.document.service.pdf.PDFService;
import gov.nsf.research.document.service.pdf.PDFServiceiTextImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
public class PDFServiceiTextImplUnitTests {

	
	private final String SAMPLE_PDF_TEXT = "Hello World!";
	
	ProjectSummary ps = new ProjectSummary();
	
	public String editorText = "<p>111111Here is normal text.&nbsp;<strong>Here is bold text.&nbsp;</strong>Here is another normal text.<em>Here is italicized text.&nbsp;</em><u>Here is underlined text.</u>Here is another normal text.</p>";

	
	
	private PDFService pdfService;
	
	@Before
	public void init(){
		pdfService = new PDFServiceiTextImpl();
	}
	
	@Test
	public void createPDFDocumentFromTextTest() throws IOException {
		
	
		ps.setOverView("hello");
		ByteArrayOutputStream output = pdfService.createPDF(ps);
		
		OutputStream fos;
		fos = new FileOutputStream("src/test/resources/testpdfs/itext/generated_pdf_from_text.pdf");
		output.writeTo(fos);
		output.close();
		
		
	}
	
	//@Test
	public void testcreateProjectSummaryPDF() throws IOException {
		
		Set<EditorText> textoverview = EditorTextConversionUtil.convertEditorString(editorText);
		Set<EditorText> textbrodimpact = EditorTextConversionUtil.convertEditorString(editorText);
		Set<EditorText> textintellmerit = EditorTextConversionUtil.convertEditorString(editorText);
				
		ByteArrayOutputStream output = pdfService.createProjectSummaryPDF(textoverview, textbrodimpact, textintellmerit);
		
		OutputStream fos;
		fos = new FileOutputStream("C:/Users/spendyal/Desktop/generated_pdf_from_proj_text.pdf");
		output.writeTo(fos);
		output.close();
		
		
	}
	
	
	@Test
	public void stampPDFDocumentTest() throws IOException {
		ps.setOverView("hello");
		
		ByteArrayOutputStream output = pdfService.createPDF(ps);
		String isoTimestampFormat = "YYYY/MM/dd HH:mm:ss";
		
		output = pdfService.stampPDF(output, new SimpleDateFormat(isoTimestampFormat).format(new Date()));
		OutputStream fos;
		fos = new FileOutputStream("src/test/resources/testpdfs/itext/stamped_pdf.pdf");
		output.writeTo(fos);
		output.close();
	}
}
