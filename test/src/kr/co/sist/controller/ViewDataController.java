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
	 * View��� �����͸� �� ���� �����ϴ� Ŭ������
	 * ModelandView�� ����
	 * @return
	 */
	@RequestMapping(value="view/use_modelandview.do", method=GET )
	public ModelAndView useModelAndView() {
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("view/use_mav"); //view���� viewResolver�� ����� �̵�
		
		TestService ts=new TestService(); //����ó��
		List<String> data=ts.search();//����ó�� ��� �ޱ�
		
		//view�� ������ ������ ����
		mav.addObject("view_data",data);
		mav.addObject("name_data","������,������,������,�赵��");
		
		return mav;
	}//useModelAndView
	
	@RequestMapping(value="view/use_model.do", method=GET)
	public String useModel(Model m) {
		
		TestService ts=new TestService();
				
		m.addAttribute("date",new Date());//request scope��ü�� ����
		m.addAttribute("subject",ts.subjectList());//request scope��ü�� ����
		
		
		System.out.println(m);
		return "view/use_model";
	
	}//useModel
	
}
