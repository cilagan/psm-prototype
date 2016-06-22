package gov.nsf.research.psm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.UnitOfConsideration;
import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.service.ProposalRulesClient;

public class ProposalRulesClientImpl implements ProposalRulesClient {

	@Autowired 
	RestTemplate restTemplate;
	
	@Override
	public PropTemplateResponse getTemplate(PropWizAnswers propWizAnswers) {
		
		String fundOppId = propWizAnswers.getFundingOpp().getFundingOpportunityId();
		String divId = getDivId(propWizAnswers.getFundingOpp().getDivisionList());
		String pgmElemId = getPgmElemId(propWizAnswers.getUocList());
		
		String url = "http://localhost:8080/ProposalRules/rules/" + fundOppId + "/" + divId + "/" + pgmElemId; 
		
		ResponseEntity<PropTemplateResponse> response = restTemplate.getForEntity(url, PropTemplateResponse.class);
		System.out.println(response.getBody().getPropTemplate().toString());
		ProposalTemplate propTemp =  response.getBody().getPropTemplate();
		PropTemplateResponse propTemplateResponse = new PropTemplateResponse();
		propTemplateResponse.setPropTemplate(propTemp);
		return propTemplateResponse;
	}
	
	
	private static String getDivId(List<Division> divList){
		for(Division div : divList){
			return div.getDivisionCode();
		}
		
		return "";
	}
	
	private static String getPgmElemId(List<UnitOfConsideration> uocList){
		for(UnitOfConsideration uoc : uocList){
			return uoc.getProgramElementCode();
		}
		return "";
	}

}
