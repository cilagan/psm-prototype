package gov.nsf.research.psm.service.impl;

import gov.nsf.research.psm.model.BioSketches;
import gov.nsf.research.psm.model.CoverSheetDTO;
import gov.nsf.research.psm.model.CurrentPendingSupport;
import gov.nsf.research.psm.model.FacilitiesEquipmentResources;
import gov.nsf.research.psm.model.ProjectDescription;
import gov.nsf.research.psm.model.ProjectSummarySection;
import gov.nsf.research.psm.model.Proposal;
import gov.nsf.research.psm.model.ProposalClassificationForm;
import gov.nsf.research.psm.model.ProposalDataForm;
import gov.nsf.research.psm.model.ReferencesCited;
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
			} else if (ProposalSection.PROJECT_SUMMARY.equals(propSection)){
				proposal.getSectList().put(ProposalSection.PROJECT_SUMMARY, new ProjectSummarySection());
			} else if (ProposalSection.PROJECT_DESCRIPTION.equals(propSection)){
				proposal.getSectList().put(ProposalSection.PROJECT_DESCRIPTION, new ProjectDescription());
			} else if (ProposalSection.REFERENCES_CITED.equals(propSection)){
				proposal.getSectList().put(ProposalSection.REFERENCES_CITED, new ReferencesCited());
			} else if (ProposalSection.BIO_SKETCHES.equals(propSection)){
				proposal.getSectList().put(ProposalSection.BIO_SKETCHES, new BioSketches());
			} else if (ProposalSection.CURRENT_PENDING_SUPPORT.equals(propSection)){
				proposal.getSectList().put(ProposalSection.CURRENT_PENDING_SUPPORT, new CurrentPendingSupport());
			} else if (ProposalSection.FACILITIES_EQUIP_OTHER.equals(propSection)){
				proposal.getSectList().put(ProposalSection.FACILITIES_EQUIP_OTHER, new FacilitiesEquipmentResources());
			}  else if (ProposalSection.PROPOSAL_CLASSIFICATION.equals(propSection)){
				proposal.getSectList().put(ProposalSection.PROPOSAL_CLASSIFICATION, new ProposalClassificationForm());
			} else if (ProposalSection.PROPOSAL_DATA_FORM.equals(propSection)){
				proposal.getSectList().put(ProposalSection.PROPOSAL_DATA_FORM, new ProposalDataForm());
			}
		}
		
		return proposal;
	}

	
}
