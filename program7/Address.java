package program7;

public class Address {

	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Address(String street,String city, String state, String zipCode) {
		if(street==null)
			throw new IllegalArgumentException("Street name can't be null");
		if(city==null)
			throw new IllegalArgumentException("City name can't be null");
		if(state==null)
			throw new IllegalArgumentException("State name can't be null");
		if(zipCode.length() !=5) //.length() with strings returns the length of the String
			throw new IllegalArgumentException("ZipCode must be five digits.");
		this.street= street;
		this.city=city;
		this.state=state;
		this.zipCode= zipCode;
	}
	//getters
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zipCode;
	}
	//toString
	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append(String.format("Street: %-10s  City: %-10s  State: %-10s  ZipCode: %-10s", street, city, state, zipCode));
	    return str.toString();
	}

}
