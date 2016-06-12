package gov.nsf.research.psm.rules.service.impl;

import java.util.ArrayList;
import java.util.List;

import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.ServiceNotification;
import gov.nsf.research.psm.model.UnitOfConsideration;
import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.rules.factmodel.ProposalFactModel;
import gov.nsf.research.psm.rules.factmodel.ProposalSection;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.rules.service.ProposalRulesService;

public class ProposalRulesServiceImpl implements ProposalRulesService {

	private static String BIO_DIV_CODE = "08";
	
	@Override
	public PropTemplateResponse getProposalTemplate(WizardAnswersRequest request) {
		
		/**
		 * Psuedocode:
		 * 
		 * 1. getKIE
		 * 2. create session
		 * 3. add factmodel to the sessions
		 * 4. Fire rules
		 * 5. extract proposal template
		 * 6. return proposal template
		 * 
		 */
		
		ProposalFactModel pfc = new ProposalFactModel(request.getPropWizAnswers(), new ProposalTemplate());
		System.out.println("Proposal Fact Moddel: " + pfc.toString());
		List<ServiceNotification> snList = new ArrayList<ServiceNotification>();
		
		ProposalTemplate propTemplate = fireAllRules(pfc, snList);
		
		PropTemplateResponse response = new PropTemplateResponse(propTemplate);
		response.setSnList(snList);
		
		return response;
	}
	
	
	private static ProposalTemplate fireAllRules(ProposalFactModel propFactModel, List<ServiceNotification> snList){
		
		PropWizAnswers propWizAnswers = propFactModel.getPropWizAnswers();
		List<Division> divList = propWizAnswers.getFundingOpp().getDivisionList();
		String fundOppId = propWizAnswers.getFundingOpp().getFundingOpportunityId();
		List<UnitOfConsideration> uocList = propWizAnswers.getUocList();
		
		ProposalTemplate propTemplate = new ProposalTemplate();
		System.out.println(propWizAnswers);
		
		/**
		 * Rules:
		 * 1. GPG99 - add standard = pgm_ele =>
		 * 2. BIO99 - add standard + proposal classification => div_id = 08
		 * 3. DUE99 - add standard + proposal data form = prog_ele => 1746;7429;7428;7427;1536;7412;7444;7348;1668;7426;7431;1796;1795;7494;7493;7492;7695;7511;7512;7513;7514;1133;19
		 * 4. 
		 * 5. 
		 */
		
		// mock rules
		if("BIO99".equals(fundOppId) && isDivBio(divList)){
			propTemplate.setSectionList(addStandardSections());
			propTemplate.getSectionList().add(ProposalSection.PROPOSAL_CLASSIFICATION);
		} else if("DUE99".equals(fundOppId) && isDUE(uocList)){
			propTemplate.setSectionList(addStandardSections());
			propTemplate.getSectionList().add(ProposalSection.PROPOSAL_DATA_FORM);
		} else {
			//GPG
			propTemplate.setSectionList(addStandardSections());
		}
		
		return propTemplate;
	}
	
	private static List<ProposalSection> addStandardSections() {
		List<ProposalSection> formList = new ArrayList<ProposalSection>();
		
		formList.add(ProposalSection.COVER_SHEET);
		formList.add(ProposalSection.PROJECT_SUMMARY);
		formList.add(ProposalSection.PROJECT_DESCRIPTION);
		formList.add(ProposalSection.REFERENCES_CITED);
		formList.add(ProposalSection.BIO_SKETCHES);
		formList.add(ProposalSection.BUDGET);
		formList.add(ProposalSection.BUDGET_JUSTIFICATION);
		formList.add(ProposalSection.CURRENT_PENDING_SUPPORT);
		formList.add(ProposalSection.FACILITIES_EQUIP_OTHER);
		formList.add(ProposalSection.DATA_MGT_PLAN);
		formList.add(ProposalSection.MENTORING_PLAN);		
		return formList;
	}
	
	private static boolean isDivBio(List<Division> divList){
		
		for(Division div : divList){
			String s = div.getDivisionCode();
			String upToNCharacters = s.substring(0, Math.min(s.length(), 2));
			
			if(BIO_DIV_CODE.equals(upToNCharacters)){
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean isDUE(List<UnitOfConsideration> uocList){
		
		for(UnitOfConsideration uoc : uocList){
			if("1746".equals(uoc.getProgramElementCode())
					|| "7429".equals(uoc.getProgramElementCode())
					|| "7428".equals(uoc.getProgramElementCode())
					|| "7427".equals(uoc.getProgramElementCode())
					|| "1536".equals(uoc.getProgramElementCode())){
				return true;
			}
		}
		
		return false;
	}
}
