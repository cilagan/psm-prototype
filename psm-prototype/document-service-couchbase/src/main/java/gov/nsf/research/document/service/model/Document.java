package gov.nsf.research.document.service.model;

public class Document extends AbstractTransferObject {

	private static final long serialVersionUID = -5349358974762770120L;
	
	private String tempPropId;
	private SectionType sectionType;
	
	public Document(String tempPropId, SectionType sectionType){
		this.tempPropId = tempPropId;
		this.sectionType = sectionType;
	}
	
	/**
	 * @return the tempPropId
	 */
	public String getTempPropId() {
		return tempPropId;
	}
	
	/**
	 * @param tempPropId the tempPropId to set
	 */
	public void setTempPropId(String tempPropId) {
		this.tempPropId = tempPropId;
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
	
	public String getURLEnd(){
		if(SectionType.PROJECT_DESCRIPTION.equals(this.sectionType)){
			return "projdesc";
		} else if(SectionType.DATA_MANAGEMENT_PLAN.equals(this.sectionType)){
			return "dmp";
		} else {
			return null;
		}
	}
}
