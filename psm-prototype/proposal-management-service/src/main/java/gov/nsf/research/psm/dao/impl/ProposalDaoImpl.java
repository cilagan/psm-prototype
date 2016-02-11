package gov.nsf.research.psm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;
import gov.nsf.research.psm.storeprocedure.SPGetAllDirectorates;
import gov.nsf.research.psm.storeprocedure.SPGetAllFundingOpportunities;
import gov.nsf.research.psm.storeprocedure.SPGetDirectorates;
import gov.nsf.research.psm.storeprocedure.SPGetDivisions;
import gov.nsf.research.psm.storeprocedure.SPGetProgramElement;

public class ProposalDaoImpl implements ProposalDao {

	/** The PSM Jdbc Template */
	private JdbcTemplate psmFLJdbcTemplate;

	public JdbcTemplate getPsmFLJdbcTemplate() {
		return psmFLJdbcTemplate;
	}

	public void setPsmFLJdbcTemplate(JdbcTemplate psmFLJdbcTemplate) {
		this.psmFLJdbcTemplate = psmFLJdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FundingOpportunity> getAllFundingOpportunities() {
		SPGetAllFundingOpportunities sPGetAllFundingOpportunities = new SPGetAllFundingOpportunities(
				psmFLJdbcTemplate.getDataSource(),
				SPGetAllFundingOpportunities.STORED_PROC_GET_FUND_OPPORTUNITY);

		Map<String, Object> result = sPGetAllFundingOpportunities.execute();

		List<FundingOpportunity> fundingOpportunityList = (List<FundingOpportunity>) result
				.get(SPGetAllFundingOpportunities.RESULT_SET);

		for (FundingOpportunity fundingOpportunity : fundingOpportunityList) {

			fundingOpportunity
					.setDirectorateList(getDirectorates(fundingOpportunity
							.getFundingOpportunityId()));

		}

		return fundingOpportunityList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Division> getDivisions(String pgmAnncID) {
		SPGetDivisions sPGetDivisions = new SPGetDivisions(
				psmFLJdbcTemplate.getDataSource(),
				SPGetDivisions.STORED_PROC_GET_DIVISIONS_LIST);

		Map<String, Object> result = sPGetDivisions.execute(pgmAnncID);

		List<Division> divisionsList = (List<Division>) result
				.get(SPGetDivisions.RESULT_SET);

		//setting program element code list for each division
		for (Division division : divisionsList) {

			division.setProgramElementList(getProgramElements(pgmAnncID,
					division.getDivisionCode()));

		}

		return divisionsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Directorate> getAllDirectorates() {
		System.out.println("ProposalDaoImpl.getAllDirectorates()");
		SPGetAllDirectorates sPGetAllDirectorates = new SPGetAllDirectorates(
				psmFLJdbcTemplate.getDataSource(),
				SPGetAllDirectorates.STORED_PROC_GET_ALL_DIRECTORATES);

		Map<String, Object> result = sPGetAllDirectorates.execute();

		List<Directorate> directorateList = (List<Directorate>) result
				.get(SPGetAllDirectorates.RESULT_SET);

		return directorateList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgramElement> getProgramElements(String pgmAnncID,
			String divisionCode) {
		SPGetProgramElement sPGetProgramElement = new SPGetProgramElement(
				psmFLJdbcTemplate.getDataSource(),
				SPGetProgramElement.STORED_PROC_GET_PROGRAMELEMENT_LIST);

		Map<String, Object> result = sPGetProgramElement.execute(pgmAnncID,
				divisionCode);

		List<ProgramElement> sPGetProgramElementList = (List<ProgramElement>) result
				.get(SPGetProgramElement.RESULT_SET);

		return sPGetProgramElementList;
	}

	@SuppressWarnings("unchecked")
	private List<Directorate> getDirectorates(String pgmAnncID) {

		SPGetDirectorates sPGetDirectorates = new SPGetDirectorates(
				psmFLJdbcTemplate.getDataSource(),
				SPGetDirectorates.STORED_PROC_GET_DIRECTORATE_LIST);

		Map<String, Object> result = sPGetDirectorates.execute(pgmAnncID);

		List<Directorate> directorateList = (List<Directorate>) result
				.get(SPGetDirectorates.RESULT_SET);

		return directorateList;

	}

}
