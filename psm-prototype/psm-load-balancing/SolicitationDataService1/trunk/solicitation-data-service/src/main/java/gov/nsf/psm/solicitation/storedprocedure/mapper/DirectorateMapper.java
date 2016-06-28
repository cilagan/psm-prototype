package gov.nsf.psm.solicitation.storedprocedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.solicitation.common.utility.Constants;

public class DirectorateMapper implements RowMapper<Directorate> {

    @Override
    public final Directorate mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Directorate directorate;

        if (rs.getString(Constants.DIR_ID) != null) {
            directorate = new Directorate();

            directorate.setDirectorateCode(rs.getString(Constants.DIR_ID).trim()); // directorateCode
            directorate.setDirectorateName(rs.getString(Constants.DIR_NAME).trim()); //directorateName
            directorate.setDirectorateAbbrv(rs.getString(Constants.DIR_ABBRV).trim()); // directorateAbbrv
            directorate.setDirectorateLongName(rs.getString(Constants.DIR_LONG_NAME).trim()); // directorateLongName
            
        } else {
            directorate = null;
        }

        return directorate;

    }

}
