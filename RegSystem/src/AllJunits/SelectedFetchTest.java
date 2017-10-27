package AllJunits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
		
	}

}
