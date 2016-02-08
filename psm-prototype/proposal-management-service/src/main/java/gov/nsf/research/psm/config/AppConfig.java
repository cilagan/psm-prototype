package gov.nsf.research.psm.config;


import gov.nsf.research.psm.ProposalManagementServiceApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


		
	@Bean
	public ProposalManagementServiceApplication proposalManagementServiceApplication(){
		return new ProposalManagementServiceApplication();
	}

	
	
	

}