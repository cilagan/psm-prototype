package gov.nsf.psm.solicitation.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import gov.nsf.psm.solicitation.storedprocedure.SPGetAllProgramElementsByFundingOpId;

public class SolicitationDataServiceDAOImpl implements SolicitationDataServiceDAO {
    
    @Autowired
    private JdbcTemplate psmFLJdbcTemplate;

    private static final Logger LOGGER = LogManager.getLogger(SolicitationDataServiceDAOImpl.class);
    
    @SuppressWarnings("unchecked")
    @Override
    public List<FundingOpportunity> getAllFundingOpportunities() {
        LOGGER.info("ProposalDaoImpl.getAllFundingOpportunities()");
        List<FundingOpportunity> results = null;

        SPGetAllFundingOpportunities sPGetAllFundingOpportunities = new SPGetAllFundingOpportunities(psmFLJdbcTemplate.getDataSource());
        results = (List<FundingOpportunity>) sPGetAllFundingOpportunities.getFundingOpportunities().get(Constants.RESULT_SET);
        
        if(results != null && !results.isEmpty()) {
            return results;
        }
        else {
            LOGGER.info("No funding opportunities returned in the results.");
            return new ArrayList<FundingOpportunity>();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Directorate> getAllDirectorates() {
        LOGGER.info("ProposalDaoImpl.getAllDirectorates()");
        List<Directorate> results = null;
            SPGetAllDirectorates sPGetAllDirectorates = new SPGetAllDirectorates(psmFLJdbcTemplate.getDataSource());
            results = (List<Directorate>) sPGetAllDirectorates.getDirectorates().get(Constants.RESULT_SET);    
            
            if(results != null && !results.isEmpty()) {
                return results;
            }
            else {
                LOGGER.info("No directorates returned in the results.");
                return new ArrayList<Directorate>();
            }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Division> getAllDivisions() {
        LOGGER.info("ProposalDaoImpl.getAllDivisions()");
        List<Division> results = null;
            SPGetAllDivisions sPGetAllDivisions = new SPGetAllDivisions(psmFLJdbcTemplate.getDataSource());
            results = (List<Division>) sPGetAllDivisions.getDivisions().get(Constants.RESULT_SET);
            
            if(results != null && !results.isEmpty()){
                return results;
            }
            else {
                LOGGER.info("No divisions returned in the results.");
                return new ArrayList<Division>();
            }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProgramElement> getAllProgramElements() {
        LOGGER.info("ProposalDaoImpl.getAllProgramElements()");
        List<ProgramElement> results = null;

            SPGetAllProgramElement sPGetAllProgramElement = new SPGetAllProgramElement(psmFLJdbcTemplate.getDataSource());
            results = (List<ProgramElement>) sPGetAllProgramElement.getProgramElements().get(Constants.RESULT_SET);
            
            if(results != null && !results.isEmpty()){
                return results;
            }
            else {
                LOGGER.info("No program elements returned in the results.");
                return new ArrayList<ProgramElement>();
            }
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Directorate> getDirectoratesByFundingOpId(String fundingOpId) {
        LOGGER.info("ProposalDaoImpl.getDirectoratesByFundingOpId()");
        List<Directorate> results = null;
        
            SPGetAllDirectoratesByFundingOpId sPGetDirectoratesByFundingOpId =  new SPGetAllDirectoratesByFundingOpId(psmFLJdbcTemplate.getDataSource());
            results = (List<Directorate>) sPGetDirectoratesByFundingOpId.getDirectoratesByFundingOpId(fundingOpId).get(Constants.RESULT_SET);
        
            if(results != null && !results.isEmpty()){
                return results;
            }
            else {
                LOGGER.info("No directorates returned in the results.");
                return new ArrayList<Directorate>();
            }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Division> getDivisionsByFundingOpIdAndDirectorateId(String fundingOpId, String directorateId) {
        LOGGER.info("ProposalDaoImpl.getDivisionsByFundingOpIdAndDirectorateId()");
        List<Division> results = null;

            SPGetAllDivisionsByFundingOpId sPGetDivisionsByFundID =  new SPGetAllDivisionsByFundingOpId(psmFLJdbcTemplate.getDataSource());
            results = (List<Division>) sPGetDivisionsByFundID.getDivisionsByFundingOpId(fundingOpId, directorateId).get(Constants.RESULT_SET);
        
            if(results != null && !results.isEmpty()){
                return results;
            }
            else {
                LOGGER.info("No divisions returned in the results.");
                return new ArrayList<Division>();
            }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<ProgramElement> getProgramElementsByDivisionId(String fundingOpId, String divisionId) {
        LOGGER.info("ProposalDaoImpl.getProgramElementsByDivisionId()");
        List<ProgramElement> results = null;
        
            SPGetAllProgramElementsByFundingOpId sPGetProgramElementsByFundingOpId =  new SPGetAllProgramElementsByFundingOpId(psmFLJdbcTemplate.getDataSource());
            results = (List<ProgramElement>) sPGetProgramElementsByFundingOpId.getProgramElementsByDivisionId(fundingOpId, divisionId).get(Constants.RESULT_SET);
        
            if(results != null && !results.isEmpty()){
                return results;
            }
            else {
                LOGGER.info("No program elements returned in the results.");
                return new ArrayList<ProgramElement>();
            }
    }
    
    @Override
    public Directorate getDirectorateByFundingOpId(String fundingOpId, String directorateId) {
        LOGGER.info("ProposalDaoImpl.getDirectorateByFundingOpId()");
        Directorate result = null;
        
            SPGetDirectorateByFundingOpId sPGetDirectorateByFundingOpId =  new SPGetDirectorateByFundingOpId(psmFLJdbcTemplate.getDataSource());
            result = (Directorate) sPGetDirectorateByFundingOpId.getDirectorateByFundingOpId(fundingOpId, directorateId).get(Constants.RESULT_SET);
        
            if(result != null){
                return result;
            }
            else {
                LOGGER.info("No directorate was returned in the results.");
                return new Directorate();
            }
    }
}