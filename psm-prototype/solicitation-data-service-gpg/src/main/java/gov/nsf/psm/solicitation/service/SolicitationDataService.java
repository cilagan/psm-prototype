package gov.nsf.psm.solicitation.service;

import java.util.List;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;

public interface SolicitationDataService {

    public List<FundingOpportunity> getAllFundingOpportunities();

    public List<Division> getAllDivisions();

    public List<Directorate> getAllDirectorates();

    public List<ProgramElement> getAllProgramElements();

    public List<Directorate> getDirectoratesByFundingOpId(String fundingOpId);

    public List<Division> getDivisionsByFundingOpIdAndDirectorateId(String fundingOpId, String directorateId);
    
    public List<ProgramElement> getProgramElementsByDivisionId(String fundingOpId, String divisionId);

    public Directorate getDirectorateByFundingOpId(String fundingOpId, String divisionId);

    
}
