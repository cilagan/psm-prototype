package gov.nsf.psm.foundation.exception;

public class BaseError {

	private String fieldId;
	private String detail;
						
	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	

	public BaseError() {

	}

	public BaseError(String id, String message) {
		super();
		this.fieldId = id;
		this.detail = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseError [id=");
		builder.append(fieldId);
		builder.append(", detail=");
		builder.append(detail);
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}

}
