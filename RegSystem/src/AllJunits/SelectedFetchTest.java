package AllJunits;

import static org.junit.Assert.*;

import org.junit.Test;

import AllActions.Student;
import DBAccess.FetchInfo;

public class SelectedFetchTest {

	@Test
	public void test() {
		
		FetchInfo fetchInfo=new FetchInfo();
		Student student=new Student("Ryan", "Adam", 1, 1006 , "male", 0);
		assertEquals(fetchInfo.getRequestedStudent(1), student);
		
	}

}
