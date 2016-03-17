package gov.nsf.research.document.service.model;

public class PDFDocument extends AbstractTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isPDFPasswordProteced;

	private int pdfFileSize;

	private String filetype;

	private String pdfVersion;

	private boolean isImageOnly;

	private boolean isPDFEncrypted;

	private int characterCountInPDF;
	
	private String pdfErrorMessage;

	

	public String getPdfErrorMessage() {
		return pdfErrorMessage;
	}

	public void setPdfErrorMessage(String pdfErrorMessage) {
		this.pdfErrorMessage = pdfErrorMessage;
	}

	public boolean isPDFPasswordProteced() {
		return isPDFPasswordProteced;
	}

	public void setPDFPasswordProteced(boolean isPDFPasswordProteced) {
		this.isPDFPasswordProteced = isPDFPasswordProteced;
	}

	public int getPdfFileSize() {
		return pdfFileSize;
	}

	public void setPdfFileSize(int pdfFileSize) {
		this.pdfFileSize = pdfFileSize;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getPdfVersion() {
		return pdfVersion;
	}

	public void setPdfVersion(String pdfVersion) {
		this.pdfVersion = pdfVersion;
	}

	public boolean isImageOnly() {
		return isImageOnly;
	}

	public void setImageOnly(boolean isImageOnly) {
		this.isImageOnly = isImageOnly;
	}

	public boolean isPDFEncrypted() {
		return isPDFEncrypted;
	}

	public void setPDFEncrypted(boolean isPDFEncrypted) {
		this.isPDFEncrypted = isPDFEncrypted;
	}

	public int getCharacterCountInPDF() {
		return characterCountInPDF;
	}

	public void setCharacterCountInPDF(int characterCountInPDF) {
		this.characterCountInPDF = characterCountInPDF;
	}
	
	
	public String toString() {
		return "DocumentCheckModel..... [isPDFPasswordProteced=" + isPDFPasswordProteced + ", pdfFileSize="
				+ pdfFileSize + ", filetype=" + filetype
				+ ", pdfVersion=" + pdfVersion + ", isImageOnly="
				+ isImageOnly +  ", isPDFEncrypted=" + isPDFEncrypted+",pdfErrorMessage="+pdfErrorMessage
				+   ", characterCountInPDF=" + characterCountInPDF+"]"; 
	}
	
	

}
