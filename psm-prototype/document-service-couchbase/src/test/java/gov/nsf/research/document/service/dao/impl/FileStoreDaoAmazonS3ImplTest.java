package gov.nsf.research.document.service.dao.impl;

import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.dao.FileStoreDao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
public class FileStoreDaoAmazonS3ImplTest {

	@Autowired
	FileStoreDao fileStoreDao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testUploadFile(){
		
		InputStream inputStream = null;
		String tempPropId = "123456";
		
		try {
			inputStream = new ByteArrayInputStream(
					"C:\\Users\\spendyal\\Desktop\\psm_test_input_ files\\DSC_0175.JPG".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fileStoreDao.uploadFile(inputStream, tempPropId);

	}
	
}
