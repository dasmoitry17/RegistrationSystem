package AllActions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import DBAccess.FetchInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FetchRStudents extends ActionSupport {
	
	List<AppliedStudent>stdlist=new ArrayList<AppliedStudent>();
	public List<AppliedStudent> getStdlist() {
		return stdlist;
	}
	public void setStdlist(List<AppliedStudent> stdlist) {
		this.stdlist = stdlist;
	}
	ResultSet rs=null;
	String fetchStudent = null;
	
	
	public String execute() throws Exception {
//		try {
//			
//				stdlist =new ArrayList<AppliedStudent>();
//				AppliedStudent student=null;
//				rs=fetchStudent();
//				if(rs!=null)
//				{
//					while(rs.next()) {
//						student=new AppliedStudent();
//						student.setFirstName(rs.getString("fname"));
//						student.setLastName(rs.getString("lname"));
//						student.setGender(rs.getString("gender"));
//						student.setDepartment(rs.getString("department"));
//						student.setId(rs.getInt("id"));
//						student.setPassword(rs.getString("password"));
//						stdlist.add(student);
//					}
//				}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		FetchInfo fetchInfo=new FetchInfo();
		stdlist=fetchInfo.getAppliedStd();
		return "success";
		
	}
	public ResultSet fetchStudent()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "SELECT * from appliedstudents";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


}
