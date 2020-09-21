package kr.co.sist.controller;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class FileUpalodController {

	@RequestMapping(value="/upload_process.do" , method=RequestMethod.POST)
	public String uploadProcess(HttpServletRequest request, Model model) throws IOException {
		
		//업로드 파일이 저장될 폴더의 경로
		String path="C:/dev/workspace/spring_mvc_template/WebContent/upload_file/"; //맨 끝에 / 붙여주기
		//업로드 파일의 크기(byte)
		int maxSize=1024*10124*10;
		
		//업로드르 수행할 Multipart Request 생성: upload수행
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//${param.name} 못 씀(enctype=multipart/form-data 이게 파라미터 전송방식이 아니라 못씀. 그래서 model을 쓴다)
		//prj 에서는 model 대신 vo에 넣고 service에서 불러서 dao 에서 insert
		
		//뷰에서 보여줄 값 설정
		model.addAttribute("name", mr.getParameter("name"));
		model.addAttribute("type", mr.getParameterValues("filetype"));
		model.addAttribute("file1_origin", mr.getOriginalFileName("file1"));
		model.addAttribute("file1_rename", mr.getFilesystemName("file1"));
		model.addAttribute("file2_origin", mr.getOriginalFileName("file2"));
		model.addAttribute("file2_rename", mr.getFilesystemName("file2"));
		
		return "upload/upload_result"; 
	}//uploadProcess
	
	@ExceptionHandler(IOException.class)
	public ModelAndView exception(IOException ie) {
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("exception/exception_view");
		mav.addObject("except1","파일업로드 업무 수행 중 문제 발생");
		mav.addObject("except2",ie);
		
		return mav;
	}
}
