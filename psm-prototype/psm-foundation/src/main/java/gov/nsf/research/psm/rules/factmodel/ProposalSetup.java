package gov.nsf.research.psm.rules.factmodel;

import java.util.List;

import gov.nsf.research.psm.model.AbstractTransferObject;

public class ProposalSetup extends AbstractTransferObject {

	private static final long serialVersionUID = 2380267759396429644L;
	
	private List<ProposalSection> sectionList;

	/**
	 * @return the sectionList
	 */
	public List<ProposalSection> getSectionList() {
		return sectionList;
	}

	/**
	 * @param sectionList the sectionList to set
	 */
	public void setSectionList(List<ProposalSection> sectionList) {
		this.sectionList = sectionList;
	}
	
	
		
}
