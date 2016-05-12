package gov.nsf.research.psm.proposal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.nsf.research.psm.proposal.config.AppConfig;
import gov.nsf.research.psm.proposal.transfer.proposals.GetProposalResponse;
import gov.nsf.research.psm.proposal.webservice.client.ProposalDataServiceClient;


@SpringBootApplication
public class ProposalDataServiceClientApplication extends SpringBootServletInitializer {

	//@Override
	//protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	//	return application.sources(ProposalDataServiceClientApplication.class);
	//}
	
	public static void main(String[] args) {
		//SpringApplication.run(ProposalDataServiceClientApplication.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProposalDataServiceClient client = context.getBean(ProposalDataServiceClient.class);
		GetProposalResponse response = client.getProposal("7664607");
		System.out.println("Proposal Title : "+response.getProposal().getProposalHeader().getTitle());
		System.out.println("PJ FilePath : "+response.getProposal().getProposalSections().getProjectSummary().getFilePath());
	}


}
