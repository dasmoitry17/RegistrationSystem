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
		
		courselist=new ArrayList<Course>();
		courselist=fetchCourse();
		
		return "success";
	}
	
	public List<Course> fetchCourse()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "SELECT id,title,course_no,credit FROM courses";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List<Course>courselist1=new ArrayList<Course>();
			//courselist1=new ArrayList<Course>();
			Course course=null;
			
			if(rs!=null)
			{
				while(rs.next())
				{
					course=new Course();
					course.setCourseNo(rs.getString("course_no"));
					course.setCredit(rs.getString("credit"));
					course.setTitle(rs.getString("title"));
					course.setId(rs.getInt("id"));
					courselist1.add(course);
				}
			}
			return courselist1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
