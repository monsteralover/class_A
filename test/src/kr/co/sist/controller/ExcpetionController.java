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
	public String work(Model model) throws /* Exception, */NumberFormatException {// @ExceptionHandler�� ����Ǿ� ���� �ʴٸ� springframework���� ���ܸ� ó��
		
		/*
		 * if(new Random().nextBoolean()) { throw new Exception("��ȸ�� �Ÿ��α� 2�ܰ� ����");
		 * }//end if
		 */		
		
		if(new Random().nextBoolean()) {
			throw new NumberFormatException("�������˿���");
		}//end if
		
		model.addAttribute("data","SK Kim,YB Song,���� ��, ���� ��, ���� ��");
		
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
