package kr.co.sist.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcpetionController {

	
	@RequestMapping(value="/use_exception.do")
	public String work(Model model) throws /* Exception, */NumberFormatException {// @ExceptionHandler가 선언되어 있지 않다면 springframework에서 예외를 처리
		
		/*
		 * if(new Random().nextBoolean()) { throw new Exception("사회적 거리두기 2단계 예외");
		 * }//end if
		 */		
		
		if(new Random().nextBoolean()) {
			throw new NumberFormatException("숫자포맷예외");
		}//end if
		
		model.addAttribute("data","SK Kim,YB Song,도연 김, 민정 김, 예린 차");
		
		return "exception/work_view";
	}//work
	
	//@ExceptionHandler(Exception.class)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView workExceptionProcess(Exception e) {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("exception/exception_view");
		mav.addObject("except1",e.getMessage());
		mav.addObject("except2",e);
		
		return mav;
	}//workException
	
}
