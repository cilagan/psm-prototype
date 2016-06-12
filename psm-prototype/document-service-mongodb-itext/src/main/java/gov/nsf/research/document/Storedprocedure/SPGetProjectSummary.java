package gov.nsf.research.document.Storedprocedure;

import gov.nsf.research.document.Storedprocedure.mapper.ProjectSummaryDetailMapper;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetProjectSummary extends StoredProcedure {
	
	
	public static final String STORED_PROC_GET_PROJ_SUMM_DETAILS = "flp.pr_psm_sel_proj_summ";
	public static final String RESULT_SET = "ProjectSummary";
	private static final String IN_TEMP_PROP_ID = "tempPropID";
	

	public SPGetProjectSummary(){
		super();
	}
	
	public SPGetProjectSummary(DataSource dataSource, String storedProcName){
		super(dataSource, storedProcName);
		declareParameter(new SqlReturnResultSet(RESULT_SET, new ProjectSummaryDetailMapper()));
		declareParameter(new SqlParameter(SPGetProjectSummary.IN_TEMP_PROP_ID, Types.VARCHAR));
		
		compile();
	}
	
	public SPGetProjectSummary(JdbcTemplate jdbcTemplate, String name){
		super(jdbcTemplate, name);
	}

	public final Map<String, Object> execute(String tempPropID){
		Map<String, Object> inParams = new HashMap<String, Object>();
		
		inParams.put(SPGetProjectSummary.IN_TEMP_PROP_ID ,tempPropID);
					
		Map<String, Object> results  = super.execute(inParams);
		
		return results;
	}

}
