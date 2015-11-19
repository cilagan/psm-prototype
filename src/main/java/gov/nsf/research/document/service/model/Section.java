package gov.nsf.research.document.service.model;

import java.util.Date;

public class Section {

	private String tempPropId;
	private Date lastUpdateDate;
	
	/**
	 * @return the tempPropId
	 */
	public String getTempPropId() {
		return tempPropId;
	}
	
	/**
	 * @param tempPropId the tempPropId to set
	 */
	public void setTempPropId(String tempPropId) {
		this.tempPropId = tempPropId;
	}
	
	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
}
