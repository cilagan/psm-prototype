package gov.nsf.research.document.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.business.DocumentServiceImpl;
import gov.nsf.research.document.service.repository.ProjectDescRepository;
import gov.nsf.research.document.service.repository.impl.ProjectDescRepositoryImpl;

@Configuration
public class AppConfig {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	GridFsTemplate gridFsTemplate;
	
	@Bean
	public DocumentService documentService(){
		return new DocumentServiceImpl();
	}
	
	@Bean
	public ProjectDescRepository projectDescRepository(){
		return new ProjectDescRepositoryImpl(mongoTemplate, gridFsTemplate);
	}
}
