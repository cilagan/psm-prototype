package gov.nsf.research.psm.model;

/**
 * Directorate
 * 
 * @author spendyal
 *
 */

public class Directorate {
	
	private String directorateID;
	private String directorateDesc;
	
	/**
	 * 
	 * @return
	 */
	public String getDirectorateID() {
		return directorateID;
	}
	
	/**
	 * 
	 * @param directorateID
	 */
	public void setDirectorateID(String directorateID) {
		this.directorateID = directorateID;
	}
	/**
	 * 
	 * @return
	 */
	public String getDirectorateDesc() {
		return directorateDesc;
	}
	/**
	 * 
	 * @param directorateDesc
	 */
	public void setDirectorateDesc(String directorateDesc) {
		this.directorateDesc = directorateDesc;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return "Directorate [directorateID="
				+ directorateID + ", directorateDesc="
				+ directorateDesc + "]";
	}
	

}
