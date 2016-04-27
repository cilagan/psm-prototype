package gov.nsf.research.document.service.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.research.document.service.model.proposal.ProjectSummary;

@CrossOrigin
@RestController
@RequestMapping(path="/Section")
public class SectionContentController {
	
	@RequestMapping(path="/projsumm", method = RequestMethod.GET)
	public ProjectSummary getProjectSummary(){
		ProjectSummary ps = createDummyProjectSummary();
		System.out.println(ps.toString());
		return ps;
	}
	
	@RequestMapping(path="/projsumm", method = RequestMethod.POST)
	public void saveProjectSummary(ProjectSummary projectSummary){
		System.out.println(projectSummary.toString());
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
}
