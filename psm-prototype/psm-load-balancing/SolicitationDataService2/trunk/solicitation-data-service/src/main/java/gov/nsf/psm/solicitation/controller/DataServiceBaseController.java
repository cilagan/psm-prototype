package gov.nsf.psm.solicitation.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import gov.nsf.psm.solicitation.dao.SolicitationDataServiceDAOImpl;

public class DataServiceBaseController {

    private static final Logger LOGGER = LogManager.getLogger(DataServiceBaseController.class);
    
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String processBaseException(Exception ex){
        
        LOGGER.error(ex.getMessage(), ex);
        return ex.getMessage();
    }
    
}
