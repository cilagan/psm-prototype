package gov.nsf.research.document.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.document.User;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
//@WebAppConfiguration
public class DocumentServiceApplicationTests {
	
	@Autowired
	CouchbaseTemplate couchBaseTemplate;
	
	@Autowired
	DocumentServiceDao docServiceDao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testInsert(){
		User user = new User("2", "Carlo", "Ilagan");
		couchBaseTemplate.insert(user);
		System.out.println(couchBaseTemplate.findById("2", User.class).toString());
	}
	
	@Test
	public void testSaveDocument(){
		docServiceDao.saveDocument(null, null, null);
	}
}
