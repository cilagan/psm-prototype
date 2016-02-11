package gov.nsf.research.psm.service;

import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;

public interface ProposalRulesService {

	public PropTemplateResponse getProposalRules(WizardAnswersRequest wizAnwers);
	
}
