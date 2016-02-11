package gov.nsf.research.psm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;
import gov.nsf.research.psm.rules.factmodel.ProposalSection;
import gov.nsf.research.psm.service.ProposalRulesService;

public class ProposalRulesWebServiceImpl implements ProposalRulesService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public PropTemplateResponse getProposalRules(WizardAnswersRequest wizAnwers) {
		ResponseEntity<List<ProposalSection>> response = 
		restTemplate.exchange("http://localhost:8080/ProposalRules/rules", HttpMethod.GET, null, new ParameterizedTypeReference<List<ProposalSection>>(){});
		List<ProposalSection> proposalTemplate = response.getBody();
		System.out.println(proposalTemplate.toString());
		return null;
	}

}
