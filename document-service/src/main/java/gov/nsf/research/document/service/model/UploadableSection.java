package gov.nsf.research.document.service.model;

import java.util.Date;

public class UploadableSection extends Section {

	private static final long serialVersionUID = -5417536402738985794L;
	
	private Date uploadDate;

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
