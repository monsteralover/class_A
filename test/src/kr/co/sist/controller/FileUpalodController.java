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
		
		//���ε� ������ ����� ������ ���
		String path="C:/dev/workspace/spring_mvc_template/WebContent/upload_file/"; //�� ���� / �ٿ��ֱ�
		//���ε� ������ ũ��(byte)
		int maxSize=1024*10124*10;
		
		//���ε帣 ������ Multipart Request ����: upload����
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//${param.name} �� ��(enctype=multipart/form-data �̰� �Ķ���� ���۹���� �ƴ϶� ����. �׷��� model�� ����)
		//prj ������ model ��� vo�� �ְ� service���� �ҷ��� dao ���� insert
		
		//�信�� ������ �� ����
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
		mav.addObject("except1","���Ͼ��ε� ���� ���� �� ���� �߻�");
		mav.addObject("except2",ie);
		
		return mav;
	}
}
