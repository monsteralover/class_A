package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncludeController {

	@RequestMapping(value="use_include.do", method=RequestMethod.GET)
	public String testInclude() {
		
		return "include/include_a";
	}
	
	@RequestMapping(value="use_include_c.do", method=RequestMethod.GET)
	public String testInclude1(Model model) {
		
		String[] data= {"Java","Oracle","JSP","Spring"};//诀公贸府搬苞肺 积己等 单捞磐
		model.addAttribute("controller_data",data);
		
		return "include/include_c";
	}
	
	
	
}
