

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
		//return "redirect.jsp";//view Resolver( prefix(WEB-INF/views), suffix(.jsp) )를 사용한 forward 방식의 이동
		//=>WEB-INF/views/redirect.jsp.jsp=>404
	}//redirectJsp
	
	
	@RequestMapping(value="/redirect_html.do", method=GET)
	public String redirectHTML() {
		
		return "redirect:http://localhost/spring_mvc_template/day0826/redirect.html";
		//return "redirect.jsp";//view Resolver( prefix(WEB-INF/views), suffix(.jsp) )를 사용한 forward 방식의 이동
		//=>WEB-INF/views/redirect.jsp.jsp=>404
	}//redirectHTML
	
	/**
	 * 전처리 서비스
	 * @return
	 */
	@RequestMapping(value="/pre.do", method=GET)
	public String job1() {
		
		return "forward:final.do";//forward:를 붙이면 view resolver를 안타고 해당 URI로 바로감. 
		//다른 .do를 연결하여 호출할 수 있다.
	}//job1
	
	
	/**
	 * 최종 이동 서비스
	 * @return
	 */
	@RequestMapping(value="final.do", method=GET)
	public String job2() {
		
		return "final_service"; 
	}//job2
	
}//class
