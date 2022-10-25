package spring.合并Bean定义;

public class ChildBean extends FatherBean {
	private String name;
	private String age;
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
	@Override
	public String toString() {
		return "ChildBean [name=" + name + ", age=" + age + ", toString()=" + super.toString() + "]";
	}
}
