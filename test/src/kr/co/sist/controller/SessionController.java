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
 * HttpSession에 값을 설정하거나, 값을 얻는 일
 * @author sist26
 *
 */
//@SessionAttributes(user_id)//한 개 설정, 여러개 설정은 배열
@SessionAttributes({"user_id","login_time"})
@Controller
public class SessionController {

	@RequestMapping(value="set_session_value.do", method=GET )
	public String sessionValue(String id, Model model) {
		String url="session/use_session_value";
		
		model.addAttribute("user_id",id);//request(model), session(@sessionAttribute) scope에 추가됨
		model.addAttribute("login_time",System.currentTimeMillis());//request()
		
		return url;
	}//sessionValue
	
	@RequestMapping(value="get_session_value.do", method=GET)
	//HttpSession을 매개변수로 사용한 세션 값 사용
	public String getSessionValue(HttpSession session) {
		String url="redirect:day0828/use_session.html"; //세션이 없을 때 설정할 페이지
		
		//세션 얻기
		String id=(String)session.getAttribute("user_id");
		
		if(id != null) {//세션에 값이 있을 때 세션을 읽는 페이지
			System.out.println("세션있음"+id);
			url="session/use_session_value";
		}//end if
		System.out.println(url);
		return url;
	}//getSessionValue
	
	@RequestMapping(value="remove_session.do",method=GET )
	public String removeSession(SessionStatus ss) {
		ss.setComplete();
		System.out.println("세션삭제");
		
		return "redirect:day0828/use_session.html";
	}
//	public String removeSession(HttpSession ss) {
//		ss.removeAttribute("user_id");
//		ss.removeAttribute("login_time");
//		ss.invalidate();
//		
//		return "redirect:day0828/use_session.html";
//	}//removeSession
//HttpSession을 가지고 세션 삭제 불가
	

	//HttpServletRequest를 매개변수로 사용한 세션 값 사용
//	public String getSessionValue(HttpServletRequest request) {
//		String url="redirect:day0828/use_session.html"; //세션이 없을 때 설정할 페이지
//		
//		//세션 얻기
//		HttpSession session=request.getSession();
//		String id=(String)session.getAttribute("user_id");
//		
//		if(id != null) {//세션에 값이 있을 때 세션을 읽는 페이지
//			url="session/use_session_value";
//			System.out.println("세션있음"+id);
//		}//end if
//		System.out.println(url);
//		return url;
//	}//getSessionValue
	@RequestMapping(value="/set_cookie_value.do", method=GET)
	//1 HttpServletResponse를 매개변수로 선언
	public String setCookie(HttpServletResponse response) {
		String url="session/cookie_result";
		
		//2쿠키 생성
		Cookie timeCookie =new Cookie("conn_time", String.valueOf(System.currentTimeMillis()));
		Cookie nickCookie= new Cookie("nick","officemart");
		
		timeCookie.setMaxAge(60*60);
		nickCookie.setMaxAge(60*60);
		
		//3쿠키 심기
		response.addCookie(timeCookie);
		response.addCookie(nickCookie);
		
		return url;
	}//setCookie
	
//	@RequestMapping(value="/read_cookie_value.do", method = GET)
//	//1HttpServletRequest 매개변수 선언
//	public String readCookie(HttpServletRequest request, Model model) {
//		//2쿠키들 읽기
//		Cookie[] cookies= request.getCookies();
//		//3읽어들인 쿠키가 존재하면
//		if(cookies !=null) {
//			for(Cookie temp: cookies) {
//				if("conn_time".equals(temp.getName())) {
//					model.addAttribute("time",temp.getValue());
//					
//				}//end if
//				System.out.println("쿠키값"+temp.getValue());
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

