package gov.nsf.research.document.service.controller;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.resarch.document.service.util.EditorTextConversionUtil;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.model.EditorText;
import gov.nsf.research.document.service.model.proposal.ProjectSummary;

@CrossOrigin
@RestController
@RequestMapping(path="/Section")
public class SectionContentController {
	
	@Autowired
	ProposalDao propDao;
	
	@RequestMapping(path="/projsumm", method = RequestMethod.GET)
	public ProjectSummary getProjectSummary(){
		ProjectSummary ps = propDao.getProjectSummary("1008698");
		System.out.println(ps.toString());
		return ps;
	}
	
	@RequestMapping(path="/projsumm", method = RequestMethod.POST)
	public void saveProjectSummary(@RequestBody ProjectSummary projectSummary){
		
		System.out.println("Project Summary: " + projectSummary.toString());
		
		if(projectSummary != null){
//			propDao.saveProjectSummary("1059422", 
//					projectSummary.getOverView(), 
//					projectSummary.getIntulMerit(), 
//					projectSummary.getBrodrImpt());
		} else {
			System.out.println("Project summary is null.");
		}
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
	public ByteArrayOutputStream getProjectSummaryPdf(){
		ProjectSummary ps = propDao.getProjectSummary("1008698");
		
		Set<EditorText> overview = EditorTextConversionUtil.convertEditorString(ps.getOverView());
		Set<EditorText> broaderImpact = EditorTextConversionUtil.convertEditorString(ps.getBrodrImpt());
		Set<EditorText> intMerit = EditorTextConversionUtil.convertEditorString(ps.getIntulMerit());
		
		//send to PDF Service
		
		return null;
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

