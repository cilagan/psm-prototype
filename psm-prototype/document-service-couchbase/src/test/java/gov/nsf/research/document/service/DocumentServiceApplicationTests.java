package gov.nsf.research.document.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.util.StringUtils;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.SectionType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
//@WebAppConfiguration
public class DocumentServiceApplicationTests {
	
	@Autowired
	CouchbaseTemplate couchBaseTemplate;
	
	@Autowired
	DocumentServiceDao docServiceDao;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSaveDocument(){
		InputStream inputStream = null;
		String tempPropId = "12343333";
		try {
			inputStream = new FileInputStream(
					"C:\\Users\\spendyal\\Desktop\\psm_test_input_ files\\DSC_0175.JPG");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		docServiceDao.saveDocument(inputStream, tempPropId, null);
	}
	
	@Test
	public void testViewDocument() {
		ByteArrayOutputStream outputStream = null;
		String tempPropId = "1234568";

		outputStream = docServiceDao.viewDocument(tempPropId,
				SectionType.PROJECT_DESCRIPTION);
		System.out.println("**END" + outputStream.size());
	}
	
	@Test
	public void testDeleteDocument() {
	
		String tempPropId = "1234568";

		docServiceDao.deleteDocument(tempPropId,SectionType.PROJECT_DESCRIPTION);
		
	}
	
	@Test
	@Ignore
	public void testAWSS3(){
		AmazonS3 conn = amazonS3;
		
		List<Bucket> buckets = conn.listBuckets();
		for (Bucket bucket : buckets) {
		        System.out.println(bucket.getName() + "\t" +
		                StringUtils.fromDate(bucket.getCreationDate()));
		}
		
//		ByteArrayInputStream input = new ByteArrayInputStream("Hello World!".getBytes());
//		conn.putObject("psm-data-store", "hello.txt", input, new ObjectMetadata());
	}
	
}

