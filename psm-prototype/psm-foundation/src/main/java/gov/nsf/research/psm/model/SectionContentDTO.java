package gov.nsf.research.psm.model;

import java.util.List;


public class SectionContentDTO {
	
	private ProjectSummarySection projectSummary;
	private ProjectDescription projectDescription;
	private ReferencesCited referencesCited;
	private List<BioSketches> bioSketches;
	private List<Budget> budget;
	private List<BudgetJustification> budgetJustification;
	private List<CurrentPendingSupport> currentPendingSupport;
	private FacilitiesEquipmentResources facilitiesEquipmentResources;
	private DataMgtPlan dataMgtPlan;
	private MentoringPlan mentoringPlan;
	private List<OtherSupplementaryDoc> otherSupplementaryDoc;
	private DeviationAuthorization deviationAuthorization;
	private SuggestedReviewers suggestedReviewers;
	private List<AddlSingleCopyDoc> addlSingleCopyDoc;
	
	/**
	 * @return the projectSummary
	 */
	public ProjectSummarySection getProjectSummary() {
		return projectSummary;
	}
	/**
	 * @param projectSummary the projectSummary to set
	 */
	public void setProjectSummary(ProjectSummarySection projectSummary) {
		this.projectSummary = projectSummary;
	}
	/**
	 * @return the projectDescription
	 */
	public ProjectDescription getProjectDescription() {
		return projectDescription;
	}
	/**
	 * @param projectDescription the projectDescription to set
	 */
	public void setProjectDescription(ProjectDescription projectDescription) {
		this.projectDescription = projectDescription;
	}
	/**
	 * @return the referencesCited
	 */
	public ReferencesCited getReferencesCited() {
		return referencesCited;
	}
	/**
	 * @param referencesCited the referencesCited to set
	 */
	public void setReferencesCited(ReferencesCited referencesCited) {
		this.referencesCited = referencesCited;
	}
	/**
	 * @return the bioSketches
	 */
	public List<BioSketches> getBioSketches() {
		return bioSketches;
	}
	/**
	 * @param bioSketches the bioSketches to set
	 */
	public void setBioSketches(List<BioSketches> bioSketches) {
		this.bioSketches = bioSketches;
	}
	/**
	 * @return the budget
	 */
	public List<Budget> getBudget() {
		return budget;
	}
	/**
	 * @param budget the budget to set
	 */
	public void setBudget(List<Budget> budget) {
		this.budget = budget;
	}
	/**
	 * @return the budgetJustification
	 */
	public List<BudgetJustification> getBudgetJustification() {
		return budgetJustification;
	}
	/**
	 * @param budgetJustification the budgetJustification to set
	 */
	public void setBudgetJustification(List<BudgetJustification> budgetJustification) {
		this.budgetJustification = budgetJustification;
	}
	/**
	 * @return the currentPendingSupport
	 */
	public List<CurrentPendingSupport> getCurrentPendingSupport() {
		return currentPendingSupport;
	}
	/**
	 * @param currentPendingSupport the currentPendingSupport to set
	 */
	public void setCurrentPendingSupport(
			List<CurrentPendingSupport> currentPendingSupport) {
		this.currentPendingSupport = currentPendingSupport;
	}
	/**
	 * @return the facilitiesEquipmentResources
	 */
	public FacilitiesEquipmentResources getFacilitiesEquipmentResources() {
		return facilitiesEquipmentResources;
	}
	/**
	 * @param facilitiesEquipmentResources the facilitiesEquipmentResources to set
	 */
	public void setFacilitiesEquipmentResources(
			FacilitiesEquipmentResources facilitiesEquipmentResources) {
		this.facilitiesEquipmentResources = facilitiesEquipmentResources;
	}
	/**
	 * @return the dataMgtPlan
	 */
	public DataMgtPlan getDataMgtPlan() {
		return dataMgtPlan;
	}
	/**
	 * @param dataMgtPlan the dataMgtPlan to set
	 */
	public void setDataMgtPlan(DataMgtPlan dataMgtPlan) {
		this.dataMgtPlan = dataMgtPlan;
	}
	/**
	 * @return the mentoringPlan
	 */
	public MentoringPlan getMentoringPlan() {
		return mentoringPlan;
	}
	/**
	 * @param mentoringPlan the mentoringPlan to set
	 */
	public void setMentoringPlan(MentoringPlan mentoringPlan) {
		this.mentoringPlan = mentoringPlan;
	}
	/**
	 * @return the otherSupplementaryDoc
	 */
	public List<OtherSupplementaryDoc> getOtherSupplementaryDoc() {
		return otherSupplementaryDoc;
	}
	/**
	 * @param otherSupplementaryDoc the otherSupplementaryDoc to set
	 */
	public void setOtherSupplementaryDoc(List<OtherSupplementaryDoc> otherSupplementaryDoc) {
		this.otherSupplementaryDoc = otherSupplementaryDoc;
	}
	/**
	 * @return the deviationAuthorization
	 */
	public DeviationAuthorization getDeviationAuthorization() {
		return deviationAuthorization;
	}
	/**
	 * @param deviationAuthorization the deviationAuthorization to set
	 */
	public void setDeviationAuthorization(
			DeviationAuthorization deviationAuthorization) {
		this.deviationAuthorization = deviationAuthorization;
	}
	/**
	 * @return the suggestedReviewers
	 */
	public SuggestedReviewers getSuggestedReviewers() {
		return suggestedReviewers;
	}
	/**
	 * @param suggestedReviewers the suggestedReviewers to set
	 */
	public void setSuggestedReviewers(SuggestedReviewers suggestedReviewers) {
		this.suggestedReviewers = suggestedReviewers;
	}
	/**
	 * @return the addlSingleCopyDoc
	 */
	public List<AddlSingleCopyDoc> getAddlSingleCopyDoc() {
		return addlSingleCopyDoc;
	}
	/**
	 * @param addlSingleCopyDoc the addlSingleCopyDoc to set
	 */
	public void setAddlSingleCopyDoc(List<AddlSingleCopyDoc> addlSingleCopyDoc) {
		this.addlSingleCopyDoc = addlSingleCopyDoc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SectionContentDTO [projectSummary=" + projectSummary
				+ ", projectDescription=" + projectDescription
				+ ", referencesCited=" + referencesCited + ", bioSketches="
				+ bioSketches + ", budget=" + budget + ", budgetJustification="
				+ budgetJustification + ", currentPendingSupport="
				+ currentPendingSupport + ", facilitiesEquipmentResources="
				+ facilitiesEquipmentResources + ", dataMgtPlan=" + dataMgtPlan
				+ ", mentoringPlan=" + mentoringPlan
				+ ", otherSupplementaryDoc=" + otherSupplementaryDoc
				+ ", deviationAuthorization="
				+ deviationAuthorization + ", suggestedReviewers="
				+ suggestedReviewers + ", addlSingleCopyDoc="
				+ addlSingleCopyDoc + "]";
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
				+ ((addlSingleCopyDoc == null) ? 0 : addlSingleCopyDoc
						.hashCode());
		result = prime * result
				+ ((bioSketches == null) ? 0 : bioSketches.hashCode());
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime
				* result
				+ ((budgetJustification == null) ? 0 : budgetJustification
						.hashCode());
		result = prime
				* result
				+ ((currentPendingSupport == null) ? 0 : currentPendingSupport
						.hashCode());
		result = prime * result
				+ ((dataMgtPlan == null) ? 0 : dataMgtPlan.hashCode());
		result = prime
				* result
				+ ((deviationAuthorization == null) ? 0
						: deviationAuthorization.hashCode());
		result = prime
				* result
				+ ((facilitiesEquipmentResources == null) ? 0
						: facilitiesEquipmentResources.hashCode());
		result = prime * result
				+ ((mentoringPlan == null) ? 0 : mentoringPlan.hashCode());
		result = prime
				* result
				+ ((otherSupplementaryDoc == null) ? 0 : otherSupplementaryDoc
						.hashCode());
		result = prime
				* result
				+ ((projectDescription == null) ? 0 : projectDescription
						.hashCode());
		result = prime * result
				+ ((projectSummary == null) ? 0 : projectSummary.hashCode());
		result = prime * result
				+ ((referencesCited == null) ? 0 : referencesCited.hashCode());
		result = prime
				* result
				+ ((suggestedReviewers == null) ? 0 : suggestedReviewers
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
		SectionContentDTO other = (SectionContentDTO) obj;
		if (addlSingleCopyDoc == null) {
			if (other.addlSingleCopyDoc != null)
				return false;
		} else if (!addlSingleCopyDoc.equals(other.addlSingleCopyDoc))
			return false;
		if (bioSketches == null) {
			if (other.bioSketches != null)
				return false;
		} else if (!bioSketches.equals(other.bioSketches))
			return false;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (budgetJustification == null) {
			if (other.budgetJustification != null)
				return false;
		} else if (!budgetJustification.equals(other.budgetJustification))
			return false;
		if (currentPendingSupport == null) {
			if (other.currentPendingSupport != null)
				return false;
		} else if (!currentPendingSupport.equals(other.currentPendingSupport))
			return false;
		if (dataMgtPlan == null) {
			if (other.dataMgtPlan != null)
				return false;
		} else if (!dataMgtPlan.equals(other.dataMgtPlan))
			return false;
		if (deviationAuthorization == null) {
			if (other.deviationAuthorization != null)
				return false;
		} else if (!deviationAuthorization.equals(other.deviationAuthorization))
			return false;
		if (facilitiesEquipmentResources == null) {
			if (other.facilitiesEquipmentResources != null)
				return false;
		} else if (!facilitiesEquipmentResources
				.equals(other.facilitiesEquipmentResources))
			return false;
		if (mentoringPlan == null) {
			if (other.mentoringPlan != null)
				return false;
		} else if (!mentoringPlan.equals(other.mentoringPlan))
			return false;
		if (otherSupplementaryDoc == null) {
			if (other.otherSupplementaryDoc != null)
				return false;
		} else if (!otherSupplementaryDoc.equals(other.otherSupplementaryDoc))
			return false;
		if (projectDescription == null) {
			if (other.projectDescription != null)
				return false;
		} else if (!projectDescription.equals(other.projectDescription))
			return false;
		if (projectSummary == null) {
			if (other.projectSummary != null)
				return false;
		} else if (!projectSummary.equals(other.projectSummary))
			return false;
		if (referencesCited == null) {
			if (other.referencesCited != null)
				return false;
		} else if (!referencesCited.equals(other.referencesCited))
			return false;
		if (suggestedReviewers == null) {
			if (other.suggestedReviewers != null)
				return false;
		} else if (!suggestedReviewers.equals(other.suggestedReviewers))
			return false;
		return true;
	}

}
