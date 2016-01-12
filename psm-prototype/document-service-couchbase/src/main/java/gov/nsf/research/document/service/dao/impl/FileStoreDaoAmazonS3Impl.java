package gov.nsf.research.document.service.dao.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import gov.nsf.research.document.service.dao.FileStoreDao;
import gov.nsf.research.document.service.dao.MetaDataServiceDao;

public class FileStoreDaoAmazonS3Impl implements FileStoreDao {
	
	private static final String BUCKET_NAME = "psm-data-store-01";

	@Autowired
	AmazonS3 amazonS3;
	
	@Autowired
	MetaDataServiceDao metaDataServiceDao;

	@Override
	public boolean checkFileExist(String fileName) {
		boolean fileExist = false;

		try {
			ObjectListing objectListing = amazonS3.listObjects(new ListObjectsRequest().withBucketName(BUCKET_NAME));
			for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
				String key = objectSummary.getKey();
				System.out.println(" Key - " + key);
				if(fileName.equals(key)){
					fileExist = true;
					break;
				}
			}
		}  catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which " +
					"means your request made it " +
					"to Amazon S3, but was rejected with an error response" +
					" for some reason.");
			System.out.println("Error Message: " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code: " + ase.getErrorCode());
			System.out.println("Error Type: " + ase.getErrorType());
			System.out.println("Request ID: " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which " +
					"means the client encountered " +
					"an internal error while trying to " +
					"communicate with S3, " +
					"such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}

		return fileExist;
	}

	@Override
	public boolean uploadFile(InputStream inputStream, String fileName) {
		
		amazonS3.putObject(new PutObjectRequest(BUCKET_NAME, fileName,
				inputStream, new ObjectMetadata()));

		return true;
	}


	@Override
	public boolean deleteFile(String fileName) {
		boolean deleted = false;

		try {
			amazonS3.deleteObject(new DeleteObjectRequest(BUCKET_NAME, fileName));

			deleted = true;
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which " +
					"means your request made it " +
					"to Amazon S3, but was rejected with an error response" +
					" for some reason.");
			System.out.println("Error Message: " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code: " + ase.getErrorCode());
			System.out.println("Error Type: " + ase.getErrorType());
			System.out.println("Request ID: " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which " +
					"means the client encountered " +
					"an internal error while trying to " +
					"communicate with S3, " +
					"such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}

		return deleted;
	}

	@Override
	public OutputStream downloadFile(String fileName) {
		ByteArrayOutputStream out = null;
		try {
			System.out.println("Downloading an object fileName : "+fileName);
			S3Object object = amazonS3.getObject(new GetObjectRequest(BUCKET_NAME,fileName));
			System.out.println("Content-Type: " + object.getObjectMetadata().getContentType());
			InputStream in = object.getObjectContent();
			byte[] buff = new byte[in.read()];
			int bytesRead = 0;
			out = new ByteArrayOutputStream();
			while((bytesRead = in.read(buff)) != -1) {
				out.write(buff, 0, bytesRead);
			}
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which" +
					" means your request made it " +
					"to Amazon S3, but was rejected with an error response" +
					" for some reason.");
			System.out.println("Error Message: " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code: " + ase.getErrorCode());
			System.out.println("Error Type: " + ase.getErrorType());
			System.out.println("Request ID: " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which means"+
					" the client encountered " +
					"an internal error while trying to " +
					"communicate with S3, " +
					"such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}catch(Exception e){
			e.printStackTrace();
		}
		return out;

	}

}
