package gov.nsf.research.psm.service;

import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;

public interface ProposalRulesClient {

	public PropTemplateResponse getTemplate(PropWizAnswers propWizAnswers);
	
}
