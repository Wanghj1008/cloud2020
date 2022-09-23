package 泛型;


import spring.mybatis.model.User;

/**
 * @Description:
 * @ClassName: T
 * @Author: WHJ
 * @Date: 2022/9/23 14:20
 * @Version: 6.0.18.0
 */
public class Cache<T> {

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setName("whj");
		Cache<User> userCache = new Cache<>();
		userCache.setT(user);

		System.out.println(userCache.getT().toString());
	}
}
