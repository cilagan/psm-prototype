package gov.nsf.psm.solicitation.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.dao.SolicitationDataServiceDAO;

public class SolicitationDataServiceImpl implements SolicitationDataService {

    @Autowired
    SolicitationDataServiceDAO solicitationDao;
    
    private static final Logger LOGGER = LogManager.getLogger(SolicitationDataServiceImpl.class);

    @Override
    public List<FundingOpportunity> getAllFundingOpportunities() {
        LOGGER.debug("SolicitationDataServiceImpl.getAllFundingOpportunities()");
        return solicitationDao.getAllFundingOpportunities();
    }

    @Override
    public List<Division> getAllDivisions() {
        LOGGER.debug("SolicitationDataServiceImpl.getAllDivisions()");
        return solicitationDao.getAllDivisions();
    }

    @Override
    public List<Directorate> getAllDirectorates() {
        LOGGER.debug("SolicitationDataServiceImpl.getAllDirectorates()");
        return solicitationDao.getAllDirectorates();
    }

    @Override
    public List<ProgramElement> getAllProgramElements() {
        LOGGER.debug("SolicitationDataServiceImpl.getAllProgramElements()");
        return solicitationDao.getAllProgramElements();
    }
    
    @Override
    public List<Directorate> getDirectoratesByFundingOpId(String fundingOpId) {
        LOGGER.debug("SolicitationDataServiceImpl.getDirectoratesByFundingOpId()");
        return solicitationDao.getDirectoratesByFundingOpId(fundingOpId);
    }
    
    @Override
    public List<Division> getDivisionsByFundingOpIdAndDirectorateId(String fundingOpId, String directorateId) {
        LOGGER.debug("SolicitationDataServiceImpl.getDivisionsByFundingOpIdAndDirectorateId()");
        return solicitationDao.getDivisionsByFundingOpIdAndDirectorateId(fundingOpId, directorateId);
    }
    
    @Override
    public List<ProgramElement> getProgramElementsByDivisionId(String fundingOpId, String divisionId) {
        LOGGER.debug("SolicitationDataServiceImpl.getProgramElementsByDivisionId()");
        return solicitationDao.getProgramElementsByDivisionId(fundingOpId, divisionId);
    }

    @Override
    public Directorate getDirectorateByFundingOpId(String fundingOpId, String divisionId) {
        LOGGER.debug("SolicitationDataServiceImpl.getDirectorateByFundingOpId()");
        return solicitationDao.getDirectorateByFundingOpId(fundingOpId, divisionId);
    }
}
