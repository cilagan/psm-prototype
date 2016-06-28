package gov.nsf.psm.solicitation.storedprocedure.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.common.utility.SolicitationDataUtils;

public class DivisionMapper  implements RowMapper<Division> {

    @Override
    public final Division mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Division division;

        if (rs.getString(Constants.DIV_ID) != null) {
            division = new Division();

            division.setDivisionCode(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_ID))); // divisionCode
            division.setDivisionName(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_NAME))); // divisionName
            division.setDivisionAbbrv(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_ABBRV))); // divisionAbbrv
            division.setDivisionLongName(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_LONG_NAME))); // divisionLongName

        } else {
            division = null;
        }

        return division;

    }

}
