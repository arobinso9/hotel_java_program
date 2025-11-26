package program7;

import java.util.*; //must hv import statement for the ArrayLists!!

public class Hotel {

	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;
	private ArrayList<Employee> employees;
	private ArrayList<Guest> guests; //i need this field so i added it


	// constructors
	public Hotel() {
		rooms = new ArrayList<>();
		reservations = new ArrayList<>();
		employees = new ArrayList<>();
		guests= new ArrayList<>();
	}

	public Hotel(Hotel h) {
		this(h.rooms, h.reservations, h.employees, h.guests);
	}

	public Hotel(ArrayList<Room> rooms, ArrayList<Reservation> reservations, ArrayList<Employee> employees, ArrayList <Guest> guests) {
		if (rooms == null)
			throw new IllegalArgumentException("Rooms can't be null");
		if (reservations == null)
			throw new IllegalArgumentException("Reservations can't be null");
		if (employees == null)
			throw new IllegalArgumentException("Employees can't be null");
		if(guests==null) 
			throw new IllegalArgumentException("Guests can't be null");
		// this.rooms=rooms; both arrays are pointing to the same address-so
		// removing/adding/changing objects is obv seen in both-- same reference. not even a shallow copy...
		/**
		 * for(int i=0; i<rooms.size(); i++) { this.rooms.add(rooms.get(i)); } - SHALLOW
		 * COPY! - bc we are copying param rooms references and storing them in our
		 * fields rooms arrayList. New arraylist but reference same objects. when u add/remove w shallow copy, the other arrayList
		 * doesn't change- bc u either just added another reference to an object, or u
		 * just removed a reference to an object, so u no longer have access to it. 
		 * shallow copy ex-this.rooms.add(rooms.get(i));- new list but references/points to the same objects 
		 * However, when one guy makes changes to the actual
		 * Objects in the ArrayList(which both guys reference) then the changes will be
		 * seen in both ArrayLists which can potentially be unsafe for the data.
		 *  --To make a deep copy of an ArrayList- we need to 1)make a new ArrayList and 2)
		 * make new Objects to be added to our new ArrayList:) In our first case, we
		 * will be creating new rooms and adding that to our new ArrayList. We can only
		 * create these new rooms IF AND ONLY IF we have a copy constructor in the Room
		 * class, which we do. We are creating new objects, for our new list, so that
		 * when u change the value of one object it wont change the value of the other
		 * object in the other ArrayList bc they are 2 different objects now!
		 */

		// DEEP COPIES:
		this.rooms = new ArrayList<>(); // creates a brand-new list
		for (int i = 0; i < rooms.size(); i++)
			this.rooms.add(new Room(rooms.get(i))); // creates a new Room object (thru Room copy constructor) for each
													// original

		this.reservations = new ArrayList<>();
		for (Reservation r : reservations) // same idea but we used the for each loop instead.
			this.reservations.add(new Reservation(r));

		this.employees = new ArrayList<>();
		for (Employee e : employees) // (DataType var: ArrayListName)
			this.employees.add(new Employee(e));
		
		this.guests=new ArrayList<>();
		for(int i=0; i<guests.size(); i++)
			this.guests.add(new Guest(guests.get(i)));
	}

	// setters
	public void setRooms(ArrayList<Room> rooms) {
		if (rooms == null)
			throw new IllegalArgumentException("Rooms can't be null");
		this.rooms = new ArrayList<>();
		for (Room r : rooms)
			this.rooms.add(new Room(r));
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		if (reservations == null)
			throw new IllegalArgumentException("Reservations can't be null");
		this.reservations = new ArrayList<>();
		for (Reservation r : reservations)
			this.reservations.add(new Reservation(r));
	}

	public void setEmployees(ArrayList<Employee> employees) {
		if (employees == null)
			throw new IllegalArgumentException("Employees can't be null");
		this.employees = new ArrayList<>();
		for (Employee e : employees)
			this.employees.add(new Employee(e));
	}
	public void setGuests(ArrayList <Guest> guests) {
		if(guests==null) 
			throw new IllegalArgumentException("Guests can't be null");
		this.guests=new ArrayList<>();
		for(int i=0; i<guests.size(); i++)
			this.guests.add(new Guest(guests.get(i)));
	}

