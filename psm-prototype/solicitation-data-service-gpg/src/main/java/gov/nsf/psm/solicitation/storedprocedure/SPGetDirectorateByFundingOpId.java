package gov.nsf.psm.solicitation.storedprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.extractor.GetDirectorateByFundingOpIdResultSetExtractor;

public class SPGetDirectorateByFundingOpId extends StoredProcedure {

    public SPGetDirectorateByFundingOpId() {
        super();
    }

    public SPGetDirectorateByFundingOpId(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_DIRECTORATE);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new GetDirectorateByFundingOpIdResultSetExtractor()));
        declareParameter(new SqlParameter(Constants.IN_FUND_OP_ID,
                Types.VARCHAR));
        declareParameter(new SqlParameter(Constants.IN_DIR_ID,
                Types.VARCHAR));

        compile();
    }

    public Map<String, Object> getDirectorateByFundingOpId(String fundingOpId, String directorateId) {
        Map<String, Object> inParams = new HashMap<String, Object>();
        inParams.put(Constants.IN_FUND_OP_ID, fundingOpId);
        inParams.put(Constants.IN_DIR_ID, directorateId);
        return super.execute(inParams);
    }
}
