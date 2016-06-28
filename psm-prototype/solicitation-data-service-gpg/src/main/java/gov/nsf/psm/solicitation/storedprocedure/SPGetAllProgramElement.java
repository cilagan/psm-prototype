package gov.nsf.psm.solicitation.storedprocedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.mapper.ProgramElementMapper;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllProgramElement extends StoredProcedure {

    public SPGetAllProgramElement() {
        super();
    }

    public SPGetAllProgramElement(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_ALL_PROGRAM_ELEMENTS);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new ProgramElementMapper()));
        
        compile();
    }

    public Map<String, Object> getProgramElements() {
        return super.execute();
    }
    
}
