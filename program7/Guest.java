package program7;

public class Guest extends Person { //WE MUST HV THIS W INHERITANCE. 

	private String reservationNumber;
	private String phoneNumber;
	private String email;
	
	public Guest(String f, String l, Gender g, Address addr, String birthdate, String reservationNumber, String phoneNumber, String email) {
		super(f,l,g,addr,birthdate); //calls the Persons constructor, so now we have access to those fields thru their GETTERS
		if(reservationNumber==null)
			throw new IllegalArgumentException("Reservation-number cant be null");
		if(phoneNumber==null)
			throw new IllegalArgumentException("Phone-number cant be null");
		if(email==null)
			throw new IllegalArgumentException("Email cant be null");
		this.reservationNumber= reservationNumber;
		this.phoneNumber= phoneNumber;
		this.email= email;
	}
	//professor margolis said we can add in methods if we need them for the client code and she wont take off any points- she said we should comment this to you
	public Guest(Person p, String reservationNumber, String phoneNumber, String email) {
		super(p); //copies person object and stores values in the fields
		if(reservationNumber==null)
			throw new IllegalArgumentException("Reservation-number cant be null");
		if(phoneNumber==null)
			throw new IllegalArgumentException("Phone-number cant be null");
		if(email==null)
			throw new IllegalArgumentException("Email cant be null");
		this.reservationNumber= reservationNumber;
		this.phoneNumber= phoneNumber;
		this.email= email;
	}
	public Guest(Guest g) {
		/**
		 * When you make a new Guest, you also need to construct the Person part of it. That’s where super(...) comes in 
		 * Bc we are working with inheritance, if we have a Guest then we must have a person! bc a guest is a person. 
		 * you CANT use super(g) in a call to the constructor above, It wont work.= java rule.
		 * Since Guest extend Person ie a Guest IS A person- we have access to all public fields and methods. 
		 * In our case, we only have private fields, and public methods. So we have access to the Person fields! yay!
		 * if we would have done super(g) and then this.email=email....we would have been calling the Persons copy constructor.
		 */
		this(g.getFirstName(), g.getLastName(), g.getGender(), g.getAddress(),
				g.getBirthdate().toString(), g.reservationNumber, g.phoneNumber, g.email);
	}
	public void setReservationNumber(String reservationNumber) {
		if(reservationNumber==null)
			throw new IllegalArgumentException("Reservation-number cant be null");
		this.reservationNumber= reservationNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber==null)
			throw new IllegalArgumentException("Phone-number cant be null");
		this.phoneNumber= phoneNumber;
	}
	public void setEmail(String email) {
		if(email==null)
			throw new IllegalArgumentException("Email cant be null");
		this.email= email;
	}
	public String getReservationNumber() {
		return reservationNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append(super.toString());
	    str.append(String.format("Reservation-number: %-15s  Phone-number: %-15s  Email: %-25s%n",
	                             reservationNumber, phoneNumber, email));
	    return str.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true; //if they hv same address then r the same object
		if(o==null)
			return false; //if obj is null, cant be = to current object bc we just called the equals method on it and did not get null pointer exception
		if(this.getClass()!= o.getClass()) //if r not instances of same class, cant be =
			return false;
		Guest other= (Guest) o;
		if(this.reservationNumber==null) {
			if(other.reservationNumber !=null)
				return false;
		}else if(!reservationNumber.equalsIgnoreCase(other.reservationNumber))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
