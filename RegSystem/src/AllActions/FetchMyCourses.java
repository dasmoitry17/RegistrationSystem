package AllActions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DBAccess.FetchInfo;

public class FetchMyCourses extends ActionSupport {
	List<Course> myCourses=null;
	
	public List<Course> getMyCourses() {
		return myCourses;
	}

	public void setMyCourses(List<Course> myCourses) {
		this.myCourses = myCourses;
	}

	public int sId = Integer.parseInt(ActionContext.getContext().getSession()
            .get("userId").toString());
	
	public String execute() throws Exception{
		
		myCourses=new ArrayList<Course>();
		FetchInfo fetchInfo=new FetchInfo();
		myCourses=fetchInfo.getMyCourses(sId);
		
		if(myCourses!=null)
			
			return "SUCCESS";
			else {
				return "FAILURE";
			}
	}

}
