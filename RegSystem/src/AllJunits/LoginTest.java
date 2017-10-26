package AllJunits;

import static org.junit.Assert.*;
import java.lang.AssertionError;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

import AllActions.ClientLoginAction;

public class LoginTest extends StrutsTestCase {

	@Test
	public void test() {
		request.setParameter("userId", "21");
		request.setParameter("userPass", "sparrow");
		
		ClientLoginAction cl=new ClientLoginAction();
		cl.setUserId(request.getParameter("userId"));
		cl.setUserPass(request.getParameter("userPass"));
		ActionProxy proxy=getActionProxy("/users/clientLogin");
		cl=(ClientLoginAction)proxy.getAction();
		cl.execute();
		
		assertEquals(cl.execute(), "LOGIN");
	}

}
