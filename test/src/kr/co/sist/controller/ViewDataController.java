package kr.co.sist.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.service.TestService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;;

@Controller
public class ViewDataController {

	/**
	 * View명과 데이터를 한 번에 관리하는 클래스인
	 * ModelandView의 사용법
	 * @return
	 */
	@RequestMapping(value="view/use_modelandview.do", method=GET )
	public ModelAndView useModelAndView() {
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("view/use_mav"); //view설정 viewResolver를 사용한 이동
		
		TestService ts=new TestService(); //업무처리
		List<String> data=ts.search();//업무처리 결과 받기
		
		//view로 전달할 데이터 설정
		mav.addObject("view_data",data);
		mav.addObject("name_data","차예린,이혜민,장은혜,김도연");
		
		return mav;
	}//useModelAndView
	
	@RequestMapping(value="view/use_model.do", method=GET)
	public String useModel(Model m) {
		
		TestService ts=new TestService();
				
		m.addAttribute("date",new Date());//request scope객체에 설정
		m.addAttribute("subject",ts.subjectList());//request scope객체에 설정
		
		
		System.out.println(m);
		return "view/use_model";
	
	}//useModel
	
}
