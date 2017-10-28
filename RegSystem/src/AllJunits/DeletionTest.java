package AllJunits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import AllActions.AppliedStudent;
import DBAccess.FetchInfo;

public class DeletionTest {

	@Test
	public void test() {
		List<AppliedStudent> list=new ArrayList<AppliedStudent>();
	 FetchInfo fetchInfo=new FetchInfo();
	 list=fetchInfo.getAppliedStd();
	 
	 assertTrue(list.isEmpty());
	 
	 //AppliedStudent student=new AppliedStudent("", lastName, id, gender);
	 
	 
	}

}
