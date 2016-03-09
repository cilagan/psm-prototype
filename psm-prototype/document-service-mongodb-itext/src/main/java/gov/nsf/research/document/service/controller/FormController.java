package gov.nsf.research.document.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.SectionType;

@Controller
public class FormController {

	@Autowired
	DocumentServiceDao docServiceDao;

	public final String PD_KEY = "-pd";
	public final String DMP_KEY = "-dmp";
	public final String MENT_KEY = "-ment";
	public final String CAPS_KEY = "-caps";
	public final String BS_KEY = "-bs";

	@RequestMapping(path="/upload" )
	public String displayUploadForm(Model model){
		List<Document> pdList = new ArrayList<Document>();
		List<Document> dmpList = new ArrayList<Document>();
		List<Document> mentList = new ArrayList<Document>();
		List<Document> capsList = new ArrayList<Document>();
		List<Document> bsList = new ArrayList<Document>();

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
			else if(SectionType.BIO_SKETCHES.equals(doc.getSectionType())) {
				bsList.add(doc);
				propMap.put(doc.getTempPropId() + BS_KEY, doc);
			}
			else if(SectionType.CURR_PEND_SUPPORT.equals(doc.getSectionType())) {
				capsList.add(doc);
				propMap.put(doc.getTempPropId() + CAPS_KEY, doc);
			}
			else if(SectionType.MENTOR_PLAN.equals(doc.getSectionType())) {
					mentList.add(doc);
					propMap.put(doc.getTempPropId() + MENT_KEY, doc);
			}

			if(propMap.containsKey(doc.getTempPropId() + PD_KEY) && propMap.containsKey(doc.getTempPropId() + DMP_KEY)
					&& propMap.containsKey(doc.getTempPropId() + BS_KEY)
					&&  propMap.containsKey(doc.getTempPropId() + CAPS_KEY)
					&& propMap.containsKey(doc.getTempPropId() + MENT_KEY)){
				propList.add(doc.getTempPropId());
			}
		}

		//System.out.println(propMap.toString());

		model.addAttribute("pdList", pdList);
		model.addAttribute("dmpList", dmpList);
		model.addAttribute("mentList", mentList);
		model.addAttribute("capsList", capsList);
		model.addAttribute("bsList", bsList);
		model.addAttribute("propList", propList);

		return "upload_form";
	}
}
