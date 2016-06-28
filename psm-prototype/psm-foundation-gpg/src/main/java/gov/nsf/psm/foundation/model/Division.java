package gov.nsf.psm.foundation.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Division
 * 
 * @author spendyal
 *
 */

public class Division extends AbstractTransferObject {

    private static final long serialVersionUID = 1530979725469556846L;

    private String divisionCode;
    private String divisionName;
    private String divisionAbbrv;
    private String divisionLongName;
    private ProgramElement[] programElements;
        
    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getDivisionAbbrv() {
        return divisionAbbrv;
    }

    public void setDivisionAbbrv(String divisionAbbrv) {
        this.divisionAbbrv = divisionAbbrv;
    }

    public String getDivisionLongName() {
        return divisionLongName;
    }

    public void setDivisionLongName(String divisionLongName) {
        this.divisionLongName = divisionLongName;
    }

    public ProgramElement[] getProgramElements() {
        return programElements;
    }

    public void setProgramElements(ProgramElement[] programElements) {
        this.programElements = programElements;
    }

    public String toString() {
        return new ToStringBuilder(this)
                .append("divisionCode", divisionCode)
                .append("divisionName", divisionName)
                .append("divisionAbbrv", divisionAbbrv)
                .append("divisionLongName", divisionLongName)
                .append("programElements", programElements)
                .toString();
    }

}
