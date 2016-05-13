package gov.nsf.research.document.service.config;


import gov.nsf.research.document.service.controller.DocumentGenerationController;
import gov.nsf.research.document.service.pdf.PDFService;
import gov.nsf.research.document.service.pdf.impl.ITextPDFServiceImpl;
import gov.nsf.research.psm.proposal.webservice.client.ProposalDataServiceClient;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;


@Configuration
public class AppConfig {


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
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("gov.nsf.research.psm.proposal.transfer.proposals");
		return marshaller;
	}
	
	@Bean
	public HttpComponentsMessageSender messageSender(UsernamePasswordCredentials credentials) {
		HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
		messageSender.setCredentials(credentials);
		return messageSender;
	}
	
	@Bean
	public UsernamePasswordCredentials credentials() {
		return new UsernamePasswordCredentials("pcv","pcv12345");
	}
	
	@Bean
	public ProposalDataServiceClient proposalDataServiceClient(Jaxb2Marshaller marshaller, 
			HttpComponentsMessageSender messageSender){ 
		ProposalDataServiceClient client = new ProposalDataServiceClient();
		//client.setDefaultUri("http://wsinside.intg.research.gov/pcv/proposal-service");	
		client.setDefaultUri("http://wsinside.acpt.research.gov/pcv/proposal-service");	
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.setMessageSender(messageSender);
		return client;
	}
    
    
	@Bean
	public PDFService pDFService(){
		return new ITextPDFServiceImpl();
	}
      
	      
	@Bean
	public DocumentGenerationController documentGenerationController(){
		return new DocumentGenerationController();
	}


}
