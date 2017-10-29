package AllActions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import DBAccess.FetchInfo;

public class SelectCourseActions {
	
	List<Student> coursestdlist=null;
	private String courseName;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Student> getCoursestdlist() {
		return coursestdlist;
	}

	public void setCoursestdlist(List<Student> coursestdlist) {
		this.coursestdlist = coursestdlist;
	}
	private Map select=new HashMap();

	public Map getSelect() {
		return select;
	}

	public void setSelect(Map select) {
		this.select = select;
	}
	private int cid;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	public String execute() throws Exception{
		
		for (Iterator i = select.keySet().iterator(); i.hasNext(); ) {
			 String id = (String) i.next();
			  cid=Integer.parseInt(id);
       }
		
		FetchInfo fetchInfo=new FetchInfo();
		coursestdlist=fetchInfo.getStdofCourse(cid);
		FetchInfo fetchInfo1=new FetchInfo();
		courseName=fetchInfo1.getCourseName(cid);
		
		return "success";
		
	}

}
