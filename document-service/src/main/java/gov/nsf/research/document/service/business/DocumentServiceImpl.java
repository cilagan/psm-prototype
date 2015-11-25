package gov.nsf.research.document.service.business;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.repository.ProjectDescRepository;

public class DocumentServiceImpl implements DocumentService {

	@Autowired
	ProjectDescRepository pdr;
	
	@Override
	public DocumentMetaData uploadPropSection(ByteArrayInputStream inputStream, String tempPropId, SectionType sectionType) {
		return null;
	}

	@Override
	public ByteArrayOutputStream getPropSection(String tempPropId, SectionType sectionType) {
		return pdr.getProjDescDocument();
	}

	@Override
	public ByteArrayOutputStream getEntirePropSection(String tempPropId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
