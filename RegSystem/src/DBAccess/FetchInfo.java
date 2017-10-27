package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import AllActions.Course;
import AllActions.DbInsert;
import AllActions.Student;

public class FetchInfo {
	
	public int getCourseId  (int idc, int ids)
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
			if(rs.next()==false)
				selectedcourseid=0;
            
			else
			{
				selectedcourseid=rs.getInt("courseid");
				//selectedcourseid=0;
			}
	
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting: "+e.getMessage());
		    
		}
		return selectedcourseid;
	}
	
	
	public Student getRequestedStudent(int sid)
	{
		Student student=new Student();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String qs = "SELECT * FROM regstd where id= ?" ;
			PreparedStatement ps=conn.prepareStatement(qs);
			ps.setInt(1, sid);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next())
    		{
    			
    			student.setFirstName(rs.getString("fname"));
    			student.setLastName(rs.getString("lname"));
    			student.setGender(rs.getString("gender"));
    			student.setId(rs.getInt("id"));
    			student.setNo_course_taken(0);	
    			student.setStdId(rs.getInt("stdid"));
    			
//    			DbInsert dbInsert=new DbInsert();
//    			dbInsert.InsertObject(student);
    		}
			
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting: "+e.getMessage());
		}
		return student;
	}
	
	public List<Course> getMyCourses(int sId)
	{
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String qs = "SELECT * FROM std_course  where stdid= ?" ;
			PreparedStatement ps=conn.prepareStatement(qs);
			ps.setInt(1, sId);
    		ResultSet rs = ps.executeQuery();
    		List<Course>myCourses=new ArrayList<Course>();
    		
    		while(rs.next())
    		{
    			String qString="SELECT * FROM courses  where id=?"  ;
    			PreparedStatement preparedStatement=conn.prepareStatement(qString);
    			preparedStatement.setInt(1, rs.getInt("courseid"));
    			ResultSet resultSet=preparedStatement.executeQuery();
    			
    			Course course=null;
    			while(resultSet.next())
    			{
    				 course=new Course();
    				course.setCourseNo(resultSet.getString("course_no"));
    				course.setCredit(resultSet.getString("credit"));
    				course.setId(resultSet.getInt("id"));
    				course.setTitle(resultSet.getString("title"));
    				myCourses.add(course);
    				
    			}
    			
    		}
    		return myCourses;
			
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting: "+e.getMessage());
			return null;
		}
		
	}

}
