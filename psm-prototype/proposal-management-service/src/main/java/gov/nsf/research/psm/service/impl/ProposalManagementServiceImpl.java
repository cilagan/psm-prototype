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
		System.out
				.println("ProposalManagementServiceImpl.getAllFundingOpportunities()");
		
		return proposalDao.getAllFundingOpportunities();
	}

	@Override
	public List<Division> getAllDivisions() {
		System.out.println("ProposalManagementServiceImpl.getAllDivisions()");
		return proposalDao.getAllDivisions();
	}

	@Override
	public List<Directorate> getAllDirectorates() {
		System.out
				.println("ProposalManagementServiceImpl.getAllDirectorates()");
		return proposalDao.getAllDirectorates();
	}

	@Override
	public List<ProgramElement> getAllProgramElements() {
		System.out
				.println("ProposalManagementServiceImpl.getAllProgramElements()");
		return proposalDao.getAllProgramElements();
	}

	@Override
	public Proposal createProposal(PropWizAnswers propWizAnswers) {
		PropTemplateResponse propTempResp = propRulesClient.getTemplate(propWizAnswers.getFundingOpp().getFundingOpportunityId());
		ProposalTemplate propTemplate = propTempResp.getPropTemplate();
		
		Proposal proposal = propBuilder.buildProposal(propTemplate);
		return proposal;
	}

}
