package gov.nsf.research.psm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.SubmissionType;
import gov.nsf.research.psm.model.UnitOfConsideration;
import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.rules.factmodel.ProposalSection;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.rules.service.ProposalRulesService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProposalRulesServiceApplication.class)
@WebAppConfiguration
public class ProposalRulesServiceImplTest {

	@Autowired
	ProposalRulesService prs;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getProposalTemplateTest(){
		PropWizAnswers pwa = new PropWizAnswers();
		
		FundingOpportunity fundingOpp = new FundingOpportunity();
		fundingOpp.setFundingOpportunityId("NSF-12345");
		fundingOpp.setFundingOpportunityType("Biology");
		pwa.setFundingOpp(fundingOpp);
		
		pwa.setFundingMechanism("RAPID");
		pwa.setSubmissionType(SubmissionType.FULL_PROPOSAL);
		
		UnitOfConsideration uoc = new UnitOfConsideration();
		uoc.setProgramElementCode("BIO");
		uoc.setProgramElementName("Biology");
		uoc.setOrgCode("NS");
		uoc.setOrgName("Natural Science");
		
		List<UnitOfConsideration> uocList = new ArrayList<UnitOfConsideration>();
		uocList.add(uoc);
		pwa.setUocList(uocList);
		
		PropTemplateResponse response = prs.getProposalTemplate(new WizardAnswersRequest(pwa));
		
		ProposalTemplate propTemplate = response.getPropTemplate();
		
		List<ProposalSection> secList = propTemplate.getSectionList();
		
		for(ProposalSection ps : secList){
			System.out.println(ps.toString());
			System.out.println();
		}
		
	}
	
}
