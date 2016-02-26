package gov.nsf.research.document.service.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.business.DocumentServiceImpl;
import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.dao.impl.DocumentServiceDaoImpl;
import gov.nsf.research.document.service.dao.impl.ProposalDaoImpl;
import gov.nsf.research.document.service.repository.ProjectDescRepository;
import gov.nsf.research.document.service.repository.impl.ProjectDescRepositoryImpl;


@Configuration
public class AppConfig {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	GridFsTemplate gridFsTemplate;
	
	/**
	 * CORS support
	 * 
	 */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }
        };
    }
    
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.sybase.jdbc3.jdbc.SybDriver");
        dataSource.setUrl("jdbc:sybase:Tds:fldevel15.nsf.gov:5000/fldb");
        dataSource.setUsername("flpupd");
        dataSource.setPassword("k2,OnivH");
         
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate psmFLJdbcTemplate(){
    	return new JdbcTemplate(getDataSource());
    }

	@Bean
	public DocumentService documentService(){
		return new DocumentServiceImpl();
	}
	
	@Bean
	public ProjectDescRepository projectDescRepository(){
		return new ProjectDescRepositoryImpl(mongoTemplate, gridFsTemplate);
	}
	
	@Bean
	public DocumentServiceDao documentServiceDao(){
		return new DocumentServiceDaoImpl(mongoTemplate, gridFsTemplate);
	}
	
	  @Bean
	    public ProposalDao proposalDao(){
	    	return new ProposalDaoImpl();
	    }
	
}
