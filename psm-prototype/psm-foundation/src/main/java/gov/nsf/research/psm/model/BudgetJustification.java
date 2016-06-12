package gov.nsf.research.psm.model;

public class BudgetJustification extends UploadableSection {
	
	private String instId;
	private String budgJustTxt;
	/**
	 * @return the instId
	 */
	public String getInstId() {
		return instId;
	}
	/**
	 * @param instId the instId to set
	 */
	public void setInstId(String instId) {
		this.instId = instId;
	}
	/**
	 * @return the budgJustTxt
	 */
	public String getBudgJustTxt() {
		return budgJustTxt;
	}
	/**
	 * @param budgJustTxt the budgJustTxt to set
	 */
	public void setBudgJustTxt(String budgJustTxt) {
		this.budgJustTxt = budgJustTxt;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BudgetJustification [instId=" + instId + ", budgJustTxt="
				+ budgJustTxt + ", sectionFormat=" + sectionFormat
				+ ", pageCount=" + pageCount + ", filePath=" + filePath
				+ ", lastUpdateTimeStamp=" + lastUpdateTimeStamp + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((budgJustTxt == null) ? 0 : budgJustTxt.hashCode());
		result = prime * result + ((instId == null) ? 0 : instId.hashCode());
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
		BudgetJustification other = (BudgetJustification) obj;
		if (budgJustTxt == null) {
			if (other.budgJustTxt != null)
				return false;
		} else if (!budgJustTxt.equals(other.budgJustTxt))
			return false;
		if (instId == null) {
			if (other.instId != null)
				return false;
		} else if (!instId.equals(other.instId))
			return false;
		return true;
	}
	

}
