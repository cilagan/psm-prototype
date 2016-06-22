package gov.nsf.research.document.Storedprocedure.mapper;

import gov.nsf.research.document.service.model.proposal.ProjectSummary;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProjectSummaryDetailMapper implements RowMapper<ProjectSummary> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public final ProjectSummary mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		ProjectSummary projectSummary;

		projectSummary = new ProjectSummary();

		projectSummary.setOverView(rs.getString("overView"));
		projectSummary.setIntulMerit(rs.getString("intulMerit"));
		projectSummary.setBrodrImpt(rs.getString("brodrImpt"));
		
		

		return projectSummary;

	}

}
