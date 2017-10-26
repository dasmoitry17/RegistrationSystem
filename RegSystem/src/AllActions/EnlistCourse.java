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
			int courseid=fetchInfo.getCourseId(cid, sId);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
//	 String qs = "SELECT courseid FROM std_course where courseid= ? && stdid=?" ;
//			PreparedStatement ps=conn.prepareStatement(qs);
//			ps.setInt(1, cid);
//			ps.setInt(2, sId);
//			ResultSet rs = ps.executeQuery();
			
			if(courseid==0)
			{
			
		    		  String q = "INSERT INTO std_course ("
		    				    + " stdid,"
		    				    
		    				    + " courseid ) VALUES ("
		    				    + "?, ?)";
		    		
		    			PreparedStatement statement=conn.prepareStatement(q);
			    		  statement.setInt(1, sId);
			    		  statement.setInt(2, cid);
						
					statement.executeUpdate();
					statement.close();
		    
		      conn.close();
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
	
	public int getCourseId(int idc, int ids)
	{
		int selectedcourseid=0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
	 String qs = "SELECT courseid FROM std_course where courseid= ? && stdid=?" ;
			PreparedStatement ps=conn.prepareStatement(qs);
			ps.setInt(1, idc);
			ps.setInt(2, ids);
			ResultSet rs = ps.executeQuery();
			
            selectedcourseid=rs.getInt("courseid");
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return selectedcourseid;
	}

	public Map getAdd() {
		return Add;
	}

	public void setAdd(Map add) {
		Add = add;
	}

}
