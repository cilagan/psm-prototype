package gov.nsf.psm.solicitation.storedprocedure;

import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.mapper.FundingOpportunityMapper;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import java.util.Map;

import javax.sql.DataSource;

public class SPGetAllFundingOpportunities extends StoredProcedure {
    
    public SPGetAllFundingOpportunities() {
        super();
    }
    
    public SPGetAllFundingOpportunities(DataSource dataSource) {
        super(dataSource, Constants.STORED_PROC_GET_ALL_FUNDING_OPPORTUNITIES);

        declareParameter(new SqlReturnResultSet(Constants.RESULT_SET,
                new FundingOpportunityMapper()));

        compile();
    }
    
    public Map<String, Object> getFundingOpportunities() {
        return super.execute();
    }

}
