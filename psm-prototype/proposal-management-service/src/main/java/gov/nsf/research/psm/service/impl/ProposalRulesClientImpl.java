package gov.nsf.research.psm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.service.ProposalRulesClient;

public class ProposalRulesClientImpl implements ProposalRulesClient {

	@Autowired 
	RestTemplate restTemplate;
	
	@Override
	public PropTemplateResponse getTemplate(String fundOppId) {
		ResponseEntity<PropTemplateResponse> response = restTemplate.getForEntity("http://localhost:8080/ProposalRules/rules/" + fundOppId, PropTemplateResponse.class);
		System.out.println(response.getBody().getPropTemplate().toString());
		ProposalTemplate propTemp =  response.getBody().getPropTemplate();
		PropTemplateResponse propTemplateResponse = new PropTemplateResponse();
		propTemplateResponse.setPropTemplate(propTemp);
		return propTemplateResponse;
	}

}
