package gov.nsf.research.psm.model;

import java.util.List;

/**
 * Division
 * 
 * @author spendyal
 *
 */

public class Division {

	private String pgmAnncID;
	
	private String divisionCode;
	
	private String divisionCodeDesc;
	
	private List<ProgramElement> programElementList;

	public String getPgmAnncID() {
		return pgmAnncID;
	}

	public void setPgmAnncID(String pgmAnncID) {
		this.pgmAnncID = pgmAnncID;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getDivisionCodeDesc() {
		return divisionCodeDesc;
	}

	public void setDivisionCodeDesc(String divisionCodeDesc) {
		this.divisionCodeDesc = divisionCodeDesc;
	}
	
}
