package gov.nsf.research.document.service.dao.impl;

import gov.nsf.research.document.service.dao.FileStoreDao;
import gov.nsf.research.document.service.dao.MetaDataServiceDao;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class FileStoreDaoAmazonS3Impl implements FileStoreDao {
	
	private static final String BUCKET_NAME = "psm_data_store_01";

	@Autowired
	AmazonS3 amazonS3;
	
	@Autowired
	MetaDataServiceDao metaDataServiceDao;

	@Override
	public boolean checkFileExist(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uploadFile(InputStream inputStream, String fileName) {
		
		amazonS3.putObject(new PutObjectRequest(BUCKET_NAME, fileName,
				inputStream, new ObjectMetadata()));

		return true;
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
