package gov.nsf.research.document.service.dao;

import java.io.InputStream;
import java.io.OutputStream;

import gov.nsf.research.document.service.model.DocumentMetaData;

public interface FileStoreDao {
	
	/**
	 * Checks if the specified file exists
	 * @param bucketName
	 * @param fileName
	 * @return
	 */
	public boolean checkFileExist(String fileName);
	
	/**
	 * Uploads file from specified bucket
	 * @param inputStream
	 * @param bucketName
	 * @param fileName
	 * @return
	 */
	public boolean uploadFile(InputStream inputStream, DocumentMetaData docMetaData);
	
	/**
	 * Deletes file from specified bucket
	 * @param bucketName
	 * @param fileName
	 * @return
	 */
	public boolean deleteFile(String fileName);
	
	/**
	 * Downloads file from specified bucket
	 * @param bucketName
	 * @param fileName
	 * @return
	 */
	public OutputStream downloadFile(String fileName);
}