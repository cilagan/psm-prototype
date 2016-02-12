package gov.nsf.research.psm;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import gov.nsf.research.psm.model.Directorate;
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
	
	private List<ProposalSection> standardProposalSectionList;
	
	@Before public void setUp(){
		standardProposalSectionList = new ArrayList<ProposalSection>();
		standardProposalSectionList.add(ProposalSection.COVER_SHEET);
		standardProposalSectionList.add(ProposalSection.PROJECT_SUMMARY);
		standardProposalSectionList.add(ProposalSection.PROJECT_DESCRIPTION);
		standardProposalSectionList.add(ProposalSection.REFERENCES_CITED);
		standardProposalSectionList.add(ProposalSection.BIO_SKETCHES);
		standardProposalSectionList.add(ProposalSection.BUDGET);
		standardProposalSectionList.add(ProposalSection.BUDGET_JUSTIFICATION);
		standardProposalSectionList.add(ProposalSection.CURRENT_PENDING_SUPPORT);
		standardProposalSectionList.add(ProposalSection.FACILITIES_EQUIP_OTHER);
		standardProposalSectionList.add(ProposalSection.DATA_MGT_PLAN);
		standardProposalSectionList.add(ProposalSection.MENTORING_PLAN);	
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getProposalTemplateBIO99Test(){
		PropWizAnswers pwa = new PropWizAnswers();
		
		FundingOpportunity fundingOpp = new FundingOpportunity();
		fundingOpp.setFundingOpportunityId("BIO99");
		fundingOpp.setFundingOpportunityType("Biology");
		fundingOpp.setDirectorateList(new ArrayList<Directorate>());
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
		
		assertTrue(secList.containsAll(standardProposalSectionList)
				&& secList.contains(ProposalSection.PROPOSAL_CLASSIFICATION));
	}
	
	@Test
	public void getProposalTemplateGPG99Test(){
		PropWizAnswers pwa = new PropWizAnswers();
		
		FundingOpportunity fundingOpp = new FundingOpportunity();
		fundingOpp.setFundingOpportunityId("GPG99");
		fundingOpp.setFundingOpportunityType("Biology");
		fundingOpp.setDirectorateList(new ArrayList<Directorate>());
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
		
		assertTrue(secList.containsAll(standardProposalSectionList));
		
	}
	
	@Test
	public void getProposalTemplateDUE99Test(){
		PropWizAnswers pwa = new PropWizAnswers();
		
		FundingOpportunity fundingOpp = new FundingOpportunity();
		fundingOpp.setFundingOpportunityId("DUE99");
		fundingOpp.setFundingOpportunityType("Biology");
		fundingOpp.setDirectorateList(new ArrayList<Directorate>());
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
		
		assertTrue(secList.containsAll(standardProposalSectionList)
				&& secList.contains(ProposalSection.PROPOSAL_DATA_FORM));
		
	}
	
	@Test
	public void getProposalTemplateUnknownFundingOpIdTest(){
		PropWizAnswers pwa = new PropWizAnswers();
		
		FundingOpportunity fundingOpp = new FundingOpportunity();
		fundingOpp.setFundingOpportunityId("TEST99");
		fundingOpp.setFundingOpportunityType("Biology");
		fundingOpp.setDirectorateList(new ArrayList<Directorate>());
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
		
		assertTrue(secList.containsAll(standardProposalSectionList));
		
	}
	

}
