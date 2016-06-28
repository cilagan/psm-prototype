package gov.nsf.psm.foundation.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Directorate
 * 
 * @author spendyal
 *
 */

public class Directorate extends AbstractTransferObject {

    private static final long serialVersionUID = -4187798178641366050L;
    
    private String directorateCode;
    private String directorateName;
    private String directorateAbbrv;
    private String directorateLongName;
    private Division[] divisions;
        
    public String getDirectorateCode() {
        return directorateCode;
    }

    public void setDirectorateCode(String directorateCode) {
        this.directorateCode = directorateCode;
    }

    public String getDirectorateName() {
        return directorateName;
    }

    public void setDirectorateName(String directorateName) {
        this.directorateName = directorateName;
    }

    public String getDirectorateAbbrv() {
        return directorateAbbrv;
    }

    public void setDirectorateAbbrv(String directorateAbbrv) {
        this.directorateAbbrv = directorateAbbrv;
    }

    public String getDirectorateLongName() {
        return directorateLongName;
    }

    public void setDirectorateLongName(String directorateLongName) {
        this.directorateLongName = directorateLongName;
    }

    public Division[] getDivisions() {
        return divisions;
    }

    public void setDivisions(Division[] divisions) {
        this.divisions = divisions;
    }

    public String toString() {
        return new ToStringBuilder(this)
                .append("directorateCode", directorateCode)
                .append("directorateName", directorateName)
                .append("directorateAbbrv", directorateAbbrv)
                .append("directorateLongName", directorateLongName)
                .toString();
    }
    
}
