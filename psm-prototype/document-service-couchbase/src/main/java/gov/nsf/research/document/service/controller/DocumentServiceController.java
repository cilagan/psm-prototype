package gov.nsf.research.document.service.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.model.proposal.DataMgtPlan;
import gov.nsf.research.document.service.model.proposal.ProjectDesc;
import gov.nsf.research.document.service.model.proposal.Proposal;
import gov.nsf.research.document.service.pdf.DocServiceUtility;

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
	public void uploadProjDesc(@PathVariable String tempPropId, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{

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
		response.sendRedirect("/upload");
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
	public void uploadDMP(@PathVariable String tempPropId, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
		
		response.sendRedirect("/upload");
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
	public void getEntireProposal(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream = docService.getEntirePropSection(tempPropId);
		
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping(path="/delete/proposal/{tempPropId}/projdesc", method = RequestMethod.GET)
	public void deleteProjDesc(@PathVariable String tempPropId, HttpServletResponse response) throws Exception {
		docService.deletePropSection(tempPropId, SectionType.PROJECT_DESCRIPTION);
		System.out.println("delete proj desc");
		response.sendRedirect("/upload");
	}
	
	
	@RequestMapping(path="/delete/proposal/{tempPropId}/dmp", method = RequestMethod.GET)
	public void deleteDMP(@PathVariable String tempPropId, HttpServletResponse response) throws Exception {
		docService.deletePropSection(tempPropId, SectionType.DATA_MANAGEMENT_PLAN);
		System.out.println("delete dmp");
		response.sendRedirect("/upload");
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/projdesc/metadata", method = RequestMethod.GET)
	public DocumentMetaData getProjDescMetaData(@PathVariable String tempPropId){
		DocumentMetaData dmd = getMockDMD();
		dmd.setId("1234567-PROJECT_DESCRIPTION");
		dmd.setFileName("1234567-PROJECT_DESCRIPTION.pdf");
		dmd.setSectionType(SectionType.PROJECT_DESCRIPTION);
		return dmd;
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/dmp/metadata", method = RequestMethod.GET)
	public DocumentMetaData getDMPMetaData(@PathVariable String tempPropId){
		return getMockDMD();	
	}
	
	private DocumentMetaData getMockDMD(){
		DocumentMetaData dmd = new DocumentMetaData();
		dmd.setContent("This is a test content");
		dmd.setId("1234567-DATA_MANAGEMENT_PLAN");
		dmd.setFileName("1234567-DATA_MANAGEMENT_PLAN.pdf");
		dmd.setSectionType(SectionType.DATA_MANAGEMENT_PLAN);
		dmd.setTempPropId("1234567");
		
		dmd.setPages(15);
		dmd.setSize(new Long(32165487));
		
		dmd.setUploadDate(new DateTime().toDate());
		
		return dmd;
	}
	
	private DocumentMetaData getSampleDMD(){
		try {
			return DocServiceUtility.assembleMetaData(new FileInputStream("C://Apps//mongo_result_1.pdf"), "1234567", SectionType.DATA_MANAGEMENT_PLAN);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
