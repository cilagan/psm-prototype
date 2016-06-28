package gov.nsf.psm.solicitation.storedprocedure.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.solicitation.common.utility.Constants;

public class DivisionMapper  implements RowMapper<Division> {

    @Override
    public final Division mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Division division;

        if (rs.getString(Constants.DIV_ID) != null) {
            division = new Division();

            division.setDivisionCode(rs.getString(Constants.DIV_ID).trim()); // divisionCode
            division.setDivisionName(rs.getString(Constants.DIV_NAME).trim()); // divisionName
            division.setDivisionAbbrv(rs.getString(Constants.DIV_ABBRV).trim()); // divisionAbbrv
            division.setDivisionLongName(rs.getString(Constants.DIV_LONG_NAME).trim()); // divisionLongName

        } else {
            division = null;
        }

        return division;

    }

}
