
package gov.nsf.research.psm.model;

import java.util.List;

/**
 * Proposal Funding Opportunity
 * 
 * @author spendyal
 *
 */
public class FundingOpportunity {

	private String pgmAnncID;
	private String pgmAnncTitle;
	private List<Directorate> directorateList;
	
	
	public String getPgmAnncID() {
		return pgmAnncID;
	}

	public void setPgmAnncID(String pgmAnncID) {
		this.pgmAnncID = pgmAnncID;
	}

	public String getPgmAnncTitle() {
		return pgmAnncTitle;
	}

	public void setPgmAnncTitle(String pgmAnncTitle) {
		this.pgmAnncTitle = pgmAnncTitle;
	}

	public List<Directorate> getDirectorateList() {
		return directorateList;
	}

	public void setDirectorateList(List<Directorate> directorateList) {
		this.directorateList = directorateList;
	}

	@Override
	public String toString() {
		return "FundingOpportunity [pgmAnncID="
				+ pgmAnncID + ", pgmAnncTitle="
				+ pgmAnncTitle + ", directorateList="
				+ directorateList.toString() + "]";
	}
	
	
		
}
