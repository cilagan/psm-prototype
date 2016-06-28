package gov.nsf.psm.foundation.exception;

import org.apache.log4j.Logger;

/***
 * 
 * @author yogeshbansal
 *
 */

public class CommonUtilException extends Exception {

	private static final Logger LOGGER = Logger.getLogger(CommonUtilException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String className = null;
	int errCode = 0;
	String errMsg = null;

	/**
	 * Default constructor that inherits the parent qualities
	 *
	 */
	public CommonUtilException() {
		super();
	}

	/**
	 * Constructor with a param error msg that inherits the parent qualities
	 * 
	 * @param Exception
	 *
	 */
	public CommonUtilException(Exception _errMsg) {
		super(_errMsg);
		LOGGER.error(_errMsg);
	}

	public CommonUtilException(Exception _errMsg, String msg) {
		super(_errMsg);
		this.errMsg = msg; // Changed to use errMsg instead of
							// customErrorMessage
		LOGGER.error(msg, _errMsg);

	}

	/**
	 * Constructor with a param error msg that inherits the parent qualities
	 * 
	 * @param String
	 *            error message
	 *
	 */
	public CommonUtilException(String _errMsg) {
		this.errMsg = _errMsg;
		LOGGER.error(_errMsg);
	}

	/**
	 * Constructor with a param error msg that inherits the parent qualities
	 * 
	 * @param Exception,
	 *            String classname
	 *
	 */
	public CommonUtilException(String _className, Exception _errMsg) {
		super(_errMsg);
		className = _className;
		LOGGER.error(_className, _errMsg);

	}

	/**
	 * Constructor with a param error msg that inherits the parent qualities
	 * 
	 * @param String
	 *            error message, String classname
	 *
	 */
	public CommonUtilException(String _className, String _errMsg) {
		this.className = _className;
		this.errMsg = _errMsg;
	}

	/**
	 * Constructor with a param error msg that inherits the parent qualities
	 * 
	 * @param Exception,
	 *            String classname, int error code
	 *
	 */
	public CommonUtilException(String _className, Exception _errMsg, int _errCode) {
		super(_errMsg);
		className = _className;
		errCode = _errCode;
	}

	/**
	 * Constructor with a param error msg that inherits the parent qualities
	 * 
	 * @param String
	 *            error message, String classname, int error code
	 *
	 */
	public CommonUtilException(String _className, String _errMsg, int _errCode) {
		super(_errMsg);
		className = _className;
		errCode = _errCode;
	}

	/**
	 * @return classname
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @return error code
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * @return error message
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param string
	 *            classname
	 */
	public void setClassName(String string) {
		className = string;
	}

	/**
	 * @param int
	 *            error code
	 */
	public void setErrCode(int i) {
		errCode = i;
	}

	/**
	 * @param string
	 *            error message
	 */
	public void setErrMsg(String string) {
		errMsg = string;
	}

}
