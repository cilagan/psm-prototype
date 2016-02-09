package gov.nsf.research.psm.model;

/**
 * ProgramElement
 * 
 * @author spendyal
 *
 */

public class ProgramElement {
	
	private String divisionID;
	
	private String programElementCode;
	
	private String programElementDesc;

	public String getDivisionID() {
		return divisionID;
	}

	public void setDivisionID(String divisionID) {
		this.divisionID = divisionID;
	}

	public String getProgramElementCode() {
		return programElementCode;
	}

	public void setProgramElementCode(String programElementCode) {
		this.programElementCode = programElementCode;
	}

	public String getProgramElementDesc() {
		return programElementDesc;
	}

	public void setProgramElementDesc(String programElementDesc) {
		this.programElementDesc = programElementDesc;
	}

	public String toString() {
		return "ProgramElement [programElementCode="
				+ programElementCode + ", programElementDesc="
				+ programElementDesc  + "]";
	}
	

}
