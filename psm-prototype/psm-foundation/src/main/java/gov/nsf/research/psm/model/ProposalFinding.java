package gov.nsf.research.psm.model;

public class ProposalFinding {

	private String findingCode;
	private FindingLevel findingLevel;
	private String findingMessage;
	
	
	/**
	 * Field constructor
	 * @param findingCode
	 * @param findingLevel
	 * @param findingMessage
	 */
	public ProposalFinding(String findingCode, FindingLevel findingLevel,
			String findingMessage) {
		super();
		this.findingCode = findingCode;
		this.findingLevel = findingLevel;
		this.findingMessage = findingMessage;
	}
	
	/**
	 * @return the findingCode
	 */
	public String getFindingCode() {
		return findingCode;
	}
	/**
	 * @param findingCode the findingCode to set
	 */
	public void setFindingCode(String findingCode) {
		this.findingCode = findingCode;
	}
	/**
	 * @return the findingLevel
	 */
	public FindingLevel getFindingLevel() {
		return findingLevel;
	}
	/**
	 * @param findingLevel the findingLevel to set
	 */
	public void setFindingLevel(FindingLevel findingLevel) {
		this.findingLevel = findingLevel;
	}
	/**
	 * @return the findingMessage
	 */
	public String getFindingMessage() {
		return findingMessage;
	}
	/**
	 * @param findingMessage the findingMessage to set
	 */
	public void setFindingMessage(String findingMessage) {
		this.findingMessage = findingMessage;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProposalFinding [findingCode=" + findingCode
				+ ", findingLevel=" + findingLevel + ", findingMessage="
				+ findingMessage + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((findingCode == null) ? 0 : findingCode.hashCode());
		result = prime * result
				+ ((findingLevel == null) ? 0 : findingLevel.hashCode());
		result = prime * result
				+ ((findingMessage == null) ? 0 : findingMessage.hashCode());
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
		ProposalFinding other = (ProposalFinding) obj;
		if (findingCode == null) {
			if (other.findingCode != null)
				return false;
		} else if (!findingCode.equals(other.findingCode))
			return false;
		if (findingLevel != other.findingLevel)
			return false;
		if (findingMessage == null) {
			if (other.findingMessage != null)
				return false;
		} else if (!findingMessage.equals(other.findingMessage))
			return false;
		return true;
	}	
}
