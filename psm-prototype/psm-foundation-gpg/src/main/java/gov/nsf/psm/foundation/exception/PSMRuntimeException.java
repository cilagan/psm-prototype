package gov.nsf.psm.foundation.exception;

import org.apache.log4j.Logger;

public class PSMRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 678L;
    private static final Logger LOGGER = Logger.getLogger(PSMRuntimeException.class);

    /*
     * No argument constructor
     */
    public PSMRuntimeException() {
        super();
    }

    public PSMRuntimeException(String msg) {
        super(msg);
        LOGGER.error(msg);
    }

    public PSMRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
        LOGGER.error(msg,cause);
    }


}
