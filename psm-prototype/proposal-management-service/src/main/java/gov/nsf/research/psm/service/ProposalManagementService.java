package gov.nsf.research.psm.service;

import java.util.List;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;


public interface ProposalManagementService {

	/**
	 * 
	 * @return list of fundingopportunity
	 */
	public List<FundingOpportunity> getAllFundingOpportunities();

	/**
	 * List of divisions within the funding opportunity
	 * @param pgmAnncID
	 * @return
	 */
	public List<Division> getDivisions(String pgmAnncID);

	/**
	 * 
	 * @return list of directorates
	 */
	public List<Directorate> getAllDirectorates();

	/**
	 * 
	 * @param pgmAnncID
	 * @param divisionCode
	 * @return
	 */
	public List<ProgramElement> getProgramElements(String pgmAnncID,
			String divisionCode);
	
}
