package AllActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class DbInsert {
	
	public void InsertObject(Student student) throws Exception{
		Connection connection=null;
		String query = "INSERT INTO regstd ("
			    + " fName,"
			    + " lName,"
			    + "id,"
			    +"no_of_course,"
			    
			    + " gender ) VALUES ("
			    + "?, ?, ?,?,?)";

		
			try {
			    connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(query);
				statement.setString(1, student.getFirstName());
				statement.setString(2, student.getLastName());
				statement.setInt(3, student.getId());
				statement.setInt(4, student.getNo_course_taken());
				statement.setString(5, student.getGender());
				statement.executeUpdate();
				statement.close();
				
				
			} catch (Exception se) {
				System.out.println("validateInsert: Error inserting: "+se.getMessage());
			    throw se;
			}
		
	}
	
	private Connection getConnection() throws Exception{
	    Connection connection=null;
	    
	  try {
		
		  Class.forName("com.mysql.jdbc.Driver");
		  connection= DriverManager.getConnection("jdbc:mysql://localhost/registration_db","root","");
		  

		
	} catch (SQLException sqle) {
		System.out.println("SQLException: Unable to open connection to db: "+sqle.getMessage());
		throw sqle;
	} catch (Exception e) {
		System.out.println("SQLException: Unable to open connection to db: "+e.getMessage());
		throw e;
	}
	    
	    return connection;
	}


}
