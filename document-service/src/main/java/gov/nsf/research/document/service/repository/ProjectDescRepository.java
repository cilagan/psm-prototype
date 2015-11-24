package gov.nsf.research.document.service.repository;

import gov.nsf.research.document.service.model.proposal.ProjectDesc;

public interface ProjectDescRepository{

	public void insertProjDesc(ProjectDesc projDesc);
	public ProjectDesc getProjectDescByTempPropId(String tempPropId);
	public void saveProjectDescDocument();
	public void getProjDescDocument();
}
