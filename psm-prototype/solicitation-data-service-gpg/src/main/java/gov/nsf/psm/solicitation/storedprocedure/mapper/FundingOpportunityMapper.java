package gov.nsf.psm.solicitation.storedprocedure.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;




import org.springframework.jdbc.core.RowMapper;

import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.common.utility.SolicitationDataUtils;

public class FundingOpportunityMapper implements RowMapper<FundingOpportunity>{
    
    @Override
    public final FundingOpportunity mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        FundingOpportunity fundingOpportunity;

        if (rs.getString(Constants.FUND_OP_ID) != null) {
            fundingOpportunity = new FundingOpportunity();

            fundingOpportunity.setFundingOpportunityId(SolicitationDataUtils.getValue(rs.getString(Constants.FUND_OP_ID))); // fundingOpId
            fundingOpportunity.setFundingOpportunityTitle(SolicitationDataUtils.getValue(rs.getString(Constants.FUND_OP_TITLE))); // fundingOpTitle

        } else {
            fundingOpportunity = null;
        }

        return fundingOpportunity;

    }

}

