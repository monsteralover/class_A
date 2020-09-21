package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;

public class TestService {

	public List<String> search(){
		List<String> list=new ArrayList<String>();
		list.add("응용 소프트웨어 기초기술 활용 : OS에 프로그램 설치");
		list.add("프로그래밍언어 활용: java");
		list.add("애플리케이션 테스트 수행: Junit 사용 method별 단위테스트");
		list.add("애플리케이션 테스트 관리: 단위 테스트나 통합 테스트의 결과를 가지고 기능 개선");
		list.add("SQL 활용 : DDL,DCL, DML");
		list.add("데이터베이스구현 :DBMS설치, 객체 생성");
		list.add("요구사항 확인: 아이템 선정 분석,검증");
		list.add("화면설계: 요구사항을 어떻게 보여줄지 화면 그리는 단계(prototype 생성)");
		list.add("인터페이스 구현:  데이터를 주고받기 위한 형태 설정");
		list.add("UI 구현: 화면 설계에서 나온 화면을 제작하는 과정");
		
		
		return list;
	}//search
	
	public List<String> subjectList(){ 
		List<String> list= new ArrayList<String>();
		list.add("응용 SW 기초 기술 활용");
		list.add("프로그래밍 언어활용");
		list.add("애플리케이션 테스트 수행");
		list.add("애플리케이션 테스트 관리");//java SE, junit5, JDBC, DBCP
		list.add("SQL 활용");
		list.add("데이터베이스 구현");//DBMS
		list.add("요구사항 확인");//요구사항확인서(RFP)
		list.add("애플리케이션 설계");
		list.add("인터페이스 구현");//XML, JSON, AJAX
		list.add("화면설계");//UI설계서(Story board)
		list.add("통합구현-공통모듈작성");//클 다
		list.add("ui 구현-frontend");//HTML/JavaScript/CSS
		list.add("서버프로그램 구현-BackEnd"); //JAVA EE - Servlet/JSP(Model1)/Spring
		list.add("정보시스템이행");//서버 배포(배포문서, 매뉴얼, 사용자 교육)
		
		
	return list;
	}//subject list
}//class
