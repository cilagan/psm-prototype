package gov.nsf.research.document.dao;


import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.model.proposal.ProjectSummary;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
@WebAppConfiguration
public class ProposalDaoImplTest {

	@Autowired
	ProposalDao proposalDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetProjectSummary() {

	ProjectSummary ps =	proposalDao.getProjectSummary("0000251");
	
	System.out.println("Test getOverView:"+ps.getOverView());
	System.out.println("Test getBrodrImpt:"+ps.getBrodrImpt());
	System.out.println("Test getIntulMerit:"+ps.getIntulMerit());

	}
	
	@Test
	public void testsaveProjectSummary() {

    proposalDao.saveProjectSummary("0000251", "overView", "intulMerit", "brodrImpt");
	
	

	}

	
	
	
	
	

}