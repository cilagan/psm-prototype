package gov.nsf.research.document.service.model.proposal;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import gov.nsf.research.document.service.model.AbstractTransferObject;

@Document
public class ProjectSummary extends AbstractTransferObject {
	
	private static final long serialVersionUID = 1434641520396503475L;

	@Id
	String id;
	String tempPropId;
	Date lastUpdttmsp;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	 * @return the lastUpdttmsp
	 */
	public Date getLastUpdttmsp() {
		return lastUpdttmsp;
	}
	/**
	 * @param lastUpdttmsp the lastUpdttmsp to set
	 */
	public void setLastUpdttmsp(Date lastUpdttmsp) {
		this.lastUpdttmsp = lastUpdttmsp;
	}
	
	
}
