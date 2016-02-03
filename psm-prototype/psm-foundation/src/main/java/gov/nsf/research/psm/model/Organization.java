package gov.nsf.research.psm.model;

public class Organization {

	
	private String orgName;
	private String strAddress;
	private String city;
	private String state;
	private String zipCode;
	private String cntry;
	
	
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Organization(String orgName, String strAddress,
			String city, String state, String zipCode, String cntry) {
		super();
		
		this.orgName = orgName;
		this.strAddress = strAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.cntry = cntry;
	}




	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}


	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	/**
	 * @return the strAddress
	 */
	public String getStrAddress() {
		return strAddress;
	}


	/**
	 * @param strAddress the strAddress to set
	 */
	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}


	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	/**
	 * @return the cntry
	 */
	public String getCntry() {
		return cntry;
	}


	/**
	 * @param cntry the cntry to set
	 */
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Organization [orgName=" + orgName
				+ ", strAddress=" + strAddress + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", cntry=" + cntry + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((cntry == null) ? 0 : cntry.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((strAddress == null) ? 0 : strAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Organization other = (Organization) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cntry == null) {
			if (other.cntry != null)
				return false;
		} else if (!cntry.equals(other.cntry))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (strAddress == null) {
			if (other.strAddress != null)
				return false;
		} else if (!strAddress.equals(other.strAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	
	
	}
