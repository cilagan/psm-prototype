package gov.nsf.research.psm.config;


import gov.nsf.research.psm.ProposalManagementServiceApplication;
import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.dao.impl.ProposalDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig {


		
	@Bean
	public ProposalManagementServiceApplication proposalManagementServiceApplication(){
		return new ProposalManagementServiceApplication();
	}

	
	
	

}