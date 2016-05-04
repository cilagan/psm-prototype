package gov.nsf.research.psm.proposal.config;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import gov.nsf.research.psm.proposal.webservice.client.ProposalDataServiceClient;

@Configuration
public class AppConfig {

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
		client.setDefaultUri("http://wsinside.intg.research.gov/pcv/proposal-service");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.setMessageSender(messageSender);
		return client;
	}
}
