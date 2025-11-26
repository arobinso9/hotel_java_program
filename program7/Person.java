package program7;
import java.time.*; //for LocalDate
public class Person {
/**
 * Person HAS A address, so we need to create the address in the Person class- bc the person does not yet hv an address from b4.
 * However, a Guest IS A Person, so in the Guest class, we already have a guest, which means we already have a person, 
 * so we user the super() to INHERIT the info from the previous class!
 */
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private LocalDate birthdate;
	
	//ASK TATTY IF ITS OVERKILL TO MAKE SURE STRINGS ARE NOT NULL- its ok lol
	public Person(String f, String l, Gender g, Address add, String birthdate) {
		if(f==null) 
			throw new IllegalArgumentException("First name cant be null");
		if(l==null)
			throw new IllegalArgumentException("Last name can't be null");
		if(g==null)
			throw new IllegalArgumentException("Gender cant be null");
		if(add==null)
			throw new IllegalArgumentException("Address cant be null");
		if(birthdate==null)
			throw new IllegalArgumentException("Birthdate cant be null");
		
			this.birthdate= LocalDate.parse(birthdate); //use LocalDate.parse () to convert date of type String to type LocalDate.
		
		firstName=f;
		lastName=l;
		gender=g;
		address=add;
	}
	public Person (String f, String l, Gender g, String s, String c, String state, String zip, String birthdate) {
		/**since the user is entering in values that are used to create an Address object- composition, we need to
		 * create the Address object here and then pass that into out constructor.
		 * Its tricky bc the call to the constructor MUST be the first line of the method.
		 * We are NOT allowed to declare a variable inside a method call, so you can't do Address addr=new Address() if its in
		 * the method call. We can tho crate a new Address object and then pass that directly into the method call. so long as 
		 * we are not declaring a new variable, we are okay! What we did is- passed an object as an argument=LEGAL.
		 */
		this(f,l,g, new Address(s,c,state, zip), birthdate);
	}
	public Person(String f, String l, Gender g, Address add, LocalDate birthdate) {
		this(f,l,g,add,birthdate.toString()); //we convert birthday which is type LocalDate into type String by using .toString()
	}
	public Person(Person p) {
		this(p.firstName, p.lastName, p.gender, p.address, p.birthdate);
	}
	
	//getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public Address getAddress() {
		return address;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	//setters
	public void setLastName(String last) {
		if(last==null) 
			throw new IllegalArgumentException("Last name can't be null");
		lastName=last;
	}
	public void setAddress(Address addr) {
		if(addr==null)
			throw new IllegalArgumentException("Address cant be null");
		address=addr;
	}
	//toString
	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append(String.format("Name: %-15s %-15s  Gender: %-8s%n", firstName, lastName, gender));
	    str.append("Address: " + address.toString() + "%n");
	    str.append(String.format("Birthday: %s%n", birthdate));
	    return str.toString();
	}

	//equals
	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o==null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Person other= (Person) o;
		if(this.firstName==null) { // we need to compare first name bc if we have twins both living at home...
			if(other.firstName!=null)
				return false;
		}else if(!this.firstName.equalsIgnoreCase(other.firstName))
			return false;
		if(this.lastName==null) {
			if(other.lastName!=null)
				return false;
		}else if(!this.lastName.equalsIgnoreCase(other.lastName))
			return false;
		if(this.birthdate==null) {
			if(other.birthdate!=null)
				return false;
		}else if(!this.birthdate.equals(other.birthdate))
			return false;
		return true;
	}
	
	
	
	
	
	
}
