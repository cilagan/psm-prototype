package gov.nsf.psm.solicitation.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import gov.nsf.psm.foundation.ember.model.EmberModel;
import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.dao.SolicitationDataServiceDAO;
import gov.nsf.psm.solicitation.dao.SolicitationDataServiceDAOImpl;
import gov.nsf.psm.solicitation.service.SolicitationDataService;
import gov.nsf.psm.solicitation.service.SolicitationDataServiceImpl;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class SolicitationDataServiceImplTest {

    @InjectMocks
    private SolicitationDataService solicitationDataService = new SolicitationDataServiceImpl();
    
    @Mock
    private SolicitationDataServiceDAO solicitationDao = new SolicitationDataServiceDAOImpl();
    
    private List<Directorate> directorates;
    private List<FundingOpportunity> fundingOpportunities;
    private List<Division> divisions;
    private List<ProgramElement> programElements;
    private Directorate singleDirectorate;
    
    @Before
    public void setUp() {
        initDirectorates();
        initFundingOpportunities();
        initDivisions();
        initProgramElements();
        initSingleDirectorate();
    }
    
    @Test
    public void testGetAllDirectorates() {
        when(solicitationDao.getAllDirectorates()).thenReturn(directorates);
        
        Assert.assertEquals(solicitationDataService.getAllDirectorates(), directorates);
        
        verify(solicitationDao).getAllDirectorates();
    
    }
    
    @Test
    public void testGetAllFundingOpportunities() {
        when(solicitationDao.getAllFundingOpportunities()).thenReturn(fundingOpportunities);
        
        Assert.assertEquals(solicitationDataService.getAllFundingOpportunities(), fundingOpportunities);
        
        verify(solicitationDao).getAllFundingOpportunities();
    
    }
    
    @Test
    public void testGetAllDivisions() {
        when(solicitationDao.getAllDivisions()).thenReturn(divisions);
        
        Assert.assertEquals(solicitationDataService.getAllDivisions(), divisions);
        
        verify(solicitationDao).getAllDivisions();
    
    }
    
    @Test
    public void testGetAllProgramElements() {
        when(solicitationDao.getAllProgramElements()).thenReturn(programElements);
        
        Assert.assertEquals(solicitationDataService.getAllProgramElements(), programElements);
        
        verify(solicitationDao).getAllProgramElements();
    
    }
    
    @Test
    public void testGetDirectoratesByFundingOpId() {
        when(solicitationDao.getDirectoratesByFundingOpId(any(String.class))).thenReturn(directorates);
        
        Assert.assertEquals(solicitationDataService.getDirectoratesByFundingOpId(any(String.class)), directorates);
        
        verify(solicitationDao).getDirectoratesByFundingOpId(any(String.class));
    }
    
    @Test
    public void testGetDivisionsByFundingOpIdAndDirectorateId() {
        when(solicitationDao.getDivisionsByFundingOpIdAndDirectorateId(any(String.class), any(String.class))).thenReturn(divisions);
        
        Assert.assertEquals(solicitationDataService.getDivisionsByFundingOpIdAndDirectorateId(any(String.class), any(String.class)), divisions);
        
        verify(solicitationDao).getDivisionsByFundingOpIdAndDirectorateId(any(String.class), any(String.class));
    }
    
    @Test
    public void testGetProgramElementsByDivisionId() {
        when(solicitationDao.getProgramElementsByDivisionId(any(String.class), any(String.class))).thenReturn(programElements);
        
        Assert.assertEquals(solicitationDataService.getProgramElementsByDivisionId(any(String.class), any(String.class)), programElements);
        
        verify(solicitationDao).getProgramElementsByDivisionId(any(String.class), any(String.class));
    }
    
    @Test
    public void testGetDirectorateByFundingOpId() {
        when(solicitationDao.getDirectorateByFundingOpId(any(String.class), any(String.class))).thenReturn(singleDirectorate);
        
        Assert.assertEquals(solicitationDataService.getDirectorateByFundingOpId(any(String.class), any(String.class)), singleDirectorate);
        
        verify(solicitationDao).getDirectorateByFundingOpId(any(String.class), any(String.class));
    }
    
    private void initDirectorates() {
        directorates = new ArrayList<Directorate>();
        
        Directorate dir1 = new Directorate();
        dir1.setDirectorateCode("01000000");
        dir1.setDirectorateName("Office Of The Director");
        
        Directorate dir2 = new Directorate();
        dir2.setDirectorateCode("03000000");
        dir2.setDirectorateName("Direct For Mathematical & Physical Science");
        
        directorates.add(dir1);
        directorates.add(dir2);
    }
    
    private void initFundingOpportunities() {
        fundingOpportunities = new ArrayList<FundingOpportunity>();
        
        FundingOpportunity fo1 = new FundingOpportunity();
        fo1.setFundingOpportunityId("NSF 13-593");
        fo1.setFundingOpportunityTitle("East Asia and Pacific Summer Institutes for U.S. Graduate Students");
        
        FundingOpportunity fo2 = new FundingOpportunity();
        fo2.setFundingOpportunityId("NSF 16-557");
        fo2.setFundingOpportunityTitle("EPSCoR Research Infrastructure Improvement Program Track-1:");
        
        fundingOpportunities.add(fo1);
        fundingOpportunities.add(fo2);
    }
    
    private void initDivisions() {
        divisions = new ArrayList<Division>();
        
        Division div1 = new Division();
        div1.setDivisionCode("01060000");
        div1.setDivisionName("Office of Integrative Activities");
        
        Division div2 = new Division();
        div2.setDivisionCode("03010000");
        div2.setDivisionName("Division Of Physics");
        
        divisions.add(div1);
        divisions.add(div2);
    }
    
    private void initProgramElements() {
        programElements = new ArrayList<ProgramElement>();
        
        ProgramElement pe1 = new ProgramElement();
        pe1.setProgramElementCode("005Y");
        pe1.setProgramElementName("STEM + Computing (STEM+C) Part");
        
        ProgramElement pe2 = new ProgramElement();
        pe2.setProgramElementCode("009Y");
        pe2.setProgramElementName("Political Science DDRIG");
        
        programElements.add(pe1);
        programElements.add(pe2);
    }
    
    private void initSingleDirectorate() {
        singleDirectorate = new Directorate();
        singleDirectorate.setDirectorateCode("01000000");
        singleDirectorate.setDirectorateName("Office Of The Director");
        
        List<Division> divisions = new ArrayList<Division>();
        Division div1 = new Division();
        div1.setDivisionCode("01060000");
        div1.setDivisionName("Office of Integrative Activities");
        
        List<ProgramElement> programElements = new ArrayList<ProgramElement>();
        ProgramElement pe1 = new ProgramElement();
        pe1.setProgramElementCode("005Y");
        pe1.setProgramElementName("STEM + Computing (STEM+C) Part");
        
        programElements.add(pe1);
        div1.setProgramElements(programElements.toArray(new ProgramElement[programElements.size()]));
        divisions.add(div1);
        singleDirectorate.setDivisions(divisions.toArray(new Division[divisions.size()]));
    }
    
}
