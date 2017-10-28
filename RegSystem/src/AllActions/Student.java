package AllActions;

import java.util.List;

public class Student {
	
	private String firstName;
	private String lastName;
	private int id;
	private int stdId; //auto inc
	private String password;
	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public Student(String firstName, String lastName, int id, int stdId, String gender, 
			int no_course_taken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.stdId = stdId;
		this.gender = gender;
		
		this.no_course_taken = no_course_taken;
	}




	private String gender;
   
	public Student() {
		
	}
	

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	
		result = prime * result + no_course_taken;
		result = prime * result + stdId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		
		if (no_course_taken != other.no_course_taken)
			return false;
		if (stdId != other.stdId)
			return false;
		return true;
	}




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
