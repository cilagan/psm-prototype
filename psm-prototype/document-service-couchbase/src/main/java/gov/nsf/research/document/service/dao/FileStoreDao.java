package gov.nsf.research.document.service.dao;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

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
	public boolean uploadFile(InputStream inputStream, String fileName);
	
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
	
	
	public List<String> getAllFileNames();
}