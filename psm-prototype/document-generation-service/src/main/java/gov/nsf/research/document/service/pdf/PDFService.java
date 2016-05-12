package gov.nsf.research.document.service.pdf;

import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;

public interface PDFService {
	
	/**
	 * 
	 * @param sectionType
	 * @param tempPropId
	 * @return
	 */

	public ByteArrayOutputStream createPDF(SectionType sectionType,	String tempPropId);
	
	/**
	 * 
	 * @param tempPropId
	 * @return
	 */

	public ByteArrayOutputStream CreateEntireProposalPDF(String tempPropId);

	
	/**
	 * 
	 * @param srcDocStream
	 * @param sectionType
	 * @return
	 */
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, SectionType sectionType);

	/**
	 * 
	 * @param srcDocStream
	 * @param sectionType
	 * @param stampText
	 * @return
	 */
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream,	SectionType sectionType, String stampText);

}
