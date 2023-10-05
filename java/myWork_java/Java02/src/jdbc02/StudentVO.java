package jdbc02;

public class StudentVO {
	private int sno;
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;
	private String birthday;
	
	// => getter / setter 자동생성 (Alt + Shift + S / Source)
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	// => toString 자동생성 (Alt + Shift + S / Source)
	@Override
	public String toString() {
		return "StudentNo [sno=" + sno + ", name=" + name + ", age=" + age + ", jno=" + jno + ", info=" + info
				+ ", point=" + point + ", birthday=" + birthday + "]";
	}
	

	
	

	
	
	
} // class StudentNo
