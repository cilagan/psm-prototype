package gov.nsf.research.psm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.rules.service.ProposalRulesService;

@RestController
@RequestMapping(path="/ProposalRules")
public class ProposalRulesController {

	@Autowired
	ProposalRulesService propRulesService;
	
	@RequestMapping(path="/rules" )
	public PropTemplateResponse getProposalTemplate(WizardAnswersRequest wizAnsRequest){
		WizardAnswersRequest request = new WizardAnswersRequest();
		
		FundingOpportunity fo = new FundingOpportunity();
		fo.setFundingOpportunityId("GPG99");
		
		PropWizAnswers pwa = new PropWizAnswers();
		pwa.setFundingOpp(fo);
		
		request.setPropWizAnswers(pwa);
		System.out.println(request.toString());
		return propRulesService.getProposalTemplate(wizAnsRequest);
	}
}
