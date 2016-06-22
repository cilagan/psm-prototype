package gov.nsf.psm.solicitation.storedprocedure.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import gov.nsf.psm.foundation.model.Directorate;
import gov.nsf.psm.foundation.model.Division;
import gov.nsf.psm.foundation.model.ProgramElement;
import gov.nsf.psm.solicitation.common.utility.Constants;
import gov.nsf.psm.solicitation.common.utility.SolicitationDataUtils;

public class GetDirectorateByFundingOpIdResultSetExtractor implements ResultSetExtractor<Directorate>  {

    @Override
    public Directorate extractData(ResultSet rs) throws SQLException, DataAccessException {
        Directorate directorate = new Directorate();
        List<Division> divisions = new ArrayList<Division>();
        Division division = null;
        List<ProgramElement> programElements = null;
        String divCode = null;
        
        while(rs.next()) {
            // execute this for the first record only
            if(rs.isFirst()) {
                 
                 // populate directorate only once
                 directorate.setDirectorateCode(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_ID)));
                 directorate.setDirectorateName(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_NAME)));
                 directorate.setDirectorateAbbrv(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_ABBRV)));
                 directorate.setDirectorateLongName(SolicitationDataUtils.getValue(rs.getString(Constants.DIR_LONG_NAME)));
             }
             
             // if record has a different division code...
             if(divCode == null || !divCode.equals(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_ID)))) {
                 // initialize the first division
                 division = new Division();
                 division.setDivisionCode(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_ID)));
                 division.setDivisionName(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_NAME)));
                 division.setDivisionAbbrv(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_ABBRV)));
                 division.setDivisionLongName(SolicitationDataUtils.getValue(rs.getString(Constants.DIV_LONG_NAME)));
                 divisions.add(division);
                 
                 // initialize the division code tracker
                 divCode = SolicitationDataUtils.getValue(rs.getString(Constants.DIV_ID));
                 
                 // initialize the programElements array
                 programElements = new ArrayList<ProgramElement>();
             }
              
             // create a ProgramElement object and populate it with record data. 
             // Then add it to the programElement list
             ProgramElement progElement = new ProgramElement();
             progElement.setProgramElementCode(SolicitationDataUtils.getValue(rs.getString(Constants.PGM_ELE_ID)));
             progElement.setProgramElementName(SolicitationDataUtils.getValue(rs.getString(Constants.PGM_ELE_NAME)));
             progElement.setProgramElementLongName(SolicitationDataUtils.getValue(rs.getString(Constants.PGM_ELE_LONG_NAME)));
             programElements.add(progElement);
             division.setProgramElements(programElements.toArray(new ProgramElement[programElements.size()]));
             
         }
        
        directorate.setDivisions(divisions.toArray(new Division[divisions.size()]));
        return directorate;
    }

}
