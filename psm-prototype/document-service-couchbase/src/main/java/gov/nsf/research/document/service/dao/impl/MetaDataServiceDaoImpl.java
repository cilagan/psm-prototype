package gov.nsf.research.document.service.dao.impl;

import java.util.List;

import org.springframework.data.couchbase.core.CouchbaseTemplate;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.java.query.SimpleN1qlQuery;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;

import gov.nsf.research.document.service.dao.MetaDataServiceDao;
import gov.nsf.research.document.service.model.DocumentMetaData;

public class MetaDataServiceDaoImpl implements MetaDataServiceDao {
	
	CouchbaseTemplate couchBaseTemplate;
	
	
	public MetaDataServiceDaoImpl(CouchbaseTemplate couchBaseTemplate){
		this.couchBaseTemplate = couchBaseTemplate;
	}


	@Override
	public void saveDocumentMetaData(DocumentMetaData documentMetaData) {
		System.out.println("**saveDocumentMetaData"+documentMetaData.toString());
		couchBaseTemplate.insert(documentMetaData);
		

	}

	@Override
	public DocumentMetaData viewDocumentMetaData(String key) {

		DocumentMetaData documentMetaData = couchBaseTemplate.findById(key,
				DocumentMetaData.class);
		System.out.println("**viewDocumentMetaData"+documentMetaData.toString());

		return documentMetaData;

	}

	@Override
	public boolean deleteDocumentMetaData(String key) {
		System.out.println("**deleteDocumentMetaData"+key);
		couchBaseTemplate.remove(key);
		return true;
	}


    @Override
    public List<DocumentMetaData> getAllDocs() {
        // TODO Auto-generated method stub
    	CouchbaseClient client =  couchBaseTemplate.getCouchbaseClient();
    	SimpleN1qlQuery query = SimpleN1qlQuery.simple("SELECT * FROM default");  	
//    	View view = client.getView("_design/view_all", "view_all");
    	Query query1 = new Query();
    	List<DocumentMetaData> docMetaList = couchBaseTemplate.findByView("_design/view_all", "view_all", new Query(), DocumentMetaData.class);
    	
    	for(DocumentMetaData dmd : docMetaList){
    		System.out.println(dmd.toString());
    	}
    	
        return null;
    }


    @Override
    public boolean isDocExist(String key) {
        return couchBaseTemplate.exists(key);
    }


}
