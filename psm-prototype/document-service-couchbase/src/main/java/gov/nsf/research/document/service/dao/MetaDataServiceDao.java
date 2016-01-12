package gov.nsf.research.document.service.dao;

import java.util.List;

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
	
	/**
	 * 
	 * @return
	 */
	public List<DocumentMetaData> getAllDocs();
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean isDocExist(String key);
}
