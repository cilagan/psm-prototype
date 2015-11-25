package gov.nsf.research.document.dao;



import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;





import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
//@WebAppConfiguration
public class DocumentServiceDaoImplUnitTests {

	@Autowired
	DocumentServiceDao documentServiceDao;
	
	@Test
	public void contextLoads() {
	}
	
	

	@Test
	public void testSaveDocument(){

		InputStream inputStream = null;
		String tempPropId = "6666666";
		try {
			inputStream = new FileInputStream(
					"C:\\Users\\spendyal\\Desktop\\psm_test_input_ files\\PDF_Test_66MB.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DocumentMetaData DocumentMetaData = documentServiceDao.saveDocument(
				inputStream, tempPropId, SectionType.DATA_MANAGEMENT_PLAN);

		System.out.println("SaveDocument - MetaData:"
				+ DocumentMetaData.toString());
	}
	
	
	}

		

	

