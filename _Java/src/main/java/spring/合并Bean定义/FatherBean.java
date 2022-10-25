package spring.合并Bean定义;

public class FatherBean {
	private String familyName;
	private String name;
	private String age;
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
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
		return "FatherBean [familyName=" + familyName + ", name=" + name + ", age=" + age + "]";
	}

}

