package gov.nsf.psm.solicitation.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nsf.psm.foundation.controller.PsmBaseController;
import gov.nsf.psm.foundation.ember.model.EmberModel;
import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.service.SolicitationDataService;

@CrossOrigin
@RestController
@RequestMapping(path = "/sdsvc")
public class SolicitationDataServiceController extends PsmBaseController {

	@Autowired
	SolicitationDataService solicitationDataService;

	private static final Logger LOGGER = LogManager.getLogger(SolicitationDataServiceController.class);

    @RequestMapping(path = "/fundingOps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmberModel getAllFundingOpportunities() {
        System.out.println(LOGGER.isInfoEnabled());
        LOGGER.info("SolicitationDataServiceController.getAllFundingOpportunities()");
        List<FundingOpportunity> fundingOpsList = solicitationDataService.getAllFundingOpportunities();
        return new EmberModel.Builder<>(FundingOpportunity.class, fundingOpsList).build();
    }
	   
	@RequestMapping(path = "/divisions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmberModel getAllDivisions() {
		LOGGER.debug("SolicitationDataServiceController.getAllDivisions()");
		List<Division> divisionsList = solicitationDataService.getAllDivisions();
		return new EmberModel.Builder<>(Division.class, divisionsList).build();
	}

    @RequestMapping(path = "/directorates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmberModel getAllDirectorates() {
        LOGGER.debug("SolicitationDataServiceController.getAllDirectorates()");
        List<Directorate> directoratesList = solicitationDataService.getAllDirectorates();
        return new EmberModel.Builder<>(Directorate.class, directoratesList).build();
    }
    
    @RequestMapping(path = "/programElements", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmberModel getAllProgramElements() {
        LOGGER.debug("SolicitationDataServiceController.getAllProgramElements()");
        List<ProgramElement> programElementsList = solicitationDataService.getAllProgramElements();
        return new EmberModel.Builder<>(ProgramElement.class, programElementsList).build();
    }
    
    @RequestMapping(path = "/fundingOps/{fundingOpId}/directorates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmberModel getDirectoratesByFundingOpId(@PathVariable String fundingOpId) {
        LOGGER.debug("SolicitationDataServiceController.getDirectoratesByFundingOpId()");
        List<Directorate> directoratesList = solicitationDataService.getDirectoratesByFundingOpId(fundingOpId);
        return new EmberModel.Builder<>(Directorate.class, directoratesList).build();
    }
    
    @RequestMapping(path = "/fundingOps/{fundingOpId}/directorates/{directorateId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmberModel getDirectorateByFundingOpId(@PathVariable String fundingOpId, @PathVariable String directorateId) {
        LOGGER.debug("SolicitationDataServiceController.getDirectorateByFundingOpId()");
        Directorate directorate = solicitationDataService.getDirectorateByFundingOpId(fundingOpId, directorateId);
        return new EmberModel.Builder<>(Directorate.class.getSimpleName().toLowerCase(), directorate).build();
    }
    
    @RequestMapping(path = "/fundingOps/{fundingOpId}/directorates/{directorateId}/divisions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmberModel getDivisionsByFundingOpIdAndDirectorateId(@PathVariable String fundingOpId, @PathVariable String directorateId) {
        LOGGER.debug("SolicitationDataServiceController.getDivisionsByFundingOpIdAndDirectorateId()");
        List<Division> divisionsList = solicitationDataService.getDivisionsByFundingOpIdAndDirectorateId(fundingOpId, directorateId);
        return new EmberModel.Builder<>(Division.class, divisionsList).build();
    }
    
    @RequestMapping(path = "/fundingOps/{fundingOpId}/directorates/{directorateId}/divisions/{divisionId}/programElements", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmberModel getProgramElementsByDivisionId(@PathVariable String fundingOpId, @PathVariable String directorateId, @PathVariable String divisionId) {
        LOGGER.debug("SolicitationDataServiceController.getProgramElementsByDivisionId()");
        List<ProgramElement> programElementsList = solicitationDataService.getProgramElementsByDivisionId(fundingOpId, divisionId);
        return new EmberModel.Builder<>(ProgramElement.class, programElementsList).build();
    }    

}
