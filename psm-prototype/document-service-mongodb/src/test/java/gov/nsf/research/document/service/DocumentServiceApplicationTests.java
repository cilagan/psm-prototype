package gov.nsf.research.document.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import gov.nsf.research.document.service.model.proposal.ProjectDesc;
import gov.nsf.research.document.service.repository.ProjectDescRepository;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
//@WebAppConfiguration
public class DocumentServiceApplicationTests {

	@Autowired
	ProjectDescRepository projectDescRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testProjDesc(){
		
		ProjectDesc projDesc = new ProjectDesc();
		projDesc.setTempPropId("2345678");
		projDesc.setUploadDate(new Date());
		projDesc.setLastUpdateDate(new Date());
		
		projectDescRepository.insertProjDesc(projDesc);
	}
	
	
	public void testGetProjDesc(){
		String tempPropId = "2345678";
		ProjectDesc projDesc = projectDescRepository.getProjectDescByTempPropId(tempPropId);
		assertTrue(projDesc != null);
		
		System.out.println(projDesc.toString());
	}
	
	
	
	public void testSaveProjectDescDocument(){
		projectDescRepository.saveProjectDescDocument("test");
	}

	
	public void testGetProjDescDocument(){
		projectDescRepository.getProjDescDocument();
	}
}
