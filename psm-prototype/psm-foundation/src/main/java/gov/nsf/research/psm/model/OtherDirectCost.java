package gov.nsf.research.psm.model;

import java.math.BigDecimal;

public class OtherDirectCost {

	private BigDecimal materialsSuppliesDollars;
	private BigDecimal publicationDocumentationDollars;
	private BigDecimal consultantServiceDollars;
	private BigDecimal computerServicesDollars;
	private BigDecimal subcontractDollars;
	private BigDecimal otherDirectCostDollars;
	
	/**
	 * @return the materialsSuppliesDollars
	 */
	public BigDecimal getMaterialsSuppliesDollars() {
		return materialsSuppliesDollars;
	}
	/**
	 * @param materialsSuppliesDollars the materialsSuppliesDollars to set
	 */
	public void setMaterialsSuppliesDollars(BigDecimal materialsSuppliesDollars) {
		this.materialsSuppliesDollars = materialsSuppliesDollars;
	}
	/**
	 * @return the publicationDocumentationDollars
	 */
	public BigDecimal getPublicationDocumentationDollars() {
		return publicationDocumentationDollars;
	}
	/**
	 * @param publicationDocumentationDollars the publicationDocumentationDollars to set
	 */
	public void setPublicationDocumentationDollars(
			BigDecimal publicationDocumentationDollars) {
		this.publicationDocumentationDollars = publicationDocumentationDollars;
	}
	/**
	 * @return the consultantServiceDollars
	 */
	public BigDecimal getConsultantServiceDollars() {
		return consultantServiceDollars;
	}
	/**
	 * @param consultantServiceDollars the consultantServiceDollars to set
	 */
	public void setConsultantServiceDollars(BigDecimal consultantServiceDollars) {
		this.consultantServiceDollars = consultantServiceDollars;
	}
	/**
	 * @return the computerServicesDollars
	 */
	public BigDecimal getComputerServicesDollars() {
		return computerServicesDollars;
	}
	/**
	 * @param computerServicesDollars the computerServicesDollars to set
	 */
	public void setComputerServicesDollars(BigDecimal computerServicesDollars) {
		this.computerServicesDollars = computerServicesDollars;
	}
	/**
	 * @return the subcontractDollars
	 */
	public BigDecimal getSubcontractDollars() {
		return subcontractDollars;
	}
	/**
	 * @param subcontractDollars the subcontractDollars to set
	 */
	public void setSubcontractDollars(BigDecimal subcontractDollars) {
		this.subcontractDollars = subcontractDollars;
	}
	/**
	 * @return the otherDirectCostDollars
	 */
	public BigDecimal getOtherDirectCostDollars() {
		return otherDirectCostDollars;
	}
	/**
	 * @param otherDirectCostDollars the otherDirectCostDollars to set
	 */
	public void setOtherDirectCostDollars(BigDecimal otherDirectCostDollars) {
		this.otherDirectCostDollars = otherDirectCostDollars;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OtherDirectCost [materialsSuppliesDollars="
				+ materialsSuppliesDollars
				+ ", publicationDocumentationDollars="
				+ publicationDocumentationDollars
				+ ", consultantServiceDollars=" + consultantServiceDollars
				+ ", computerServicesDollars=" + computerServicesDollars
				+ ", subcontractDollars=" + subcontractDollars
				+ ", otherDirectCostDollars=" + otherDirectCostDollars + "]";
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
				+ ((computerServicesDollars == null) ? 0
						: computerServicesDollars.hashCode());
		result = prime
				* result
				+ ((consultantServiceDollars == null) ? 0
						: consultantServiceDollars.hashCode());
		result = prime
				* result
				+ ((materialsSuppliesDollars == null) ? 0
						: materialsSuppliesDollars.hashCode());
		result = prime
				* result
				+ ((otherDirectCostDollars == null) ? 0
						: otherDirectCostDollars.hashCode());
		result = prime
				* result
				+ ((publicationDocumentationDollars == null) ? 0
						: publicationDocumentationDollars.hashCode());
		result = prime
				* result
				+ ((subcontractDollars == null) ? 0 : subcontractDollars
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
		OtherDirectCost other = (OtherDirectCost) obj;
		if (computerServicesDollars == null) {
			if (other.computerServicesDollars != null)
				return false;
		} else if (!computerServicesDollars
				.equals(other.computerServicesDollars))
			return false;
		if (consultantServiceDollars == null) {
			if (other.consultantServiceDollars != null)
				return false;
		} else if (!consultantServiceDollars
				.equals(other.consultantServiceDollars))
			return false;
		if (materialsSuppliesDollars == null) {
			if (other.materialsSuppliesDollars != null)
				return false;
		} else if (!materialsSuppliesDollars
				.equals(other.materialsSuppliesDollars))
			return false;
		if (otherDirectCostDollars == null) {
			if (other.otherDirectCostDollars != null)
				return false;
		} else if (!otherDirectCostDollars.equals(other.otherDirectCostDollars))
			return false;
		if (publicationDocumentationDollars == null) {
			if (other.publicationDocumentationDollars != null)
				return false;
		} else if (!publicationDocumentationDollars
				.equals(other.publicationDocumentationDollars))
			return false;
		if (subcontractDollars == null) {
			if (other.subcontractDollars != null)
				return false;
		} else if (!subcontractDollars.equals(other.subcontractDollars))
			return false;
		return true;
	}

}
