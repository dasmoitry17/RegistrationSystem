package AllActions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FetchRStudents extends ActionSupport {
	
	List<Student>stdlist=null;
	public List<Student> getStdlist() {
		return stdlist;
	}
	public void setStdlist(List<Student> stdlist) {
		this.stdlist = stdlist;
	}
	ResultSet rs=null;
	String fetchStudent = null;
	
	
	public String execute() throws Exception {
		try {
			
				stdlist =new ArrayList<Student>();
				Student student=null;
				rs=fetchStudent();
				if(rs!=null)
				{
					while(rs.next()) {
						student=new Student();
						student.setFirstName(rs.getString("firstname"));
						student.setLastName(rs.getString("lastname"));
						student.setGender(rs.getString("gender"));
						student.setId(rs.getInt("id"));
						stdlist.add(student);
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
		
	}
	public ResultSet fetchStudent()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "SELECT id,firstname, lastname,gender FROM students";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


}
