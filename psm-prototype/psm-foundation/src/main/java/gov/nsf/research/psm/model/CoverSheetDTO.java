package gov.nsf.research.psm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CoverSheetDTO {

	private String proposalId;
	private String temporaryProposalId;
	private String proposalTitle;
	private String proposalStatus;
	private PrincipalInvestigator pi;
	private Date submitTimeStamp;
	private AwardeeOrganization awardeeOrganization;
	private PrimaryPlaceOfPerformance primPlaceofPerformanceOrg;
	private SubmissionType submissionType;
	private String fundingMechanism;
	private FundingOpportunity fundingOpportunity;
	private BigDecimal requestedBudgetAmount;
	private int proposalDurationInMonths;
	private Date requestedStartingDate;
	private boolean hasPreliminaryProposal;
	private SpecialItemCodeFlags specialItemCodeFlags;
	private List<String> internationalCoopCountryCodes;
	private List<String> otherAgenciesSubmittedProposal;
	private Date IACUCDate;
	private String phsAnimalNumber;
	private Date irbAppDate;
	private String humanSubjectsAssuranceNumber;
	private List<UnitOfConsideration> unitOfConsideration;
	private String exemptSubSect; 
	private Boolean isPFU;
	
	/**
	 * @return the proposalId
	 */
	public String getProposalId() {
		return proposalId;
	}
	/**
	 * @param proposalId the proposalId to set
	 */
	public void setProposalId(String proposalId) {
		this.proposalId = proposalId;
	}
	/**
	 * @return the temporaryProposalId
	 */
	public String getTemporaryProposalId() {
		return temporaryProposalId;
	}
	/**
	 * @param temporaryProposalId the temporaryProposalId to set
	 */
	public void setTemporaryProposalId(String temporaryProposalId) {
		this.temporaryProposalId = temporaryProposalId;
	}
	/**
	 * @return the proposalTitle
	 */
	public String getProposalTitle() {
		return proposalTitle;
	}
	/**
	 * @param proposalTitle the proposalTitle to set
	 */
	public void setProposalTitle(String proposalTitle) {
		this.proposalTitle = proposalTitle;
	}
	/**
	 * @return the proposalStatus
	 */
	public String getProposalStatus() {
		return proposalStatus;
	}
	/**
	 * @param proposalStatus the proposalStatus to set
	 */
	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}
	/**
	 * @return the pi
	 */
	public PrincipalInvestigator getPi() {
		return pi;
	}
	/**
	 * @param pi the pi to set
	 */
	public void setPi(PrincipalInvestigator pi) {
		this.pi = pi;
	}
	/**
	 * @return the submitTimeStamp
	 */
	public Date getSubmitTimeStamp() {
		return submitTimeStamp;
	}
	/**
	 * @param submitTimeStamp the submitTimeStamp to set
	 */
	public void setSubmitTimeStamp(Date submitTimeStamp) {
		this.submitTimeStamp = submitTimeStamp;
	}
	/**
	 * @return the awardeeOrganization
	 */
	public AwardeeOrganization getAwardeeOrganization() {
		return awardeeOrganization;
	}
	/**
	 * @param awardeeOrganization the awardeeOrganization to set
	 */
	public void setAwardeeOrganization(AwardeeOrganization awardeeOrganization) {
		this.awardeeOrganization = awardeeOrganization;
	}
	/**
	 * @return the primPlaceofPerformanceOrg
	 */
	public PrimaryPlaceOfPerformance getPrimPlaceofPerformanceOrg() {
		return primPlaceofPerformanceOrg;
	}
	/**
	 * @param primPlaceofPerformanceOrg the primPlaceofPerformanceOrg to set
	 */
	public void setPrimPlaceofPerformanceOrg(
			PrimaryPlaceOfPerformance primPlaceofPerformanceOrg) {
		this.primPlaceofPerformanceOrg = primPlaceofPerformanceOrg;
	}
	/**
	 * @return the submissionType
	 */
	public SubmissionType getSubmissionType() {
		return submissionType;
	}
	/**
	 * @param submissionType the submissionType to set
	 */
	public void setSubmissionType(SubmissionType submissionType) {
		this.submissionType = submissionType;
	}
	/**
	 * @return the fundingMechanism
	 */
	public String getFundingMechanism() {
		return fundingMechanism;
	}
	/**
	 * @param fundingMechanism the fundingMechanism to set
	 */
	public void setFundingMechanism(String fundingMechanism) {
		this.fundingMechanism = fundingMechanism;
	}
	/**
	 * @return the fundingOpportunity
	 */
	public FundingOpportunity getFundingOpportunity() {
		return fundingOpportunity;
	}
	/**
	 * @param fundingOpportunity the fundingOpportunity to set
	 */
	public void setFundingOpportunity(FundingOpportunity fundingOpportunity) {
		this.fundingOpportunity = fundingOpportunity;
	}
	/**
	 * @return the requestedBudgetAmount
	 */
	public BigDecimal getRequestedBudgetAmount() {
		return requestedBudgetAmount;
	}
	/**
	 * @param requestedBudgetAmount the requestedBudgetAmount to set
	 */
	public void setRequestedBudgetAmount(BigDecimal requestedBudgetAmount) {
		this.requestedBudgetAmount = requestedBudgetAmount;
	}
	/**
	 * @return the proposalDurationInMonths
	 */
	public int getProposalDurationInMonths() {
		return proposalDurationInMonths;
	}
	/**
	 * @param proposalDurationInMonths the proposalDurationInMonths to set
	 */
	public void setProposalDurationInMonths(int proposalDurationInMonths) {
		this.proposalDurationInMonths = proposalDurationInMonths;
	}
	/**
	 * @return the requestedStartingDate
	 */
	public Date getRequestedStartingDate() {
		return requestedStartingDate;
	}
	/**
	 * @param requestedStartingDate the requestedStartingDate to set
	 */
	public void setRequestedStartingDate(Date requestedStartingDate) {
		this.requestedStartingDate = requestedStartingDate;
	}
	/**
	 * @return the hasPreliminaryProposal
	 */
	public boolean isHasPreliminaryProposal() {
		return hasPreliminaryProposal;
	}
	/**
	 * @param hasPreliminaryProposal the hasPreliminaryProposal to set
	 */
	public void setHasPreliminaryProposal(boolean hasPreliminaryProposal) {
		this.hasPreliminaryProposal = hasPreliminaryProposal;
	}
	/**
	 * @return the specialItemCodeFlags
	 */
	public SpecialItemCodeFlags getSpecialItemCodeFlags() {
		return specialItemCodeFlags;
	}
	/**
	 * @param specialItemCodeFlags the specialItemCodeFlags to set
	 */
	public void setSpecialItemCodeFlags(SpecialItemCodeFlags specialItemCodeFlags) {
		this.specialItemCodeFlags = specialItemCodeFlags;
	}
	/**
	 * @return the internationalCoopCountryCodes
	 */
	public List<String> getInternationalCoopCountryCodes() {
		return internationalCoopCountryCodes;
	}
	/**
	 * @param internationalCoopCountryCodes the internationalCoopCountryCodes to set
	 */
	public void setInternationalCoopCountryCodes(
			List<String> internationalCoopCountryCodes) {
		this.internationalCoopCountryCodes = internationalCoopCountryCodes;
	}
	/**
	 * @return the otherAgenciesSubmittedProposal
	 */
	public List<String> getOtherAgenciesSubmittedProposal() {
		return otherAgenciesSubmittedProposal;
	}
	/**
	 * @param otherAgenciesSubmittedProposal the otherAgenciesSubmittedProposal to set
	 */
	public void setOtherAgenciesSubmittedProposal(
			List<String> otherAgenciesSubmittedProposal) {
		this.otherAgenciesSubmittedProposal = otherAgenciesSubmittedProposal;
	}
	/**
	 * @return the iACUCDate
	 */
	public Date getIACUCDate() {
		return IACUCDate;
	}
	/**
	 * @param iACUCDate the iACUCDate to set
	 */
	public void setIACUCDate(Date iACUCDate) {
		IACUCDate = iACUCDate;
	}
	/**
	 * @return the phsAnimalNumber
	 */
	public String getPhsAnimalNumber() {
		return phsAnimalNumber;
	}
	/**
	 * @param phsAnimalNumber the phsAnimalNumber to set
	 */
	public void setPhsAnimalNumber(String phsAnimalNumber) {
		this.phsAnimalNumber = phsAnimalNumber;
	}
	/**
	 * @return the irbAppDate
	 */
	public Date getIrbAppDate() {
		return irbAppDate;
	}
	/**
	 * @param irbAppDate the irbAppDate to set
	 */
	public void setIrbAppDate(Date irbAppDate) {
		this.irbAppDate = irbAppDate;
	}
	/**
	 * @return the humanSubjectsAssuranceNumber
	 */
	public String getHumanSubjectsAssuranceNumber() {
		return humanSubjectsAssuranceNumber;
	}
	/**
	 * @param humanSubjectsAssuranceNumber the humanSubjectsAssuranceNumber to set
	 */
	public void setHumanSubjectsAssuranceNumber(String humanSubjectsAssuranceNumber) {
		this.humanSubjectsAssuranceNumber = humanSubjectsAssuranceNumber;
	}
	/**
	 * @return the unitOfConsideration
	 */
	public List<UnitOfConsideration> getUnitOfConsideration() {
		return unitOfConsideration;
	}
	/**
	 * @param unitOfConsideration the unitOfConsideration to set
	 */
	public void setUnitOfConsideration(List<UnitOfConsideration> unitOfConsideration) {
		this.unitOfConsideration = unitOfConsideration;
	}
	/**
	 * @return the exemptSubSect
	 */
	public String getExemptSubSect() {
		return exemptSubSect;
	}
	/**
	 * @param exemptSubSect the exemptSubSect to set
	 */
	public void setExemptSubSect(String exemptSubSect) {
		this.exemptSubSect = exemptSubSect;
	}
	/**
	 * @return the isPFU
	 */
	public Boolean getIsPFU() {
		return isPFU;
	}
	/**
	 * @param isPFU the isPFU to set
	 */
	public void setIsPFU(Boolean isPFU) {
		this.isPFU = isPFU;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CoverSheetDTO [proposalId=" + proposalId
				+ ", temporaryProposalId=" + temporaryProposalId
				+ ", proposalTitle=" + proposalTitle + ", proposalStatus="
				+ proposalStatus + ", pi=" + pi + ", submitTimeStamp="
				+ submitTimeStamp + ", awardeeOrganization="
				+ awardeeOrganization + ", primPlaceofPerformanceOrg="
				+ primPlaceofPerformanceOrg + ", submissionType="
				+ submissionType + ", fundingMechanism=" + fundingMechanism
				+ ", fundingOpportunity=" + fundingOpportunity
				+ ", requestedBudgetAmount=" + requestedBudgetAmount
				+ ", proposalDurationInMonths=" + proposalDurationInMonths
				+ ", requestedStartingDate=" + requestedStartingDate
				+ ", hasPreliminaryProposal=" + hasPreliminaryProposal
				+ ", specialItemCodeFlags=" + specialItemCodeFlags
				+ ", internationalCoopCountryCodes="
				+ internationalCoopCountryCodes
				+ ", otherAgenciesSubmittedProposal="
				+ otherAgenciesSubmittedProposal + ", IACUCDate=" + IACUCDate
				+ ", phsAnimalNumber=" + phsAnimalNumber + ", irbAppDate="
				+ irbAppDate + ", humanSubjectsAssuranceNumber="
				+ humanSubjectsAssuranceNumber + ", unitOfConsideration="
				+ unitOfConsideration + ", exemptSubSect=" + exemptSubSect
				+ ", isPFU=" + isPFU + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IACUCDate == null) ? 0 : IACUCDate.hashCode());
		result = prime
				* result
				+ ((awardeeOrganization == null) ? 0 : awardeeOrganization
						.hashCode());
		result = prime * result
				+ ((exemptSubSect == null) ? 0 : exemptSubSect.hashCode());
		result = prime
				* result
				+ ((fundingMechanism == null) ? 0 : fundingMechanism.hashCode());
		result = prime
				* result
				+ ((fundingOpportunity == null) ? 0 : fundingOpportunity
						.hashCode());
		result = prime * result + (hasPreliminaryProposal ? 1231 : 1237);
		result = prime
				* result
				+ ((humanSubjectsAssuranceNumber == null) ? 0
						: humanSubjectsAssuranceNumber.hashCode());
		result = prime
				* result
				+ ((internationalCoopCountryCodes == null) ? 0
						: internationalCoopCountryCodes.hashCode());
		result = prime * result
				+ ((irbAppDate == null) ? 0 : irbAppDate.hashCode());
		result = prime * result + ((isPFU == null) ? 0 : isPFU.hashCode());
		result = prime
				* result
				+ ((otherAgenciesSubmittedProposal == null) ? 0
						: otherAgenciesSubmittedProposal.hashCode());
		result = prime * result
				+ ((phsAnimalNumber == null) ? 0 : phsAnimalNumber.hashCode());
		result = prime * result + ((pi == null) ? 0 : pi.hashCode());
		result = prime
				* result
				+ ((primPlaceofPerformanceOrg == null) ? 0
						: primPlaceofPerformanceOrg.hashCode());
		result = prime * result + proposalDurationInMonths;
		result = prime * result
				+ ((proposalId == null) ? 0 : proposalId.hashCode());
		result = prime * result
				+ ((proposalStatus == null) ? 0 : proposalStatus.hashCode());
		result = prime * result
				+ ((proposalTitle == null) ? 0 : proposalTitle.hashCode());
		result = prime
				* result
				+ ((requestedBudgetAmount == null) ? 0 : requestedBudgetAmount
						.hashCode());
		result = prime
				* result
				+ ((requestedStartingDate == null) ? 0 : requestedStartingDate
						.hashCode());
		result = prime
				* result
				+ ((specialItemCodeFlags == null) ? 0 : specialItemCodeFlags
						.hashCode());
		result = prime * result
				+ ((submissionType == null) ? 0 : submissionType.hashCode());
		result = prime * result
				+ ((submitTimeStamp == null) ? 0 : submitTimeStamp.hashCode());
		result = prime
				* result
				+ ((temporaryProposalId == null) ? 0 : temporaryProposalId
						.hashCode());
		result = prime
				* result
				+ ((unitOfConsideration == null) ? 0 : unitOfConsideration
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
		CoverSheetDTO other = (CoverSheetDTO) obj;
		if (IACUCDate == null) {
			if (other.IACUCDate != null)
				return false;
		} else if (!IACUCDate.equals(other.IACUCDate))
			return false;
		if (awardeeOrganization == null) {
			if (other.awardeeOrganization != null)
				return false;
		} else if (!awardeeOrganization.equals(other.awardeeOrganization))
			return false;
		if (exemptSubSect == null) {
			if (other.exemptSubSect != null)
				return false;
		} else if (!exemptSubSect.equals(other.exemptSubSect))
			return false;
		if (fundingMechanism == null) {
			if (other.fundingMechanism != null)
				return false;
		} else if (!fundingMechanism.equals(other.fundingMechanism))
			return false;
		if (fundingOpportunity == null) {
			if (other.fundingOpportunity != null)
				return false;
		} else if (!fundingOpportunity.equals(other.fundingOpportunity))
			return false;
		if (hasPreliminaryProposal != other.hasPreliminaryProposal)
			return false;
		if (humanSubjectsAssuranceNumber == null) {
			if (other.humanSubjectsAssuranceNumber != null)
				return false;
		} else if (!humanSubjectsAssuranceNumber
				.equals(other.humanSubjectsAssuranceNumber))
			return false;
		if (internationalCoopCountryCodes == null) {
			if (other.internationalCoopCountryCodes != null)
				return false;
		} else if (!internationalCoopCountryCodes
				.equals(other.internationalCoopCountryCodes))
			return false;
		if (irbAppDate == null) {
			if (other.irbAppDate != null)
				return false;
		} else if (!irbAppDate.equals(other.irbAppDate))
			return false;
		if (isPFU == null) {
			if (other.isPFU != null)
				return false;
		} else if (!isPFU.equals(other.isPFU))
			return false;
		if (otherAgenciesSubmittedProposal == null) {
			if (other.otherAgenciesSubmittedProposal != null)
				return false;
		} else if (!otherAgenciesSubmittedProposal
				.equals(other.otherAgenciesSubmittedProposal))
			return false;
		if (phsAnimalNumber == null) {
			if (other.phsAnimalNumber != null)
				return false;
		} else if (!phsAnimalNumber.equals(other.phsAnimalNumber))
			return false;
		if (pi == null) {
			if (other.pi != null)
				return false;
		} else if (!pi.equals(other.pi))
			return false;
		if (primPlaceofPerformanceOrg == null) {
			if (other.primPlaceofPerformanceOrg != null)
				return false;
		} else if (!primPlaceofPerformanceOrg
				.equals(other.primPlaceofPerformanceOrg))
			return false;
		if (proposalDurationInMonths != other.proposalDurationInMonths)
			return false;
		if (proposalId == null) {
			if (other.proposalId != null)
				return false;
		} else if (!proposalId.equals(other.proposalId))
			return false;
		if (proposalStatus == null) {
			if (other.proposalStatus != null)
				return false;
		} else if (!proposalStatus.equals(other.proposalStatus))
			return false;
		if (proposalTitle == null) {
			if (other.proposalTitle != null)
				return false;
		} else if (!proposalTitle.equals(other.proposalTitle))
			return false;
		if (requestedBudgetAmount == null) {
			if (other.requestedBudgetAmount != null)
				return false;
		} else if (!requestedBudgetAmount.equals(other.requestedBudgetAmount))
			return false;
		if (requestedStartingDate == null) {
			if (other.requestedStartingDate != null)
				return false;
		} else if (!requestedStartingDate.equals(other.requestedStartingDate))
			return false;
		if (specialItemCodeFlags == null) {
			if (other.specialItemCodeFlags != null)
				return false;
		} else if (!specialItemCodeFlags.equals(other.specialItemCodeFlags))
			return false;
		if (submissionType != other.submissionType)
			return false;
		if (submitTimeStamp == null) {
			if (other.submitTimeStamp != null)
				return false;
		} else if (!submitTimeStamp.equals(other.submitTimeStamp))
			return false;
		if (temporaryProposalId == null) {
			if (other.temporaryProposalId != null)
				return false;
		} else if (!temporaryProposalId.equals(other.temporaryProposalId))
			return false;
		if (unitOfConsideration == null) {
			if (other.unitOfConsideration != null)
				return false;
		} else if (!unitOfConsideration.equals(other.unitOfConsideration))
			return false;
		return true;
	}
	
}
