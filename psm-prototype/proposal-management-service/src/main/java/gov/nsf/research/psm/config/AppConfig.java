package gov.nsf.research.psm.config;


import gov.nsf.research.psm.ProposalManagementServiceApplication;
import gov.nsf.research.psm.service.ProposalBuilder;
import gov.nsf.research.psm.service.ProposalManagementService;
import gov.nsf.research.psm.service.ProposalRulesClient;
import gov.nsf.research.psm.service.impl.ProposalBuilderImpl;
import gov.nsf.research.psm.service.impl.ProposalManagementServiceImpl;
import gov.nsf.research.psm.service.impl.ProposalRulesClientImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@Configuration
//@ImportResource("classpath:nr-business-context.xml")
public class AppConfig {


		
//	@Bean
//	public ProposalManagementServiceApplication proposalManagementServiceApplication(){
//		return new ProposalManagementServiceApplication();
//	}
	
	@Bean
	public ProposalManagementService ProposalManagementService(){
		return new ProposalManagementServiceImpl();
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public ProposalRulesClient proposalRulesClient(){
		return new ProposalRulesClientImpl();
	}
	
	@Bean
	public ProposalBuilder proposalBuilder(){
		return new ProposalBuilderImpl();
	}
}