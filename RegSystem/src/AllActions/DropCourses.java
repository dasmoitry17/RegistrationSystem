package AllActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import DBAccess.DeleteInfo;
import DBAccess.FetchInfo;

public class DropCourses {
	
	private Map Drop=new HashMap();
	private int cid;
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Map getDrop() {
		return Drop;
	}
	
	public int sId = Integer.parseInt(ActionContext.getContext().getSession()
            .get("userId").toString());
	
	public String execute() throws Exception{
		
		for (Iterator i = Drop.keySet().iterator(); i.hasNext(); ) {
			 String id = (String) i.next();
			  cid=Integer.parseInt(id);
			  
       }
		int no_c=0;
		FetchInfo fetchInfo=new FetchInfo();
		no_c=fetchInfo.getCourseNo(sId);
		
		DeleteInfo deleteInfo=new DeleteInfo();
		deleteInfo.delete(sId, cid , no_c);
		return "SUCCESS";
		
		
		
	}

}
