package gov.nsf.research.document.service.model;

public enum SectionType {

	PROJECT_DESCRIPTION,
	
	DATA_MANAGEMENT_PLAN;

	public static SectionType getSectionType(String sectionType){
		if("PROJECT_DESCRIPTION".equals(sectionType)){
			return SectionType.PROJECT_DESCRIPTION;
		} else if ("DATA_MANAGEMENT_PLAN".equals(sectionType)){
			return SectionType.DATA_MANAGEMENT_PLAN;
		} else {
			return null;
		}
	}
}
