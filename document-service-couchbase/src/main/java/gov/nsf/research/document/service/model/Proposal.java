package gov.nsf.research.document.service.model;

public class Proposal extends DocumentMetaData {


	private static final long serialVersionUID = 8445638027599461796L;
	
	private String title;
	private DocumentMetaData projectDescription;
	private DocumentMetaData coverSheet;
	private DocumentMetaData dmp;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the projectDescription
	 */
	public DocumentMetaData getProjectDescription() {
		return projectDescription;
	}
	/**
	 * @param projectDescription the projectDescription to set
	 */
	public void setProjectDescription(DocumentMetaData projectDescription) {
		this.projectDescription = projectDescription;
	}
	/**
	 * @return the coverSheet
	 */
	public DocumentMetaData getCoverSheet() {
		return coverSheet;
	}
	/**
	 * @param coverSheet the coverSheet to set
	 */
	public void setCoverSheet(DocumentMetaData coverSheet) {
		this.coverSheet = coverSheet;
	}
	/**
	 * @return the dmp
	 */
	public DocumentMetaData getDmp() {
		return dmp;
	}
	/**
	 * @param dmp the dmp to set
	 */
	public void setDmp(DocumentMetaData dmp) {
		this.dmp = dmp;
	}

}
