package gov.nsf.research.psm.model;

import java.math.BigDecimal;
import java.util.List;

public class Budget extends Section {

	int budgetYear;
	String performingOrgId;
	int revisionNumber;
	BudgetInfo otherSeniorPersonnelBudget;
	BudgetInfo postDoctoralScholarBudget;
	BudgetInfo otherProfessionalsBudget;
	BudgetInfo graduateStudentsBudget;
	BudgetInfo undergraduateStudentsBudget;
	BudgetInfo secretarialBudget;
	BudgetInfo otherStaffBudget;
	ParticipantSupportCost participantSupportCost;
	OtherDirectCost otherDirectCost;
	List<SeniorPersonnelBudget> snrPersBudgetList;
	List<EquipmentCost> equipCostList;
	List<IndirectCost> indirectCostList; 
	BigDecimal fringeBenefitDollars;
	BigDecimal foreignTravelDollars;
	BigDecimal domesticTravelDollars;
	BigDecimal residualFunds;
	BigDecimal costSharingDollars;
	
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
	 * @return the revisionNumber
	 */
	public int getRevisionNumber() {
		return revisionNumber;
	}
	/**
	 * @param revisionNumber the revisionNumber to set
	 */
	public void setRevisionNumber(int revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	/**
	 * @return the otherSeniorPersonnelBudget
	 */
	public BudgetInfo getOtherSeniorPersonnelBudget() {
		return otherSeniorPersonnelBudget;
	}
	/**
	 * @param otherSeniorPersonnelBudget the otherSeniorPersonnelBudget to set
	 */
	public void setOtherSeniorPersonnelBudget(BudgetInfo otherSeniorPersonnelBudget) {
		this.otherSeniorPersonnelBudget = otherSeniorPersonnelBudget;
	}
	/**
	 * @return the postDoctoralScholarBudget
	 */
	public BudgetInfo getPostDoctoralScholarBudget() {
		return postDoctoralScholarBudget;
	}
	/**
	 * @param postDoctoralScholarBudget the postDoctoralScholarBudget to set
	 */
	public void setPostDoctoralScholarBudget(BudgetInfo postDoctoralScholarBudget) {
		this.postDoctoralScholarBudget = postDoctoralScholarBudget;
	}
	/**
	 * @return the otherProfessionalsBudget
	 */
	public BudgetInfo getOtherProfessionalsBudget() {
		return otherProfessionalsBudget;
	}
	/**
	 * @param otherProfessionalsBudget the otherProfessionalsBudget to set
	 */
	public void setOtherProfessionalsBudget(BudgetInfo otherProfessionalsBudget) {
		this.otherProfessionalsBudget = otherProfessionalsBudget;
	}
	/**
	 * @return the graduateStudentsBudget
	 */
	public BudgetInfo getGraduateStudentsBudget() {
		return graduateStudentsBudget;
	}
	/**
	 * @param graduateStudentsBudget the graduateStudentsBudget to set
	 */
	public void setGraduateStudentsBudget(BudgetInfo graduateStudentsBudget) {
		this.graduateStudentsBudget = graduateStudentsBudget;
	}
	/**
	 * @return the undergraduateStudentsBudget
	 */
	public BudgetInfo getUndergraduateStudentsBudget() {
		return undergraduateStudentsBudget;
	}
	/**
	 * @param undergraduateStudentsBudget the undergraduateStudentsBudget to set
	 */
	public void setUndergraduateStudentsBudget(
			BudgetInfo undergraduateStudentsBudget) {
		this.undergraduateStudentsBudget = undergraduateStudentsBudget;
	}
	/**
	 * @return the secretarialBudget
	 */
	public BudgetInfo getSecretarialBudget() {
		return secretarialBudget;
	}
	/**
	 * @param secretarialBudget the secretarialBudget to set
	 */
	public void setSecretarialBudget(BudgetInfo secretarialBudget) {
		this.secretarialBudget = secretarialBudget;
	}
	/**
	 * @return the otherStaffBudget
	 */
	public BudgetInfo getOtherStaffBudget() {
		return otherStaffBudget;
	}
	/**
	 * @param otherStaffBudget the otherStaffBudget to set
	 */
	public void setOtherStaffBudget(BudgetInfo otherStaffBudget) {
		this.otherStaffBudget = otherStaffBudget;
	}
	/**
	 * @return the participantSupportCost
	 */
	public ParticipantSupportCost getParticipantSupportCost() {
		return participantSupportCost;
	}
	/**
	 * @param participantSupportCost the participantSupportCost to set
	 */
	public void setParticipantSupportCost(
			ParticipantSupportCost participantSupportCost) {
		this.participantSupportCost = participantSupportCost;
	}
	/**
	 * @return the otherDirectCost
	 */
	public OtherDirectCost getOtherDirectCost() {
		return otherDirectCost;
	}
	/**
	 * @param otherDirectCost the otherDirectCost to set
	 */
	public void setOtherDirectCost(OtherDirectCost otherDirectCost) {
		this.otherDirectCost = otherDirectCost;
	}
	/**
	 * @return the snrPersBudgetList
	 */
	public List<SeniorPersonnelBudget> getSnrPersBudgetList() {
		return snrPersBudgetList;
	}
	/**
	 * @param snrPersBudgetList the snrPersBudgetList to set
	 */
	public void setSnrPersBudgetList(List<SeniorPersonnelBudget> snrPersBudgetList) {
		this.snrPersBudgetList = snrPersBudgetList;
	}
	/**
	 * @return the equipCostList
	 */
	public List<EquipmentCost> getEquipCostList() {
		return equipCostList;
	}
	/**
	 * @param equipCostList the equipCostList to set
	 */
	public void setEquipCostList(List<EquipmentCost> equipCostList) {
		this.equipCostList = equipCostList;
	}
	/**
	 * @return the indirectCostList
	 */
	public List<IndirectCost> getIndirectCostList() {
		return indirectCostList;
	}
	/**
	 * @param indirectCostList the indirectCostList to set
	 */
	public void setIndirectCostList(List<IndirectCost> indirectCostList) {
		this.indirectCostList = indirectCostList;
	}
	/**
	 * @return the fringeBenefitDollars
	 */
	public BigDecimal getFringeBenefitDollars() {
		return fringeBenefitDollars;
	}
	/**
	 * @param fringeBenefitDollars the fringeBenefitDollars to set
	 */
	public void setFringeBenefitDollars(BigDecimal fringeBenefitDollars) {
		this.fringeBenefitDollars = fringeBenefitDollars;
	}
	/**
	 * @return the foreignTravelDollars
	 */
	public BigDecimal getForeignTravelDollars() {
		return foreignTravelDollars;
	}
	/**
	 * @param foreignTravelDollars the foreignTravelDollars to set
	 */
	public void setForeignTravelDollars(BigDecimal foreignTravelDollars) {
		this.foreignTravelDollars = foreignTravelDollars;
	}
	/**
	 * @return the domesticTravelDollars
	 */
	public BigDecimal getDomesticTravelDollars() {
		return domesticTravelDollars;
	}
	/**
	 * @param domesticTravelDollars the domesticTravelDollars to set
	 */
	public void setDomesticTravelDollars(BigDecimal domesticTravelDollars) {
		this.domesticTravelDollars = domesticTravelDollars;
	}
	/**
	 * @return the residualFunds
	 */
	public BigDecimal getResidualFunds() {
		return residualFunds;
	}
	/**
	 * @param residualFunds the residualFunds to set
	 */
	public void setResidualFunds(BigDecimal residualFunds) {
		this.residualFunds = residualFunds;
	}
	/**
	 * @return the costSharingDollars
	 */
	public BigDecimal getCostSharingDollars() {
		return costSharingDollars;
	}
	/**
	 * @param costSharingDollars the costSharingDollars to set
	 */
	public void setCostSharingDollars(BigDecimal costSharingDollars) {
		this.costSharingDollars = costSharingDollars;
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
				+ ((costSharingDollars == null) ? 0 : costSharingDollars
						.hashCode());
		result = prime
				* result
				+ ((domesticTravelDollars == null) ? 0 : domesticTravelDollars
						.hashCode());
		result = prime * result
				+ ((equipCostList == null) ? 0 : equipCostList.hashCode());
		result = prime
				* result
				+ ((foreignTravelDollars == null) ? 0 : foreignTravelDollars
						.hashCode());
		result = prime
				* result
				+ ((fringeBenefitDollars == null) ? 0 : fringeBenefitDollars
						.hashCode());
		result = prime
				* result
				+ ((graduateStudentsBudget == null) ? 0
						: graduateStudentsBudget.hashCode());
		result = prime
				* result
				+ ((indirectCostList == null) ? 0 : indirectCostList.hashCode());
		result = prime * result
				+ ((otherDirectCost == null) ? 0 : otherDirectCost.hashCode());
		result = prime
				* result
				+ ((otherProfessionalsBudget == null) ? 0
						: otherProfessionalsBudget.hashCode());
		result = prime
				* result
				+ ((otherSeniorPersonnelBudget == null) ? 0
						: otherSeniorPersonnelBudget.hashCode());
		result = prime
				* result
				+ ((otherStaffBudget == null) ? 0 : otherStaffBudget.hashCode());
		result = prime
				* result
				+ ((participantSupportCost == null) ? 0
						: participantSupportCost.hashCode());
		result = prime * result
				+ ((performingOrgId == null) ? 0 : performingOrgId.hashCode());
		result = prime
				* result
				+ ((postDoctoralScholarBudget == null) ? 0
						: postDoctoralScholarBudget.hashCode());
		result = prime * result
				+ ((residualFunds == null) ? 0 : residualFunds.hashCode());
		result = prime * result + revisionNumber;
		result = prime
				* result
				+ ((secretarialBudget == null) ? 0 : secretarialBudget
						.hashCode());
		result = prime
				* result
				+ ((snrPersBudgetList == null) ? 0 : snrPersBudgetList
						.hashCode());
		result = prime
				* result
				+ ((undergraduateStudentsBudget == null) ? 0
						: undergraduateStudentsBudget.hashCode());
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
		Budget other = (Budget) obj;
		if (budgetYear != other.budgetYear)
			return false;
		if (costSharingDollars == null) {
			if (other.costSharingDollars != null)
				return false;
		} else if (!costSharingDollars.equals(other.costSharingDollars))
			return false;
		if (domesticTravelDollars == null) {
			if (other.domesticTravelDollars != null)
				return false;
		} else if (!domesticTravelDollars.equals(other.domesticTravelDollars))
			return false;
		if (equipCostList == null) {
			if (other.equipCostList != null)
				return false;
		} else if (!equipCostList.equals(other.equipCostList))
			return false;
		if (foreignTravelDollars == null) {
			if (other.foreignTravelDollars != null)
				return false;
		} else if (!foreignTravelDollars.equals(other.foreignTravelDollars))
			return false;
		if (fringeBenefitDollars == null) {
			if (other.fringeBenefitDollars != null)
				return false;
		} else if (!fringeBenefitDollars.equals(other.fringeBenefitDollars))
			return false;
		if (graduateStudentsBudget == null) {
			if (other.graduateStudentsBudget != null)
				return false;
		} else if (!graduateStudentsBudget.equals(other.graduateStudentsBudget))
			return false;
		if (indirectCostList == null) {
			if (other.indirectCostList != null)
				return false;
		} else if (!indirectCostList.equals(other.indirectCostList))
			return false;
		if (otherDirectCost == null) {
			if (other.otherDirectCost != null)
				return false;
		} else if (!otherDirectCost.equals(other.otherDirectCost))
			return false;
		if (otherProfessionalsBudget == null) {
			if (other.otherProfessionalsBudget != null)
				return false;
		} else if (!otherProfessionalsBudget
				.equals(other.otherProfessionalsBudget))
			return false;
		if (otherSeniorPersonnelBudget == null) {
			if (other.otherSeniorPersonnelBudget != null)
				return false;
		} else if (!otherSeniorPersonnelBudget
				.equals(other.otherSeniorPersonnelBudget))
			return false;
		if (otherStaffBudget == null) {
			if (other.otherStaffBudget != null)
				return false;
		} else if (!otherStaffBudget.equals(other.otherStaffBudget))
			return false;
		if (participantSupportCost == null) {
			if (other.participantSupportCost != null)
				return false;
		} else if (!participantSupportCost.equals(other.participantSupportCost))
			return false;
		if (performingOrgId == null) {
			if (other.performingOrgId != null)
				return false;
		} else if (!performingOrgId.equals(other.performingOrgId))
			return false;
		if (postDoctoralScholarBudget == null) {
			if (other.postDoctoralScholarBudget != null)
				return false;
		} else if (!postDoctoralScholarBudget
				.equals(other.postDoctoralScholarBudget))
			return false;
		if (residualFunds == null) {
			if (other.residualFunds != null)
				return false;
		} else if (!residualFunds.equals(other.residualFunds))
			return false;
		if (revisionNumber != other.revisionNumber)
			return false;
		if (secretarialBudget == null) {
			if (other.secretarialBudget != null)
				return false;
		} else if (!secretarialBudget.equals(other.secretarialBudget))
			return false;
		if (snrPersBudgetList == null) {
			if (other.snrPersBudgetList != null)
				return false;
		} else if (!snrPersBudgetList.equals(other.snrPersBudgetList))
			return false;
		if (undergraduateStudentsBudget == null) {
			if (other.undergraduateStudentsBudget != null)
				return false;
		} else if (!undergraduateStudentsBudget
				.equals(other.undergraduateStudentsBudget))
			return false;
		return true;
	}

}
