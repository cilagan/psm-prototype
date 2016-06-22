package gov.nsf.research.psm.model;

public class BioSketches extends UploadableSection {

	private String firstName;
	private String lastName;
	private int textLength;
	private String text;
	private PersonnelType personnelType;
	
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
	 * @return the textLength
	 */
	public int getTextLength() {
		return textLength;
	}
	/**
	 * @param textLength the textLength to set
	 */
	public void setTextLength(int textLength) {
		this.textLength = textLength;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
	/**
	 * @return the personnelType
	 */
	public PersonnelType getPersonnelType() {
		return personnelType;
	}
	/**
	 * @param personnelType the personnelType to set
	 */
	public void setPersonnelType(PersonnelType personnelType) {
		this.personnelType = personnelType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BioSketches [firstName=" + firstName + ", lastName=" + lastName
				+ ", textLength=" + textLength + ", text=" + text
				+ ", personnelType=" + personnelType + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((personnelType == null) ? 0 : personnelType.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + textLength;
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
		BioSketches other = (BioSketches) obj;
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
		if (personnelType != other.personnelType)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (textLength != other.textLength)
			return false;
		return true;
	}

	
	
}
