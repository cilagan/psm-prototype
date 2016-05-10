package gov.nsf.research.document.service.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.resarch.document.service.util.EditorTextConversionUtil;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.model.EditorText;
import gov.nsf.research.document.service.model.proposal.ProjectSummary;
import gov.nsf.research.document.service.pdf.PDFService;

@CrossOrigin
@RestController
@RequestMapping(path="/Section")
public class SectionContentController {
	
	@Autowired
	ProposalDao propDao;
	
	@Autowired
	PDFService pDFService;
	
	public static final String tempPropId = "1008698";
	
	@RequestMapping(path="/projsumm", method = RequestMethod.GET)
	public ProjectSummary getProjectSummary(){
		ProjectSummary ps = propDao.getProjectSummary(tempPropId);
		return ps;
	}
	
	@RequestMapping(path="/projsumm", method = RequestMethod.POST)
	public ProjectSummary saveProjectSummary(@RequestBody ProjectSummary projectSummary){
				
		ProjectSummary ps = new ProjectSummary();
		
		if(projectSummary != null){
			propDao.saveProjectSummary(tempPropId, 
					projectSummary.getOverView(), 
					projectSummary.getIntulMerit(), 
					projectSummary.getBrodrImpt());
			ps = propDao.getProjectSummary(tempPropId);
		}
		return ps;
	}
	
	private ProjectSummary createDummyProjectSummary(){
		ProjectSummary ps = new ProjectSummary();
		ps.setTempPropId("1234567");
		ps.setId("1234567");
		ps.setIntulMerit("This is intellectual merit");
		ps.setOverView("This is overview.");
		ps.setBrodrImpt("This is broader impacts");
		
		return ps;
	}
	
	@RequestMapping(path="/projsumm/pdf", method = RequestMethod.GET)
	public void getProjectSummaryPdf(HttpServletResponse response){
		ProjectSummary ps = propDao.getProjectSummary(tempPropId);
		
		Set<EditorText> overview = EditorTextConversionUtil.convertEditorString(ps.getOverView());
		Set<EditorText> broaderImpact = EditorTextConversionUtil.convertEditorString(ps.getBrodrImpt());
		Set<EditorText> intMerit = EditorTextConversionUtil.convertEditorString(ps.getIntulMerit());
		
		//send to PDF Service		
		ByteArrayOutputStream outputStream = pDFService.createProjectSummaryPDF(overview, broaderImpact, intMerit);
		try {
			 FileCopyUtils.copy(outputStream.toByteArray(), response.getOutputStream());
			 response.setContentType("application/pdf");      
			 response.flushBuffer();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ;
	}
}

/**
 * List of temppropid:
 * 	1008698
 *	1059422
 *	1100752
 *	6060138
 *	6170087 
 */

