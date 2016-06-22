package gov.nsf.research.psm.model;

public class SpecialItemCodeFlags {

	private boolean beginningInvestigatorFlag;
	private boolean disclosureOfLobbyingActivitiesFlag;
	private boolean historicPlacesFlag;
	private boolean humanSubjectsFlag;
	private boolean internationalCoopActivitiesFlag;
	private boolean proprietyAndPreviledgedFlag;
	private boolean vertebrateAnimalFlag;
	private boolean rapidFlag;
	private boolean eagerFlag;
	
	/**
	 * @return the beginningInvestigatorFlag
	 */
	public boolean isBeginningInvestigatorFlag() {
		return beginningInvestigatorFlag;
	}
	/**
	 * @param beginningInvestigatorFlag the beginningInvestigatorFlag to set
	 */
	public void setBeginningInvestigatorFlag(boolean beginningInvestigatorFlag) {
		this.beginningInvestigatorFlag = beginningInvestigatorFlag;
	}
	/**
	 * @return the disclosureOfLobbyingActivitiesFlag
	 */
	public boolean isDisclosureOfLobbyingActivitiesFlag() {
		return disclosureOfLobbyingActivitiesFlag;
	}
	/**
	 * @param disclosureOfLobbyingActivitiesFlag the disclosureOfLobbyingActivitiesFlag to set
	 */
	public void setDisclosureOfLobbyingActivitiesFlag(
			boolean disclosureOfLobbyingActivitiesFlag) {
		this.disclosureOfLobbyingActivitiesFlag = disclosureOfLobbyingActivitiesFlag;
	}
	/**
	 * @return the historicPlacesFlag
	 */
	public boolean isHistoricPlacesFlag() {
		return historicPlacesFlag;
	}
	/**
	 * @param historicPlacesFlag the historicPlacesFlag to set
	 */
	public void setHistoricPlacesFlag(boolean historicPlacesFlag) {
		this.historicPlacesFlag = historicPlacesFlag;
	}
	/**
	 * @return the humanSubjectsFlag
	 */
	public boolean isHumanSubjectsFlag() {
		return humanSubjectsFlag;
	}
	/**
	 * @param humanSubjectsFlag the humanSubjectsFlag to set
	 */
	public void setHumanSubjectsFlag(boolean humanSubjectsFlag) {
		this.humanSubjectsFlag = humanSubjectsFlag;
	}
	/**
	 * @return the internationalCoopActivitiesFlag
	 */
	public boolean isInternationalCoopActivitiesFlag() {
		return internationalCoopActivitiesFlag;
	}
	/**
	 * @param internationalCoopActivitiesFlag the internationalCoopActivitiesFlag to set
	 */
	public void setInternationalCoopActivitiesFlag(
			boolean internationalCoopActivitiesFlag) {
		this.internationalCoopActivitiesFlag = internationalCoopActivitiesFlag;
	}
	/**
	 * @return the proprietyAndPreviledgedFlag
	 */
	public boolean isProprietyAndPreviledgedFlag() {
		return proprietyAndPreviledgedFlag;
	}
	/**
	 * @param proprietyAndPreviledgedFlag the proprietyAndPreviledgedFlag to set
	 */
	public void setProprietyAndPreviledgedFlag(boolean proprietyAndPreviledgedFlag) {
		this.proprietyAndPreviledgedFlag = proprietyAndPreviledgedFlag;
	}
	/**
	 * @return the vertebrateAnimalFlag
	 */
	public boolean isVertebrateAnimalFlag() {
		return vertebrateAnimalFlag;
	}
	/**
	 * @param vertebrateAnimalFlag the vertebrateAnimalFlag to set
	 */
	public void setVertebrateAnimalFlag(boolean vertebrateAnimalFlag) {
		this.vertebrateAnimalFlag = vertebrateAnimalFlag;
	}
	/**
	 * @return the rapidFlag
	 */
	public boolean isRapidFlag() {
		return rapidFlag;
	}
	/**
	 * @param rapidFlag the rapidFlag to set
	 */
	public void setRapidFlag(boolean rapidFlag) {
		this.rapidFlag = rapidFlag;
	}
	/**
	 * @return the eagerFlag
	 */
	public boolean isEagerFlag() {
		return eagerFlag;
	}
	/**
	 * @param eagerFlag the eagerFlag to set
	 */
	public void setEagerFlag(boolean eagerFlag) {
		this.eagerFlag = eagerFlag;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpecialItemCodeFlags [beginningInvestigatorFlag="
				+ beginningInvestigatorFlag
				+ ", disclosureOfLobbyingActivitiesFlag="
				+ disclosureOfLobbyingActivitiesFlag + ", historicPlacesFlag="
				+ historicPlacesFlag + ", humanSubjectsFlag="
				+ humanSubjectsFlag + ", internationalCoopActivitiesFlag="
				+ internationalCoopActivitiesFlag
				+ ", proprietyAndPreviledgedFlag="
				+ proprietyAndPreviledgedFlag + ", vertebrateAnimalFlag="
				+ vertebrateAnimalFlag + ", rapidFlag=" + rapidFlag
				+ ", eagerFlag=" + eagerFlag + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (beginningInvestigatorFlag ? 1231 : 1237);
		result = prime * result
				+ (disclosureOfLobbyingActivitiesFlag ? 1231 : 1237);
		result = prime * result + (eagerFlag ? 1231 : 1237);
		result = prime * result + (historicPlacesFlag ? 1231 : 1237);
		result = prime * result + (humanSubjectsFlag ? 1231 : 1237);
		result = prime * result
				+ (internationalCoopActivitiesFlag ? 1231 : 1237);
		result = prime * result + (proprietyAndPreviledgedFlag ? 1231 : 1237);
		result = prime * result + (rapidFlag ? 1231 : 1237);
		result = prime * result + (vertebrateAnimalFlag ? 1231 : 1237);
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
		SpecialItemCodeFlags other = (SpecialItemCodeFlags) obj;
		if (beginningInvestigatorFlag != other.beginningInvestigatorFlag)
			return false;
		if (disclosureOfLobbyingActivitiesFlag != other.disclosureOfLobbyingActivitiesFlag)
			return false;
		if (eagerFlag != other.eagerFlag)
			return false;
		if (historicPlacesFlag != other.historicPlacesFlag)
			return false;
		if (humanSubjectsFlag != other.humanSubjectsFlag)
			return false;
		if (internationalCoopActivitiesFlag != other.internationalCoopActivitiesFlag)
			return false;
		if (proprietyAndPreviledgedFlag != other.proprietyAndPreviledgedFlag)
			return false;
		if (rapidFlag != other.rapidFlag)
			return false;
		if (vertebrateAnimalFlag != other.vertebrateAnimalFlag)
			return false;
		return true;
	}
	
}
