package gov.nsf.research.document.service.dao;

import gov.nsf.research.document.service.model.DocumentMetaData;

public interface MetaDataServiceDao {
	
	/**
	 * 
	 * @param documentMetaData
	 */
	public void saveDocumentMetaData(DocumentMetaData documentMetaData);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public DocumentMetaData viewDocumentMetaData(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean deleteDocumentMetaData(String key);
	
	//TODO: where is this method? ---> public List<DocumentMetaData> getAllDocs()
}
