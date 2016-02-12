package gov.nsf.research.psm.model;

import java.util.Date;
import java.util.List;

/**
 * Proposal Funding Opportunity
 * 
 * @author cilagan
 *
 */
public class FundingOpportunity extends AbstractTransferObject{

	private String fundingOpportunityId;
	private String fundingOpportunityType;
	private Date fundingOpportunityDeadline;
	private String fundingOpportunityTitle;
	private List<Directorate> directorateList;
	
	/**
	 * 
	 * @return
	 */
	public String getFundingOpportunityTitle() {
		return fundingOpportunityTitle;
	}
	/**
	 * 
	 * @param fundingOpportunityTitle
	 */
	
	/**
	 * 
	 * @param fundingOpportunityTitle
	 */
	public void setFundingOpportunityTitle(String fundingOpportunityTitle) {
		this.fundingOpportunityTitle = fundingOpportunityTitle;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Directorate> getDirectorateList() {
		return directorateList;
	}
	/**
	 * 
	 * @param directorateList
	 */
	public void setDirectorateList(List<Directorate> directorateList) {
		this.directorateList = directorateList;
	}

	
	
	/**
	 * @return the fundingOpportunityId
	 */
	public String getFundingOpportunityId() {
		return fundingOpportunityId;
	}
	/**
	 * @param fundingOpportunityId the fundingOpportunityId to set
	 */
	public void setFundingOpportunityId(String fundingOpportunityId) {
		this.fundingOpportunityId = fundingOpportunityId;
	}
	/**
	 * @return the fundingOpportunityType
	 */
	public String getFundingOpportunityType() {
		return fundingOpportunityType;
	}
	/**
	 * @param fundingOpportunityType the fundingOpportunityType to set
	 */
	public void setFundingOpportunityType(String fundingOpportunityType) {
		this.fundingOpportunityType = fundingOpportunityType;
	}
	/**
	 * @return the fundingOpportunityDeadline
	 */
	public Date getFundingOpportunityDeadline() {
		return fundingOpportunityDeadline;
	}
	/**
	 * @param fundingOpportunityDeadline the fundingOpportunityDeadline to set
	 */
	public void setFundingOpportunityDeadline(Date fundingOpportunityDeadline) {
		this.fundingOpportunityDeadline = fundingOpportunityDeadline;
	}	
}
