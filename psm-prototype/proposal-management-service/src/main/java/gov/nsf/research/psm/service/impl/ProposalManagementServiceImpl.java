package gov.nsf.research.psm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;
import gov.nsf.research.psm.model.Proposal;
import gov.nsf.research.psm.model.wrapper.PropTemplateResponse;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.service.ProposalBuilder;
import gov.nsf.research.psm.service.ProposalManagementService;
import gov.nsf.research.psm.service.ProposalRulesClient;

public class ProposalManagementServiceImpl implements ProposalManagementService {
	
	@Autowired
	ProposalDao proposalDao;

	@Autowired
	ProposalRulesClient propRulesClient;
	
	@Autowired
	ProposalBuilder propBuilder;
	
	@Override
	public List<FundingOpportunity> getAllFundingOpportunities() {
		
		return proposalDao.getAllFundingOpportunities();
	}

	@Override
	public List<Division> getDivisions(String pgmAnncID) {
		return proposalDao.getDivisions(pgmAnncID);
	}

	@Override
	public List<Directorate> getAllDirectorates() {
		System.out
				.println("ProposalManagementServiceImpl.getAllDirectorates()");
		return proposalDao.getAllDirectorates();
	}

	@Override
	public List<ProgramElement> getProgramElements(String pgmAnncID,
			String divisionCode) {
		return proposalDao.getProgramElements(pgmAnncID, divisionCode);
	}

	@Override
	public Proposal createProposal(PropWizAnswers propWizAnswers) {
		PropTemplateResponse propTempResp = propRulesClient.getTemplate(propWizAnswers.getFundingOpp().getFundingOpportunityId());
		ProposalTemplate propTemplate = propTempResp.getPropTemplate();
		
		Proposal proposal = propBuilder.buildProposal(propTemplate);
		return proposal;
	}

}
