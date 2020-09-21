package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpSession�� ���� �����ϰų�, ���� ��� ��
 * @author sist26
 *
 */
//@SessionAttributes(user_id)//�� �� ����, ������ ������ �迭
@SessionAttributes({"user_id","login_time"})
@Controller
public class SessionController {

	@RequestMapping(value="set_session_value.do", method=GET )
	public String sessionValue(String id, Model model) {
		String url="session/use_session_value";
		
		model.addAttribute("user_id",id);//request(model), session(@sessionAttribute) scope�� �߰���
		model.addAttribute("login_time",System.currentTimeMillis());//request()
		
		return url;
	}//sessionValue
	
	@RequestMapping(value="get_session_value.do", method=GET)
	//HttpSession�� �Ű������� ����� ���� �� ���
	public String getSessionValue(HttpSession session) {
		String url="redirect:day0828/use_session.html"; //������ ���� �� ������ ������
		
		//���� ���
		String id=(String)session.getAttribute("user_id");
		
		if(id != null) {//���ǿ� ���� ���� �� ������ �д� ������
			System.out.println("��������"+id);
			url="session/use_session_value";
		}//end if
		System.out.println(url);
		return url;
	}//getSessionValue
	
	@RequestMapping(value="remove_session.do",method=GET )
	public String removeSession(SessionStatus ss) {
		ss.setComplete();
		System.out.println("���ǻ���");
		
		return "redirect:day0828/use_session.html";
	}
//	public String removeSession(HttpSession ss) {
//		ss.removeAttribute("user_id");
//		ss.removeAttribute("login_time");
//		ss.invalidate();
//		
//		return "redirect:day0828/use_session.html";
//	}//removeSession
//HttpSession�� ������ ���� ���� �Ұ�
	

	//HttpServletRequest�� �Ű������� ����� ���� �� ���
//	public String getSessionValue(HttpServletRequest request) {
//		String url="redirect:day0828/use_session.html"; //������ ���� �� ������ ������
//		
//		//���� ���
//		HttpSession session=request.getSession();
//		String id=(String)session.getAttribute("user_id");
//		
//		if(id != null) {//���ǿ� ���� ���� �� ������ �д� ������
//			url="session/use_session_value";
//			System.out.println("��������"+id);
//		}//end if
//		System.out.println(url);
//		return url;
//	}//getSessionValue
	@RequestMapping(value="/set_cookie_value.do", method=GET)
	//1 HttpServletResponse�� �Ű������� ����
	public String setCookie(HttpServletResponse response) {
		String url="session/cookie_result";
		
		//2��Ű ����
		Cookie timeCookie =new Cookie("conn_time", String.valueOf(System.currentTimeMillis()));
		Cookie nickCookie= new Cookie("nick","officemart");
		
		timeCookie.setMaxAge(60*60);
		nickCookie.setMaxAge(60*60);
		
		//3��Ű �ɱ�
		response.addCookie(timeCookie);
		response.addCookie(nickCookie);
		
		return url;
	}//setCookie
	
//	@RequestMapping(value="/read_cookie_value.do", method = GET)
//	//1HttpServletRequest �Ű����� ����
//	public String readCookie(HttpServletRequest request, Model model) {
//		//2��Ű�� �б�
//		Cookie[] cookies= request.getCookies();
//		//3�о���� ��Ű�� �����ϸ�
//		if(cookies !=null) {
//			for(Cookie temp: cookies) {
//				if("conn_time".equals(temp.getName())) {
//					model.addAttribute("time",temp.getValue());
//					
//				}//end if
//				System.out.println("��Ű��"+temp.getValue());
//			}//end for
//		}//end if
//		
//		return"session/read_cookie";
//	}//readCookie
	@RequestMapping(value="/read_cookie_value.do", method=GET)
	public String readCookie(@CookieValue(value="conn_time", defaultValue="0") String time, Model model) {
		System.out.println("annotation cookie value"+time);
		model.addAttribute("time",time);
		return "session/read_cookie";
	}

}//class

