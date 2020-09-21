package kr.co.sist.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AjaxService {//json을 만드는 일은 업무로직이라 service에서 처리

	/**
	 * {pubDate:생성일, dataCnt: x, data:[{name:'yubin song' ,age:26,'''},{},{}]}
	 * @return
	 */ 
	public String createJson() {
		//나중에는 db table에서 나온 데이터
		String[] names= {"yubin song","도연","민정 김","예린 차","이지우"};
		int[] age= {26,27,28,25,26};
		
		JSONObject json= new JSONObject();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		json.put("pubDate",sdf.format(new Date()));
		json.put("dataCnt",names.length);
		
		JSONArray ja=new JSONArray();//데이터를 가진 jsonobject을 저장할 JSONArray
		JSONObject jsonTemp=null;
		
		for(int i=0; i<names.length; i++) {
			jsonTemp=new JSONObject();//데이터가 존재하면 jsonobject 생성하고 
			//데이터를 추가한다.
			jsonTemp.put("name", names[i]);
			jsonTemp.put("age", age[i]);
			
			//JSONArray에 추가
			ja.add(jsonTemp);
			
		}//end for
		//데이터를 가진 JSONarray를 jsonObject에 추가
		json.put("data", ja);
		
		return json.toJSONString();
	}//createJson
	
}
