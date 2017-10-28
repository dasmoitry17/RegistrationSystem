package AllJunits;

import static org.junit.Assert.*;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

import AllActions.EnlistCourse;
import DBAccess.FetchInfo;

public class EnlistCourseTest extends StrutsTestCase{

	@Test
	public void test() {
		
		FetchInfo fetchInfo=new FetchInfo();
		assertEquals(fetchInfo.getCourseId(2, 12), 2);


		
	}

}
