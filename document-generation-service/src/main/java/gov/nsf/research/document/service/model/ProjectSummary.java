package gov.nsf.research.document.service.model;

import gov.nsf.research.document.service.model.SectionType;


public class ProjectSummary {

	private SectionType sectionType;
	
	public ProjectSummary(){
		super();
		sectionType = SectionType.PROJ_SUMM;
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
