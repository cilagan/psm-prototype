package gov.nsf.psm.solicitation.storedprocedure.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;




import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.solicitation.common.utility.Constants;

public class FundingOpportunityMapper implements RowMapper<FundingOpportunity>{
    
    @Override
    public final FundingOpportunity mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        FundingOpportunity fundingOpportunity;

        if (rs.getString(Constants.FUND_OP_ID) != null) {
            fundingOpportunity = new FundingOpportunity();

            fundingOpportunity.setFundingOpportunityId(rs.getString(Constants.FUND_OP_ID).trim()); // fundingOpId
            fundingOpportunity.setFundingOpportunityTitle(rs.getString(Constants.FUND_OP_TITLE).trim()); // fundingOpTitle

        } else {
            fundingOpportunity = null;
        }

        return fundingOpportunity;

    }

}

