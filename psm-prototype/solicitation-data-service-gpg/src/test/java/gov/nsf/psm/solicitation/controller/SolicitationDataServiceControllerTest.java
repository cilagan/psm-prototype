package gov.nsf.psm.solicitation.controller;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import gov.nsf.psm.foundation.controller.PsmBaseController;
import gov.nsf.psm.foundation.ember.model.EmberModel;
import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.service.SolicitationDataService;
import gov.nsf.psm.solicitation.service.SolicitationDataServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SolicitationDataServiceControllerTest {

    @InjectMocks
    private SolicitationDataServiceController solicitationDataServiceController = new SolicitationDataServiceController();
    
    @Mock
    private SolicitationDataService solicitationDataService = new SolicitationDataServiceImpl();
    @Mock 
    private PsmBaseController baseController = new PsmBaseController();
    
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
        when(solicitationDataService.getAllDirectorates()).thenReturn(directorates);
        EmberModel directoratesModel = new EmberModel.Builder<>(Directorate.class, directorates).build();
        Assert.assertEquals(solicitationDataServiceController.getAllDirectorates(), directoratesModel);
        
        verify(solicitationDataService).getAllDirectorates();
    
    }
    
    @Test
    public void testGetAllFundingOpportunities() {
        when(solicitationDataService.getAllFundingOpportunities()).thenReturn(fundingOpportunities);
        EmberModel fundingOpsModel = new EmberModel.Builder<>(FundingOpportunity.class, fundingOpportunities).build();
        
        Assert.assertEquals(solicitationDataServiceController.getAllFundingOpportunities(), fundingOpsModel);
        
        verify(solicitationDataService).getAllFundingOpportunities();
    
    }
    
    @Test
    public void testGetAllDivisions() {
        when(solicitationDataService.getAllDivisions()).thenReturn(divisions);
        EmberModel divisionsModel = new EmberModel.Builder<>(Division.class, divisions).build();
        
        Assert.assertEquals(solicitationDataServiceController.getAllDivisions(), divisionsModel);
        
        verify(solicitationDataService).getAllDivisions();
    
    }
    
    @Test
    public void testGetAllProgramElements() {
        when(solicitationDataService.getAllProgramElements()).thenReturn(programElements);
        EmberModel programElementsModel = new EmberModel.Builder<>(ProgramElement.class, programElements).build();
        
        Assert.assertEquals(solicitationDataServiceController.getAllProgramElements(), programElementsModel);
        
        verify(solicitationDataService).getAllProgramElements();
    
    }
    
    @Test
    public void testGetDirectoratesByFundingOpId() {
        when(solicitationDataService.getDirectoratesByFundingOpId(any(String.class))).thenReturn(directorates);
        EmberModel directoratesModel = new EmberModel.Builder<>(Directorate.class, directorates).build();
        
        Assert.assertEquals(solicitationDataServiceController.getDirectoratesByFundingOpId(any(String.class)), directoratesModel);
        
        verify(solicitationDataService).getDirectoratesByFundingOpId(any(String.class));
    }
    
    @Test
    public void testGetDivisionsByFundingOpIdAndDirectorateId() {
        when(solicitationDataService.getDivisionsByFundingOpIdAndDirectorateId(any(String.class), any(String.class))).thenReturn(divisions);
        EmberModel divisionsModel = new EmberModel.Builder<>(Division.class, divisions).build();
        
        Assert.assertEquals(solicitationDataServiceController.getDivisionsByFundingOpIdAndDirectorateId(any(String.class), any(String.class)), divisionsModel);
        
        verify(solicitationDataService).getDivisionsByFundingOpIdAndDirectorateId(any(String.class), any(String.class));
    }
    
    @Test
    public void testGetProgramElementsByDivisionId() {
        when(solicitationDataService.getProgramElementsByDivisionId(any(String.class), any(String.class))).thenReturn(programElements);
        EmberModel programElementsModel = new EmberModel.Builder<>(ProgramElement.class, programElements).build();
        
        Assert.assertEquals(solicitationDataServiceController.getProgramElementsByDivisionId(any(String.class), null, any(String.class)), programElementsModel);
        
        verify(solicitationDataService).getProgramElementsByDivisionId(any(String.class), any(String.class));
    }
    
    @Test
    public void testGetDirectorateByFundingOpId() {
        when(solicitationDataService.getDirectorateByFundingOpId(any(String.class), any(String.class))).thenReturn(singleDirectorate);
        EmberModel directorateModel = new EmberModel.Builder<>(Directorate.class.getName().toLowerCase(), singleDirectorate).build();
        
        Assert.assertEquals(solicitationDataServiceController.getDirectorateByFundingOpId(any(String.class), any(String.class)), directorateModel);
        
        verify(solicitationDataService).getDirectorateByFundingOpId(any(String.class), any(String.class));
    }
    
    @Test(expected = Exception.class)
    public void testException() {
        Exception testException = new Exception("The service threw an exception for this operation");
        doThrow(testException).when(solicitationDataService).getAllDirectorates();

        Assert.assertEquals(solicitationDataServiceController.getAllDirectorates(), directorates); 
        
        verify(solicitationDataService).getAllDirectorates();
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