	public void setAllHotelComponents(ArrayList<Room> rooms, ArrayList<Reservation> reservations,
			ArrayList<Employee> employees, ArrayList <Guest> guests) {
		if (rooms == null)
			throw new IllegalArgumentException("Rooms can't be null");
		if (reservations == null)
			throw new IllegalArgumentException("Reservations can't be null");
		if (employees == null)
			throw new IllegalArgumentException("Employees can't be null");
		if(guests==null) 
			throw new IllegalArgumentException("Guests can't be null");

		this.rooms = new ArrayList<>();
		for (Room r : rooms)
			this.rooms.add(new Room(r));

		this.reservations = new ArrayList<>();
		for (Reservation r : reservations)
			this.reservations.add(new Reservation(r));

		this.employees = new ArrayList<>();
		for (Employee e : employees)
			this.employees.add(new Employee(e));
	
		this.guests=new ArrayList<>();
		for(int i=0; i<guests.size(); i++)
			this.guests.add(new Guest(guests.get(i)));
	}

	// getters
	public ArrayList<Room> getRooms() { // for the return type in ArrayLists, u must do it like this
		ArrayList<Room> copy= new ArrayList<>();
		for(int i=0; i<rooms.size();i++) 
		    copy.add(new Room(rooms.get(i)));                                //copy over current values from field, and return a deep copy of it.
		return copy;
	}

	public ArrayList<Reservation> getReservations() {
		ArrayList<Reservation> copy= new ArrayList<>();
		for(Reservation r: reservations)
			copy.add(new Reservation(r));
		return copy;
	}

	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> copy= new ArrayList <>();
		for(Employee e: employees)
			copy.add(new Employee(e));
		return copy;
	}
	public ArrayList<Guest> getGuests(){
		ArrayList<Guest> copy=new ArrayList<>();
		for(int i=0; i<guests.size(); i++)
			copy.add(new Guest(guests.get(i)));
		return copy;
	}


	// toString()
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(String.format("Complete Room Info:%s%n  Complete Reservation Info:%s%n Complete Employee Info:%s%n  Complete Guest Info:%s%n",
						rooms, reservations, employees,guests));
		return str.toString();
	}

	// Other methods
	// add room to hotel if it does not already exist.
	public void addRoom(Room r) { // rooms ArrayList can't be null bc we validated for that. so don't need to check it again
		if(rooms.contains(r)) //we can only use the contains method bc we have an equals method in the Room class
		  throw new RoomExistsException();

		rooms.add(new Room(r)); // add a deep copy!
	}

	// add reservation. receive a reservation. if there's a reservation for that room, don't add it in.
	public void addReservation(Reservation r) {
			if(reservations.contains(r))
				throw new ReservationExistsException();
		reservations.add(new Reservation(r));
	}
	//professor margolis said we can add methods if need
	public void addGuest(Guest g) {
		if(guests.contains(g))
			throw new GuestExistsException();
		guests.add(new Guest(g));
}

	// cancel reservation.
	public void cancelReservation(String reservationNumber) {
		// loop thru the reservations, get the guest, get the reservation number, and do a
		// sequential search to see if the one passed in is there.
		boolean reservationTaken = false;
		int ctr = -1;
		for (int i = 0; i < reservations.size() && reservationTaken != true; i++) {
			if (reservations.get(i).getGuest().getReservationNumber().equalsIgnoreCase(reservationNumber)) {
				reservationTaken = true;
				ctr = i;
			}
		}
		if (reservationTaken)
			reservations.remove(ctr);
		 else
		 throw new ReservationNotFoundException();
	}

	// finds specific room info- find the room in the ArrayList and return the Room
	// object. get the room object, get room number
	public Room getInfoOnRoom(int roomNumber) {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getRoomNumber() == roomNumber)  
				return rooms.get(i);
		}
		return null;
	}

	// finds guests info when they send in reservation number. get reservation obj,
	// get guest, get guests reservation number
	public Guest getGuestInfo(String reservationNumber) {
		for (int i = 0; i < guests.size(); i++) {
			if (guests.get(i).getReservationNumber().equalsIgnoreCase(reservationNumber))
				return guests.get(i);
		}
		return null;
	}

	// add employee to hotel- get an employee object. then use contains() to see if employee is already there.
	public void addEmployee(Employee e) {
		 if(employees.contains(e))
		 throw new EmployeeExistsException();
		employees.add(new Employee(e)); // deep copy!! we made a new employee, and then we added the NEW employee.
		//adds Employee object which is adding an element to the employees array list
	}
	public Employee getInfoOnEmployee(String employeeID) {
		for(int i=0; i<employees.size(); i++) {
			if(employees.get(i).getEmployeeID().equalsIgnoreCase(employeeID))
				return employees.get(i);
			}
		return null;
	}
	
	

}
