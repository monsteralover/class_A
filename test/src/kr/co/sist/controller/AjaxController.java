package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.service.AjaxService;

@Controller
public class AjaxController {

//	@RequestMapping(value="/use_responsebody.do",method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String testAjax() {
//		//JSONObect 받기
//		AjaxService as= new AjaxService();
//		String json=as.createJson(); 
//		System.out.println("dd");
//		return json;
//	}//testAjax
	
	@RequestMapping(value="/use_responsebody.do", method=RequestMethod.GET)
	public String testAjax(Model model) {
		//JSONObect 받기
		AjaxService as= new AjaxService();
		String json=as.createJson(); 
		model.addAttribute("json",json);
		
		return "ajax/output_json";
	}

	
}
