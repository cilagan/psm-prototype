package gov.nsf.research.psm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.storeprocedure.SPGetAllFundingOpportunities;

public class ProposalDaoImpl implements ProposalDao {

	/** The NR Jdbc Template */
	JdbcTemplate psmFLJdbcTemplate;

	

	public ProposalDaoImpl(JdbcTemplate psmFLJdbcTemplate) {
		this.psmFLJdbcTemplate = psmFLJdbcTemplate;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FundingOpportunity> getAllFundingOpportunities() {
		
		System.out.println("IN .....DAOimpl:"+psmFLJdbcTemplate.getDataSource());
		SPGetAllFundingOpportunities sPGetAllFundingOpportunities = new SPGetAllFundingOpportunities(
				psmFLJdbcTemplate.getDataSource(),
				SPGetAllFundingOpportunities.STORED_PROC_GET_FUND_OPPORTUNITY);

		Map<String, Object> result = sPGetAllFundingOpportunities.execute();

		List<FundingOpportunity> fundingOpportunityList = (List<FundingOpportunity>) result
				.get(SPGetAllFundingOpportunities.RESULT_SET);

		return fundingOpportunityList;
	}

	@Override
	public List<Division> getDivisionAndProgramElements(String pgmAnncID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Directorate> getAllDirectorates() {
		// TODO Auto-generated method stub
		return null;
	}

}
