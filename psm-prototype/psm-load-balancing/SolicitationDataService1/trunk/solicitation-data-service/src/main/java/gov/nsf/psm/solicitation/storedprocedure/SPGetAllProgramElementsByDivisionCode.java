package gov.nsf.psm.solicitation.storedprocedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.mapper.ProgramElementMapper;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllProgramElementsByDivisionCode extends StoredProcedure {

    public SPGetAllProgramElementsByDivisionCode() {
        super();
    }

    public SPGetAllProgramElementsByDivisionCode(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_PROGRAM_ELEMENTS_BY_DIV_CODE);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new ProgramElementMapper()));
    
        declareParameter(new SqlParameter(Constants.IN_DIV_ID,
                Types.VARCHAR));

        compile();
    }

    public final Map<String, Object> getProgramElementsByDivisionId(String divisionId) {
        Map<String, Object> inParams = new HashMap<String, Object>();
        inParams.put(Constants.IN_DIV_ID, divisionId);
        return super.execute(inParams);
    }


}
