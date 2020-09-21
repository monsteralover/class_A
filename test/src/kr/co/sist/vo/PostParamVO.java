package kr.co.sist.vo;

import java.util.Arrays;

public class PostParamVO {

	private String name, age;
	private String[] hobby;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "PostParamVO [name=" + name + ", age=" + age + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	
	
}
