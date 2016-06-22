package gov.nsf.research.document.service.pdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

import gov.nsf.research.document.service.model.DocumentMetaData;

public class PDFUtility_UnitTest {

	@Test
	public void testExtractMetaData(){
		try {
			InputStream is = new FileInputStream("C://Apps//mongo_result_1.pdf");
			DocumentMetaData docMetaData = new DocumentMetaData();
			docMetaData.setTempPropId("1234567");
			PDFUtility.extractMetaData(is, docMetaData);
			System.out.println(docMetaData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
