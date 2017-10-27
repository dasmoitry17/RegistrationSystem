package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertInfo {
	
	public void insertCourse(int sid,int cid)

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

  conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
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
	
	
	

}
