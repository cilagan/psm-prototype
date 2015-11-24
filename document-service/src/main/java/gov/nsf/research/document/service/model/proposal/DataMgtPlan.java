package gov.nsf.research.document.service.model.proposal;

import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.model.UploadableSection;

public class DataMgtPlan extends UploadableSection {

	private static final long serialVersionUID = 1922905486673946796L;
	private SectionType sectionType;
	
	public DataMgtPlan(){
		super();
		sectionType = SectionType.DATA_MANAGEMENT_PLAN;
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
