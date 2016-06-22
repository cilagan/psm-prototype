package gov.nsf.research.psm.model;

import java.math.BigDecimal;

public class EquipmentCost {

	private String tempPropId;
	private String performingOrgId;
	private int budgetYear;
	private String equipCostItemName;
	private BigDecimal equipCostDollarRequested;
	
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
	 * @return the equipCostItemName
	 */
	public String getEquipCostItemName() {
		return equipCostItemName;
	}
	/**
	 * @param equipCostItemName the equipCostItemName to set
	 */
	public void setEquipCostItemName(String equipCostItemName) {
		this.equipCostItemName = equipCostItemName;
	}
	/**
	 * @return the equipCostDollarRequested
	 */
	public BigDecimal getEquipCostDollarRequested() {
		return equipCostDollarRequested;
	}
	/**
	 * @param equipCostDollarRequested the equipCostDollarRequested to set
	 */
	public void setEquipCostDollarRequested(BigDecimal equipCostDollarRequested) {
		this.equipCostDollarRequested = equipCostDollarRequested;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EquipmentCost [tempPropId=" + tempPropId + ", performingOrgId="
				+ performingOrgId + ", budgetYear=" + budgetYear
				+ ", equipCostItemName=" + equipCostItemName
				+ ", equipCostDollarRequested=" + equipCostDollarRequested
				+ "]";
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
				+ ((equipCostDollarRequested == null) ? 0
						: equipCostDollarRequested.hashCode());
		result = prime
				* result
				+ ((equipCostItemName == null) ? 0 : equipCostItemName
						.hashCode());
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
		EquipmentCost other = (EquipmentCost) obj;
		if (budgetYear != other.budgetYear)
			return false;
		if (equipCostDollarRequested == null) {
			if (other.equipCostDollarRequested != null)
				return false;
		} else if (!equipCostDollarRequested
				.equals(other.equipCostDollarRequested))
			return false;
		if (equipCostItemName == null) {
			if (other.equipCostItemName != null)
				return false;
		} else if (!equipCostItemName.equals(other.equipCostItemName))
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
