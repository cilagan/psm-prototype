package gov.nsf.psm.foundation.model;

public class UnitOfConsideration extends AbstractTransferObject {
    
    private static final long serialVersionUID = -1591715666837384024L;
    
    private String fundingOpportunityId;
    private String orgCode;
    private String orgName;
    private String programElementCode;
    private String programElementName;
    
    public String getFundingOpportunityCode() {
        return fundingOpportunityId;
    }
    public void setFundingOpportunityCode(String fundingOpportunityCode) {
        this.fundingOpportunityId = fundingOpportunityCode;
    }
    

    public String getOrgCode() {
        return orgCode;
    }
    
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    
    public String getOrgName() {
        return orgName;
    }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    public String getProgramElementCode() {
        return programElementCode;
    }
    
    public void setProgramElementCode(String programElementCode) {
        this.programElementCode = programElementCode;
    }
    
    public String getProgramElementName() {
        return programElementName;
    }
    
    public void setProgramElementName(String programElementName) {
        this.programElementName = programElementName;
    }
    
    @Override
    public String toString() {
        return "UnitOfConsideration [orgCode=" + orgCode + ", orgName="
                + orgName + ", programElementCode=" + programElementCode
                + ", programElementName=" + programElementName + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
        result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
        result = prime
                * result
                + ((programElementCode == null) ? 0 : programElementCode
                        .hashCode());
        result = prime
                * result
                + ((programElementName == null) ? 0 : programElementName
                        .hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnitOfConsideration other = (UnitOfConsideration) obj;
        if (orgCode == null) {
            if (other.orgCode != null)
                return false;
        } else if (!orgCode.equals(other.orgCode))
            return false;
        if (orgName == null) {
            if (other.orgName != null)
                return false;
        } else if (!orgName.equals(other.orgName))
            return false;
        if (programElementCode == null) {
            if (other.programElementCode != null)
                return false;
        } else if (!programElementCode.equals(other.programElementCode))
            return false;
        if (programElementName == null) {
            if (other.programElementName != null)
                return false;
        } else if (!programElementName.equals(other.programElementName))
            return false;
        return true;
    }
    
}

