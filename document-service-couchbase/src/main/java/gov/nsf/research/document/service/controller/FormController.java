package gov.nsf.research.document.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gov.nsf.research.document.service.dao.FileStoreDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.DocServiceUtility;

@Controller
public class FormController {

	@Autowired
	FileStoreDao fileStoreDao;
	
	public final String PD_KEY = "-pd";
	public final String DMP_KEY = "-dmp";
	
	@RequestMapping(path="/upload" )
	public String displayUploadForm(Model model){
		List<DocumentMetaData> pdList = new ArrayList<DocumentMetaData>();
		List<DocumentMetaData> dmpList = new ArrayList<DocumentMetaData>();
		List<String> propList = new ArrayList<String>();
		Map<String, DocumentMetaData> propMap = new HashMap<String, DocumentMetaData>();
		
		List<DocumentMetaData> tempList = DocServiceUtility.extractDocMetaDataFromFileName(fileStoreDao.getAllFileNames());
		
		for(DocumentMetaData doc : tempList){
			if(SectionType.PROJECT_DESCRIPTION.equals(doc.getSectionType())){
				pdList.add(doc);
				propMap.put(doc.getTempPropId() + PD_KEY, doc);
			} else if(SectionType.DATA_MANAGEMENT_PLAN.equals(doc.getSectionType())) {
				dmpList.add(doc);
				propMap.put(doc.getTempPropId() + DMP_KEY, doc);
			}
			
			if(propMap.containsKey(doc.getTempPropId() + PD_KEY) && propMap.containsKey(doc.getTempPropId() + DMP_KEY)){
				propList.add(doc.getTempPropId());
			}
		}
		
		System.out.println(propMap.toString());
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("dmpList", dmpList);
		model.addAttribute("propList", propList);
		
		return "upload_form";
	}
}
