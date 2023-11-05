package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.impl.userDaoImpl;
import entity.user;

public class loginAction extends ActionSupport {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception{
		
		user u = new userDaoImpl().queryUser(username, password);
		String result = null;
		if(u!=null) {
			result="vote";
			
		}else {
			result= "loginError";
		}
		System.out.println(result);
		return result;
		
		
	}

}
