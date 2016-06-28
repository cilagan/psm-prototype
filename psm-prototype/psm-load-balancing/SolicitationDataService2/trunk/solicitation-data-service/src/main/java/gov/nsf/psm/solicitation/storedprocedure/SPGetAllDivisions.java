package gov.nsf.psm.solicitation.storedprocedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.mapper.DivisionMapper;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllDivisions extends StoredProcedure {

    public SPGetAllDivisions() {
        super();
    }

    public SPGetAllDivisions(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_ALL_DIVISIONS);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new DivisionMapper()));
        
        compile();
    }

    public Map<String, Object> getDivisions() {
        return super.execute();
    }

}
