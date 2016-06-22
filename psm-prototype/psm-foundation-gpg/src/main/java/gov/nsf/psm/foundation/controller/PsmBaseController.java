package gov.nsf.psm.foundation.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import gov.nsf.psm.foundation.exception.BaseError;
import gov.nsf.psm.foundation.exception.BaseResponseWrapper;
import gov.nsf.psm.foundation.exception.CommonUtilException;
import gov.nsf.psm.foundation.exception.PSMRuntimeException;
import gov.nsf.psm.foundation.exception.ResourceNotFoundException;
import gov.nsf.psm.foundation.utility.Constants;

/**
 * Description : Base Controller Class to server Exception/Error handling
 * mechanism to all sub class Controllers
 * 
 * @author yogeshbansal
 */

public class PsmBaseController {

	/**
	 * @param commonUtilException
	 * @return ValidationErrorDTO Description - Method to handle all caught
	 *         system exceptions rolled up to CommonUtil while serving requests
	 *         for any of the routes in all available Controllers
	 */
	@ExceptionHandler({ CommonUtilException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResponseWrapper processCommonUtilException(CommonUtilException commonUtilException) {
		BaseResponseWrapper response = new BaseResponseWrapper();
		response.addError(
				new BaseError(Constants.SERVER_UNEXPECTED_ERROR, StringUtils.isBlank(commonUtilException.getErrMsg())
						? commonUtilException.getMessage() : commonUtilException.getErrMsg()));
		return response;
	}

	/**
	 * @param ResourceNotFoundException
	 * @return ValidationErrorDTO Description - Method to handle runtime
	 *         exceptions/errors caused while serving requests for any of the
	 *         routes in all available Controllers
	 */
	@ExceptionHandler({ ResourceNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseResponseWrapper processResourceNotFoundException(ResourceNotFoundException ex) {
		BaseResponseWrapper response = new BaseResponseWrapper();
		response.addError(new BaseError(Constants.SERVER_RESOURCE_NOT_FOUND, ex.getMessage()));
		return response;
	}

	/**
	 * @param Exception
	 * @return ValidationErrorDTO Description - Method to handle runtime
	 *         exceptions/errors caused while serving requests for any of the
	 *         routes in all available Controllers
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResponseWrapper processException(Exception ex) {
		BaseResponseWrapper response = new BaseResponseWrapper();
		response.addError(new BaseError(Constants.SERVER_500_ERROR, ex.getMessage()));
		return response;
	}

	   /**
     * @param PSMRuntimeException
     * @return RuntimeException description - Method to handle certain runtime
     *         exceptions/errors caused while serving requests for any of the
     *         routes in all available Controllers
     */
    @ExceptionHandler({ PSMRuntimeException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public BaseResponseWrapper processPSMRuntimeException(PSMRuntimeException ex) {
        BaseResponseWrapper response = new BaseResponseWrapper();
        response.addError(new BaseError(Constants.SERVER_401_ERROR, ex.getMessage()));
        return response;
    }
}
