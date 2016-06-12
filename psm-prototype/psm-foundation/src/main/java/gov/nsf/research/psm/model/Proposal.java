package gov.nsf.research.psm.model;

import java.util.HashMap;
import java.util.Map;

import gov.nsf.research.psm.rules.factmodel.ProposalSection;

public class Proposal extends AbstractTransferObject {

	private static final long serialVersionUID = 2113057779112969703L;
	
	private CoverSheetDTO coverSheet;
	private Map<ProposalSection, Section> sectList;
	
	public Proposal(){
		this.sectList = new HashMap<ProposalSection, Section>();
	}

	/**
	 * @return the coverSheet
	 */
	public CoverSheetDTO getCoverSheet() {
		return coverSheet;
	}

	/**
	 * @param coverSheet the coverSheet to set
	 */
	public void setCoverSheet(CoverSheetDTO coverSheet) {
		this.coverSheet = coverSheet;
	}

	/**
	 * @return the sectList
	 */
	public Map<ProposalSection, Section> getSectList() {
		return sectList;
	}

	/**
	 * @param sectList the sectList to set
	 */
	public void setSectList(Map<ProposalSection, Section> sectList) {
		this.sectList = sectList;
	}
	
	
	

}
