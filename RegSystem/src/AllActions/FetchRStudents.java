package AllActions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import DBAccess.FetchInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FetchRStudents extends ActionSupport {
	
	List<AppliedStudent>stdlist=new ArrayList<AppliedStudent>();
	public List<AppliedStudent> getStdlist() {
		return stdlist;
	}
	public void setStdlist(List<AppliedStudent> stdlist) {
		this.stdlist = stdlist;
	}
	ResultSet rs=null;
	String fetchStudent = null;
	
	
	public String execute() throws Exception {

		FetchInfo fetchInfo=new FetchInfo();
		stdlist=fetchInfo.getAppliedStd();
		return "success";
		
	}
	


}
