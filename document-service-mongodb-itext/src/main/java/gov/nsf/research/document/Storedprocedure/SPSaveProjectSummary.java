package gov.nsf.research.document.Storedprocedure;

import gov.nsf.research.document.service.model.proposal.ProjectSummary;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class SPSaveProjectSummary extends StoredProcedure{
	
	
	public static final String STORED_PROC_SAVE_PROJ_SUMM = "flp.pr_psm_save_proj_summ";
	private static final String IN_TEMP_PROP_ID = "tempPropID";
	private static final String IN_OVERVIEW = "overView";
	private static final String IN_BRODRIMPT = "brodrImpt";
	private static final String IN_INTULMERIT = "intulMerit";
	
	

	public SPSaveProjectSummary(){
		super();
	}
	
	
	public SPSaveProjectSummary(DataSource dataSource, String storedProcName){
		super(dataSource, storedProcName);
		
		declareParameter(new SqlParameter(SPSaveProjectSummary.IN_TEMP_PROP_ID, Types.CHAR));
		declareParameter(new SqlParameter(SPSaveProjectSummary.IN_OVERVIEW, Types.VARCHAR));
		declareParameter(new SqlParameter(SPSaveProjectSummary.IN_BRODRIMPT, Types.VARCHAR));
		declareParameter(new SqlParameter(SPSaveProjectSummary.IN_INTULMERIT, Types.VARCHAR));
	
		
		
		compile();
	}
	
	public SPSaveProjectSummary(JdbcTemplate jdbcTemplate, String name){
		super(jdbcTemplate, name);
	}
	
	public void execute(String tempPropID,String overView, String brodrImpt, String intulMerit) {
				
		Map<String, Object> inParams = new HashMap<String, Object>();
		
		inParams.put(IN_TEMP_PROP_ID, tempPropID);
		inParams.put(IN_OVERVIEW, overView);
		inParams.put(IN_BRODRIMPT, brodrImpt);
		inParams.put(IN_INTULMERIT, intulMerit);
		
		
	    super.execute(inParams);
	
	
}// end of c

}
