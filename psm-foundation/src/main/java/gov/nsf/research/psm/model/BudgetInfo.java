package gov.nsf.research.psm.model;

import java.math.BigDecimal;

public class BudgetInfo {

	private int count;
	private BigDecimal calendarMonths;
	private BigDecimal academicMonths;
	private BigDecimal summerMonths;
	private BigDecimal requestedDollars;
	
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the calendarMonths
	 */
	public BigDecimal getCalendarMonths() {
		return calendarMonths;
	}
	/**
	 * @param calendarMonths the calendarMonths to set
	 */
	public void setCalendarMonths(BigDecimal calendarMonths) {
		this.calendarMonths = calendarMonths;
	}
	/**
	 * @return the academicMonths
	 */
	public BigDecimal getAcademicMonths() {
		return academicMonths;
	}
	/**
	 * @param academicMonths the academicMonths to set
	 */
	public void setAcademicMonths(BigDecimal academicMonths) {
		this.academicMonths = academicMonths;
	}
	/**
	 * @return the summerMonths
	 */
	public BigDecimal getSummerMonths() {
		return summerMonths;
	}
	/**
	 * @param summerMonths the summerMonths to set
	 */
	public void setSummerMonths(BigDecimal summerMonths) {
		this.summerMonths = summerMonths;
	}
	/**
	 * @return the requestedDollars
	 */
	public BigDecimal getRequestedDollars() {
		return requestedDollars;
	}
	/**
	 * @param requestedDollars the requestedDollars to set
	 */
	public void setRequestedDollars(BigDecimal requestedDollars) {
		this.requestedDollars = requestedDollars;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BudgetInfo [count=" + count + ", calendarMonths="
				+ calendarMonths + ", academicMonths=" + academicMonths
				+ ", summerMonths=" + summerMonths + ", requestedDollars="
				+ requestedDollars + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((academicMonths == null) ? 0 : academicMonths.hashCode());
		result = prime * result
				+ ((calendarMonths == null) ? 0 : calendarMonths.hashCode());
		result = prime * result + count;
		result = prime
				* result
				+ ((requestedDollars == null) ? 0 : requestedDollars.hashCode());
		result = prime * result
				+ ((summerMonths == null) ? 0 : summerMonths.hashCode());
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
		BudgetInfo other = (BudgetInfo) obj;
		if (academicMonths == null) {
			if (other.academicMonths != null)
				return false;
		} else if (!academicMonths.equals(other.academicMonths))
			return false;
		if (calendarMonths == null) {
			if (other.calendarMonths != null)
				return false;
		} else if (!calendarMonths.equals(other.calendarMonths))
			return false;
		if (count != other.count)
			return false;
		if (requestedDollars == null) {
			if (other.requestedDollars != null)
				return false;
		} else if (!requestedDollars.equals(other.requestedDollars))
			return false;
		if (summerMonths == null) {
			if (other.summerMonths != null)
				return false;
		} else if (!summerMonths.equals(other.summerMonths))
			return false;
		return true;
	}	
}
