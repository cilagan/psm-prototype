package gov.nsf.research.psm.service.impl;

import gov.nsf.research.psm.model.BioSketches;
import gov.nsf.research.psm.model.CoverSheetDTO;
import gov.nsf.research.psm.model.Proposal;
import gov.nsf.research.psm.model.ProposalClassificationForm;
import gov.nsf.research.psm.model.ProposalDataForm;
import gov.nsf.research.psm.rules.factmodel.ProposalSection;
import gov.nsf.research.psm.rules.factmodel.ProposalTemplate;
import gov.nsf.research.psm.service.ProposalBuilder;

public class ProposalBuilderImpl implements ProposalBuilder{

	@Override
	public Proposal buildProposal(ProposalTemplate propTemplate) {
		
		Proposal proposal = new Proposal();
		
		for(ProposalSection propSection : propTemplate.getSectionList()){
			if(ProposalSection.COVER_SHEET.equals(propSection)){
				proposal.setCoverSheet(new CoverSheetDTO());
			} else if (ProposalSection.BIO_SKETCHES.equals(propSection)){
				proposal.getSectList().put(ProposalSection.BIO_SKETCHES, new BioSketches());
			} else if (ProposalSection.PROPOSAL_CLASSIFICATION.equals(propSection)){
				proposal.getSectList().put(ProposalSection.PROPOSAL_CLASSIFICATION, new ProposalClassificationForm());
			} else if (ProposalSection.PROPOSAL_DATA_FORM.equals(propSection)){
				proposal.getSectList().put(ProposalSection.PROPOSAL_DATA_FORM, new ProposalDataForm());
			}
		}
		
		return proposal;
	}

	
}
