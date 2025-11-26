package program7;
import java.time.*;
public class Reservation {

	private Room room; 
	private Guest guest;
	private BookingStatus bookingStatus;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	
	//constructors
	public Reservation(Room r, Guest g) {
		this(r,g, BookingStatus.PENDING, LocalDate.now(), LocalDate.now());
	}
	public Reservation(Room room, Guest guest, BookingStatus bookingStatus, LocalDate checkInDate, LocalDate checkOutDate) {
		//am i meant to be validating for this or not? TATTY SAID YES. Its common practice to validate to make sure no null values come in
		//prof margolis said its good also..:)
		if(room==null)
			throw new IllegalArgumentException("room can't be null");
		if(guest==null)
			throw new IllegalArgumentException("guest can't be null");
		if(bookingStatus==null)
			throw new IllegalArgumentException("BookingStatus can't be null");
		if(checkInDate==null)
			throw new IllegalArgumentException("checkInDate can't be null");
		if(checkOutDate==null)
			throw new IllegalArgumentException("checkOutDate can't be null");
		if(checkInDate.isAfter(checkOutDate))
			throw new InvalidDateException("Umm, thats not a valid date. CheckInDate must be BEFORE the checkOutDate");
		
		this.room= room;
		this.guest=guest;
		this.bookingStatus= bookingStatus;
		this.checkInDate=checkInDate;
		this.checkOutDate=checkOutDate;
	}
	public Reservation(Reservation r) {
		this(r.room, r.guest, r.bookingStatus, r.checkInDate, r.checkOutDate);
	}
	//setters
	public void setRoom(Room room) {
		if(room==null)
			throw new IllegalArgumentException("room can't be null");
		this.room=room;
	}
	public void setGuest(Guest guest) {
		if(guest==null)
			throw new IllegalArgumentException("guest can't be null");
		this.guest=guest;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		if(bookingStatus==null)
			throw new IllegalArgumentException("BookingStatus can't be null");
		this.bookingStatus=bookingStatus;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		if(checkInDate==null)
			throw new IllegalArgumentException("checkInDate can't be null");
		if(checkInDate.isAfter(checkOutDate))
			throw new InvalidDateException("Umm, thats not a valid date. CheckInDate must be BEFORE the checkOutDate");
		this.checkInDate= checkInDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		if(checkOutDate==null)
			throw new IllegalArgumentException("checkOutDate can't be null");
		if(checkOutDate.isBefore(checkInDate))
			throw new InvalidDateException("Umm, thats not a valid date. CheckInDate must be BEFORE the checkOutDate");
		this.checkOutDate= checkOutDate;
	}
	public void setAllReservations(Room room, Guest guest, BookingStatus bookingStatus, LocalDate checkInDate, LocalDate checkOutDate) {
		if(room==null)
			throw new IllegalArgumentException("room can't be null");
		if(guest==null)
			throw new IllegalArgumentException("guest can't be null");
		if(bookingStatus==null)
			throw new IllegalArgumentException("BookingStatus can't be null");
		if(checkInDate==null)
			throw new IllegalArgumentException("checkInDate can't be null");
		if(checkOutDate==null)
			throw new IllegalArgumentException("checkOutDate can't be null");
	   if(checkInDate.isAfter(checkOutDate))
			throw new InvalidDateException("Umm, thats not a valid date. CheckInDate must be BEFORE the checkOutDate");
		
		this.room= room;
		this.guest=guest;
		this.bookingStatus= bookingStatus;
		this.checkInDate=checkInDate;
		this.checkOutDate=checkOutDate;
	}
	
	//getters
	public Room getRoom() {
		return room;
	}
	public Guest getGuest() {
		return guest;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	//toString()- for pretty formatting put each object in its own append and call its toString()
	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append("Room Info:\n" + room.toString());
	    str.append("Guest Info:\n" + guest.toString());
	    str.append(String.format("BookingStatus: %-10s%n", bookingStatus));
	    str.append(String.format("CheckInDate: %-15s  CheckOutDate: %-15s%n", checkInDate, checkOutDate));
	    return str.toString();
	}

	//equals
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Reservation other= (Reservation) obj;
		//professor said in class that we should make an equals method here- and compare whatever we want to
		if(this.room==null) {
			if(other.room!=null)
				return false;
		}else if(!this.room.equals(other.room))
			return false;
		if(this.guest==null) {
			if(other.guest!=null)
				return false;
		}else if(!this.guest.equals(other.guest))
			return false;
		if(this.bookingStatus==null) {
			if(other.bookingStatus!=null)
				return false;
		}else if(!bookingStatus.equals(other.bookingStatus))
			return false;
		if(this.checkInDate==null) {
			if(other.checkInDate!=null)
				return false;
		}else if(!this.checkInDate.equals(other.checkInDate))
			return false;
		if(checkOutDate==null) {
			if(other.checkOutDate!=null)
				return false;
		}else if(!checkOutDate.equals(other.checkOutDate))
			return false;
		return true;	
	}
	
	
	
}
