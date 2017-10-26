package AllJunits;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

import AllActions.Course;

import AllActions.FetchCourses;

public class FetchCoursesTest extends StrutsTestCase {

	@Test
	public void test() throws Exception {
		List<Course> list=new ArrayList<Course>();
		Course course=new Course("Intro to Software Enginering", "102012", "0.5", 1);
		list.add(course);
		Course course1=new Course("Database Management System", "102013", "0.5", 2);
		list.add(course1);
		Course course3=new Course("Wireless Networking", "102014", "0.5", 3);
		list.add(course3);
		Course course4=new Course("Data Mining", "102015", "0.5", 4);
		list.add(course4);
		
		FetchCourses fetchCourses=new FetchCourses();
		ActionProxy proxy=getActionProxy("/users/BringSt");
		fetchCourses=(FetchCourses)proxy.getAction();
		
	
	assertEquals(fetchCourses.fetchCourse(), list);
	
	assertEquals(fetchCourses.execute(), "success");
		

		
	
		
	}

}
