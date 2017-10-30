package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.Statement;

public class DeleteInfo {
	
	public void delete(int sid, int cid, int no_c,int no_s)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "delete from std_course where stdid = ? && courseid=?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, sid);
		      preparedStmt.setInt(2, cid);
		      preparedStmt.execute();
		      
		      String q1 = "update regstd set no_of_course = ? where stdid = ? ";
			    no_c=no_c-1;
				PreparedStatement statement1=conn.prepareStatement(q1);
				  statement1.setInt(1, no_c);
				  statement1.setInt(2, sid);
				  
				  statement1.executeUpdate();			  
				  statement1.close();
				  
				  String q2 = "update courses set stdno = ? where id = ? ";
				    no_s=no_s-1;
					PreparedStatement statement2=conn.prepareStatement(q2);
					  statement2.setInt(1, no_s);
					  statement2.setInt(2, cid);
					  
					  statement2.executeUpdate();
					  
					  statement2.close();
				  
				  
		      
		      conn.close();
		      
		} catch (Exception e) {
			System.out.println("validateInsert: Error dropping course: "+e.getMessage());
			
		}
	}
	
	public String deleteAllTables()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
			String query = "delete from appliedstudents";
		      Statement statement=conn.createStatement();
		      statement.executeUpdate(query);
		      
		      String query1 = "delete from regstd";
		      Statement statement1=conn.createStatement();
		      statement1.executeUpdate(query1);
		      
		      String query2 = "delete from std_course";
		      Statement statement2=conn.createStatement();
		      statement.executeUpdate(query2);
		      
		      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	      
	}

}
