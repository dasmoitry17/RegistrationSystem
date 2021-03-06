package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import AllActions.AppliedStudent;
import AllActions.Student;

public class InsertInfo {
	
	public void insertCourse(int sid,int cid, int no_c, int no_s)

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
		
			String q = "INSERT INTO std_course ("
				    + " stdid,"
				    
				    + " courseid ) VALUES ("
				    + "?, ?)";
		
			PreparedStatement statement=conn.prepareStatement(q);
    		  statement.setInt(1, sid);
    		  statement.setInt(2, cid);
			
		statement.executeUpdate();
		statement.close();
		
		String q1 = "update regstd set no_of_course = ? where stdid = ? ";
	    no_c=no_c+1;
		PreparedStatement statement1=conn.prepareStatement(q1);
		  statement1.setInt(1, no_c);
		  statement1.setInt(2, sid);
		  
		  statement1.executeUpdate();
		  
		  statement1.close();
		  
		  String q2 = "update courses set stdno = ? where id = ? ";
		    no_s=no_s+1;
			PreparedStatement statement2=conn.prepareStatement(q2);
			  statement2.setInt(1, no_s);
			  statement2.setInt(2, cid);
			  
			  statement2.executeUpdate();
			  
			  statement2.close();
		
		

  conn.close();
			
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting in insert and update: "+e.getMessage());
		}
		
	}
	
	public int getRows()
	{
		int rows=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "SELECT * FROM std_course";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.last()) {
			     rows = rs.getRow();
			    // Move to beginning
			    rs.beforeFirst();
			    
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rows;
	}
	
	public void insertApplication(AppliedStudent student)
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "INSERT INTO appliedstudents ("
				    + " fname,"
				    + " lname,"
				    + " password,"
				    + " department,"
				    + " gender ) VALUES ("
				    + "?, ?, ?,?,?)";
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, student.getPassword());
			statement.setString(4, student.getDepartment());
			statement.setString(5, student.getGender());
			
			statement.executeUpdate();
			statement.close();
			  
			
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting: "+e.getMessage());
		}
	}

	public void insetRegstd(Student student) {
		
		String query = "INSERT INTO regstd ("
			    + " fName,"
			    + " lName,"
			    + "id,"
			    +"no_of_course,"
			    +"password,"
			    + " gender ) VALUES ("
			    + "?, ?, ?,?,?,?)";

		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			    
				PreparedStatement statement=connection.prepareStatement(query);
				statement.setString(1, student.getFirstName());
				statement.setString(2, student.getLastName());
				statement.setInt(3, student.getId());
				statement.setInt(4, student.getNo_course_taken());
				statement.setString(5, student.getPassword());
				statement.setString(6, student.getGender());
				statement.executeUpdate();
				statement.close();
				
				
			} catch (Exception se) {
				System.out.println("validateInsert: Error inserting a reg student: "+se.getMessage());
			    
			}
		
		
	}
	
	
	

}
