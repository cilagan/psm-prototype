package gov.nsf.research.document.service.dao;


import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;


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
	
	public ByteArrayOutputStream viewDocument(String tempPropId, SectionType sectionType);
	
	/**
	 * 
	 * @param tempPropId
	 */
	
	public void viewEntireProposal(String tempPropId);
	
	/**
	 * 
	 * @param tempPropId
	 * @return
	 */
	
	public ByteArrayOutputStream viewDMP(String tempPropId);
	
	
	/**
	 * 
	 * @param tempPropId
	 * @return
	 */
	
	public ByteArrayOutputStream viewProjectDesc(String tempPropId);
	
	
	
	
}
