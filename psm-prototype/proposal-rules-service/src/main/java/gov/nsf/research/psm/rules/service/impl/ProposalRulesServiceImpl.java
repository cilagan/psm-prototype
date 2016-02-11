package gov.nsf.research.psm.rules.service.impl;

import java.util.ArrayList;
import java.util.List;

import gov.nsf.research.psm.model.ServiceNotification;
import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.model.wrapper.WizardAnswersRequest;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.rules.factmodel.ProposalFactModel;
import gov.nsf.research.psm.rules.factmodel.ProposalSection;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.rules.service.ProposalRulesService;

public class ProposalRulesServiceImpl implements ProposalRulesService {

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
		List<ServiceNotification> snList = new ArrayList<ServiceNotification>();
		
		ProposalTemplate propTemplate = fireAllRules(pfc, snList);
		
		PropTemplateResponse response = new PropTemplateResponse(propTemplate);
		response.setSnList(snList);
		
		return response;
	}
	
	
	private static ProposalTemplate fireAllRules(ProposalFactModel propFactModel, List<ServiceNotification> snList){
		
		PropWizAnswers propWizAnswers = propFactModel.getPropWizAnswers();
		ProposalTemplate propTemplate = new ProposalTemplate();
		System.out.println(propWizAnswers);
		/**
		 * Rules:
		 * 1. GPG99 - add standard
		 * 2. BIO99 - add standard + proposal classification
		 * 3. DUE99 - add standard + proposal data form
		 * 4. 
		 * 5. 
		 */
		
		// mock rules
		if("GPG99".equals(propWizAnswers.getFundingOpp().getFundingOpportunityId())){
			propTemplate.setSectionList(addStandardSections());
		} else if("BIO99".equals(propWizAnswers.getFundingOpp().getFundingOpportunityId())){
			propTemplate.setSectionList(addStandardSections());
			propTemplate.getSectionList().add(ProposalSection.PROPOSAL_CLASSIFICATION);
		} else if("DUE99".equals(propWizAnswers.getFundingOpp().getFundingOpportunityId())){
			propTemplate.setSectionList(addStandardSections());
			propTemplate.getSectionList().add(ProposalSection.PROPOSAL_DATA_FORM);
		} else {
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
}
