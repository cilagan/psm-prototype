package gov.nsf.research.document.service.dao;

import gov.nsf.research.document.service.model.proposal.ProjectSummary;



/**
 * @author spendyal
 *
 */
public interface ProposalDao {

	
	/**
	 * 
	 * @param tempPropID
	 * @return
	 */
	public ProjectSummary getProjectSummary(String tempPropID);
	
	
	
	/**
	 * 
	 * @param overView
	 * @param intulMerit
	 * @param brodrImpt
	 * @return
	 */
	
	public void saveProjectSummary(String tempPropID, String overView, String intulMerit, String brodrImpt);
	
	/**
	 * 
	 * @param tempPropID
	 * @return
	 */
	public String getStampPDFTimeStamp(String tempPropID);

	

}
