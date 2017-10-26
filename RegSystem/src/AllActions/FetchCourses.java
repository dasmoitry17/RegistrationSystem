package AllActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class FetchCourses extends ActionSupport {
	
	List<Course> courselist=null;
	ResultSet rs=null;

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	
	public String execute() throws Exception{
		
		try {
			courselist=new ArrayList<Course>();
			Course course=null;
			rs=fetchCourse();
			if(rs!=null)
			{
				while(rs.next())
				{
					course=new Course();
					course.setCourseNo(rs.getString("course_no"));
					course.setCredit(rs.getString("credit"));
					course.setTitle(rs.getString("title"));
					course.setId(rs.getInt("id"));
					courselist.add(course);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public ResultSet fetchCourse()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "SELECT id,title,course_no,credit FROM courses";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
