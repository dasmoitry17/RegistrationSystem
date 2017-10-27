package AllJunits;

import static org.junit.Assert.*;

import org.junit.Test;

import DBAccess.InsertInfo;

public class InsertionTest {

	@Test
	public void test() {
		InsertInfo insertInfo=new InsertInfo();
		assertEquals(insertInfo.getRows(),24);
	}

}
