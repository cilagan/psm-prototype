package gov.nsf.psm.solicitation.storedprocedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.common.utility.SolicitationDataUtils;

public class DirectorateMapper implements RowMapper<Directorate> {

    @Override
    public final Directorate mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Directorate directorate;

        if (rs.getString(Constants.DIR_ID) != null) {
            directorate = new Directorate();

            directorate.setDirectorateCode(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_ID))); // directorateCode
            directorate.setDirectorateName(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_NAME))); //directorateName
            directorate.setDirectorateAbbrv(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_ABBRV))); // directorateAbbrv
            directorate.setDirectorateLongName(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_LONG_NAME))); // directorateLongName
            
        } else {
            directorate = null;
        }

        return directorate;

    }

}
