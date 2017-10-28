package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteInfo {
	
	public void delete(int sid, int cid)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "delete from std_course where stdid = ? && courseid=?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, sid);
		      preparedStmt.setInt(2, cid);
		      preparedStmt.execute();
		      
		      conn.close();
		      
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting: "+e.getMessage());
			
		}
	}

}
