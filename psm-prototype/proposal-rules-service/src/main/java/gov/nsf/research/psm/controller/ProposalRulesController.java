package gov.nsf.research.psm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(path="/rules/{fundOppId}", method = RequestMethod.GET)
	public ResponseEntity<PropTemplateResponse> getProposalTemplate(@PathVariable String fundOppId){
		WizardAnswersRequest request = new WizardAnswersRequest();
		
		FundingOpportunity fo = new FundingOpportunity();
		fo.setFundingOpportunityId(fundOppId);
		
		PropWizAnswers pwa = new PropWizAnswers();
		pwa.setFundingOpp(fo);
		
		request.setPropWizAnswers(pwa);
		System.out.println(request.toString());
		
		
		return new ResponseEntity<PropTemplateResponse>(propRulesService.getProposalTemplate(request), HttpStatus.OK);
	}
}
