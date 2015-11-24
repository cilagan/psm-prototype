package gov.nsf.research.document.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import gov.nsf.research.document.service.repository.ProjectDescRepository;
import gov.nsf.research.document.service.repository.impl.ProjectDescRepositoryImpl;

@Configuration
public class AppConfig {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Bean
	public ProjectDescRepository projectDescRepository(){
		return new ProjectDescRepositoryImpl(mongoTemplate);
	}
}
