package gov.nsf.psm.solicitation.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllDirectorates;
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllDivisions;
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllFundingOpportunities;
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllProgramElement;
import gov.nsf.psm.solicitation.storedprocedure.SPGetDirectorateByFundingOpId;
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllDirectoratesByFundingOpId;
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllDivisionsByFundingOpId;
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllProgramElementsByDivisionCode;

public class SolicitationDataServiceDAOImpl implements SolicitationDataServiceDAO {
    
    @Autowired
    private JdbcTemplate psmFLJdbcTemplate;

    private static final Logger LOGGER = LogManager.getLogger(SolicitationDataServiceDAOImpl.class);
    
    @SuppressWarnings("unchecked")
    @Override
    public List<FundingOpportunity> getAllFundingOpportunities() {
        LOGGER.debug("ProposalDaoImpl.getAllFundingOpportunities()");
        List<FundingOpportunity> result = null;
        try {
            SPGetAllFundingOpportunities sPGetAllFundingOpportunities = new SPGetAllFundingOpportunities(psmFLJdbcTemplate.getDataSource());
            result = (List<FundingOpportunity>) sPGetAllFundingOpportunities.getFundingOpportunities().get(Constants.RESULT_SET);
            
            if(result != null && result.size() > 0) {
                return result;
            }
            else {
                return new ArrayList<FundingOpportunity>();
            }
        }
//        catch (DataAccessException e) {
//            LOGGER.error(e);
//            throw e;
//        }
        catch (Exception e) {
            LOGGER.error(e);
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Directorate> getAllDirectorates() {
        LOGGER.debug("ProposalDaoImpl.getAllDirectorates()");
        List<Directorate> results = null;
        try {
            SPGetAllDirectorates sPGetAllDirectorates = new SPGetAllDirectorates(psmFLJdbcTemplate.getDataSource());
            results = (List<Directorate>) sPGetAllDirectorates.getDirectorates().get(Constants.RESULT_SET);    
            
            if(results != null && results.size() > 0) {
                return results;
            }
            else {
                return new ArrayList<Directorate>();
            }
        }
        catch(Exception e) {
            LOGGER.error(e);
            throw e;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Division> getAllDivisions() {
        LOGGER.debug("ProposalDaoImpl.getAllDivisions()");
        List<Division> results = null;
        try {
            SPGetAllDivisions sPGetAllDivisions = new SPGetAllDivisions(psmFLJdbcTemplate.getDataSource());
            results = (List<Division>) sPGetAllDivisions.getDivisions().get(Constants.RESULT_SET);
            
            if(results != null && results.size() > 0){
                return results;
            }
            else {
                return new ArrayList<Division>();
            }
        }
        catch(Exception e){
            LOGGER.error(e);
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProgramElement> getAllProgramElements() {
        LOGGER.debug("ProposalDaoImpl.getAllProgramElements()");
        List<ProgramElement> results = null;
        try {
            SPGetAllProgramElement sPGetAllProgramElement = new SPGetAllProgramElement(psmFLJdbcTemplate.getDataSource());
            results = (List<ProgramElement>) sPGetAllProgramElement.getProgramElements().get(Constants.RESULT_SET);
            
            if(results != null && results.size() > 0){
                return results;
            }
            else {
                return new ArrayList<ProgramElement>();
            }
        }
        catch(Exception e){
            LOGGER.error(e);
            throw e;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Directorate> getDirectoratesByFundingOpId(String fundingOpId) {
        LOGGER.debug("ProposalDaoImpl.getAllProgramElements()");
        List<Directorate> results = null;
        
        try {
            SPGetAllDirectoratesByFundingOpId sPGetDirectoratesByFundingOpId =  new SPGetAllDirectoratesByFundingOpId(psmFLJdbcTemplate.getDataSource());
            results = (List<Directorate>) sPGetDirectoratesByFundingOpId.getDirectoratesByFundingOpId(fundingOpId).get(Constants.RESULT_SET);
        
            if(results != null && results.size() > 0){
                return results;
            }
            else {
                return new ArrayList<Directorate>();
            }
        }
        catch(Exception e){
            LOGGER.error(e);
            throw e;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Division> getDivisionsByFundingOpIdAndDirectorateId(String fundingOpId, String directorateId) {
        LOGGER.debug("ProposalDaoImpl.getDivisionsByFundingOpIdAndDirectorateId()");
        List<Division> results = null;
        
        try {
            SPGetAllDivisionsByFundingOpId sPGetDivisionsByFundID =  new SPGetAllDivisionsByFundingOpId(psmFLJdbcTemplate.getDataSource());
            results = (List<Division>) sPGetDivisionsByFundID.getDivisionsByFundingOpId(fundingOpId, directorateId).get(Constants.RESULT_SET);
        
            if(results != null && results.size() > 0){
                return results;
            }
            else {
                return new ArrayList<Division>();
            }
        }
        catch(Exception e){
            LOGGER.error(e);
            throw e;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<ProgramElement> getProgramElementsByDivisionId(String divisionId) {
        LOGGER.debug("ProposalDaoImpl.getProgramElementsByDivisionId()");
        List<ProgramElement> results = null;
        
        try {
            SPGetAllProgramElementsByDivisionCode sPGetProgramElementsByDivisionCode =  new SPGetAllProgramElementsByDivisionCode(psmFLJdbcTemplate.getDataSource());
            results = (List<ProgramElement>) sPGetProgramElementsByDivisionCode.getProgramElementsByDivisionId(divisionId).get(Constants.RESULT_SET);
        
            if(results != null && results.size() > 0){
                return results;
            }
            else {
                return new ArrayList<ProgramElement>();
            }
        }
        catch(Exception e){
            LOGGER.error(e);
            throw e;
        }
    }
    
    @Override
    public Directorate getDirectorateByFundingOpId(String fundingOpId, String directorateId) {
        LOGGER.debug("ProposalDaoImpl.getDirectorateByFundingOpId()");
        Directorate result = null;
        
        try {
            SPGetDirectorateByFundingOpId sPGetDirectorateByFundingOpId =  new SPGetDirectorateByFundingOpId(psmFLJdbcTemplate.getDataSource());
            result = (Directorate) sPGetDirectorateByFundingOpId.getDirectorateByFundingOpId(fundingOpId, directorateId).get(Constants.RESULT_SET);
        
            if(result != null){
                return result;
            }
            else {
                return new Directorate();
            }
        }
        catch(Exception e){
            LOGGER.error(e);
            throw e;
        }
    }
}