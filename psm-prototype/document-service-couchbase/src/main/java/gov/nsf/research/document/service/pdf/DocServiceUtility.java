package gov.nsf.research.document.service.pdf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
	
	public static List<DocumentMetaData>extractDocMetaDataFromFileName(List<String> fileList){
		List<DocumentMetaData> docMetaDataList = new ArrayList<DocumentMetaData>();
		
		for(String fileName : fileList){
			DocumentMetaData docMetaData = new DocumentMetaData();
			StringTokenizer st = new StringTokenizer(fileName, "-");
			String tempPropId = (String)st.nextElement();
			String restOfFileName = (String)st.nextElement();
			docMetaData.setTempPropId(tempPropId);
			StringTokenizer st2 = new StringTokenizer(restOfFileName, ".");
			String sectionType = (String)st2.nextElement();
			System.out.println(sectionType);
			docMetaData.setSectionType(SectionType.getSectionType(sectionType));
			System.out.println(docMetaData.toString());
			docMetaDataList.add(docMetaData);
		}
		
		return docMetaDataList;
	}
}
