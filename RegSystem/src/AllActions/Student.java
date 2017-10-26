package AllActions;

import java.util.List;

public class Student {
	
	private String firstName;
	private String lastName;
	private int id;
	private int stdId; //auto inc
	private String gender;
    private List<Course> listOfCourses;
    private int no_course_taken;
    
	
    public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public int getNo_course_taken() {
		return no_course_taken;
	}

	public void setNo_course_taken(int no_course_taken) {
		this.no_course_taken = no_course_taken;
	}

	public List<Course> getListOfCourses() {
		return listOfCourses;
	}

	public void setListOfCourses(List<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	


}
