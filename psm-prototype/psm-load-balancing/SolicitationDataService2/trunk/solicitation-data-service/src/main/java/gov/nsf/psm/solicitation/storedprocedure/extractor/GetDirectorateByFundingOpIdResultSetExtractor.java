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
                 directorate.setDirectorateCode(rs.getString(Constants.DIR_ID).trim());
                 directorate.setDirectorateName(rs.getString(Constants.DIR_NAME).trim());
                 directorate.setDirectorateAbbrv(rs.getString(Constants.DIR_ABBRV).trim());
                 directorate.setDirectorateLongName(rs.getString(Constants.DIR_LONG_NAME).trim());
             }
             
             // if record has a different division code...
             if(divCode == null || !divCode.equals(rs.getString(Constants.DIV_ID).trim())) {
                 // initialize the first division
                 division = new Division();
                 division.setDivisionCode(rs.getString(Constants.DIV_ID).trim());
                 division.setDivisionName(rs.getString(Constants.DIV_NAME).trim());
                 division.setDivisionAbbrv(rs.getString(Constants.DIV_ABBRV).trim());
                 division.setDivisionLongName(rs.getString(Constants.DIV_LONG_NAME).trim());
                 divisions.add(division);
                 
                 // initialize the division code tracker
                 divCode = rs.getString(Constants.DIV_ID).trim();
                 
                 // initialize the programElements array
                 programElements = new ArrayList<ProgramElement>();
             }
              
             // create a ProgramElement object and populate it with record data. 
             // Then add it to the programElement list
             ProgramElement progElement = new ProgramElement();
             progElement.setProgramElementCode(rs.getString(Constants.PGM_ELE_ID).trim());
             progElement.setProgramElementName(rs.getString(Constants.PGM_ELE_NAME).trim());
             progElement.setProgramElementLongName(rs.getString(Constants.PGM_ELE_LONG_NAME).trim());
             programElements.add(progElement);
             division.setProgramElements(programElements.toArray(new ProgramElement[programElements.size()]));
             
         }
        
        directorate.setDivisions(divisions.toArray(new Division[divisions.size()]));
        return directorate;
    }

}
