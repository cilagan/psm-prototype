package gov.nsf.research.psm.proposal.webservice.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import gov.nsf.research.psm.proposal.transfer.proposals.GetProposalRequest;
import gov.nsf.research.psm.proposal.transfer.proposals.GetProposalResponse;


public class ProposalDataServiceClient extends WebServiceGatewaySupport {

	public GetProposalResponse getProposal(String tempPropId) {
		
		GetProposalRequest request = new GetProposalRequest();
		request.setTemporaryProposalID(tempPropId);
		
		GetProposalResponse response = (GetProposalResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		
		return response;
	}
}
