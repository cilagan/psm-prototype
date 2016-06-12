package gov.nsf.research.psm.service;

import gov.nsf.research.psm.model.Proposal;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;

public interface ProposalBuilder {

	public Proposal buildProposal(ProposalTemplate propTemplate);
	
}
