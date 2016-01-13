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

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.business.DocumentServiceImpl;
import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.dao.FileStoreDao;
import gov.nsf.research.document.service.dao.MetaDataServiceDao;
import gov.nsf.research.document.service.dao.impl.DocumentServiceDaoImpl;
import gov.nsf.research.document.service.dao.impl.FileStoreDaoAmazonS3Impl;
import gov.nsf.research.document.service.dao.impl.MetaDataServiceDaoImpl;

@Configuration
public class AppConfig {

	@Autowired
	CouchbaseTemplate couchBaseTemplate;

	private final String AWS_ACCESS_KEY = "AKIAIZHYCZXIA3DFNAYA";
	private final String AWS_SECRET_KEY = "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";

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
		return new DocumentServiceDaoImpl();
	}

	@EnableCouchbaseRepositories
	@Configuration
	static class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

		//TODO: Move to property files later
		private String bucketName = "default";
		private String ip = "localhost";
		// private String ip = "nsf-pcv-01";
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

	@Bean
	public AmazonS3 amazonS3(){
		AWSCredentials credentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
		return new AmazonS3Client(credentials);
	}

	@Bean
	public FileStoreDao fileStoreDao(){
		return new FileStoreDaoAmazonS3Impl();
	}

	@Bean
	public MetaDataServiceDao docMetaDataDao(){
		return new MetaDataServiceDaoImpl(couchBaseTemplate);
	}
}
