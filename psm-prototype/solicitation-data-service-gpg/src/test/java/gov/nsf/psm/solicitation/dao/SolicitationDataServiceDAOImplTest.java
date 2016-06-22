package gov.nsf.psm.solicitation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.dao.SolicitationDataServiceDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"SolicitationDataServiceDAOTest-context.xml"})
public class SolicitationDataServiceDAOImplTest {

    
    private String fundingOpId;
    private String directorateId;
    private String divisionId;
    
    @Autowired
    private SolicitationDataServiceDAO solicitationDataServiceDAO;
    
    @Before
    public void setUp() {
        fundingOpId = "NSF 13-593";
        directorateId = "01000000";
        divisionId = "01090000";
    }
    
    @Test
    public void testGetAllDirectorates() {
        List<Directorate> directorateList = solicitationDataServiceDAO.getAllDirectorates();
        System.out.println(directorateList);
        assertNotNull(directorateList);
    }
    

    @Test
    public void testGetAllFundingOpportunities() {
        List<FundingOpportunity> fundingOpList = solicitationDataServiceDAO.getAllFundingOpportunities();
        System.out.println(fundingOpList);
        assertNotNull(fundingOpList);
    }
    
    @Test
    public void testGetAllDivisions() {
        List<Division> divisionList = solicitationDataServiceDAO.getAllDivisions();
        System.out.println(divisionList.size());
        //assertNotNull(divisionList);
    }
    
    @Test
    public void testGetAllProgramElements() {
        List<ProgramElement> programElementList = solicitationDataServiceDAO.getAllProgramElements();
        System.out.println(programElementList);
        assertNotNull(programElementList);
    }
    
    @Test
    public void testGetDirectoratesByFundingOpId() {
        List<Directorate> directorateList = solicitationDataServiceDAO.getDirectoratesByFundingOpId(fundingOpId);
        System.out.println(directorateList);
        assertNotNull(directorateList);
    }
    
    @Test
    public void testGetDivisionsByFundingOpIdAndDirectorateId() {
        List<Division> divisionList = solicitationDataServiceDAO.getDivisionsByFundingOpIdAndDirectorateId(fundingOpId, directorateId);
        System.out.println(divisionList);
        //assertNotNull(divisionList);
    }
    
    @Test
    public void testGetProgramElementsByDivisionId() {
        List<ProgramElement> programElementList = solicitationDataServiceDAO.getProgramElementsByDivisionId(fundingOpId, divisionId);
        System.out.println(programElementList);
        assertNotNull(programElementList);
    }

    @Test
    public void testGetDirectorateByFundingOpId() {
        Directorate directorate = solicitationDataServiceDAO.getDirectorateByFundingOpId(fundingOpId, directorateId);
        System.out.println(directorate);
        assertNotNull(directorate);
        assertEquals( "Office Of The Director", directorate.getDirectorateName());
    }
    
}
