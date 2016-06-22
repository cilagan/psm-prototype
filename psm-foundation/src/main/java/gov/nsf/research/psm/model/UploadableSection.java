package gov.nsf.research.psm.model;

public class UploadableSection extends Section {

	protected SectionFormat sectionFormat;
	protected int pageCount;
	protected String filePath;
	
	/**
	 * @return the sectionFormat
	 */
	public SectionFormat getSectionFormat() {
		return sectionFormat;
	}
	/**
	 * @param sectionFormat the sectionFormat to set
	 */
	public void setSectionFormat(SectionFormat sectionFormat) {
		this.sectionFormat = sectionFormat;
	}
	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}
	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UploadableSection [sectionFormat=" + sectionFormat
				+ ", pageCount=" + pageCount + ", filePath=" + filePath
				+ ", lastUpdateTimeStamp=" + lastUpdateTimeStamp + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + pageCount;
		result = prime * result
				+ ((sectionFormat == null) ? 0 : sectionFormat.hashCode());
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
		UploadableSection other = (UploadableSection) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (pageCount != other.pageCount)
			return false;
		if (sectionFormat != other.sectionFormat)
			return false;
		return true;
	}

	
	
}
