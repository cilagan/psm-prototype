package gov.nsf.research.document.service.dao.impl;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.StringUtils;

import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.dao.FileStoreDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
public class FileStoreDaoAmazonS3ImplTest {

	@Autowired
	FileStoreDao fileStoreDao;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testUploadFile(){
		
		InputStream inputStream = null;
		String tempPropId = "123454";
		
		try {
			inputStream = new ByteArrayInputStream(
					"C:\\Users\\spendyal\\Desktop\\psm_test_input_ files\\DSC_0175.JPG".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fileStoreDao.uploadFile(inputStream, tempPropId);

	}
	
	@Test
	public void testDownloadFile(){
		System.out.println("DocumentServiceApplicationTests.testDownloadFile() Downloading File Content :");
		fileStoreDao.downloadFile("C:\\TestUploads\\Upload.txt");
		
	}
	
	@Test
	public void tesDeleteFile(){
		System.out.println("DocumentServiceApplicationTests.testDownloadFile() deleting File");
		fileStoreDao.deleteFile("C:\\TestUploads\\Upload.txt");
		
	}
	
	
	@Test
	public void tesFileExist(){
		System.out.println("DocumentServiceApplicationTests.testDownloadFile() deleting File");
		String fileName = "12345689";
		boolean fileExist = fileStoreDao.checkFileExist(fileName);
		System.out.println("DocumentServiceApplicationTests.tesFileExist() -- ["+fileName+"] : "+fileExist);
		
	}
	
	@Test
	public void testAWSS3(){
		AmazonS3 conn = amazonS3;
		
		List<Bucket> buckets = conn.listBuckets();
		for (Bucket bucket : buckets) {
		        System.out.println(bucket.getName() + "\t" + StringUtils.fromDate(bucket.getCreationDate()));
		}
        System.out.println("Listing objects");
        ObjectListing objectListing = amazonS3.listObjects(new ListObjectsRequest().withBucketName("psm-data-store-01"));
        for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" Key - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }
        
        System.out.println();
		
//		ByteArrayInputStream input = new ByteArrayInputStream("Hello World!".getBytes());
//		conn.putObject("psm-data-store", "hello.txt", input, new ObjectMetadata());
	}
	
}
