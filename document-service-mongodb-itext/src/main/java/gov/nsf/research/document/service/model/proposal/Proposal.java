package gov.nsf.research.document.service.model.proposal;

public class Proposal {

	/* Proposal Sections */
	private ProjectDesc projDesc;
	private DataMgtPlan dataMgtPlan;
	
	/**
	 * @return the projDesc
	 */
	public ProjectDesc getProjDesc() {
		return projDesc;
	}
	
	/**
	 * @param projDesc the projDesc to set
	 */
	public void setProjDesc(ProjectDesc projDesc) {
		this.projDesc = projDesc;
	}
	
	/**
	 * @return the dataMgtPlan
	 */
	public DataMgtPlan getDataMgtPlan() {
		return dataMgtPlan;
	}
	
	/**
	 * @param dataMgtPlan the dataMgtPlan to set
	 */
	public void setDataMgtPlan(DataMgtPlan dataMgtPlan) {
		this.dataMgtPlan = dataMgtPlan;
	}
}
