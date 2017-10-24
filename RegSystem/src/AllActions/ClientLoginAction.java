package AllActions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;


public class ClientLoginAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -3434561352924343132L;

	private String userId, userPass, msg;
	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	private SessionMap<String, Object> sessionMap;
	
	
	public void setSession(Map<String, Object>map) {
		sessionMap=(SessionMap<String, Object>)map;
	}
	
	
	public String execute() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession(true);
		
		if(userId!=null)
		{
			if (userPass.equals("sparrow")) {
				// add the attribute in session				
				sessionMap.put("userId", userId);

				return "SUCCESS";
			} else {
				setMsg("Invalid Password");
				return "LOGIN";
			}
		}
		else {
String getSessionAttr = (String) session.getAttribute("userId");
			
			if (getSessionAttr != null) {

				return "SUCCESS";

			} else {
				setMsg("not getting");
				return "LOGIN";
			}
		}
	}
	
	
public String logout() {
		
		sessionMap.remove("userId");
		sessionMap.invalidate();
		
		return "LOGOUT";
	}


public String getMsg() {
	return msg;
}


public void setMsg(String msg) {
	this.msg = msg;
}


}
