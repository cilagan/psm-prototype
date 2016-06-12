package gov.nsf.research.psm.rules.factmodel;

import java.util.ArrayList;
import java.util.List;

import gov.nsf.research.psm.model.AbstractTransferObject;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.SubmissionType;
import gov.nsf.research.psm.model.UnitOfConsideration;

public class PropWizAnswers extends AbstractTransferObject{

	private static final long serialVersionUID = 5308844691468457474L;
	
	private FundingOpportunity fundingOpp;
	private List<UnitOfConsideration> uocList;
	private SubmissionType submissionType;
	private String fundingMechanism;
	
	public PropWizAnswers(){
		uocList = new ArrayList<UnitOfConsideration>();
	}
		
	public PropWizAnswers(FundingOpportunity fundingOpp, List<UnitOfConsideration> uocList,
			SubmissionType submissionType, String fundingMechanism) {
		super();
		this.fundingOpp = fundingOpp;
		this.uocList = uocList;
		this.submissionType = submissionType;
		this.fundingMechanism = fundingMechanism;
	}

	/**
	 * @return the fundingOpp
	 */
	public FundingOpportunity getFundingOpp() {
		return fundingOpp;
	}
	/**
	 * @param fundingOpp the fundingOpp to set
	 */
	public void setFundingOpp(FundingOpportunity fundingOpp) {
		this.fundingOpp = fundingOpp;
	}
	/**
	 * @return the uocList
	 */
	public List<UnitOfConsideration> getUocList() {
		return uocList;
	}
	/**
	 * @param uocList the uocList to set
	 */
	public void setUocList(List<UnitOfConsideration> uocList) {
		this.uocList = uocList;
	}
	/**
	 * @return the submissionType
	 */
	public SubmissionType getSubmissionType() {
		return submissionType;
	}
	/**
	 * @param submissionType the submissionType to set
	 */
	public void setSubmissionType(SubmissionType submissionType) {
		this.submissionType = submissionType;
	}
	/**
	 * @return the fundingMechanism
	 */
	public String getFundingMechanism() {
		return fundingMechanism;
	}
	/**
	 * @param fundingMechanism the fundingMechanism to set
	 */
	public void setFundingMechanism(String fundingMechanism) {
		this.fundingMechanism = fundingMechanism;
	}

}
