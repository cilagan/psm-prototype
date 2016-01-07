package gov.nsf.research.document.service.dao.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import gov.nsf.research.document.service.dao.FileStoreDao;

public class FileStoreDaoAmazonS3Impl implements FileStoreDao {

	@Autowired
	AmazonS3 amazonS3;

	@Override
	public boolean checkFileExist(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uploadFile(InputStream inputStream, String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFile(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OutputStream downloadFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
