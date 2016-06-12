package gov.nsf.research.document.service.model;

public class EditorText extends AbstractTransferObject {

	private static final long serialVersionUID = -8634808498843207905L;
	
	private String text;
	private EditorFormat format;
		

	public EditorText() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EditorText(String text, EditorFormat format) {
		super();
		this.text = text;
		this.format = format;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the format
	 */
	public EditorFormat getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(EditorFormat format) {
		this.format = format;
	} 
	
	
}
