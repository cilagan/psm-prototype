package gov.nsf.research.psm.model;

public class DeviationAuthorization extends Section  {
	
	private String devAuthTxt;

	/**
	 * @return the devAuthTxt
	 */
	public String getDevAuthTxt() {
		return devAuthTxt;
	}

	/**
	 * @param devAuthTxt the devAuthTxt to set
	 */
	public void setDevAuthTxt(String devAuthTxt) {
		this.devAuthTxt = devAuthTxt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeviationAuthorization [devAuthTxt=" + devAuthTxt + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((devAuthTxt == null) ? 0 : devAuthTxt.hashCode());
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
		DeviationAuthorization other = (DeviationAuthorization) obj;
		if (devAuthTxt == null) {
			if (other.devAuthTxt != null)
				return false;
		} else if (!devAuthTxt.equals(other.devAuthTxt))
			return false;
		return true;
	}
	
	

}
