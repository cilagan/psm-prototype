package gov.nsf.psm.solicitation.common.utility;

public final class Constants {
    
    //  Stored Procedure Fields
    public static final String RESULT_SET = "RESULT_SET";
    
    //  Stored Procedure Mapper constants
    public static final String FUND_OP_ID = "fundingOpId";
    public static final String FUND_OP_TITLE = "fundingOpTitle";
    public static final String DIR_ID = "directorateCode";
    public static final String DIR_NAME = "directorateName";
    public static final String DIR_ABBRV = "directorateAbbrv";
    public static final String DIR_LONG_NAME = "directorateLongName";
    public static final String DIV_ID = "divisionCode";
    public static final String DIV_NAME = "divisionName";
    public static final String DIV_ABBRV = "divisionAbbrv";
    public static final String DIV_LONG_NAME = "divisionLongName";
    public static final String PGM_ELE_ID = "pgmEleCode";
    public static final String PGM_ELE_NAME = "pgmEleName";
    public static final String PGM_ELE_LONG_NAME = "pgmEleLongName";
    
    // Stored procedure input params
    public static final String IN_FUND_OP_ID = "fundingOpId";
    public static final String IN_DIR_ID = "dirCode";
    public static final String IN_DIV_ID = "divCode";
    
    
    //  Stored Procedure names
    public static final String STORED_PROC_GET_ALL_PROGRAM_ELEMENTS = "flp.pr_psm_get_all_pgm_ele";
    public static final String STORED_PROC_GET_ALL_FUNDING_OPPORTUNITIES = "flp.pr_psm_get_all_fund_oppr";
    public static final String STORED_PROC_GET_ALL_DIVISIONS = "flp.pr_psm_get_all_div";
    public static final String STORED_PROC_GET_ALL_DIRECTORATES = "flp.pr_psm_get_all_drct";
    public static final String STORED_PROC_GET_DIVISIONS_BY_FUND_OP_ID = "flp.pr_psm_get_divs_by_fund_op_id";
    public static final String STORED_PROC_GET_PROGRAM_ELEMENTS_BY_DIV_CODE = "flp.pr_psm_get_pgm_eles_by_div_id";
    public static final String STORED_PROC_GET_DIRECTORATES_BY_FUND_OP_ID = "flp.pr_psm_get_drcts_by_fund_op_id";
    public static final String STORED_PROC_GET_DIRECTORATE = "flp.pr_psm_get_dir_by_fund_op_id";
    
    private Constants() {
        super();
      }
}
