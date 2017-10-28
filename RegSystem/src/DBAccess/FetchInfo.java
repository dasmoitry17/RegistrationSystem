package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AllActions.AppliedStudent;
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
		student=null;
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
	
	
	public List<AppliedStudent> getAppliedStd()
	{
		
		try {
			List<AppliedStudent>stdlist =new ArrayList<AppliedStudent>();
			AppliedStudent student=null;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "SELECT * from appliedstudents";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs!=null)
			{
				while(rs.next()) {
					student=new AppliedStudent();
					student.setFirstName(rs.getString("fname"));
					student.setLastName(rs.getString("lname"));
					student.setGender(rs.getString("gender"));
					student.setDepartment(rs.getString("department"));
					student.setId(rs.getInt("id"));
					student.setPassword(rs.getString("password"));
					stdlist.add(student);
				}
			}
			return stdlist;
			
		}
		
		
		catch (Exception e) {
			System.out.println("validateInsert: Error inserting: "+e.getMessage());
			return null;
		}
	}


	public int getCourseNo(int sId) {
		int no=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "SELECT no_of_course from regstd where stdid =" + sId;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				 no=rs.getInt("no_of_course");
				
			}
			
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting in getcourseNo: "+e.getMessage());
			
		}
		return no;
	}
	
	public void getAppliedStd(int sid)
	
	{
		AppliedStudent astudent=new AppliedStudent();
		
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
    			
    			
    			InsertInfo insertInfo=new InsertInfo();
    			insertInfo.insetRegstd(student);
    		}
    		
    		String query = "delete from appliedstudents where id = ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, sid);
		      preparedStmt.execute();
		      
		      conn.close();
    		
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting in getcourseNo: "+e.getMessage());
		}
		
	}


	public List<Course> getAllCourses() {
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
	
	public List<Student> getAllRegStudents() {
		try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
					String query = "SELECT * FROM regstd";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					List<Student>studentlist1=new ArrayList<Student>();
					//courselist1=new ArrayList<Course>();
					Student student=null;
					
					if(rs!=null)
					{
						while(rs.next())
						{
							student=new Student();
							student.setFirstName(rs.getString("fName"));
							student.setLastName(rs.getString("lName"));
							student.setGender(rs.getString("gender"));
							student.setNo_course_taken(rs.getInt("no_of_course"));
							student.setPassword(rs.getString("password"));
							student.setStdId(rs.getInt("stdid"));
							studentlist1.add(student);
						}
					}
					return studentlist1;
					
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			
	
	

}
