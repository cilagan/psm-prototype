package gov.nsf.research.psm.model;

public class PrimaryPlaceOfPerformance extends Organization{

	private boolean upldFlag;
	
	public PrimaryPlaceOfPerformance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PrimaryPlaceOfPerformance(String orgName, String strAddr,
			String ctyName, String stCode, String zipCode, String ctryCode,
			boolean upldFlag) {
		super(orgName, strAddr, ctyName, stCode, zipCode, ctryCode);
		
		this.upldFlag = upldFlag;
	}


	/**
	 * @return the upldFlag
	 */
	public boolean isUpldFlag() {
		return upldFlag;
	}
	/**
	 * @param upldFlag the upldFlag to set
	 */
	public void setUpldFlag(boolean upldFlag) {
		this.upldFlag = upldFlag;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrimaryPlaceOfPerformance [upldFlag=" + upldFlag
				+ ", toString()=" + super.toString() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (upldFlag ? 1231 : 1237);
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
		PrimaryPlaceOfPerformance other = (PrimaryPlaceOfPerformance) obj;
		if (upldFlag != other.upldFlag)
			return false;
		return true;
	}
	

	
}
