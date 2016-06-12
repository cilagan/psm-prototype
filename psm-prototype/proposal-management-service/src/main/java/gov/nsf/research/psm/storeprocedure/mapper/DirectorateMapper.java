package gov.nsf.research.psm.storeprocedure.mapper;

import gov.nsf.research.psm.model.Directorate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DirectorateMapper implements RowMapper<Directorate> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public final Directorate mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		Directorate directorate;

		if (rs.getString("directorateID") != null) {
			directorate = new Directorate();

			directorate.setDirectorateID((rs.getString("directorateID")));// directorateID
			directorate.setDirectorateDesc((rs.getString("directorateTitle")));// directorateTitle

		} else {
			directorate = null;
		}

		return directorate;

	}

}
