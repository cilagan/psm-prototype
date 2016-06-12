package gov.nsf.research.psm.model;

public class ProjectSummarySection extends UploadableSection{

	private String projectSummaryText;
	private String intellectualMerit;
	private String broaderImpacts;
	private boolean specialCharPDF;
	
	/**
	 * @return the projectSummaryText
	 */
	public String getProjectSummaryText() {
		return projectSummaryText;
	}
	/**
	 * @param projectSummaryText the projectSummaryText to set
	 */
	public void setProjectSummaryText(String projectSummaryText) {
		this.projectSummaryText = projectSummaryText;
	}
	/**
	 * @return the intellectualMerit
	 */
	public String getIntellectualMerit() {
		return intellectualMerit;
	}
	/**
	 * @param intellectualMerit the intellectualMerit to set
	 */
	public void setIntellectualMerit(String intellectualMerit) {
		this.intellectualMerit = intellectualMerit;
	}
	/**
	 * @return the broaderImpacts
	 */
	public String getBroaderImpacts() {
		return broaderImpacts;
	}
	/**
	 * @param broaderImpacts the broaderImpacts to set
	 */
	public void setBroaderImpacts(String broaderImpacts) {
		this.broaderImpacts = broaderImpacts;
	}
	/**
	 * @return the specialCharPDF
	 */
	public boolean isSpecialCharPDF() {
		return specialCharPDF;
	}
	/**
	 * @param specialCharPDF the specialCharPDF to set
	 */
	public void setSpecialCharPDF(boolean specialCharPDF) {
		this.specialCharPDF = specialCharPDF;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectSummary [projectSummaryText=" + projectSummaryText
				+ ", intellectualMerit=" + intellectualMerit
				+ ", broaderImpacts=" + broaderImpacts + ", specialCharPDF="
				+ specialCharPDF + ", sectionFormat=" + sectionFormat
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
				+ ((broaderImpacts == null) ? 0 : broaderImpacts.hashCode());
		result = prime
				* result
				+ ((intellectualMerit == null) ? 0 : intellectualMerit
						.hashCode());
		result = prime
				* result
				+ ((projectSummaryText == null) ? 0 : projectSummaryText
						.hashCode());
		result = prime * result + (specialCharPDF ? 1231 : 1237);
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
		ProjectSummarySection other = (ProjectSummarySection) obj;
		if (broaderImpacts == null) {
			if (other.broaderImpacts != null)
				return false;
		} else if (!broaderImpacts.equals(other.broaderImpacts))
			return false;
		if (intellectualMerit == null) {
			if (other.intellectualMerit != null)
				return false;
		} else if (!intellectualMerit.equals(other.intellectualMerit))
			return false;
		if (projectSummaryText == null) {
			if (other.projectSummaryText != null)
				return false;
		} else if (!projectSummaryText.equals(other.projectSummaryText))
			return false;
		if (specialCharPDF != other.specialCharPDF)
			return false;
		return true;
	}
	
	
}
