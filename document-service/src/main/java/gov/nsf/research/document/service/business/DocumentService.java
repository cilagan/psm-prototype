package gov.nsf.research.document.service.business;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

public interface DocumentService {

	public DocumentMetaData uploadPropSection(ByteArrayInputStream inputStream, String tempPropId, SectionType sectionType);
	public ByteArrayOutputStream getPropSection(String tempPropId, SectionType sectionType);
	public ByteArrayOutputStream getEntirePropSection(String tempPropId);
	
}
