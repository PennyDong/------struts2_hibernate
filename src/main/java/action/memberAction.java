package action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Parameter.Request;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import dao.DbConnection;
import dao.impl.memberDaoImpl;

public class memberAction extends ActionSupport {
	
	
	private String i;
	
	
	String result=null;
	@Override
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		i=request.getParameter("i");
		Integer id = Integer.parseInt(i);
		Session se = DbConnection.getDb();
		
		if(i!=null) {
		new memberDaoImpl().updateVote(id);
			result="vote";
		}else {
			result="loginError";
		}
		
		return result;
	}
}
