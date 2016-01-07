package gov.nsf.research.document.service.dao.impl;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.s3.AmazonS3;

import gov.nsf.research.document.service.dao.FileStoreDao;

public class FileStoreDaoAmazonS3Impl implements FileStoreDao {

	@Autowired
	AmazonS3 amazonS3;
	
	@Override
	public boolean checkFileExist(String bucketName, String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uploadFile(InputStream inputStream, String bucketName, String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFile(String bucketName, String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OutputStream downloadFile(String bucketName, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
