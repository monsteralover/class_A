package kr.co.sist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.vo.ParamVO;
import kr.co.sist.vo.PostParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;;
/**
 * web의 파라미터 받기
 * @author sist26
 *
 */
@Controller
public class ParamController {

	/**
	 * Java EE에서 제공하는 HttpServletRequest를 사용한 web parameter 처리
	 * @return
	 *
	 */
	//http://localhost/spring_mvc_template/param/use_request.do?name=박형근&age=25&job=개발자
	@RequestMapping(value="/param/use_request.do", method=GET)
	public String useHttpServletRequest(HttpServletRequest request) {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		System.out.println(request.getParameter("job"));
		
		return "param/request_result";
	}//useHttpServletRequest
	
	/**
	 * method Parameter를 사용한 web parameter 처리
	 * 주의!! HTML Form Control의 이름과 parameter의 이름이 반드시 같아야 한다.
	 * 
	 * web의 parameter 데이터형은 문자열이지만 parameter를 정수로 선언하면 알아서 형변환해준다.
	 * Spring framework가 형변환하여 값을 넣어준다.
	 * 
	 * HTML Form Control의 이름과 parameter의 이름이 다르면 null나온다.
	 * @return
	 */     
	@RequestMapping(value="/param/use_variable.do", method=GET)
	public String useVariable(String name, String age, String job) {
		System.out.println(name+"/"+age+"/"+job);
		return "param/variable_result";
	}
	
	/**
	 * VO를 사용하여 web의 파라미터 처리
	 * @param pVO
	 * @return
	 */
	@RequestMapping(value="/param/use_vo.do", method=GET)
	public String useVO(ParamVO pVO) {
		System.out.println(pVO);
		
		return "param/vo_result";
	}//useVO
	
	/**
	 * post방식의 처리
	 * 요청방식이 맞지 않으면 405에러 발생
	 * @param ppVO
	 * @return
	 */
	@RequestMapping(value="/param/post_param.do", method=POST)
	public String usePostParam(PostParamVO ppVO) {
		
		return "param/post_result";
	}//usePostParam
	
	
}//class
