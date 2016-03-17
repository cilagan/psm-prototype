package gov.nsf.research.document.service.controller;

import gov.nsf.research.document.service.business.DocumentService;
import gov.nsf.research.document.service.model.PDFDocument;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.PDFService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping(path="/docService")
public class DocumentServiceController {
	
	@Autowired
	DocumentService docService;
	
	@Autowired
	PDFService pDFService;
	
		
	@RequestMapping(path="/proposal/{tempPropId}/projdesc", method = RequestMethod.POST)
	public void uploadProjDesc(@PathVariable String tempPropId, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{

		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = fileMap.get("uploadedFile");
		MultipartFile filepdf = fileMap.get("uploadedFile");
		PDFDocument pDFDocument = null;
		
		try {
			byte[] byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
			
			byte[] byteArrpdf = filepdf.getBytes();
			ByteArrayInputStream inputStreampdf = new ByteArrayInputStream(byteArrpdf);
			
			pDFDocument = pDFService.validatePDFDocument(inputStreampdf,tempPropId);

			if (pDFDocument.getPdfErrorMessage() == null) {
				docService.uploadPropSection(inputStream, tempPropId, SectionType.PROJECT_DESCRIPTION);
				response.sendRedirect("/upload");
			}
			System.out.println("Error Message: " + pDFDocument.getPdfErrorMessage());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/upload");
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/ment", method = RequestMethod.POST)
	public void uploadMent(@PathVariable String tempPropId, MultipartHttpServletRequest request, HttpServletResponse response, RedirectAttributes rd) throws Exception{

		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = fileMap.get("uploadedFile");
		
		MultipartFile filepdf = fileMap.get("uploadedFile");
		PDFDocument pDFDocument = null;
		
		
		try {
			byte[] byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
			
			byte[] byteArrpdf = filepdf.getBytes();
			ByteArrayInputStream inputStreampdf = new ByteArrayInputStream(byteArrpdf);
			
			pDFDocument = pDFService.validatePDFDocument(inputStreampdf,tempPropId);

			if (pDFDocument.getPdfErrorMessage() == null) {
				docService.uploadPropSection( inputStream, tempPropId, SectionType.MENTOR_PLAN);
				response.sendRedirect("/upload");
			}
			System.out.println("Error Message: " + pDFDocument.getPdfErrorMessage());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/upload");
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/bs", method = RequestMethod.POST)
	public void uploadBioSketches(@PathVariable String tempPropId, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{

		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = fileMap.get("uploadedFile");
		MultipartFile filepdf = fileMap.get("uploadedFile");
		PDFDocument pDFDocument = null;
		
		try {
			byte[] byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
			
			byte[] byteArrpdf = filepdf.getBytes();
			ByteArrayInputStream inputStreampdf = new ByteArrayInputStream(byteArrpdf);
			
			pDFDocument = pDFService.validatePDFDocument(inputStreampdf,tempPropId);

			if (pDFDocument.getPdfErrorMessage() == null) {
				docService.uploadPropSection(inputStream,tempPropId, SectionType.BIO_SKETCHES);
				response.sendRedirect("/upload");
			}
			System.out.println("Error Message: " + pDFDocument.getPdfErrorMessage());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/upload");
	}
	
	@RequestMapping(path="/proposal/{tempPropId}/caps", method = RequestMethod.POST)
	public void uploadCaps(@PathVariable String tempPropId, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{

		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = fileMap.get("uploadedFile");
		MultipartFile filepdf = fileMap.get("uploadedFile");
		PDFDocument pDFDocument = null;
		
		try {
			byte[] byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
			

			byte[] byteArrpdf = filepdf.getBytes();
			ByteArrayInputStream inputStreampdf = new ByteArrayInputStream(byteArrpdf);
			
			pDFDocument = pDFService.validatePDFDocument(inputStreampdf,tempPropId);

			if (pDFDocument.getPdfErrorMessage() == null) {
				docService.uploadPropSection(inputStream, tempPropId, SectionType.CURR_PEND_SUPPORT);
				response.sendRedirect("/upload");
			}
			System.out.println("Error Message: " + pDFDocument.getPdfErrorMessage());			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/upload");
	}
	
	
	@RequestMapping(path="/proposal/{tempPropId}/projdesc", method = RequestMethod.GET)
	public void getProjectDesc(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream = docService.getPropSection(tempPropId, SectionType.PROJECT_DESCRIPTION);
		
		//System.out.println(" ** controller get project "+outputStream.toByteArray().length);
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@RequestMapping(path="/proposal/{tempPropId}/ment", method = RequestMethod.GET)
	public void getMent(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream = docService.getPropSection(tempPropId, SectionType.MENTOR_PLAN);
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@RequestMapping(path="/proposal/{tempPropId}/bs", method = RequestMethod.GET)
	public void getBioSketches(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream = docService.getPropSection(tempPropId, SectionType.BIO_SKETCHES);
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@RequestMapping(path="/proposal/{tempPropId}/caps", method = RequestMethod.GET)
	public void getCaps(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream = docService.getPropSection(tempPropId, SectionType.CURR_PEND_SUPPORT);
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
	public void uploadDMP(Model model, @PathVariable String tempPropId,
			MultipartHttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = fileMap.get("uploadedFile");
		MultipartFile filepdf = fileMap.get("uploadedFile");

		PDFDocument pDFDocument = null;

		try {
			byte[] byteArr = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);

			byte[] byteArrpdf = filepdf.getBytes();
			ByteArrayInputStream inputStreampdf = new ByteArrayInputStream(
					byteArrpdf);

			pDFDocument = pDFService.validatePDFDocument(inputStreampdf,tempPropId);

			if (pDFDocument.getPdfErrorMessage() == null) {
				docService.uploadPropSection(inputStream, tempPropId,SectionType.DATA_MANAGEMENT_PLAN);
				response.sendRedirect("/upload");
			}
			System.out.println("Error Message: " + pDFDocument.getPdfErrorMessage());

		} catch (Exception e) {
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
		//System.out.println("delete proj desc");
		response.sendRedirect("/upload");
	}
	
	
	@RequestMapping(path="/delete/proposal/{tempPropId}/dmp", method = RequestMethod.GET)
	public void deleteDMP(@PathVariable String tempPropId, HttpServletResponse response) throws Exception {
		docService.deletePropSection(tempPropId, SectionType.DATA_MANAGEMENT_PLAN);
		//System.out.println("delete dmp");
		response.sendRedirect("/upload");
	}
	@RequestMapping(path="/delete/proposal/{tempPropId}/caps", method = RequestMethod.GET)
	public void deleteCaps(@PathVariable String tempPropId, HttpServletResponse response) throws Exception {
		docService.deletePropSection(tempPropId, SectionType.CURR_PEND_SUPPORT);
		//System.out.println("delete dmp");
		response.sendRedirect("/upload");
	}
	@RequestMapping(path="/delete/proposal/{tempPropId}/bs", method = RequestMethod.GET)
	public void deleteBioSketches(@PathVariable String tempPropId, HttpServletResponse response) throws Exception {
		docService.deletePropSection(tempPropId, SectionType.BIO_SKETCHES);
		//System.out.println("delete dmp");
		response.sendRedirect("/upload");
	}
	@RequestMapping(path="/delete/proposal/{tempPropId}/ment", method = RequestMethod.GET)
	public void deleteMentoring(@PathVariable String tempPropId, HttpServletResponse response) throws Exception {
		docService.deletePropSection(tempPropId, SectionType.MENTOR_PLAN);
		//System.out.println("delete dmp");
		response.sendRedirect("/upload");
	}
	
	
	@RequestMapping(path="/proposal/{tempPropId}/projsumm", method = RequestMethod.GET)
	public void getProjectSummary(@PathVariable String tempPropId, HttpServletResponse response){
		
		ByteArrayOutputStream outputStream  = docService.getProjectSummaryText(tempPropId);
		//System.out.println("DocumentServiceController.getProjectSummary()...."+tempPropId);
		
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
//			 response.flushBuffer();
			 response.getOutputStream().flush();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
