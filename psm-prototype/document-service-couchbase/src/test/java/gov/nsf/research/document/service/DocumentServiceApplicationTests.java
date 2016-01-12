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
	
	
	@Test
	@Ignore
	public void testViewDocument(){
	
		docServiceDao.viewDocument("test.txt", SectionType.DATA_MANAGEMENT_PLAN, 1);
//		ByteArrayInputStream input = new ByteArrayInputStream("Hello World!".getBytes());
//		conn.putObject("psm-data-store", "hello.txt", input, new ObjectMetadata());
	}
	
}

