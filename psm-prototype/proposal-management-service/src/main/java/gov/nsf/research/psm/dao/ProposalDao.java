/**
 * 
 */
package gov.nsf.research.psm.dao;

import java.util.List;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;

/**
 * @author spendyal
 *
 */
public interface ProposalDao {
	
	
	/**
	 * 
	 * @return list of fundingopportunity 
	 */
	public List<FundingOpportunity> getAllFundingOpportunities();
	
	/**
	 * 
	 * @param pgmAnncID
	 * @return list of Divisions including Program Element codes within the division
	 */
	public List<Division> getDivisionAndProgramElements( String pgmAnncID);
	
	/**
	 * 
	 * @return list of directorates
	 */
	public List<Directorate> getAllDirectorates();
	


}
