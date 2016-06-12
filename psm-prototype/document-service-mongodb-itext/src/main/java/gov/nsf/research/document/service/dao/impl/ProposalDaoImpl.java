package gov.nsf.research.document.service.dao.impl;

import gov.nsf.research.document.Storedprocedure.SPGetProjectSummary;
import gov.nsf.research.document.Storedprocedure.SPSaveProjectSummary;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.model.proposal.ProjectSummary;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProposalDaoImpl implements ProposalDao {

	@Autowired
	private JdbcTemplate psmFLJdbcTemplate;
	
	@Override
	public ProjectSummary getProjectSummary(String tempPropID) {
		
		ProjectSummary projectSummary;

		SPGetProjectSummary sPGetProjectSummary = new SPGetProjectSummary(
				psmFLJdbcTemplate.getDataSource(),
				SPGetProjectSummary.STORED_PROC_GET_PROJ_SUMM_DETAILS);

		Map<String, Object> result = sPGetProjectSummary.execute(tempPropID);

		@SuppressWarnings("unchecked")
		List<ProjectSummary> projectSummaryList = (List<ProjectSummary>) result
				.get(sPGetProjectSummary.RESULT_SET);

		// expecting only one result
		if (projectSummaryList.size() > 0) {
			projectSummary = projectSummaryList.get(0);
			projectSummary.setTempPropId(tempPropID);

		} else {
			projectSummary = null;
		}

		return projectSummary;
	}
	
	@Override
	public String getStampPDFTimeStamp(String tempPropID) {
		String sql = "select convert(char(40),LAST_UPDT_TMSP,  100) from flp.proj_summ where TEMP_PROP_ID = ?";
		
		String timeStamp = psmFLJdbcTemplate.queryForObject(
				sql, new Object[] { tempPropID }, String.class);
					
		return timeStamp;
	}

	@Override
	public void saveProjectSummary(String tempPropID, String overView, String intulMerit,
			String brodrImpt) {
		SPSaveProjectSummary sPSaveProjectSummary = new SPSaveProjectSummary(
				psmFLJdbcTemplate.getDataSource(),
				SPSaveProjectSummary.STORED_PROC_SAVE_PROJ_SUMM);
		 sPSaveProjectSummary.execute(tempPropID,overView,brodrImpt,intulMerit);
	}
}
