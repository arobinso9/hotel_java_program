package program7;

import java.util.*; //for scanner and arrayLists
import java.time.*;//for time

public class ClientCode {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Hotel hotel = new Hotel(); // so now we can call methods an ArrayLists..

		createRooms(hotel, keyboard);
		createGuests(hotel, keyboard);
		createEmployees(hotel, keyboard);
		printInfo(hotel);

		System.out.println("We are all set!! :)");
		boolean proceed = true;
		int option;
		while (proceed) {
			displayOptions();
			option = keyboard.nextInt();
			option = validateOption(option, keyboard);
			if (option != 6) {
				switch (option) {
				case 1:
					bookReservation(hotel, keyboard);
					break;
				case 2:
					cancelReservation(hotel, keyboard);
					break;
				case 3:
					viewRoomInfo(keyboard, hotel);
					break;
				case 4:
					viewGuestInfo(keyboard, hotel);
					break;
				case 5:
					viewEmployeeInfo(keyboard,hotel);
				}
			} else {
				System.out.println("Goodbye!");
				proceed = false;
			}
		}
	}
	public static void viewEmployeeInfo(Scanner keyboard, Hotel h) {
		keyboard.nextLine();
		String employeeID= doesEmployeeExist(h, keyboard);
		while(employeeID==null)
			 employeeID= doesEmployeeExist(h, keyboard);
		Employee e= h.getInfoOnEmployee(employeeID);
		System.out.println(e);
		
	}
	public static String doesEmployeeExist(Hotel h, Scanner keyboard) {
		System.out.println("Which employee do you want info on? Enter in the EmployeeID number");
		System.out.println("Here are your options to choose from----->");
		for(int i=0; i<h.getEmployees().size(); i++) {
			System.out.print(h.getEmployees().get(i).getEmployeeID()+ " ");
		}
		String id= keyboard.nextLine();
		boolean found=false;
		
		for(int i=0; i<h.getEmployees().size() && !found; i++) {
			if(h.getEmployees().get(i).getEmployeeID().equalsIgnoreCase(id))
			     found=true;
		}
		if(found)
			return id;
		return null;
	}
	public static void viewGuestInfo(Scanner keyboard, Hotel hotel) {
		keyboard.nextLine();
		Boolean exists=true;
		Guest guest;
		System.out.println("Which guests info do you want? Enter the reservation number of the guest");
		String r = keyboard.nextLine();
		exists = doesReservationNumberExist(r, hotel);
		while (!exists) {
			System.out.println("Please choose a valid guest name to make your reservation. Here are your options---->");
			for (int i = 0; i < hotel.getGuests().size(); i++)
				System.out.println(hotel.getGuests().get(i).getReservationNumber()+" ");
			System.out.println("What is the reservationNumber?");
			r= keyboard.nextLine();
			exists = doesReservationNumberExist(r, hotel);
		}
		guest=hotel.getGuestInfo(r);
		//print the guests info
		System.out.println(guest.toString());
		
	}
	public static void viewRoomInfo(Scanner keyboard, Hotel hotel) {
		Room room;
		Boolean exists=true;
		System.out.println("Which room do you want info on? Type in roomNumber");
		int roomNumber= keyboard.nextInt();
		exists = doesRoomExist(roomNumber, hotel);
		while (!exists) {
			System.out.println("Please choose a valid roomNumber, and type it in. Here are your options----->");
			for (int i = 0; i < hotel.getRooms().size(); i++)
				System.out.println(hotel.getRooms().get(i).getRoomNumber()+" ");
			System.out.println("What is the roomNumber?");
			roomNumber= keyboard.nextInt();
			exists = doesRoomExist(roomNumber, hotel);
		}
		room=hotel.getInfoOnRoom(roomNumber);
		//print the rooms info
		System.out.println(room.toString());
	}
	public static String promptForValidReservationNumber(Hotel hotel, Scanner keyboard) {
	    System.out.println("What's your reservation number?");
	    String r = keyboard.nextLine();
	    boolean exists = doesReservationNumberExist(r, hotel);

	    while (!exists) {
	        System.out.println("Please enter a valid reservation number. Here are the options:");
	        for (Guest g : hotel.getGuests()) {
	            System.out.print(g.getReservationNumber() + "  ");
	        }
	        System.out.println("\nWhat's your reservation number?");
	        r = keyboard.nextLine();
	        exists = doesReservationNumberExist(r, hotel);
	    }
	    return r;
	}

	public static void bookReservation(Hotel hotel, Scanner keyboard) {
	    Reservation reservation = promptForReservationDetails(hotel, keyboard);
	        try {
	            hotel.addReservation(reservation);
	            System.out.println("SUCCESS!! Reservation booked!");
	        } catch (ReservationExistsException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    } 

	public static void cancelReservation(Hotel hotel, Scanner keyboard) {
	    keyboard.nextLine();
	    try {
	        System.out.println("Let's cancel your reservation!");
	        String r = promptForValidReservationNumber(hotel, keyboard);
	        hotel.cancelReservation(r);
	        System.out.println("SUCCESS!! Reservation cancelled!");
	    } catch (ReservationNotFoundException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}

	public static Reservation promptForReservationDetails(Hotel hotel, Scanner keyboard) {
	    boolean exists;
	    Room room;
	    Guest guest;
	    LocalDate checkIn;
	    LocalDate checkOut;
	    BookingStatus bookingStatus;
	    
	    try {
	        System.out.println("Let's book your reservation!");

	      //get the roomNum
	        System.out.println("What Room number do you want? Room number must be 1 or higher");
	        int roomNumber = keyboard.nextInt();
	        roomNumber = roomNumChecker(roomNumber, keyboard);
	        exists = doesRoomExist(roomNumber, hotel);
	        while (!exists) {
	            System.out.println("Please choose a valid roomNumber. Here are your options:");
	            for (Room r : hotel.getRooms()) {
	                System.out.print(r.getRoomNumber() + "  ");
	            }
	            System.out.println("\nWhat's your roomNumber?");
	            roomNumber = keyboard.nextInt();
	            roomNumber = roomNumChecker(roomNumber, keyboard);
	            exists = doesRoomExist(roomNumber, hotel);
	        }
	        room = hotel.getInfoOnRoom(roomNumber);
	        keyboard.nextLine(); // consume newline

	        // get the reservationNUm
	        System.out.println("What's your reservation number?");
	        String r = keyboard.nextLine();
	        exists = doesReservationNumberExist(r, hotel);
	        while (!exists) {
	            System.out.println("Please enter a valid reservation number from the following options:");
	            for (Guest g : hotel.getGuests()) {
	                System.out.print(g.getReservationNumber() + "  ");
	            }
	            System.out.println("\nWhat's your reservation number?");
	            r = keyboard.nextLine();
	            exists = doesReservationNumberExist(r, hotel);
	        }
	        guest = hotel.getGuestInfo(r);

	        System.out.println("What's your booking status? You must type in PENDING, CANCELLED, or CONFIRMED");
	        String bstatus = keyboard.nextLine().toUpperCase();
	        bookingStatus = validateBookingStatus(keyboard, bstatus);

	        System.out.println("What day are you checking in? (YYYY-MM-DD)");
	        String d = keyboard.nextLine();
	        d = dateChecker(d, keyboard);
	        checkIn = LocalDate.parse(d);

	        System.out.println("What day are you checking out? (YYYY-MM-DD)");
	        d = keyboard.nextLine();
	        d = dateChecker(d, keyboard);
	        checkOut = LocalDate.parse(d);

	        boolean isValid = validateCheckInIsBeforeCheckOut(checkIn, checkOut);
	        while (!isValid) {
	            System.out.println("Invalid! Check in must be BEFORE check out.");
	            System.out.println("What day are you checking in? (YYYY-MM-DD)");
	            d = keyboard.nextLine();
	            d = dateChecker(d, keyboard);
	            checkIn = LocalDate.parse(d);
	            System.out.println("What day are you checking out? (YYYY-MM-DD)");
	            d = keyboard.nextLine();
	            d = dateChecker(d, keyboard);
	            checkOut = LocalDate.parse(d);
	            isValid = validateCheckInIsBeforeCheckOut(checkIn, checkOut);
	        }

	        return new Reservation(room, guest, bookingStatus, checkIn, checkOut);

	    } catch (Exception e) {
	        System.out.println("Error during reservation creation: " + e.getMessage());
	        return null;
	    }
	}

	public static boolean validateCheckInIsBeforeCheckOut(LocalDate checkIn, LocalDate checkOut) {
		if(checkIn.isAfter(checkOut))  //isBefore and isAfter we use when comparing two LocalDate objects
			return false;
		return true;
	}

	public static boolean doesReservationNumberExist(String number, Hotel hotel) {
		for (int i = 0; i < hotel.getGuests().size(); i++) {
			if (hotel.getGuests().get(i).getReservationNumber().equalsIgnoreCase(number))
				return true;
		}
		return false;
	}
	public static boolean doesRoomExist(int roomNumber, Hotel hotel) {
		for (int i = 0; i < hotel.getRooms().size(); i++) {
			if (hotel.getRooms().get(i).getRoomNumber() == roomNumber)
				return true;
		}
		return false;
	}
	public static BookingStatus validateBookingStatus(Scanner keyboard, String bstatus) {
		BookingStatus bookingStatus = BookingStatus.PENDING;
		boolean proceed=true;
		while (proceed) {
			try {
				bookingStatus = BookingStatus.valueOf(bstatus); // use valueOf to convert string to type enum
				proceed = false;
			} catch (IllegalArgumentException e) { //MAKE CUSTOM ERROR MESSAGE THINGY
				System.out.println("Illegal. Try again. Whats your booking status? You must type in PENDING,CANCELLED, or CONFIRMED");
				bstatus = keyboard.nextLine().toUpperCase();
			}
		}
		return bookingStatus;
	}
	public static int validateOption(int option, Scanner keyboard) {
		while (option < 1 || option > 6) {
			System.out.println("Invalid option. Follow instructions please and try again.");
			displayOptions();
			option = keyboard.nextInt();
		}
		return option;
	}

	public static void displayOptions() {
		System.out.printf("Type 1 to book a reservation"
				+ "%nType 2 to cancel a reservation%nType 3 to view room details%n"
				+ "Type 4 to view guest details%nType 5 to view employee details%nType 6 to EXIT ");
	}

	public static Person createPerson(Scanner keyboard) {
		Gender gender;
		System.out.println("What is your firstName?");
		String f = keyboard.nextLine();
		System.out.println("What is your lastName?");
		String l = keyboard.nextLine();
		System.out.println("What is your gender? Male or Female");
		String g = keyboard.nextLine();
		gender = genderChecker(g, keyboard);
		System.out.println("What street do you live on?");
		String street = keyboard.nextLine();
		System.out.println("What city do you live in?");
		String c = keyboard.nextLine();
		System.out.println("What state do you live in?");
		String s = keyboard.nextLine();
		System.out.println("Whats your five digit zipcode?");
		String z = keyboard.nextLine();
		while(z.length()!=5) {
			System.out.println("zipcode must be 5 integers. please try again");
			 z = keyboard.nextLine();
		}
		System.out.println("What is your birthdate?- Type it in with this forma: YYYY-MM-DD");
		String d = keyboard.nextLine();
		d = dateChecker(d, keyboard);
		Person person = new Person(f, l, gender, new Address(street, c, s, z), d);
		return person;
	}

	public static void createGuests(Hotel hotel, Scanner keyboard) {
		String response = null;
		Guest guest;
		Person person;
		System.out.println("Now we are ready to add Guests to your hotel!");
		do {
			try {
			person = createPerson(keyboard);
			System.out.println("Whats your reservation number?");
			String r = keyboard.nextLine();
			System.out.println("Whats your phone number?");
			String p = keyboard.nextLine();
			System.out.println("Whats your email?");
			String email = keyboard.nextLine();
			guest = new Guest(person, r, p, email);
			hotel.addGuest(guest); 
			System.out.println("To continue adding guests, type CONT, to exit, type EXIT. Default is EXIT");
			response = keyboard.nextLine();
			}catch(GuestExistsException e) {
				System.out.println("Error "+ e.getMessage());
			}
		} while (response.equalsIgnoreCase("CONT"));
	}

	public static void createEmployees(Hotel hotel, Scanner keyboard) {
		String response = null;
		Person person;
		Employee employee;
		System.out.println("Now we are up to our Employees!");
		do {
			try {
			person = createPerson(keyboard);
			System.out.println("Whats your employeeID?");
			String employeeID = keyboard.nextLine();
			System.out.println("Whats your role?");
			String role = keyboard.nextLine();
			System.out.println("Whats your department?");
			String dept = keyboard.nextLine();
			employee = new Employee(person, employeeID, role, dept); // first create address and gender, then create the employee
			hotel.addEmployee(employee);
			System.out.println("To continue adding employees, type CONT, to exit, type EXIT. Default is EXIT");
			response = keyboard.nextLine();
			}catch(EmployeeExistsException e) {
				System.out.println("Error."+ e.getMessage());
			}
		} while (response.equalsIgnoreCase("CONT"));
	}

	public static void createRooms(Hotel hotel, Scanner keyboard) {
		String response = null;
		Room room;
		System.out.println("Hello! Welcome to our towns Hotel. Lets get this place up and running!");
		System.out.println("We will start by setting up the Hotel rooms.");
		
		do {
			try {
			System.out.println("What Room number? Room number must be 1 or higher");
			int roomNumber = keyboard.nextInt();
			roomNumber = roomNumChecker(roomNumber, keyboard);
			keyboard.nextLine(); // consume newline char
			System.out.println("What room type?- Single, Double, Suite");
			String roomType= roomTypeChecker(keyboard);
			System.out.println("Whats the price the room? Price must be at least $1");
			double price = keyboard.nextDouble();
			price = priceChecker(price, keyboard);
			keyboard.nextLine(); // consume newline char
			room = new Room(roomNumber, roomType, price); // created the room
			hotel.addRoom(room); // add the room to the hotel arrayList of rooms
			System.out.println("To continue adding rooms, type CONT, to exit, type EXIT. Default is EXIT");
			response = keyboard.nextLine();
		}catch(RoomExistsException e) {
			System.out.println("Error  "+ e.getMessage());
		}
		}while (response.equalsIgnoreCase("CONT"));
	}
	public static String roomTypeChecker(Scanner keyboard) {
		String roomType = keyboard.nextLine();
		while(!roomType.equalsIgnoreCase("Single")&& !roomType.equalsIgnoreCase("Double")&& !roomType.equalsIgnoreCase("Suite")) {
			System.out.println("Illegal.You must enter Single, Double, Suite. Please try again. Enter a room type");
			roomType = keyboard.nextLine();
		}
		return roomType;
			
	}

	public static void printInfo(Hotel hotel) {
		System.out.println("\n-----------Room info----------------");
		for (int i = 0; i < hotel.getRooms().size(); i++)
			System.out.println(hotel.getRooms().get(i));
		System.out.println("\n-----------Guest info---------------");
		for (int i = 0; i < hotel.getGuests().size(); i++)
			System.out.println(hotel.getGuests().get(i));
		System.out.println("\n-----------Employee info------------");
		for (int i = 0; i < hotel.getEmployees().size(); i++)
			System.out.println(hotel.getEmployees().get(i));
	}

	public static String dateChecker(String d, Scanner keyboard) {
		boolean invalid = true;
		while (invalid) {
			try {
				LocalDate date = LocalDate.parse(d);
				invalid = false;
			} catch (DateTimeException e) { // throw my own exception- bad input!
				System.out.println("Whoops. Please type in the date to the following format: YYYY-MM-DD");
				d = keyboard.nextLine();
			}
		}
		return d;
	}

	public static Gender genderChecker(String g, Scanner keyboard) {
		Gender gender = Gender.FEMALE;
		boolean invalid = true;
		while (invalid) {
			try {
				gender = Gender.valueOf(g.toUpperCase()); // This is how we convert a String into type enum.
				invalid = false; // converted g to UpperCase, so that user can type in info and its case
									// insensitive. more flexibility. -bc enums must be in CAPS
			} catch (IllegalArgumentException e) {
				System.out.println("Oh no. Please either type in MALE or FEMALE. You have 2 options");
				g = keyboard.nextLine();
			}
		}
		return gender;
	}

	public static int roomNumChecker(int roomNumber, Scanner keyboard) {
		while (roomNumber < 1) {
			System.out.println("Invalid. Room number must be 1 or higher. Try again");
			roomNumber = keyboard.nextInt();
		}
		return roomNumber;
	}
	public static double priceChecker(double price, Scanner keyboard) {
		while (price < 1) {
			System.out.println("Illegal! Price must be at least $1. Please enter a new price.");
			price = keyboard.nextDouble();
		}
		return price;
	}
}