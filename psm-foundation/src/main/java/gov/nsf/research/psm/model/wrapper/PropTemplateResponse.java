package gov.nsf.research.psm.model.wrapper;

import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;

public class PropTemplateResponse extends BaseResponse {

	private static final long serialVersionUID = -3448679241238462657L;
	
	private ProposalTemplate propTemplate;

	public PropTemplateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PropTemplateResponse(ProposalTemplate propTemplate) {
		super();
		this.propTemplate = propTemplate;
	}

	/**
	 * @return the propTemplate
	 */
	public ProposalTemplate getPropTemplate() {
		return propTemplate;
	}

	/**
	 * @param propTemplate the propTemplate to set
	 */
	public void setPropTemplate(ProposalTemplate propTemplate) {
		this.propTemplate = propTemplate;
	}

}
