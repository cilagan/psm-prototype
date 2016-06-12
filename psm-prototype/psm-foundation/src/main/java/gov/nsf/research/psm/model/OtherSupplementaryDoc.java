package gov.nsf.research.psm.model;

public class OtherSupplementaryDoc extends UploadableSection{
	private String othSuppTxt;
	private int suppDocSeq;
	/**
	 * @return the othSuppTxt
	 */
	public String getOthSuppTxt() {
		return othSuppTxt;
	}
	/**
	 * @param othSuppTxt the othSuppTxt to set
	 */
	public void setOthSuppTxt(String othSuppTxt) {
		this.othSuppTxt = othSuppTxt;
	}
	/**
	 * @return the suppDocSeq
	 */
	public int getSuppDocSeq() {
		return suppDocSeq;
	}
	/**
	 * @param suppDocSeq the suppDocSeq to set
	 */
	public void setSuppDocSeq(int suppDocSeq) {
		this.suppDocSeq = suppDocSeq;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OtherSupplementaryDoc [othSuppTxt=" + othSuppTxt
				+ ", suppDocSeq=" + suppDocSeq + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((othSuppTxt == null) ? 0 : othSuppTxt.hashCode());
		result = prime * result + suppDocSeq;
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
		OtherSupplementaryDoc other = (OtherSupplementaryDoc) obj;
		if (othSuppTxt == null) {
			if (other.othSuppTxt != null)
				return false;
		} else if (!othSuppTxt.equals(other.othSuppTxt))
			return false;
		if (suppDocSeq != other.suppDocSeq)
			return false;
		return true;
	}
	

}
