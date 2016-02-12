package gov.nsf.research.psm.controller;

import java.util.List;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;
import gov.nsf.research.psm.model.Proposal;
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
		return proposalManagementService.getAllDirectorates();
	}

	@RequestMapping(value = "/fundingops/{funding_op_id}/divisions", method = RequestMethod.GET)
	public List<Division> getDivisions(@PathVariable String funding_op_id) {
		return proposalManagementService.getDivisions(funding_op_id);
	}

	@RequestMapping(value = "/fundingops/{funding_op_id}/divisions/{divisions_id}", method = RequestMethod.GET)
	public List<ProgramElement> getProgramElements(
			@PathVariable String funding_op_id,
			@PathVariable String divisions_id) {
		return proposalManagementService.getProgramElements(funding_op_id,
				divisions_id);
	}
	
	@RequestMapping(value = "/new/proposal/{fundingOppId}", method = RequestMethod.GET)
	public Proposal createProposal(@PathVariable String fundingOppId){
		PropWizAnswers propWizAnswers = new PropWizAnswers();
		FundingOpportunity fundOpp = new FundingOpportunity();
		fundOpp.setFundingOpportunityId(fundingOppId);
		
		propWizAnswers.setFundingOpp(fundOpp);
		
		Proposal proposal = proposalManagementService.createProposal(propWizAnswers);
		
		return proposal;
	}

}
