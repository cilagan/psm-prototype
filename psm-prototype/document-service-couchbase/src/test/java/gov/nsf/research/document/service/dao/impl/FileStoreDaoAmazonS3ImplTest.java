package gov.nsf.research.document.service.dao.impl;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
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
		ByteArrayOutputStream out = (ByteArrayOutputStream)fileStoreDao.downloadFile("hello.txt");

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
		String bucketName = "psm-data-store-01";
		String key = "test.txt";
		
		List<Bucket> buckets = conn.listBuckets();
		for (Bucket bucket : buckets) {
		        System.out.println(bucket.getName() + "\t" + StringUtils.fromDate(bucket.getCreationDate()));
		}
        System.out.println("Listing objects");
        ObjectListing objectListing = amazonS3.listObjects(new ListObjectsRequest().withBucketName(bucketName));
        for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" Key - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }
        
        System.out.println();
		
        
		try {
            System.out.println("Uploading a new object to S3 from a file\n");
//            amazonS3.putObject(new PutObjectRequest(bucketName, key, createSampleFile()));

            /*
             * Download an object - When you download an object, you get all of
             * the object's metadata and a stream from which to read the contents.
             * It's important to read the contents of the stream as quickly as
             * possibly since the data is streamed directly from Amazon S3 and your
             * network connection will remain open until you read all the data or
             * close the input stream.
             *
             * GetObjectRequest also supports several other options, including
             * conditional downloading of objects based on modification times,
             * ETags, and selectively downloading a range of an object.
             */
            System.out.println("Downloading an object");
            S3Object object = amazonS3.getObject(new GetObjectRequest(bucketName, key));
            System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
            displayTextInputStream(object.getObjectContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ByteArrayInputStream input = new ByteArrayInputStream("Hello World!".getBytes());
//		conn.putObject("psm-data-store", "hello.txt", input, new ObjectMetadata());
	}
	
    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("aws-java-sdk-", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("01234567890112345678901234\n");
        writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
        writer.write("01234567890112345678901234\n");
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.close();

        return file;
    }

    /**
     * Displays the contents of the specified input stream as text.
     *
     * @param input
     *            The input stream to display as text.
     *
     * @throws IOException
     */
    private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("    " + line);
        }
        System.out.println();
    }

	
}
