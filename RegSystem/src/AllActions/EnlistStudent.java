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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String qs = "SELECT * FROM appliedstudents where id= ?" ;
			PreparedStatement ps=conn.prepareStatement(qs);
			ps.setInt(1, sid);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next())
    		{
    			Student student=new Student();
    			student.setFirstName(rs.getString("fname"));
    			student.setLastName(rs.getString("lname"));
    			student.setGender(rs.getString("gender"));
    			student.setId(rs.getInt("id"));
    			student.setNo_course_taken(0);	
    			student.setPassword(rs.getString("password"));
    			DbInsert dbInsert=new DbInsert();
    			dbInsert.InsertObject(student);
    		}
    		
    		String query = "delete from appliedstudents where id = ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, sid);
		      preparedStmt.execute();
		      
		      conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	

	
	

}
