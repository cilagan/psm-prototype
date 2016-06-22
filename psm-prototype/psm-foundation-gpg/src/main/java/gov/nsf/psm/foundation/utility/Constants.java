package gov.nsf.psm.foundation.utility;

public final class Constants {

	public static final String SERVER_500_ERROR = "Server Error";
	public static final String SERVER_401_ERROR = "Not Authorized";
	public static final String SERVER_UNEXPECTED_ERROR = "The system encountered an unexpected error, please contact ITHC.";
	public static final String SERVER_RESOURCE_NOT_FOUND = "Resource Not Found";
	public static final String ACCESSMANAGEMENT_ERROR_MESSAGE = "AccessManagement Error Message";
	public static final String UNAVAILABLE = "Unavailable";

	// boolean String
	public static final String TRUE_STR = "true";
	public static final String FALSE_STR = "false";

	public static final String USER_ID = "user_id";
	public static final String ROLE_BASIC = "ROLE_BASIC";
	public static final String APPLICATION_NAME_MYNSF = "MyNSF";

	public static final String PERMISSIONMAPPER_PMSN = "pmsn";
	public static final String APPL_ID = "appl_id";
	public static final String GET_PERMISSIONS_FOR_A_ROLE = "select pmsn from cfsdb.dbo.appl_role_pmsn arm where arm.appl_id = ? and arm.serv_id = ? and arm.role_name = ?";
	public static final String SELECT_SERVICE_ID = "select appl_id from msddb.dbo.msd_serv_lkup_vw where appl_name = ?";
	public static final String SELECT_APPLICATION_ID = "select appl_id from msddb.dbo.msd_appl_lkup_vw where appl_name = ?";

	public static final String GET_PERMISSIONS_ERROR_MESSAGE = "ERROR get_permissions_for_a_role :";
	public static final String SELECT_SERVICE_ERROR_MESSAGE = "ERROR select_service_id :";
	public static final String SELECT_APPLICATION_ERROR_MESSAGE = "ERROR select_application_id :";

	private Constants() {
		super();
	}
}
