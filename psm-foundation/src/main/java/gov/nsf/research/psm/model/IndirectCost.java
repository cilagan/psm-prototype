package gov.nsf.research.psm.model;

import java.math.BigDecimal;

public class IndirectCost {

	private String tempPropId;
	private String performingOrgId;
	private int budgetYear;
	private String indirectCostItemName;
	private BigDecimal indirectCostRate;
	private BigDecimal indirectCostBase;
	private BigDecimal indirectCostDollarRequested;
	
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
	 * @return the indirectCostItemName
	 */
	public String getIndirectCostItemName() {
		return indirectCostItemName;
	}
	/**
	 * @param indirectCostItemName the indirectCostItemName to set
	 */
	public void setIndirectCostItemName(String indirectCostItemName) {
		this.indirectCostItemName = indirectCostItemName;
	}
	/**
	 * @return the indirectCostRate
	 */
	public BigDecimal getIndirectCostRate() {
		return indirectCostRate;
	}
	/**
	 * @param indirectCostRate the indirectCostRate to set
	 */
	public void setIndirectCostRate(BigDecimal indirectCostRate) {
		this.indirectCostRate = indirectCostRate;
	}
	/**
	 * @return the indirectCostBase
	 */
	public BigDecimal getIndirectCostBase() {
		return indirectCostBase;
	}
	/**
	 * @param indirectCostBase the indirectCostBase to set
	 */
	public void setIndirectCostBase(BigDecimal indirectCostBase) {
		this.indirectCostBase = indirectCostBase;
	}
	/**
	 * @return the indirectCostDollarRequested
	 */
	public BigDecimal getIndirectCostDollarRequested() {
		return indirectCostDollarRequested;
	}
	/**
	 * @param indirectCostDollarRequested the indirectCostDollarRequested to set
	 */
	public void setIndirectCostDollarRequested(
			BigDecimal indirectCostDollarRequested) {
		this.indirectCostDollarRequested = indirectCostDollarRequested;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IndirectCost [tempPropId=" + tempPropId + ", performingOrgId="
				+ performingOrgId + ", budgetYear=" + budgetYear
				+ ", indirectCostItemName=" + indirectCostItemName
				+ ", indirectCostRate=" + indirectCostRate
				+ ", indirectCostBase=" + indirectCostBase
				+ ", indirectCostDollarRequested="
				+ indirectCostDollarRequested + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + budgetYear;
		result = prime
				* result
				+ ((indirectCostBase == null) ? 0 : indirectCostBase.hashCode());
		result = prime
				* result
				+ ((indirectCostDollarRequested == null) ? 0
						: indirectCostDollarRequested.hashCode());
		result = prime
				* result
				+ ((indirectCostItemName == null) ? 0 : indirectCostItemName
						.hashCode());
		result = prime
				* result
				+ ((indirectCostRate == null) ? 0 : indirectCostRate.hashCode());
		result = prime * result
				+ ((performingOrgId == null) ? 0 : performingOrgId.hashCode());
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
		IndirectCost other = (IndirectCost) obj;
		if (budgetYear != other.budgetYear)
			return false;
		if (indirectCostBase == null) {
			if (other.indirectCostBase != null)
				return false;
		} else if (!indirectCostBase.equals(other.indirectCostBase))
			return false;
		if (indirectCostDollarRequested == null) {
			if (other.indirectCostDollarRequested != null)
				return false;
		} else if (!indirectCostDollarRequested
				.equals(other.indirectCostDollarRequested))
			return false;
		if (indirectCostItemName == null) {
			if (other.indirectCostItemName != null)
				return false;
		} else if (!indirectCostItemName.equals(other.indirectCostItemName))
			return false;
		if (indirectCostRate == null) {
			if (other.indirectCostRate != null)
				return false;
		} else if (!indirectCostRate.equals(other.indirectCostRate))
			return false;
		if (performingOrgId == null) {
			if (other.performingOrgId != null)
				return false;
		} else if (!performingOrgId.equals(other.performingOrgId))
			return false;
		if (tempPropId == null) {
			if (other.tempPropId != null)
				return false;
		} else if (!tempPropId.equals(other.tempPropId))
			return false;
		return true;
	}
}
