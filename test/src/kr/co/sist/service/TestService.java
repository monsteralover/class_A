package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;

public class TestService {

	public List<String> search(){
		List<String> list=new ArrayList<String>();
		list.add("���� ����Ʈ���� ���ʱ�� Ȱ�� : OS�� ���α׷� ��ġ");
		list.add("���α׷��־�� Ȱ��: java");
		list.add("���ø����̼� �׽�Ʈ ����: Junit ��� method�� �����׽�Ʈ");
		list.add("���ø����̼� �׽�Ʈ ����: ���� �׽�Ʈ�� ���� �׽�Ʈ�� ����� ������ ��� ����");
		list.add("SQL Ȱ�� : DDL,DCL, DML");
		list.add("�����ͺ��̽����� :DBMS��ġ, ��ü ����");
		list.add("�䱸���� Ȯ��: ������ ���� �м�,����");
		list.add("ȭ�鼳��: �䱸������ ��� �������� ȭ�� �׸��� �ܰ�(prototype ����)");
		list.add("�������̽� ����:  �����͸� �ְ�ޱ� ���� ���� ����");
		list.add("UI ����: ȭ�� ���迡�� ���� ȭ���� �����ϴ� ����");
		
		
		return list;
	}//search
	
	public List<String> subjectList(){ 
		List<String> list= new ArrayList<String>();
		list.add("���� SW ���� ��� Ȱ��");
		list.add("���α׷��� ���Ȱ��");
		list.add("���ø����̼� �׽�Ʈ ����");
		list.add("���ø����̼� �׽�Ʈ ����");//java SE, junit5, JDBC, DBCP
		list.add("SQL Ȱ��");
		list.add("�����ͺ��̽� ����");//DBMS
		list.add("�䱸���� Ȯ��");//�䱸����Ȯ�μ�(RFP)
		list.add("���ø����̼� ����");
		list.add("�������̽� ����");//XML, JSON, AJAX
		list.add("ȭ�鼳��");//UI���輭(Story board)
		list.add("���ձ���-�������ۼ�");//Ŭ ��
		list.add("ui ����-frontend");//HTML/JavaScript/CSS
		list.add("�������α׷� ����-BackEnd"); //JAVA EE - Servlet/JSP(Model1)/Spring
		list.add("�����ý�������");//���� ����(��������, �Ŵ���, ����� ����)
		
		
	return list;
	}//subject list
}//class
