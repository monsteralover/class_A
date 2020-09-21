package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;;

/*
 * HandlerMapper�� ã�� �� �ֵ��� Ŭ���� ���� @Controller �� �����Ѵ�.
 * @author sist26
 *
 */
@Controller
public class Hello {

	//��û url�� ó���� �� �ִ� method ����
	@RequestMapping(value="/hello.do", method=GET  )
	public String helloRequest() {
		System.out.println("HelloRequest() ȣ��");
		return "hello";//view resolver�� prefix�� WEB-INF/views�� ���̰� suffix�� .jsp�� �ٿ� ã�´�.
	}//helloRequest
	/**get����� ��ûó�� method
	 * @return
	 */
	@	RequestMapping(value="/get.do",method=GET)
	public String getMethod() {
		
	return "get";
	}//getMethod
	
	/**post����� ��ûó�� method
	 * @return
	 */
	@	RequestMapping(value="/post.do",method=POST)
	public String postMethod() {
		
		return "post";
	}//postMethod
	
	
	/**get, post����� ��ûó�� method
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
