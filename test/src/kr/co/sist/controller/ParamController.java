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
 * web�� �Ķ���� �ޱ�
 * @author sist26
 *
 */
@Controller
public class ParamController {

	/**
	 * Java EE���� �����ϴ� HttpServletRequest�� ����� web parameter ó��
	 * @return
	 *
	 */
	//http://localhost/spring_mvc_template/param/use_request.do?name=������&age=25&job=������
	@RequestMapping(value="/param/use_request.do", method=GET)
	public String useHttpServletRequest(HttpServletRequest request) {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		System.out.println(request.getParameter("job"));
		
		return "param/request_result";
	}//useHttpServletRequest
	
	/**
	 * method Parameter�� ����� web parameter ó��
	 * ����!! HTML Form Control�� �̸��� parameter�� �̸��� �ݵ�� ���ƾ� �Ѵ�.
	 * 
	 * web�� parameter ���������� ���ڿ������� parameter�� ������ �����ϸ� �˾Ƽ� ����ȯ���ش�.
	 * Spring framework�� ����ȯ�Ͽ� ���� �־��ش�.
	 * 
	 * HTML Form Control�� �̸��� parameter�� �̸��� �ٸ��� null���´�.
	 * @return
	 */     
	@RequestMapping(value="/param/use_variable.do", method=GET)
	public String useVariable(String name, String age, String job) {
		System.out.println(name+"/"+age+"/"+job);
		return "param/variable_result";
	}
	
	/**
	 * VO�� ����Ͽ� web�� �Ķ���� ó��
	 * @param pVO
	 * @return
	 */
	@RequestMapping(value="/param/use_vo.do", method=GET)
	public String useVO(ParamVO pVO) {
		System.out.println(pVO);
		
		return "param/vo_result";
	}//useVO
	
	/**
	 * post����� ó��
	 * ��û����� ���� ������ 405���� �߻�
	 * @param ppVO
	 * @return
	 */
	@RequestMapping(value="/param/post_param.do", method=POST)
	public String usePostParam(PostParamVO ppVO) {
		
		return "param/post_result";
	}//usePostParam
	
	
}//class
