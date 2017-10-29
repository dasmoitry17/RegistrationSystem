package AllActions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBAccess.FetchInfo;

public class CourseInfoAction {
	
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
