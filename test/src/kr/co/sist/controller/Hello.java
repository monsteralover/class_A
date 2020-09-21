package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;;

/*
 * HandlerMapper가 찾을 수 있도록 클래스 위에 @Controller 을 정의한다.
 * @author sist26
 *
 */
@Controller
public class Hello {

	//요청 url을 처리할 수 있는 method 선언
	@RequestMapping(value="/hello.do", method=GET  )
	public String helloRequest() {
		System.out.println("HelloRequest() 호출");
		return "hello";//view resolver가 prefix로 WEB-INF/views를 붙이고 suffix로 .jsp를 붙여 찾는다.
	}//helloRequest
	/**get방식의 요청처리 method
	 * @return
	 */
	@	RequestMapping(value="/get.do",method=GET)
	public String getMethod() {
		
	return "get";
	}//getMethod
	
	/**post방식의 요청처리 method
	 * @return
	 */
	@	RequestMapping(value="/post.do",method=POST)
	public String postMethod() {
		
		return "post";
	}//postMethod
	
	
	/**get, post방식의 요청처리 method
	 * @return
	 */
	@	RequestMapping(value="/get_post.do",method= {GET,POST})
	public String get_postMethod() {
		
		return "get_post";
	}//postMethod
	
	
	@	RequestMapping(value= {"/a.do", "/b.do", "/c.do"}, method= GET)
	public String multiRequest() {
		
		return "multi_request";
	}//postMethod
	
	
	
	
}//class
