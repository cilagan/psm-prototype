package gov.nsf.research.psm.model;

public class ReferencesCited extends UploadableSection {
  private String refCitedTxt;

/**
 * @return the refCitedTxt
 */
public String getRefCitedTxt() {
	return refCitedTxt;
}

/**
 * @param refCitedTxt the refCitedTxt to set
 */
public void setRefCitedTxt(String refCitedTxt) {
	this.refCitedTxt = refCitedTxt;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "ReferencesCited [refCitedTxt=" + refCitedTxt + ", sectionFormat="
			+ sectionFormat + ", pageCount=" + pageCount + ", filePath="
			+ filePath + ", lastUpdateTimeStamp=" + lastUpdateTimeStamp + "]";
}


}
