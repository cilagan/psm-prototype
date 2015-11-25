package gov.nsf.research.document.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

	@RequestMapping(path="/upload" )
	public String displayUploadForm(){
		return "upload_form";
	}
}
