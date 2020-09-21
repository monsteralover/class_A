package kr.co.sist.vo;

/**
 * web�� parameter�� �ޱ� ���� VO
 * html form control�� �̸��� vo  instance ���� �̸� ���ƾ� ��
 * �⺻������, setter getter �����
 * @author sist26
 *
 */
public class ParamVO {

	private String name, age, job;
	//framework�� ��ü�� �����ϱ� ������ ���� �⺻�����ڸ� �������� �ʴ´�.
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
