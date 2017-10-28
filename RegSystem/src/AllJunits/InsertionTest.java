package AllJunits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import AllActions.AppliedStudent;
import AllActions.Student;
import DBAccess.FetchInfo;
import DBAccess.InsertInfo;

public class InsertionTest {

	@Test
	public void test() {
		InsertInfo insertInfo=new InsertInfo();
		assertEquals(insertInfo.getRows(),24);
		
		AppliedStudent student=new AppliedStudent("Kaira", "Jones", "CS", "female","8080",6);
		
		InsertInfo insertInfo2=new InsertInfo();
		insertInfo2.insertApplication(student);
		
		List<AppliedStudent>stdlist=new ArrayList<AppliedStudent>();
		FetchInfo fetchInfo=new FetchInfo();
		stdlist=fetchInfo.getAppliedStd();
		
		assertTrue(stdlist.contains(student));
	}

}
