package gov.nsf.psm.solicitation.common.utility;

public class SolicitationDataUtils {

    /**
     * no-args private constructor
     */
    private SolicitationDataUtils() {

    }
    
    /**
     * Method to check if the String is null. If not null, then trim it. Otherwise return null.
     * 
     * @param value
     */
    
    public static String getValue(String value) {
        return value != null ? value.trim() : null;
    }
    
}
