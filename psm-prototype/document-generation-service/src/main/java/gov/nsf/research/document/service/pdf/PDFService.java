package gov.nsf.research.document.service.pdf;




import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;

public interface PDFService {
	
	
	public ByteArrayOutputStream createPDF(SectionType  sectionType , String tempPropId);
	
	public ByteArrayOutputStream CreateEntireProposalPDF(String tempPropId);
	
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, SectionType sectionType);
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, SectionType sectionType,String stampText);
	
	
}
