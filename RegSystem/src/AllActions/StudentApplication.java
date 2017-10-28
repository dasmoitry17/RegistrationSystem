package AllActions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import DBAccess.InsertInfo;

public class StudentApplication extends ActionSupport implements ModelDriven {
	
	AppliedStudent appliedStudent=new AppliedStudent();
	
	public AppliedStudent getAppliedStudent() {
		return appliedStudent;
	}

	public void setAppliedStudent(AppliedStudent appliedStudent) {
		this.appliedStudent = appliedStudent;
	}

	public Object getModel()
	{
		return appliedStudent;
	}
	
	public String execute() throws Exception {
		
		InsertInfo insertInfo=new InsertInfo();
		insertInfo.insertApplication(appliedStudent);
		
		return "SUCCESS";
	}

}
