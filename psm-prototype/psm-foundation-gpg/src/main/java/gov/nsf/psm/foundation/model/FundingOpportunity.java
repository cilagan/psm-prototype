package gov.nsf.psm.foundation.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Proposal Funding Opportunity
 * 
 * @author cilagan
 *
 */
public class FundingOpportunity extends AbstractTransferObject {

    private static final long serialVersionUID = 6285018781072433406L;

    private String fundingOpportunityId;
    private String fundingOpportunityTitle;
    
    public String getFundingOpportunityTitle() {
        return fundingOpportunityTitle;
    }
    
    public void setFundingOpportunityTitle(String fundingOpportunityTitle) {
        this.fundingOpportunityTitle = fundingOpportunityTitle;
    }

    public String getFundingOpportunityId() {
        return fundingOpportunityId;
    }

    public void setFundingOpportunityId(String fundingOpportunityId) {
        this.fundingOpportunityId = fundingOpportunityId;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
                .append("fundingOpportunityId", fundingOpportunityId)
                .append("fundingOpportunityTitle", fundingOpportunityTitle)
                .toString();
    }
}

