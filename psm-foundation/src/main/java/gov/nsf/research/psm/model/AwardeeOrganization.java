package gov.nsf.research.psm.model;

public class AwardeeOrganization extends Organization {

	private static final long serialVersionUID = 3091754513867569340L;
	
	private String orgId;
	private String dunsNumber;
	private String tinEinNumber;
	private boolean isForProfit;
	private boolean isSmallBusiness;
	private boolean isMinorityBusiness;
	private boolean isWomenOwnedBusiness;

	public AwardeeOrganization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AwardeeOrganization(String orgId, String orgName, String strAddress,
			String city, String state, String zipCode, String cntry,
			String dunsNumber, String tinEinNumber, boolean isForProfit,
			boolean isSmallBusiness, boolean isMinorityBusiness,
			boolean isWomenOwnedBusiness) {
		super(orgName, strAddress, city, state, zipCode, cntry);
		this.orgId=orgId;
		this.dunsNumber = dunsNumber;
		this.tinEinNumber = tinEinNumber;
		this.isForProfit = isForProfit;
		this.isSmallBusiness = isSmallBusiness;
		this.isMinorityBusiness = isMinorityBusiness;
		this.isWomenOwnedBusiness = isWomenOwnedBusiness;
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the dunsNumber
	 */
	public String getDunsNumber() {
		return dunsNumber;
	}

	/**
	 * @param dunsNumber the dunsNumber to set
	 */
	public void setDunsNumber(String dunsNumber) {
		this.dunsNumber = dunsNumber;
	}

	/**
	 * @return the tinEinNumber
	 */
	public String getTinEinNumber() {
		return tinEinNumber;
	}

	/**
	 * @param tinEinNumber the tinEinNumber to set
	 */
	public void setTinEinNumber(String tinEinNumber) {
		this.tinEinNumber = tinEinNumber;
	}

	/**
	 * @return the isForProfit
	 */
	public boolean isForProfit() {
		return isForProfit;
	}

	/**
	 * @param isForProfit the isForProfit to set
	 */
	public void setForProfit(boolean isForProfit) {
		this.isForProfit = isForProfit;
	}

	/**
	 * @return the isSmallBusiness
	 */
	public boolean isSmallBusiness() {
		return isSmallBusiness;
	}

	/**
	 * @param isSmallBusiness the isSmallBusiness to set
	 */
	public void setSmallBusiness(boolean isSmallBusiness) {
		this.isSmallBusiness = isSmallBusiness;
	}

	/**
	 * @return the isMinorityBusiness
	 */
	public boolean isMinorityBusiness() {
		return isMinorityBusiness;
	}

	/**
	 * @param isMinorityBusiness the isMinorityBusiness to set
	 */
	public void setMinorityBusiness(boolean isMinorityBusiness) {
		this.isMinorityBusiness = isMinorityBusiness;
	}

	/**
	 * @return the isWomenOwnedBusiness
	 */
	public boolean isWomenOwnedBusiness() {
		return isWomenOwnedBusiness;
	}

	/**
	 * @param isWomenOwnedBusiness the isWomenOwnedBusiness to set
	 */
	public void setWomenOwnedBusiness(boolean isWomenOwnedBusiness) {
		this.isWomenOwnedBusiness = isWomenOwnedBusiness;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AwardeeOrganization [orgId=" + orgId + ", dunsNumber="
				+ dunsNumber + ", tinEinNumber=" + tinEinNumber
				+ ", isForProfit=" + isForProfit + ", isSmallBusiness="
				+ isSmallBusiness + ", isMinorityBusiness="
				+ isMinorityBusiness + ", isWomenOwnedBusiness="
				+ isWomenOwnedBusiness + ", getOrgName()=" + getOrgName()
				+ ", getStrAddress()=" + getStrAddress() + ", getCity()="
				+ getCity() + ", getState()=" + getState() + ", getZipCode()="
				+ getZipCode() + ", getCntry()=" + getCntry() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dunsNumber == null) ? 0 : dunsNumber.hashCode());
		result = prime * result + (isForProfit ? 1231 : 1237);
		result = prime * result + (isMinorityBusiness ? 1231 : 1237);
		result = prime * result + (isSmallBusiness ? 1231 : 1237);
		result = prime * result + (isWomenOwnedBusiness ? 1231 : 1237);
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result
				+ ((tinEinNumber == null) ? 0 : tinEinNumber.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AwardeeOrganization other = (AwardeeOrganization) obj;
		if (dunsNumber == null) {
			if (other.dunsNumber != null)
				return false;
		} else if (!dunsNumber.equals(other.dunsNumber))
			return false;
		if (isForProfit != other.isForProfit)
			return false;
		if (isMinorityBusiness != other.isMinorityBusiness)
			return false;
		if (isSmallBusiness != other.isSmallBusiness)
			return false;
		if (isWomenOwnedBusiness != other.isWomenOwnedBusiness)
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (tinEinNumber == null) {
			if (other.tinEinNumber != null)
				return false;
		} else if (!tinEinNumber.equals(other.tinEinNumber))
			return false;
		return true;
	}


	
	
	

}
