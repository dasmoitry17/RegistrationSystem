package AllActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import DBAccess.FetchInfo;

public class EnlistStudent extends ActionSupport{
	
	private Map add=new HashMap();
	private int sid;
	
	public Map getAdd() {
		return add;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String execute() throws Exception{
		for (Iterator i = add.keySet().iterator(); i.hasNext(); ) {
			 String id = (String) i.next();
			  sid=Integer.parseInt(id);
			  
        }
		

		FetchInfo fetchInfo=new FetchInfo();
		fetchInfo.getAppliedStd(sid);
		return "success";
	}
	

	
	

}
