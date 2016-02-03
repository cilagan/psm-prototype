package gov.nsf.research.psm.model;

import java.util.Date;

/**
 * Proposal Funding Opportunity
 * 
 * @author cilagan
 *
 */
public class FundingOpportunity {

	private String fundingOpportunityId;
	private String fundingOpportunityType;
	private Date fundingOpportunityDeadline;
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FundingOpportunity [fundingOpportunityId="
				+ fundingOpportunityId + ", fundingOpportunityType="
				+ fundingOpportunityType + ", fundingOpportunityDeadline="
				+ fundingOpportunityDeadline + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((fundingOpportunityDeadline == null) ? 0
						: fundingOpportunityDeadline.hashCode());
		result = prime
				* result
				+ ((fundingOpportunityId == null) ? 0 : fundingOpportunityId
						.hashCode());
		result = prime
				* result
				+ ((fundingOpportunityType == null) ? 0
						: fundingOpportunityType.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FundingOpportunity other = (FundingOpportunity) obj;
		if (fundingOpportunityDeadline == null) {
			if (other.fundingOpportunityDeadline != null)
				return false;
		} else if (!fundingOpportunityDeadline
				.equals(other.fundingOpportunityDeadline))
			return false;
		if (fundingOpportunityId == null) {
			if (other.fundingOpportunityId != null)
				return false;
		} else if (!fundingOpportunityId.equals(other.fundingOpportunityId))
			return false;
		if (fundingOpportunityType == null) {
			if (other.fundingOpportunityType != null)
				return false;
		} else if (!fundingOpportunityType.equals(other.fundingOpportunityType))
			return false;
		return true;
	}
		
}
