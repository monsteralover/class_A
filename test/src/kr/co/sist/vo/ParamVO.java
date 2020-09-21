package kr.co.sist.vo;

/**
 * web의 parameter를 받기 위한 VO
 * html form control의 이름과 vo  instance 변수 이름 같아야 함
 * 기본생성자, setter getter 만든다
 * @author sist26
 *
 */
public class ParamVO {

	private String name, age, job;
	//framework가 객체를 생성하기 때문에 굳이 기본생성자를 정의하지 않는다.
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "ParamVO [name=" + name + ", age=" + age + ", job=" + job + "]";
	}
	
	
}
