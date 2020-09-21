

package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
@Controller
public class UseController {

	@RequestMapping( value="/redirect_jsp.do", method=GET)
	public String redirectJsp() {
		
		return "redirect:http://localhost/spring_mvc_template/day0826/redirect.jsp";
		//return "redirect.jsp";//view Resolver( prefix(WEB-INF/views), suffix(.jsp) )�� ����� forward ����� �̵�
		//=>WEB-INF/views/redirect.jsp.jsp=>404
	}//redirectJsp
	
	
	@RequestMapping(value="/redirect_html.do", method=GET)
	public String redirectHTML() {
		
		return "redirect:http://localhost/spring_mvc_template/day0826/redirect.html";
		//return "redirect.jsp";//view Resolver( prefix(WEB-INF/views), suffix(.jsp) )�� ����� forward ����� �̵�
		//=>WEB-INF/views/redirect.jsp.jsp=>404
	}//redirectHTML
	
	/**
	 * ��ó�� ����
	 * @return
	 */
	@RequestMapping(value="/pre.do", method=GET)
	public String job1() {
		
		return "forward:final.do";//forward:�� ���̸� view resolver�� ��Ÿ�� �ش� URI�� �ٷΰ�. 
		//�ٸ� .do�� �����Ͽ� ȣ���� �� �ִ�.
	}//job1
	
	
	/**
	 * ���� �̵� ����
	 * @return
	 */
	@RequestMapping(value="final.do", method=GET)
	public String job2() {
		
		return "final_service"; 
	}//job2
	
}//class
