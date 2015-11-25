package gov.nsf.research.document.service.controller;

import java.util.Date;

import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.research.document.service.model.proposal.DataMgtPlan;
import gov.nsf.research.document.service.model.proposal.ProjectDesc;
import gov.nsf.research.document.service.model.proposal.Proposal;

@RestController
@RequestMapping(path="/docService")
public class DocumentServiceController {
	
	GridFsTemplate gfsTemplate;
	GridFsOperations gfsOperations;
	
	@RequestMapping(path="/proposal" )
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
	
	@RequestMapping(path="/proposal/{tempPropId}/projdesc", method = RequestMethod.POST)
	public void uploadProjSumm(@PathVariable String tempPropId){
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/projdesc", method = RequestMethod.GET)
	public ProjectDesc getProjectDesc(@PathVariable String tempPropId){
		return new ProjectDesc();
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/dmp", method = RequestMethod.POST)
	public void uploadDMP(@PathVariable String tempPropId){
		
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/dmp", method = RequestMethod.GET)
	public DataMgtPlan getDMP(@PathVariable String tempPropId){
		return new DataMgtPlan();
	}
	
	@RequestMapping(path="/proposal/{tempPropId}", method = RequestMethod.GET)
	public Proposal getEntireProposal(@PathVariable String tempPropId){
		return new Proposal();
	}
}
