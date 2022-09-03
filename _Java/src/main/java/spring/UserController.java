package spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

//@Scope(scopeName = WebApplicationContext.SCOPE_SESSION ,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserController {

//	@Value("王浩杰")
	public String name;

	private String password;

	private void init(){
		System.out.println("init");
	}

	private void destroy(){
		System.out.println("destroy");
	}

	public void Strj(){
		System.out.println("被调用");
	}

	public UserController(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public UserController(String name) {
		this.name = name;
	}
	public UserController() {
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
