package gov.nsf.research.document.service.dao;

import java.util.List;

import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

public interface DocMetaDataDao {

	/**
	 * Saves document meta data
	 * @param docMetaData
	 * @return
	 */
	public boolean saveMetaData(DocumentMetaData docMetaData);
	
	/**
	 * Gets meta data documents
	 * @param tempPropId
	 * @param sectionType
	 * @return
	 */
	public List<DocumentMetaData> getMetaData(String tempPropId, SectionType sectionType);
	
	/**
	 * Updates meta data for documents
	 * @param docMetaData
	 * @param sectionType
	 * @param seqNum
	 * @return
	 */
	public boolean updateMetaData(DocumentMetaData docMetaData, SectionType sectionType, int seqNum);
	
	/**
	 * Deletes meta data
	 * @param docMetaData
	 * @param sectionType
	 * @param seqNum
	 * @return
	 */
	public boolean deleteMetaData(DocumentMetaData docMetaData, SectionType sectionType, int seqNum);
	
	/**
	 * Retrieves all meta data saved
	 * @return
	 */
	public List<DocumentMetaData> getAllDocs();
}
