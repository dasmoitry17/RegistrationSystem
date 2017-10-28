package AllActions;

public class AppliedStudent {

	public AppliedStudent() {
	// TODO Auto-generated constructor stub
	}
		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		AppliedStudent other = (AppliedStudent) obj;
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
		return true;
	}


	private String firstName;
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
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	private String lastName;
	
	private int id;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	private String gender;
	private String department;
	private String password;
	public String getPassword() {
		return password;
	}
	public AppliedStudent(String firstName, String lastName, int id, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.gender = gender;
	}
	
	public AppliedStudent(String firstName, String lastName, String department, String gender,String password,int id) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.gender = gender;
		this.password=password;
		this.id=id;
		
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
