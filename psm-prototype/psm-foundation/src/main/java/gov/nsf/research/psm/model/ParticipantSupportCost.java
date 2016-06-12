package gov.nsf.research.psm.model;

import java.math.BigDecimal;

public class ParticipantSupportCost {

	private BigDecimal supportDollars;
	private BigDecimal travelDollars;
	private BigDecimal subsistenceDollars;
	private BigDecimal otherSupportDollars;
	private int totalNumberOfParticipants;
	
	/**
	 * @return the supportDollars
	 */
	public BigDecimal getSupportDollars() {
		return supportDollars;
	}
	/**
	 * @param supportDollars the supportDollars to set
	 */
	public void setSupportDollars(BigDecimal supportDollars) {
		this.supportDollars = supportDollars;
	}
	/**
	 * @return the travelDollars
	 */
	public BigDecimal getTravelDollars() {
		return travelDollars;
	}
	/**
	 * @param travelDollars the travelDollars to set
	 */
	public void setTravelDollars(BigDecimal travelDollars) {
		this.travelDollars = travelDollars;
	}
	/**
	 * @return the subsistenceDollars
	 */
	public BigDecimal getSubsistenceDollars() {
		return subsistenceDollars;
	}
	/**
	 * @param subsistenceDollars the subsistenceDollars to set
	 */
	public void setSubsistenceDollars(BigDecimal subsistenceDollars) {
		this.subsistenceDollars = subsistenceDollars;
	}
	/**
	 * @return the otherSupportDollars
	 */
	public BigDecimal getOtherSupportDollars() {
		return otherSupportDollars;
	}
	/**
	 * @param otherSupportDollars the otherSupportDollars to set
	 */
	public void setOtherSupportDollars(BigDecimal otherSupportDollars) {
		this.otherSupportDollars = otherSupportDollars;
	}
	/**
	 * @return the totalNumberOfParticipants
	 */
	public int getTotalNumberOfParticipants() {
		return totalNumberOfParticipants;
	}
	/**
	 * @param totalNumberOfParticipants the totalNumberOfParticipants to set
	 */
	public void setTotalNumberOfParticipants(int totalNumberOfParticipants) {
		this.totalNumberOfParticipants = totalNumberOfParticipants;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParticipantSupportCost [supportDollars=" + supportDollars
				+ ", travelDollars=" + travelDollars + ", subsistenceDollars="
				+ subsistenceDollars + ", otherSupportDollars="
				+ otherSupportDollars + ", totalNumberOfParticipants="
				+ totalNumberOfParticipants + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((otherSupportDollars == null) ? 0 : otherSupportDollars
						.hashCode());
		result = prime
				* result
				+ ((subsistenceDollars == null) ? 0 : subsistenceDollars
						.hashCode());
		result = prime * result
				+ ((supportDollars == null) ? 0 : supportDollars.hashCode());
		result = prime * result + totalNumberOfParticipants;
		result = prime * result
				+ ((travelDollars == null) ? 0 : travelDollars.hashCode());
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
		ParticipantSupportCost other = (ParticipantSupportCost) obj;
		if (otherSupportDollars == null) {
			if (other.otherSupportDollars != null)
				return false;
		} else if (!otherSupportDollars.equals(other.otherSupportDollars))
			return false;
		if (subsistenceDollars == null) {
			if (other.subsistenceDollars != null)
				return false;
		} else if (!subsistenceDollars.equals(other.subsistenceDollars))
			return false;
		if (supportDollars == null) {
			if (other.supportDollars != null)
				return false;
		} else if (!supportDollars.equals(other.supportDollars))
			return false;
		if (totalNumberOfParticipants != other.totalNumberOfParticipants)
			return false;
		if (travelDollars == null) {
			if (other.travelDollars != null)
				return false;
		} else if (!travelDollars.equals(other.travelDollars))
			return false;
		return true;
	}
	
}