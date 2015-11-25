package gov.nsf.research.document.service.repository;

import java.io.ByteArrayOutputStream;

import gov.nsf.research.document.service.model.proposal.ProjectDesc;

public interface ProjectDescRepository{

	public void insertProjDesc(ProjectDesc projDesc);
	public ProjectDesc getProjectDescByTempPropId(String tempPropId);
	public void saveProjectDescDocument(String filename);
	public ByteArrayOutputStream getProjDescDocument();
	
}
