package gov.nsf.psm.solicitation.dao;

import java.util.List;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.FundingOpportunity;
import gov.nsf.psm.foundation.model.ProgramElement;

public interface SolicitationDataServiceDAO {

    public List<FundingOpportunity> getAllFundingOpportunities();

    public List<Division> getAllDivisions();

    public List<ProgramElement> getAllProgramElements();

    public List<Directorate> getAllDirectorates();

    public List<Directorate> getDirectoratesByFundingOpId(String fundingOpId);

    public List<Division> getDivisionsByFundingOpIdAndDirectorateId(String fundingOpId, String directorateId);

    public List<ProgramElement> getProgramElementsByDivisionId(String divisionId);

    public Directorate getDirectorateByFundingOpId(String fundingOpId, String divisionId);


}
