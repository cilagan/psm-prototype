package gov.nsf.research.document.service.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.business.DocumentServiceImpl;
import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.dao.impl.DocumentServiceDaoCBImpl;

@Configuration
public class AppConfig {
	
	@Autowired
	CouchbaseTemplate couchBaseTemplate;
	
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
	public DocumentService documentService(){
		return new DocumentServiceImpl();
	}
	
	@Bean
	public DocumentServiceDao documentServiceDao(){
		return new DocumentServiceDaoCBImpl(couchBaseTemplate);
	}
	
	@EnableCouchbaseRepositories
	@Configuration
	static class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
		
		//TODO: Move to property files later
		private String bucketName = "default";
		private String ip = "localhost";
		private String password = "";
		
		public CouchbaseConfiguration(){
			System.out.println("Testing CouchBase");
		}
		
		@Override
		protected List<String> bootstrapHosts(){
			return Arrays.asList(this.ip);
		}
		@Override
		protected String getBucketName(){
			return this.bucketName;
		}
		@Override		
		protected String getBucketPassword(){
			return this.password;
		}
	}
	
}
