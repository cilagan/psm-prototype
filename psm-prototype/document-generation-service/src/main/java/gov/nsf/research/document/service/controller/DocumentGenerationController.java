package gov.nsf.research.document.service.controller;


import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.PDFService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path="/docgeneration")
public class DocumentGenerationController {
	
		
	@Autowired
	PDFService pDFService;
	
	
	
	@RequestMapping(path="/sectionpdf/{tempPropId}/{sectionType}", method = RequestMethod.GET)
	public void createPDF(@PathVariable String tempPropId,@PathVariable SectionType sectionType, HttpServletResponse response){
		System.out.println("DocumentGenerationController.createPDF()");
		try {
		ByteArrayOutputStream outputStream = pDFService.createPDF(sectionType, tempPropId);	
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	
	
	
	
	@RequestMapping(path="/viewentirepdf/{tempPropId}", method = RequestMethod.GET)
	public void getEntireProposal(@PathVariable String tempPropId, HttpServletResponse response){
		System.out.println("DocumentGenerationController.getEntireProposal()");
		
		ByteArrayOutputStream outputStream = pDFService.CreateEntireProposalPDF(tempPropId);
		
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");     
//			 response.getOutputStream().close();
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
	}
	
	
	
	
	
	
	
}
