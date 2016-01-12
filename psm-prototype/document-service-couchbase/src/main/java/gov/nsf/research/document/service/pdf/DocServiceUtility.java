package gov.nsf.research.document.service.pdf;

import java.io.InputStream;

import org.joda.time.LocalDate;

import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

public class DocServiceUtility {

	public static DocumentMetaData assembleMetaData(InputStream inputStream, String tempPropId, SectionType sectionType) throws Exception {
		
		DocumentMetaData docMetaData = new DocumentMetaData();
		docMetaData.setTempPropId(tempPropId);
		docMetaData.setSectionType(sectionType);
		docMetaData.setId(getKey(tempPropId, sectionType));
		docMetaData.setFileName(getFileName(tempPropId, sectionType));
		docMetaData.setSize(new Long(inputStream.available()));
		docMetaData.setUploadDate(new LocalDate().toDate());
		
		//PDFUtility.extractMetaData(inputStream, docMetaData);
		
		return docMetaData;
	}
	
	public static String getKey(String tempPropId, SectionType sectionType){
		return tempPropId + "-" + sectionType;
	}
	
	public static String getFileName(String tempPropId, SectionType sectionType){
		return tempPropId + "-" + sectionType + ".pdf";
	}
	
}
