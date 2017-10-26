package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			if(rs.next()!=false)
            selectedcourseid=rs.getInt("courseid");
			else
			{
				selectedcourseid=0;
			}
	
		} catch (Exception e) {
			System.out.println("validateInsert: Error inserting: "+e.getMessage());
		    
		}
		return selectedcourseid;
	}

}
