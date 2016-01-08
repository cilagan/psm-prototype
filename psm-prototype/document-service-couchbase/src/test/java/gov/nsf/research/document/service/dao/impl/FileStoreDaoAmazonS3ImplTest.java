package gov.nsf.research.document.service.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.dao.FileStoreDao;

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

	}
	
}
