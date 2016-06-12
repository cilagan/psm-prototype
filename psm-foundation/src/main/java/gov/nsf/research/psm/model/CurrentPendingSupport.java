package gov.nsf.research.psm.model;

import java.math.BigDecimal;
import java.util.Date;

public class CurrentPendingSupport extends UploadableSection {

	private String firstName;
	private String lastName;
	private String propTitle;
	private String srcOfSupp;
	private String projLoc;
	private BigDecimal totalAwdAmt;
	private Date startDate;
	private Date endDate;
	private String suppType;
	private BigDecimal calMnthCnt;
	private BigDecimal acadMnthCnt;
	private BigDecimal summMnthcnt;
	private String revFlag;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the propTitle
	 */
	public String getPropTitle() {
		return propTitle;
	}
	/**
	 * @param propTitle the propTitle to set
	 */
	public void setPropTitle(String propTitle) {
		this.propTitle = propTitle;
	}
	/**
	 * @return the srcOfSupp
	 */
	public String getSrcOfSupp() {
		return srcOfSupp;
	}
	/**
	 * @param srcOfSupp the srcOfSupp to set
	 */
	public void setSrcOfSupp(String srcOfSupp) {
		this.srcOfSupp = srcOfSupp;
	}
	/**
	 * @return the projLoc
	 */
	public String getProjLoc() {
		return projLoc;
	}
	/**
	 * @param projLoc the projLoc to set
	 */
	public void setProjLoc(String projLoc) {
		this.projLoc = projLoc;
	}
	/**
	 * @return the totalAwdAmt
	 */
	public BigDecimal getTotalAwdAmt() {
		return totalAwdAmt;
	}
	/**
	 * @param totalAwdAmt the totalAwdAmt to set
	 */
	public void setTotalAwdAmt(BigDecimal totalAwdAmt) {
		this.totalAwdAmt = totalAwdAmt;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the suppType
	 */
	public String getSuppType() {
		return suppType;
	}
	/**
	 * @param suppType the suppType to set
	 */
	public void setSuppType(String suppType) {
		this.suppType = suppType;
	}
	/**
	 * @return the calMnthCnt
	 */
	public BigDecimal getCalMnthCnt() {
		return calMnthCnt;
	}
	/**
	 * @param calMnthCnt the calMnthCnt to set
	 */
	public void setCalMnthCnt(BigDecimal calMnthCnt) {
		this.calMnthCnt = calMnthCnt;
	}
	/**
	 * @return the acadMnthCnt
	 */
	public BigDecimal getAcadMnthCnt() {
		return acadMnthCnt;
	}
	/**
	 * @param acadMnthCnt the acadMnthCnt to set
	 */
	public void setAcadMnthCnt(BigDecimal acadMnthCnt) {
		this.acadMnthCnt = acadMnthCnt;
	}
	/**
	 * @return the summMnthcnt
	 */
	public BigDecimal getSummMnthcnt() {
		return summMnthcnt;
	}
	/**
	 * @param summMnthcnt the summMnthcnt to set
	 */
	public void setSummMnthcnt(BigDecimal summMnthcnt) {
		this.summMnthcnt = summMnthcnt;
	}
	/**
	 * @return the revFlag
	 */
	public String getRevFlag() {
		return revFlag;
	}
	/**
	 * @param revFlag the revFlag to set
	 */
	public void setRevFlag(String revFlag) {
		this.revFlag = revFlag;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrentPendingSupport [firstName=" + firstName + ", lastName="
				+ lastName + ", propTitle=" + propTitle + ", srcOfSupp="
				+ srcOfSupp + ", projLoc=" + projLoc + ", totalAwdAmt="
				+ totalAwdAmt + ", startDate=" + startDate + ", endDate="
				+ endDate + ", suppType=" + suppType + ", calMnthCnt="
				+ calMnthCnt + ", acadMnthCnt=" + acadMnthCnt
				+ ", summMnthcnt=" + summMnthcnt + ", revFlag=" + revFlag
				+ ", sectionFormat=" + sectionFormat + ", pageCount="
				+ pageCount + ", filePath=" + filePath
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
				+ ((acadMnthCnt == null) ? 0 : acadMnthCnt.hashCode());
		result = prime * result
				+ ((calMnthCnt == null) ? 0 : calMnthCnt.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((projLoc == null) ? 0 : projLoc.hashCode());
		result = prime * result
				+ ((propTitle == null) ? 0 : propTitle.hashCode());
		result = prime * result + ((revFlag == null) ? 0 : revFlag.hashCode());
		result = prime * result
				+ ((srcOfSupp == null) ? 0 : srcOfSupp.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((summMnthcnt == null) ? 0 : summMnthcnt.hashCode());
		result = prime * result
				+ ((suppType == null) ? 0 : suppType.hashCode());
		result = prime * result
				+ ((totalAwdAmt == null) ? 0 : totalAwdAmt.hashCode());
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
		CurrentPendingSupport other = (CurrentPendingSupport) obj;
		if (acadMnthCnt == null) {
			if (other.acadMnthCnt != null)
				return false;
		} else if (!acadMnthCnt.equals(other.acadMnthCnt))
			return false;
		if (calMnthCnt == null) {
			if (other.calMnthCnt != null)
				return false;
		} else if (!calMnthCnt.equals(other.calMnthCnt))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (projLoc == null) {
			if (other.projLoc != null)
				return false;
		} else if (!projLoc.equals(other.projLoc))
			return false;
		if (propTitle == null) {
			if (other.propTitle != null)
				return false;
		} else if (!propTitle.equals(other.propTitle))
			return false;
		if (revFlag == null) {
			if (other.revFlag != null)
				return false;
		} else if (!revFlag.equals(other.revFlag))
			return false;
		if (srcOfSupp == null) {
			if (other.srcOfSupp != null)
				return false;
		} else if (!srcOfSupp.equals(other.srcOfSupp))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (summMnthcnt == null) {
			if (other.summMnthcnt != null)
				return false;
		} else if (!summMnthcnt.equals(other.summMnthcnt))
			return false;
		if (suppType == null) {
			if (other.suppType != null)
				return false;
		} else if (!suppType.equals(other.suppType))
			return false;
		if (totalAwdAmt == null) {
			if (other.totalAwdAmt != null)
				return false;
		} else if (!totalAwdAmt.equals(other.totalAwdAmt))
			return false;
		return true;
	}
}
