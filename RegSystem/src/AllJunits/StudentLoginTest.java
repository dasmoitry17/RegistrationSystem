package AllJunits;

import static org.junit.Assert.*;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

import AllActions.StudentLoginAction;

public class StudentLoginTest extends StrutsTestCase{

	@Test
	public void test() {
		
		request.setParameter("userId", "21");
		request.setParameter("userPass", "abcd");
		 StudentLoginAction sl=new StudentLoginAction();
		 sl.setUserId(request.getParameter("userId"));
		 sl.setUserPass(request.getParameter("userPass"));
         ActionProxy proxy=getActionProxy("/users/studentLogin");
         sl=(StudentLoginAction)proxy.getAction();
         assertEquals(sl.execute(), "LOGIN");
         
		//fail("Not yet implemented");
	}

}
