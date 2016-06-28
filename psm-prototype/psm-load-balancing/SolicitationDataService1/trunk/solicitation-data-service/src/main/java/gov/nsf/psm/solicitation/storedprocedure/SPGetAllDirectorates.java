package gov.nsf.psm.solicitation.storedprocedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.mapper.DirectorateMapper;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllDirectorates extends StoredProcedure {

    public SPGetAllDirectorates() {
        super();
    }

    public SPGetAllDirectorates(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_ALL_DIRECTORATES);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new DirectorateMapper()));

        compile();
    }

    public Map<String, Object> getDirectorates() {
        return super.execute();
    }

}
