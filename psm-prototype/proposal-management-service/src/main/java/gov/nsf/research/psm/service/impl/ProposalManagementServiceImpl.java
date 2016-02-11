package gov.nsf.research.psm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;
import gov.nsf.research.psm.service.ProposalManagementService;

public class ProposalManagementServiceImpl implements ProposalManagementService {
	
	@Autowired
	ProposalDao proposalDao;

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
		return proposalDao.getAllDirectorates();
	}

	@Override
	public List<ProgramElement> getProgramElements(String pgmAnncID,
			String divisionCode) {
		return proposalDao.getProgramElements(pgmAnncID, divisionCode);
	}

}
