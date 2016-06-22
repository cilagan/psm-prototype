package gov.nsf.psm.foundation.exception;

import java.util.ArrayList;
import java.util.List;

public class BaseResponseWrapper {
	
	private List<BaseError> errors;
	private List<BaseError> warnings;
	private List<BaseError> informationals;
	
	public BaseResponseWrapper() {}
	
	public BaseResponseWrapper(List<BaseError> errors, List<BaseError> warnings, List<BaseError> informationals) {
		this.errors = errors;
		this.warnings = warnings;
		this.informationals = informationals;
	}
	
	public void addError(BaseError error){
		if ( this.errors == null ){
			this.errors = new ArrayList<BaseError>();
		}
			
		this.errors.add(error);
	}
	
	public List<BaseError> getErrors() {
		return errors;
	}
	public void setErrors(List<BaseError> errors) {
		this.errors = errors;
	}
	public List<BaseError> getWarnings() {
		return warnings;
	}
	public void setWarnings(List<BaseError> warnings) {
		this.warnings = warnings;
	}
	public List<BaseError> getInformationals() {
		return informationals;
	}
	public void setInformationals(List<BaseError> informationals) {
		this.informationals = informationals;
	}
	
	@Override
	public String toString(){
		StringBuilder meetingProposalWrapperDetails = new StringBuilder();
		meetingProposalWrapperDetails.append("Errors :");
		meetingProposalWrapperDetails.append(this.getErrors());
		meetingProposalWrapperDetails.append("\n");
		
		meetingProposalWrapperDetails.append("Warnings :");
		meetingProposalWrapperDetails.append(this.getWarnings());
		meetingProposalWrapperDetails.append("\n");
		
		meetingProposalWrapperDetails.append("Informationals :");
		meetingProposalWrapperDetails.append(this.getInformationals());
		meetingProposalWrapperDetails.append("\n");
		
		return meetingProposalWrapperDetails.toString();
		
	}
	

}
