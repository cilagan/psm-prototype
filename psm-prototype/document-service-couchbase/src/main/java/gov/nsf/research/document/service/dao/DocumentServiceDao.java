package gov.nsf.research.document.service.dao;


import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


public interface DocumentServiceDao{
	
	/**
	 * 
	 * @param inputStream
	 * @param tempPropId
	 * @param sectionType
	 * @return documentMedaData
	 */
	public  DocumentMetaData saveDocument(InputStream inputStream, String tempPropId, SectionType sectionType);
	
	/**
	 * 
	 * @param tempPropId
	 * @param sectionType
	 * @return outputStream
	 */
	
	public ByteArrayOutputStream viewDocument(String tempPropId, SectionType sectionType, int seqNum);
	
	/**
	 * 
	 * @param tempPropId
	 * @param sectionType
	 * @return
	 */
	public boolean isDocumentExists (String tempPropId, SectionType sectionType, int seqNum) ;
	
	
		
	/**
	 * 
	 * @param tempPropId
	 * @param sectionType
	 * @return
	 */
	public void deleteDocument(String tempPropId, SectionType sectionType, int seqNum);
	
	
	
}
