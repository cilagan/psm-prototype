package gov.nsf.research.psm.service;

import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;

public interface ProposalRulesClient {

	public PropTemplateResponse getTemplate(String fundOppId);
	
}
