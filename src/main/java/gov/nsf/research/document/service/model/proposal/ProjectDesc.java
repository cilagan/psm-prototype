package gov.nsf.research.document.service.model.proposal;

import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.model.UploadableSection;

public class ProjectDesc extends UploadableSection{

	private SectionType sectionType;
	
	public ProjectDesc(){
		super();
		sectionType = SectionType.PROJECT_DESCRIPTION;
	}

	/**
	 * @return the sectionType
	 */
	public SectionType getSectionType() {
		return sectionType;
	}

	/**
	 * @param sectionType the sectionType to set
	 */
	public void setSectionType(SectionType sectionType) {
		this.sectionType = sectionType;
	}
	
}
