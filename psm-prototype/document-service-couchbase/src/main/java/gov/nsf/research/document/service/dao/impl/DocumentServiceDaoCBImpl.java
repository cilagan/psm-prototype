package gov.nsf.research.document.service.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.data.couchbase.core.CouchbaseTemplate;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.model.document.User;


public class DocumentServiceDaoCBImpl implements  DocumentServiceDao {
	
	CouchbaseTemplate couchBaseTemplate;
	
	
	public DocumentServiceDaoCBImpl(CouchbaseTemplate couchBaseTemplate){
		this.couchBaseTemplate = couchBaseTemplate;
	}


	@Override
	public DocumentMetaData saveDocument(InputStream inputStream, String tempPropId, SectionType sectionType) {
		User user = new User("3", "Suresh", "Pendyala");
		couchBaseTemplate.insert(user);
		System.out.println(couchBaseTemplate.findById("3", User.class).toString());
		return null;
	}


	@Override
	public ByteArrayOutputStream viewDocument(String tempPropId, SectionType sectionType) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Document> viewAllFilesFromDB() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isDocumentExists(String tempPropId, SectionType sectionType) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void deleteDocument(String tempPropId, SectionType sectionType) {
		// TODO Auto-generated method stub
		
	}	
}
