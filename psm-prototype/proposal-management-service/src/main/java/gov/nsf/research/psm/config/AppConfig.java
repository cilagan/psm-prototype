package gov.nsf.research.psm.config;


import gov.nsf.research.psm.ProposalManagementServiceApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


		
	@Bean
	public ProposalManagementServiceApplication proposalManagementServiceApplication(){
		return new ProposalManagementServiceApplication();
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}