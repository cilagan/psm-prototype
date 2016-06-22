package gov.nsf.psm.solicitation.storedprocedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.mapper.DivisionMapper;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetAllDivisionsByFundingOpId extends StoredProcedure {

    public SPGetAllDivisionsByFundingOpId() {
        super();
    }

    public SPGetAllDivisionsByFundingOpId(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_DIVISIONS_BY_FUND_OP_ID);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new DivisionMapper()));
        declareParameter(new SqlParameter(Constants.IN_FUND_OP_ID,
                Types.VARCHAR));
        declareParameter(new SqlParameter(Constants.IN_DIR_ID,
                Types.VARCHAR));

        compile();
    }
    
    public Map<String, Object> getDivisionsByFundingOpId(String fundingOpId, String directorateId) {
        Map<String, Object> inParams = new HashMap<String, Object>();
        inParams.put(Constants.IN_FUND_OP_ID, fundingOpId);
        inParams.put(Constants.IN_DIR_ID, directorateId);
        return super.execute(inParams);
    }

}
