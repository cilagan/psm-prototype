package gov.nsf.psm.solicitation.storedprocedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.mapper.DirectorateMapper;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllDirectoratesByFundingOpId extends StoredProcedure {

    public SPGetAllDirectoratesByFundingOpId() {
        super();
    }

    public SPGetAllDirectoratesByFundingOpId(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_DIRECTORATES_BY_FUND_OP_ID);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new DirectorateMapper()));
        declareParameter(new SqlParameter(Constants.IN_FUND_OP_ID,
                Types.VARCHAR));

        compile();
    }

    public Map<String, Object> getDirectoratesByFundingOpId(String fundingOpId) {
        Map<String, Object> inParams = new HashMap<String, Object>();
        inParams.put(Constants.IN_FUND_OP_ID, fundingOpId);
        return super.execute(inParams);
    }

}
