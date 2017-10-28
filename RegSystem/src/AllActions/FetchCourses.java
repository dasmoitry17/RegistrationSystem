package AllActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import DBAccess.FetchInfo;

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
		FetchInfo fetchInfo=new FetchInfo();
		courselist=fetchInfo.getAllCourses();
		
		if(courselist!=null)
		
		return "success";
		else {
			return "failure";
		}
	}
	
	
}
