package gov.nsf.research.psm.rules.service;

import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;

public interface ProposalRulesService {

	PropTemplateResponse getProposalTemplate(WizardAnswersRequest wizAnwers);
	
}
