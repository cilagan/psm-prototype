package gov.nsf.research.psm.model;

public class UnitOfConsideration {
	String orgCode;
	String orgName;
	String programElementCode;
	String programElementName;
	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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
	 * @return the programElementCode
	 */
	public String getProgramElementCode() {
		return programElementCode;
	}
	/**
	 * @param programElementCode the programElementCode to set
	 */
	public void setProgramElementCode(String programElementCode) {
		this.programElementCode = programElementCode;
	}
	/**
	 * @return the programElementName
	 */
	public String getProgramElementName() {
		return programElementName;
	}
	/**
	 * @param programElementName the programElementName to set
	 */
	public void setProgramElementName(String programElementName) {
		this.programElementName = programElementName;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnitOfConsideration [orgCode=" + orgCode + ", orgName="
				+ orgName + ", programElementCode=" + programElementCode
				+ ", programElementName=" + programElementName + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime
				* result
				+ ((programElementCode == null) ? 0 : programElementCode
						.hashCode());
		result = prime
				* result
				+ ((programElementName == null) ? 0 : programElementName
						.hashCode());
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
		UnitOfConsideration other = (UnitOfConsideration) obj;
		if (orgCode == null) {
			if (other.orgCode != null)
				return false;
		} else if (!orgCode.equals(other.orgCode))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (programElementCode == null) {
			if (other.programElementCode != null)
				return false;
		} else if (!programElementCode.equals(other.programElementCode))
			return false;
		if (programElementName == null) {
			if (other.programElementName != null)
				return false;
		} else if (!programElementName.equals(other.programElementName))
			return false;
		return true;
	}
	
	
	
}
