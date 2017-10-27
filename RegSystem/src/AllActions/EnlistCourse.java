package AllActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.crypto.provider.RSACipher;

import DBAccess.FetchInfo;
import DBAccess.InsertInfo;

public class EnlistCourse extends ActionSupport {
	
	public String msg;
	private Map Add=new HashMap();
	public int sId = Integer.parseInt(ActionContext.getContext().getSession()
            .get("userId").toString());

	private int cid;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	
	
	
	public String execute() throws Exception{
		
		for (Iterator i = Add.keySet().iterator(); i.hasNext(); ) {
			 String id = (String) i.next();
			  cid=Integer.parseInt(id);
        }
		
		
		
		try {
			FetchInfo fetchInfo=new FetchInfo();
			int courseid=0;
			courseid=fetchInfo.getCourseId(cid, sId);
			
			
			
			if(courseid==0)
			{
				InsertInfo insertInfo=new InsertInfo();
				insertInfo.insertCourse(sId, cid);
							
		    }
			else {
				msg="You have already taken the course";
				return  "HaveAlready";
			}
			
		} catch (Exception se) {
			System.out.println("validateInsert: Error inserting: "+se.getMessage());
		    throw se;
		}
		
		return "SUCCESS";
	}
	
	

	public Map getAdd() {
		return Add;
	}

	public void setAdd(Map add) {
		Add = add;
	}

}
