package gov.nsf.research.psm.model;

public class SuggestedReviewers extends Section {
	
	private String prefferedReviewers;
	private String notPrefferredReviewers;
	/**
	 * @return the prefferedReviewers
	 */
	public String getPrefferedReviewers() {
		return prefferedReviewers;
	}
	/**
	 * @param prefferedReviewers the prefferedReviewers to set
	 */
	public void setPrefferedReviewers(String prefferedReviewers) {
		this.prefferedReviewers = prefferedReviewers;
	}
	/**
	 * @return the notPrefferredReviewers
	 */
	public String getNotPrefferredReviewers() {
		return notPrefferredReviewers;
	}
	/**
	 * @param notPrefferredReviewers the notPrefferredReviewers to set
	 */
	public void setNotPrefferredReviewers(String notPrefferredReviewers) {
		this.notPrefferredReviewers = notPrefferredReviewers;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuggestedReviewers [prefferedReviewers=" + prefferedReviewers
				+ ", notPrefferredReviewers=" + notPrefferredReviewers + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((notPrefferredReviewers == null) ? 0
						: notPrefferredReviewers.hashCode());
		result = prime
				* result
				+ ((prefferedReviewers == null) ? 0 : prefferedReviewers
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuggestedReviewers other = (SuggestedReviewers) obj;
		if (notPrefferredReviewers == null) {
			if (other.notPrefferredReviewers != null)
				return false;
		} else if (!notPrefferredReviewers.equals(other.notPrefferredReviewers))
			return false;
		if (prefferedReviewers == null) {
			if (other.prefferedReviewers != null)
				return false;
		} else if (!prefferedReviewers.equals(other.prefferedReviewers))
			return false;
		return true;
	}
	
	

}
