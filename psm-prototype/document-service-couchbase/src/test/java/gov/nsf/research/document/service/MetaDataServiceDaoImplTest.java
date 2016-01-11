package gov.nsf.research.document.service;

import gov.nsf.research.document.service.dao.MetaDataServiceDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
public class MetaDataServiceDaoImplTest {
		
	@Autowired
	MetaDataServiceDao metaDataServiceDao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSaveDocumentMetaData() {
		DocumentMetaData documentMetaData = new DocumentMetaData();

		String tempPropID = "1111111";
		SectionType sectionType = SectionType.DATA_MANAGEMENT_PLAN;
		String fileName = tempPropID + "_" + sectionType;
		String id = tempPropID + "_" + sectionType;
		Long size = 258L;
		int pages = 200;

		documentMetaData.setId(id);
		documentMetaData.setFileName(fileName);
		documentMetaData.setSectionType(sectionType);
		documentMetaData.setSize(size);
		documentMetaData.setPages(pages);

		metaDataServiceDao.saveDocumentMetaData(documentMetaData);

	}

	@Test
	public void testViewDocumentMetaData() {
		
		String tempPropID = "1111111";
		SectionType sectionType = SectionType.DATA_MANAGEMENT_PLAN;
		String key = tempPropID + "_" + sectionType;
		

		DocumentMetaData documentMetaData = metaDataServiceDao.viewDocumentMetaData(key);
		System.out.println("testViewDocumentMetaData: "+documentMetaData.toString());

		

	}

	@Test
	public void  setDeleteDocumentMetaData() {
		String tempPropID = "1111111";
		SectionType sectionType = SectionType.DATA_MANAGEMENT_PLAN;
		String key = tempPropID + "_" + sectionType;

		metaDataServiceDao.deleteDocumentMetaData(key);
		
	}
	

}
