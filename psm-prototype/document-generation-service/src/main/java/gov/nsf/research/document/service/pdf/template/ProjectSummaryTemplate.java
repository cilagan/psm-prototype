package gov.nsf.research.document.service.pdf.template;

import gov.nsf.research.psm.proposal.transfer.proposals.GetProposalResponse;
import gov.nsf.research.psm.proposal.webservice.client.ProposalDataServiceClient;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;

public final class ProjectSummaryTemplate {
	
	@Autowired
	public  ProposalDataServiceClient proposalDataServiceClient;
	
	

	public ProjectSummaryTemplate() {  }



	public   ByteArrayOutputStream generatPDF(String tempPropId) {
		
		//Calll Proposal Data Service to pull Project summary data
		System.out.println("ProjectSummaryTemplate.generatPDF()............"+tempPropId);
		 GetProposalResponse proposal= proposalDataServiceClient.getProposal(tempPropId);
			System.out.println("Proposal Response: "+proposal.getProposal().getProposalSections().getProjectSummary());
		
		
		//Check if it is text or uploaded file
		
		//Generate PDF 

		return null;

	}

}
