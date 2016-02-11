package gov.nsf.research.psm.config;


import gov.nsf.research.psm.ProposalManagementServiceApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:nr-business-context.xml")
public class AppConfig {


		
	@Bean
	public ProposalManagementServiceApplication proposalManagementServiceApplication(){
		return new ProposalManagementServiceApplication();
	}

	
	
	

}