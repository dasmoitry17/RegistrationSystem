package AllJunits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import AllActions.Course;
import AllActions.Student;
import DBAccess.FetchInfo;

public class SelectedFetchTest {

	@Test
	public void test() {
		
		FetchInfo fetchInfo=new FetchInfo();
		Student student=new Student("Ryan", "Adam", 1, 1006 , "male", 0);
		assertEquals(fetchInfo.getRequestedStudent(1), student);
		
		Course course=new Course("Intro to Software Enginering", "102012", "0.5", 1);
		
		List<Course> courses=new ArrayList<Course>();
		courses.add(course);
		FetchInfo fetchInfo2=new FetchInfo();
		assertEquals(fetchInfo2.getMyCourses(64), courses);
		
		FetchInfo fetchInfo3=new FetchInfo();
		Student student2=new Student();
		student2=fetchInfo3.getRequestedStudent(21);
		assertNull(student2);
		
		FetchInfo fetchInfo4=new FetchInfo();
		
		assertNotEquals(fetchInfo4.getCourseId(1, 1011), 1);
		
		
	}
	
	@Before
	public void selectAStd() {
		FetchInfo fetchInfo5=new FetchInfo();
		fetchInfo5.getAppliedStd(5);
	}
	@Test
	public void testgetAppliedStd() {
		FetchInfo fetchInfo6=new FetchInfo();
		fetchInfo6.getRequestedStudent(1015);
	}


}
