package program7;

public class Employee extends Person {

	private String employeeID;
	private String role;
	private String department;
	
	public Employee(String f, String l, Gender g, Address addr, String birthdate, String employeeID, String role, String department) {
		super(f,l,g,addr,birthdate); //go to Person constructor and everything will be validated there
		if(employeeID==null)
			throw new IllegalArgumentException("EmployeeID cant be null");
		if(role==null)
			throw new IllegalArgumentException("Role can't be null");
		if(department==null)
			throw new IllegalArgumentException("Department can't be null");
		this.employeeID= employeeID;
		this.role=role;
		this.department= department;
	}
	//professor margolis said we can add in methods if we need them for the client code and she wont take off any points- she said we should comment this to you
	public Employee(Person person, String employeeID, String role, String department) {
		super(person);
		if(employeeID==null)
			throw new IllegalArgumentException("EmployeeID cant be null");
		if(role==null)
			throw new IllegalArgumentException("Role can't be null");
		if(department==null)
			throw new IllegalArgumentException("Department can't be null");
		this.employeeID= employeeID;
		this.role=role;
		this.department= department;
	}
	public Employee(Employee e) {
		this(e.getFirstName(), e.getLastName(), e.getGender(), e.getAddress(), e.getBirthdate().toString(), e.employeeID, e.role, e.department);
	}
	public void setEmployeeID(String employeeID) {
		if(employeeID==null)
			throw new IllegalArgumentException("EmployeeID cant be null");
		this.employeeID= employeeID;
	}
	public void setRole(String role) {
		if(role==null)
			throw new IllegalArgumentException("Role can't be null");
		this.role=role;
	}
	public void setDepartment(String department) {
		if(department==null)
			throw new IllegalArgumentException("Department can't be null");
		this.department= department;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public String getRole() {
		return role;
	}
	public String getDepartment() {
		return department;
	}
	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append(super.toString());
	    str.append(String.format("EmployeeID: %-15s  Role: %-15s  Department: %-15s%n", employeeID, role, department));
	    return str.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o==null)
			return false;
		if(this.getClass() != o.getClass()) //do they both reference the same class
			return false;
		Employee other= (Employee) o;
		if(this.employeeID==null) {
			if(other.employeeID!=null)
				return false;
		}else if(!this.employeeID.equalsIgnoreCase(other.employeeID))
			return false;
		return true;
	}
}
