package gov.nsf.research.document.service.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.research.document.service.model.proposal.DataMgtPlan;
import gov.nsf.research.document.service.model.proposal.ProjectDesc;
import gov.nsf.research.document.service.model.proposal.Proposal;

@RestController
public class DocumentServiceController {
	
	@RequestMapping(path="/proposal")
	public Proposal getProposal(){
		Proposal sampleProposal = getSampleProposal();
		return sampleProposal;
	}
	
	
	private Proposal getSampleProposal(){
		
		Proposal proposal = new Proposal();
		
		ProjectDesc pd = new ProjectDesc();
		pd.setLastUpdateDate(new Date());
		pd.setTempPropId("1234567");
		pd.setUploadDate(new Date());
		
		DataMgtPlan dmp = new DataMgtPlan();
		dmp.setLastUpdateDate(new Date());
		dmp.setTempPropId("1234567");
		dmp.setUploadDate(new Date());
		
		proposal.setProjDesc(pd);
		proposal.setDataMgtPlan(dmp);
		
		return proposal;
	}
}
