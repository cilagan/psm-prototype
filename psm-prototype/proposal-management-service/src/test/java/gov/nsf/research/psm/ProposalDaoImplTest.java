package gov.nsf.research.psm;

import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.model.FundingOpportunity;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:nr-business-context-TEST.xml")
public class ProposalDaoImplTest {
	
	@Autowired
	ProposalDao proposalDao;
	
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testviewDocument(){

	List<FundingOpportunity> fundingOpportunityList =proposalDao.getAllFundingOpportunities();
	System.out.println(fundingOpportunityList.size());
	
	}
	
	
	
	
}
