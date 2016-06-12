package gov.nsf.research.psm.model;

import java.math.BigDecimal;

public class SeniorPersonnelBudget {

	private String tempPropId;
	private String performingOrgId;
	private int budgetYear;
	private String srFirstName;
	private String srLastName;
	private String srMidName;
	private String srTitle;
	private BigDecimal calMonthCount;
	private BigDecimal acadMonthCount;
	private BigDecimal summMonthCount;
	private BigDecimal requestedDollars;
	
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
	 * @return the performingOrgId
	 */
	public String getPerformingOrgId() {
		return performingOrgId;
	}
	/**
	 * @param performingOrgId the performingOrgId to set
	 */
	public void setPerformingOrgId(String performingOrgId) {
		this.performingOrgId = performingOrgId;
	}
	/**
	 * @return the budgetYear
	 */
	public int getBudgetYear() {
		return budgetYear;
	}
	/**
	 * @param budgetYear the budgetYear to set
	 */
	public void setBudgetYear(int budgetYear) {
		this.budgetYear = budgetYear;
	}
	/**
	 * @return the srFirstName
	 */
	public String getSrFirstName() {
		return srFirstName;
	}
	/**
	 * @param srFirstName the srFirstName to set
	 */
	public void setSrFirstName(String srFirstName) {
		this.srFirstName = srFirstName;
	}
	/**
	 * @return the srLastName
	 */
	public String getSrLastName() {
		return srLastName;
	}
	/**
	 * @param srLastName the srLastName to set
	 */
	public void setSrLastName(String srLastName) {
		this.srLastName = srLastName;
	}
	/**
	 * @return the srMidName
	 */
	public String getSrMidName() {
		return srMidName;
	}
	/**
	 * @param srMidName the srMidName to set
	 */
	public void setSrMidName(String srMidName) {
		this.srMidName = srMidName;
	}
	/**
	 * @return the srTitle
	 */
	public String getSrTitle() {
		return srTitle;
	}
	/**
	 * @param srTitle the srTitle to set
	 */
	public void setSrTitle(String srTitle) {
		this.srTitle = srTitle;
	}
	/**
	 * @return the calMonthCount
	 */
	public BigDecimal getCalMonthCount() {
		return calMonthCount;
	}
	/**
	 * @param calMonthCount the calMonthCount to set
	 */
	public void setCalMonthCount(BigDecimal calMonthCount) {
		this.calMonthCount = calMonthCount;
	}
	/**
	 * @return the acadMonthCount
	 */
	public BigDecimal getAcadMonthCount() {
		return acadMonthCount;
	}
	/**
	 * @param acadMonthCount the acadMonthCount to set
	 */
	public void setAcadMonthCount(BigDecimal acadMonthCount) {
		this.acadMonthCount = acadMonthCount;
	}
	/**
	 * @return the summMonthCount
	 */
	public BigDecimal getSummMonthCount() {
		return summMonthCount;
	}
	/**
	 * @param summMonthCount the summMonthCount to set
	 */
	public void setSummMonthCount(BigDecimal summMonthCount) {
		this.summMonthCount = summMonthCount;
	}
	/**
	 * @return the requestedDollars
	 */
	public BigDecimal getRequestedDollars() {
		return requestedDollars;
	}
	/**
	 * @param requestedDollars the requestedDollars to set
	 */
	public void setRequestedDollars(BigDecimal requestedDollars) {
		this.requestedDollars = requestedDollars;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SeniorPersonnelBudget [tempPropId=" + tempPropId
				+ ", performingOrgId=" + performingOrgId + ", budgetYear="
				+ budgetYear + ", srFirstName=" + srFirstName + ", srLastName="
				+ srLastName + ", srMidName=" + srMidName + ", srTitle="
				+ srTitle + ", calMonthCount=" + calMonthCount
				+ ", acadMonthCount=" + acadMonthCount + ", summMonthCount="
				+ summMonthCount + ", requestedDollars=" + requestedDollars
				+ "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((acadMonthCount == null) ? 0 : acadMonthCount.hashCode());
		result = prime * result + budgetYear;
		result = prime * result
				+ ((calMonthCount == null) ? 0 : calMonthCount.hashCode());
		result = prime * result
				+ ((performingOrgId == null) ? 0 : performingOrgId.hashCode());
		result = prime
				* result
				+ ((requestedDollars == null) ? 0 : requestedDollars.hashCode());
		result = prime * result
				+ ((srFirstName == null) ? 0 : srFirstName.hashCode());
		result = prime * result
				+ ((srLastName == null) ? 0 : srLastName.hashCode());
		result = prime * result
				+ ((srMidName == null) ? 0 : srMidName.hashCode());
		result = prime * result + ((srTitle == null) ? 0 : srTitle.hashCode());
		result = prime * result
				+ ((summMonthCount == null) ? 0 : summMonthCount.hashCode());
		result = prime * result
				+ ((tempPropId == null) ? 0 : tempPropId.hashCode());
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
		SeniorPersonnelBudget other = (SeniorPersonnelBudget) obj;
		if (acadMonthCount == null) {
			if (other.acadMonthCount != null)
				return false;
		} else if (!acadMonthCount.equals(other.acadMonthCount))
			return false;
		if (budgetYear != other.budgetYear)
			return false;
		if (calMonthCount == null) {
			if (other.calMonthCount != null)
				return false;
		} else if (!calMonthCount.equals(other.calMonthCount))
			return false;
		if (performingOrgId == null) {
			if (other.performingOrgId != null)
				return false;
		} else if (!performingOrgId.equals(other.performingOrgId))
			return false;
		if (requestedDollars == null) {
			if (other.requestedDollars != null)
				return false;
		} else if (!requestedDollars.equals(other.requestedDollars))
			return false;
		if (srFirstName == null) {
			if (other.srFirstName != null)
				return false;
		} else if (!srFirstName.equals(other.srFirstName))
			return false;
		if (srLastName == null) {
			if (other.srLastName != null)
				return false;
		} else if (!srLastName.equals(other.srLastName))
			return false;
		if (srMidName == null) {
			if (other.srMidName != null)
				return false;
		} else if (!srMidName.equals(other.srMidName))
			return false;
		if (srTitle == null) {
			if (other.srTitle != null)
				return false;
		} else if (!srTitle.equals(other.srTitle))
			return false;
		if (summMonthCount == null) {
			if (other.summMonthCount != null)
				return false;
		} else if (!summMonthCount.equals(other.summMonthCount))
			return false;
		if (tempPropId == null) {
			if (other.tempPropId != null)
				return false;
		} else if (!tempPropId.equals(other.tempPropId))
			return false;
		return true;
	}

}
