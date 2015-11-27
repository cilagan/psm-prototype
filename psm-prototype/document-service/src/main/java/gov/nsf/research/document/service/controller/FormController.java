package gov.nsf.research.document.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.SectionType;

@Controller
public class FormController {

	@Autowired
	DocumentServiceDao docServiceDao;
	
	public final String PD_KEY = "-pd";
	public final String DMP_KEY = "-dmp";
	
	@RequestMapping(path="/upload" )
	public String displayUploadForm(Model model){
		List<Document> pdList = new ArrayList<Document>();
		List<Document> dmpList = new ArrayList<Document>();
		List<String> propList = new ArrayList<String>();
		Map<String, Document> propMap = new HashMap<String, Document>();
		
		List<Document> tempList = docServiceDao.viewAllFilesFromDB();
		
		for(Document doc : tempList){
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
	
	@RequestMapping(path="/redirect" )
	public void redirectUpload(MultipartHttpServletRequest request, HttpServletResponse response, @RequestParam String tempPropId, @RequestParam String sectionType) throws Exception{
		
		String url = "/docService/proposal/"+ tempPropId + "/" + sectionType;
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
