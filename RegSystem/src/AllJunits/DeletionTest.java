package AllJunits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import AllActions.AppliedStudent;
import AllActions.TimerAction;
import AllActions.TimerDelete;
import DBAccess.DeleteInfo;
import DBAccess.FetchInfo;

public class DeletionTest {

	@Test
	public void test() {
		List<AppliedStudent> list=new ArrayList<AppliedStudent>();
	 FetchInfo fetchInfo=new FetchInfo();
	 list=fetchInfo.getAppliedStd();
	 
	 assertTrue(list.isEmpty());
	 
	 AppliedStudent student=new AppliedStudent("John", "Smith", 1, "male");
	 
	 assertThat(list, CoreMatchers.hasItem(student));
	 
	 AppliedStudent student2=new AppliedStudent("Laura", "Smith", 2, "female");
	 
	 DeleteInfo deleteInfo=new DeleteInfo();
	 assertEquals(deleteInfo.deleteAllTables(),"success");
	 
	
	 
	 TimerDelete timerDelete=new TimerDelete();
	 assertEquals(timerDelete.execute("2017-10-29"),"success");
	 
	}

}
