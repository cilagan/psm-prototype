package gov.nsf.psm.foundation.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ProgramElement
 * 
 * @author spendyal
 *
 */

public class ProgramElement extends AbstractTransferObject {
    
    private static final long serialVersionUID = 4492089938791099912L;

    private String programElementCode;
    private String programElementName;
    private String programElementLongName;
        
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

    public String getProgramElementLongName() {
        return programElementLongName;
    }

    public void setProgramElementLongName(String programElementLongName) {
        this.programElementLongName = programElementLongName;
    }


    public String toString() {
        return new ToStringBuilder(this)
                .append("programElementCode", programElementCode)
                .append("programElementName", programElementName)
                .append("programElementLongName", programElementLongName)
                .toString();
    }

}

