package gov.nsf.research.psm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;
import gov.nsf.research.psm.rules.service.ProposalRulesService;

@RestController
@RequestMapping(path="/ProposalRules")
public class ProposalRulesController {

	@Autowired
	ProposalRulesService propRulesService;
	
	@RequestMapping(path="/proposal" )
	public PropTemplateResponse getProposalTemplate(WizardAnswersRequest wizAnsRequest){
		return propRulesService.getProposalTemplate(wizAnsRequest);
	}
}
