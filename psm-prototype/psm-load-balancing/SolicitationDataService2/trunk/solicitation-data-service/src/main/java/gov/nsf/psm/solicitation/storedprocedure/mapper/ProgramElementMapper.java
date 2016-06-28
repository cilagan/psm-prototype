package gov.nsf.psm.solicitation.storedprocedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.common.utility.Constants;

public class ProgramElementMapper implements RowMapper<ProgramElement> {

    @Override
    public final ProgramElement mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        ProgramElement programElement;

        if (rs.getString(Constants.PGM_ELE_ID) != null) {
            programElement = new ProgramElement();

            programElement.setProgramElementCode(rs.getString(Constants.PGM_ELE_ID).trim()); // pgmEleCode
            programElement.setProgramElementName(rs.getString(Constants.PGM_ELE_NAME).trim()); // pgmEleName
            programElement.setProgramElementLongName(rs.getString(Constants.PGM_ELE_LONG_NAME).trim()); //pgmEleLongName
            
        } else {
            programElement = null;
        }

        return programElement;

    }

}
