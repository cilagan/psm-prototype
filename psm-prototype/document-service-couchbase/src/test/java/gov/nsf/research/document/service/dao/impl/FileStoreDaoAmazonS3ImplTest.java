package gov.nsf.research.document.service.dao.impl;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import gov.nsf.research.document.service.pdf.DocServiceUtility;

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
        ByteArrayOutputStream out = (ByteArrayOutputStream)fileStoreDao.downloadFile("mongo-sample.pdf");
        
        File file = new File("C://Apps//test.pdf");
        
        try {
			OutputStream fileOut = new FileOutputStream(file);
			out.writeTo(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("=======Print the content======== ");

        byte b [] = out.toByteArray();
        for(int x= 0 ; x < b.length; x++) {
            //printing the characters
            System.out.print((char)b[x]); 
        }
        System.out.println(" \n=========content END================== ");

		
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
	
	@Test
	public void testGetAllFileNames(){
		List<String> fileNameList = fileStoreDao.getAllFileNames();
		for(String fileName : fileNameList){
			System.out.println("FileName: "+ fileName);
		}
		
		DocServiceUtility.extractDocMetaDataFromFileName(fileNameList);
	}
}
