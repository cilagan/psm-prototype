package gov.nsf.research.psm.model;

public class AddlSingleCopyDoc extends UploadableSection {
	
	private String addlSnglCopyTxt;
	private int addlSnglCopyDocSeq;
	/**
	 * @return the addlSnglCopyTxt
	 */
	public String getAddlSnglCopyTxt() {
		return addlSnglCopyTxt;
	}
	/**
	 * @param addlSnglCopyTxt the addlSnglCopyTxt to set
	 */
	public void setAddlSnglCopyTxt(String addlSnglCopyTxt) {
		this.addlSnglCopyTxt = addlSnglCopyTxt;
	}
	/**
	 * @return the addlSnglCopyDocSeq
	 */
	public int getAddlSnglCopyDocSeq() {
		return addlSnglCopyDocSeq;
	}
	/**
	 * @param addlSnglCopyDocSeq the addlSnglCopyDocSeq to set
	 */
	public void setAddlSnglCopyDocSeq(int addlSnglCopyDocSeq) {
		this.addlSnglCopyDocSeq = addlSnglCopyDocSeq;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddlSingleCopyDoc [addlSnglCopyTxt=" + addlSnglCopyTxt
				+ ", addlSnglCopyDocSeq=" + addlSnglCopyDocSeq + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + addlSnglCopyDocSeq;
		result = prime * result
				+ ((addlSnglCopyTxt == null) ? 0 : addlSnglCopyTxt.hashCode());
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
		AddlSingleCopyDoc other = (AddlSingleCopyDoc) obj;
		if (addlSnglCopyDocSeq != other.addlSnglCopyDocSeq)
			return false;
		if (addlSnglCopyTxt == null) {
			if (other.addlSnglCopyTxt != null)
				return false;
		} else if (!addlSnglCopyTxt.equals(other.addlSnglCopyTxt))
			return false;
		return true;
	}
	
	
	
}
