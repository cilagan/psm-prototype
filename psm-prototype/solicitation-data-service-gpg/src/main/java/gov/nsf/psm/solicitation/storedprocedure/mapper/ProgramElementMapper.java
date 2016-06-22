package gov.nsf.psm.solicitation.storedprocedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.common.utility.SolicitationDataUtils;

public class ProgramElementMapper implements RowMapper<ProgramElement> {

    @Override
    public final ProgramElement mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        ProgramElement programElement;

        if (rs.getString(Constants.PGM_ELE_ID) != null) {
            programElement = new ProgramElement();

            programElement.setProgramElementCode(SolicitationDataUtils.getValue(rs.getString(Constants.PGM_ELE_ID))); // pgmEleCode
            programElement.setProgramElementName(SolicitationDataUtils.getValue(rs.getString(Constants.PGM_ELE_NAME))); // pgmEleName
            programElement.setProgramElementLongName(SolicitationDataUtils.getValue(rs.getString(Constants.PGM_ELE_LONG_NAME))); //pgmEleLongName
            
        } else {
            programElement = null;
        }

        return programElement;

    }

}
