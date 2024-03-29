package spring.mybatis.model;

import java.io.Serializable;

/**
 * @Description:
 * @ClassName: User
 * @Author: WHJ
 * @Date: 2022/9/16 18:08
 * @Version: 6.0.18.0
 */
public class User implements Serializable {
	private static final long serialVersionUID =1L;
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
