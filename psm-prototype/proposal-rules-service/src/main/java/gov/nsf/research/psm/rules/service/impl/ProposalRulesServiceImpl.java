package gov.nsf.research.psm.rules.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		ProposalTemplate propTemplate = fireAllRules(pfc);
		PropTemplateResponse response = new PropTemplateResponse(propTemplate);
		return response;
	}
	
	
	private static ProposalTemplate fireAllRules(ProposalFactModel propFactModel){
		
		PropWizAnswers propWizAnswers = propFactModel.getPropWizAnswers();
		ProposalTemplate propTemplate = new ProposalTemplate();
		/**
		 * Rules:
		 * 1.  
		 * 2. if program announcement = NSF-12345 and DIV = BIO
		 * then sections should be 
		 * 
		 */
		
		//TODO: Add rule logic here
		propTemplate.setSectionList(addAllSections());
		return propTemplate;
	}
	
	private static List<ProposalSection> addAllSections() {
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
		formList.add(ProposalSection.PROPOSAL_CLASSIFICATION);
		
		return formList;
	}
}
