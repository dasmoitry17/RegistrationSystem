package AllJunits;

import static org.junit.Assert.*;

import org.hibernate.validator.internal.xml.DefaultValidatedExecutableTypesType;
import org.junit.Before;
import org.junit.Test;

import DBAccess.DeleteInfo;
import DBAccess.FetchInfo;

public class UpdateTest {
	
	@Before
	public void deleteFirst()
	{
		DeleteInfo deleteInfo=new DeleteInfo();
		deleteInfo.delete(1011, 1, 3);
	}

	@Test
	public void test() {
		FetchInfo fetchInfo=new FetchInfo();
		int number_of_course=fetchInfo.getCourseNo(1011);
		assertEquals(2, number_of_course);
	}

}
