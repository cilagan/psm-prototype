package gov.nsf.research.psm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.Proposal;
import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.service.ProposalBuilder;
import gov.nsf.research.psm.service.ProposalManagementService;
import gov.nsf.research.psm.service.ProposalRulesClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProposalManagementServiceApplication.class)
@WebAppConfiguration
public class ProposalManagementServiceApplicationTests {

	@Autowired
	ProposalRulesClient proposalRulesClient;
	
	@Autowired
	ProposalBuilder propBuilder;
	
	@Autowired
	ProposalManagementService propMgtService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testRestTemplate(){
		PropTemplateResponse response = proposalRulesClient.getTemplate("GPG99");
		System.out.println(response.toString());
	}
	
	@Test
	public void testProposalBuilder(){
		PropTemplateResponse response = proposalRulesClient.getTemplate("GPG99");
		ProposalTemplate propTemp = response.getPropTemplate();
		Proposal proposal = propBuilder.buildProposal(propTemp);
		System.out.println(proposal.toString());
	}
	
	@Test
	public void testCreateProposal(){
		PropWizAnswers propWizAnswers = new PropWizAnswers();
		
		FundingOpportunity fundOpp = new FundingOpportunity();
		fundOpp.setFundingOpportunityId("BIO99");
		
		propWizAnswers.setFundingOpp(fundOpp);
		
		Proposal proposal = propMgtService.createProposal(propWizAnswers);
		System.out.println(proposal.toString());
		
	}
}
