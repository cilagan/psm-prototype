package gov.nsf.research.document.dao;



import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;  

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
	
	@Autowired
	DocumentService documentService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testgetProjectsummary()
	{
		
		documentService.getProjectSummaryText("1008698");
	}

	@Test
	public void testSaveDocument(){
		
		/** Temporary proposal numbers
		 * 1617503
			1540860
			1530501
			1616896
			1534035
			1540711
			1608727
			1557574
			1526869
		 */

		InputStream inputStream = null;
		String tempPropId = "8888888";
		try {
			inputStream = new FileInputStream(
					"C:\\Users\\spendyal\\Desktop\\psm_test_input_ files\\12335.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DocumentMetaData DocumentMetaData = documentServiceDao.saveDocument(
				inputStream, tempPropId, SectionType.PROJECT_DESCRIPTION
				);

		System.out.println("SaveDocument - MetaData:"
				+ DocumentMetaData.toString());
	}
	
	@Test
	public void testviewDocument(){

		ByteArrayOutputStream inputStream = null;
		String tempPropId = "8888888";
		
		inputStream = documentServiceDao.viewDocument(tempPropId, SectionType.PROJECT_DESCRIPTION);
		System.out.println("**END"+inputStream.size());

	
	}
	
	@Test
	public void testViewAllFilesFromDB(){	

		List<Document> docList =  documentServiceDao.viewAllFilesFromDB();
		System.out.println("**END"+docList.toString());

	
	}
	
	@Test
	public void testDeleteDocument(){	

		 documentServiceDao.deleteDocument("1111111", SectionType.DATA_MANAGEMENT_PLAN);		

	
	}
	
	}

		

	

