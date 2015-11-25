package gov.nsf.research.document.service.model;

import java.util.Date;

public class DocumentMetaData extends AbstractTransferObject {

	private static final long serialVersionUID = -2286699837590905590L;
	
	private String fileName;
	private Long length;
	private String contentType;
	private String MD5;
	private Date uploadDate;
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * @return the length
	 */
	public Long getLength() {
		return length;
	}
	
	/**
	 * @param length the length to set
	 */
	public void setLength(Long length) {
		this.length = length;
	}
	
	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}
	
	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	/**
	 * @return the mD5
	 */
	public String getMD5() {
		return MD5;
	}
	
	/**
	 * @param mD5 the mD5 to set
	 */
	public void setMD5(String mD5) {
		MD5 = mD5;
	}
	
	/**
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}
	
	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}	
}
