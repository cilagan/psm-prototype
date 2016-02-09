package gov.nsf.research.psm.model;

import java.util.List;

/**
 * Division
 * 
 * @author spendyal
 *
 */

public class Division {

	private String divisionCode;
	private String divisionDesc;

	private List<ProgramElement> ProgramElementList;

	public List<ProgramElement> getProgramElementList() {
		return ProgramElementList;
	}

	public void setProgramElementList(List<ProgramElement> programElementList) {
		ProgramElementList = programElementList;
	}

	public String getDivisionDesc() {
		return divisionDesc;
	}

	public void setDivisionDesc(String divisionDesc) {
		this.divisionDesc = divisionDesc;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	public String toString() {
		return "Division [divisionCode="
				+ divisionCode + ", divisionDesc="
				+ divisionDesc + ", ProgramElementList="
				+ ProgramElementList.toString() + "]";
	}

}
