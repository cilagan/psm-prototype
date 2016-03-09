package gov.nsf.research.document.service.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Section extends AbstractTransferObject {

	private static final long serialVersionUID = -7208576129024500320L;
	
	@Id
	private String id;
	private String tempPropId;
	private Date lastUpdateDate;
	
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
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
