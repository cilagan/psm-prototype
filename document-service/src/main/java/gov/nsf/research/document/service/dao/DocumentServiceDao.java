package gov.nsf.research.document.service.dao;


import java.io.InputStream;
import java.io.OutputStream;

import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;


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
	
	public OutputStream viewDocument(String tempPropId, SectionType sectionType);
	
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
	
	public OutputStream viewDMP(String tempPropId);
	
	
	/**
	 * 
	 * @param tempPropId
	 * @return
	 */
	
	public OutputStream viewProjectDesc(String tempPropId);
	
	
	
	
}
