package gov.nsf.research.psm.controller;

import java.util.ArrayList;
import java.util.List;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;
import gov.nsf.research.psm.model.Proposal;
import gov.nsf.research.psm.model.UnitOfConsideration;
import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;
import gov.nsf.research.psm.service.ProposalManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/propmgt")
public class ProposalMangementController {

	@Autowired
	ProposalManagementService proposalManagementService;


	@RequestMapping(path = "/fundingops")
	public List<FundingOpportunity> getAllFundingOpportunities() {
		System.out
				.println("****"
						+ proposalManagementService
								.getAllFundingOpportunities().size());

		return proposalManagementService.getAllFundingOpportunities();
	}

	@RequestMapping(path = "/directorates")
	public List<Directorate> getAllDirectorates() {
		System.out.println("ProposalMangementController.getAllDirectorates()");
		return proposalManagementService.getAllDirectorates();
	}

	@RequestMapping(value = "/divisions")
	public List<Division> getAllDivisions() {
		System.out.println("ProposalMangementController.getAllDivisions()");
		return proposalManagementService.getAllDivisions();
	}

	@RequestMapping(value = "/programs")
	public List<ProgramElement> getAllProgramElements() {
		System.out
				.println("ProposalMangementController.getAllProgramElements()");
		return proposalManagementService.getAllProgramElements();
	}
	
	@RequestMapping(value = "/new/proposal/{fundOppId}/{divId}/{pgmEleCode}", method = RequestMethod.GET)
	public Proposal createProposal(@PathVariable String fundOppId, @PathVariable String divId, @PathVariable String pgmEleCode){
		FundingOpportunity fo = new FundingOpportunity();
		fo.setFundingOpportunityId(fundOppId);
		
		List<Division> divList = new ArrayList<Division>();
		Division division = new Division();
		division.setDivisionCode(divId);
		divList.add(division);
		fo.setDivisionList(divList);
		
		List<UnitOfConsideration> uocList = new ArrayList<UnitOfConsideration>();
		UnitOfConsideration uoc = new UnitOfConsideration();
		uoc.setProgramElementCode(pgmEleCode);
		uocList.add(uoc);
		
		PropWizAnswers pwa = new PropWizAnswers();
		pwa.setFundingOpp(fo);
		pwa.setUocList(uocList);
		
		Proposal proposal = proposalManagementService.createProposal(pwa);
		
		return proposal;
	}
}
