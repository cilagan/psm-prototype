package gov.nsf.research.document.service.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.model.proposal.DataMgtPlan;
import gov.nsf.research.document.service.model.proposal.ProjectDesc;
import gov.nsf.research.document.service.model.proposal.Proposal;

@RestController
@RequestMapping(path="/docService")
public class DocumentServiceController {
	
	@Autowired
	DocumentService docService;
	
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
	public String uploadProjDesc(@PathVariable String tempPropId, MultipartHttpServletRequest request){

		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = fileMap.get("uploadedFile");
		
		try {
			byte[] byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
			System.out.println("inputStream: " + inputStream != null);
			//send to service layer
			docService.uploadPropSection(inputStream, tempPropId, SectionType.PROJECT_DESCRIPTION);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/projdesc", method = RequestMethod.GET)
	public void getProjectDesc(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream = docService.getPropSection(tempPropId, SectionType.PROJECT_DESCRIPTION);
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/dmp", method = RequestMethod.POST)
	public String uploadDMP(@PathVariable String tempPropId, MultipartHttpServletRequest request){
		
		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = fileMap.get("uploadedFile");
		
		try {
			byte[] byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
			System.out.println("inputStream: " + inputStream != null);
			//send to service layer
			docService.uploadPropSection(inputStream, tempPropId, SectionType.DATA_MANAGEMENT_PLAN);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
		
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/dmp", method = RequestMethod.GET)
	public void getDMP(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream = docService.getPropSection(tempPropId, SectionType.DATA_MANAGEMENT_PLAN);
		
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping(path="/proposal/{tempPropId}", method = RequestMethod.GET)
	public Proposal getEntireProposal(@PathVariable String tempPropId){
		return new Proposal();
	}
}
