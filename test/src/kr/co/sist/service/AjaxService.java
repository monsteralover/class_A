package kr.co.sist.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AjaxService {//json�� ����� ���� ���������̶� service���� ó��

	/**
	 * {pubDate:������, dataCnt: x, data:[{name:'yubin song' ,age:26,'''},{},{}]}
	 * @return
	 */ 
	public String createJson() {
		//���߿��� db table���� ���� ������
		String[] names= {"yubin song","����","���� ��","���� ��","������"};
		int[] age= {26,27,28,25,26};
		
		JSONObject json= new JSONObject();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		json.put("pubDate",sdf.format(new Date()));
		json.put("dataCnt",names.length);
		
		JSONArray ja=new JSONArray();//�����͸� ���� jsonobject�� ������ JSONArray
		JSONObject jsonTemp=null;
		
		for(int i=0; i<names.length; i++) {
			jsonTemp=new JSONObject();//�����Ͱ� �����ϸ� jsonobject �����ϰ� 
			//�����͸� �߰��Ѵ�.
			jsonTemp.put("name", names[i]);
			jsonTemp.put("age", age[i]);
			
			//JSONArray�� �߰�
			ja.add(jsonTemp);
			
		}//end for
		//�����͸� ���� JSONarray�� jsonObject�� �߰�
		json.put("data", ja);
		
		return json.toJSONString();
	}//createJson
	
}
