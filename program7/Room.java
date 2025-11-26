package program7;

public class Room {
 
	//fields
	private int roomNumber;
	private String roomType;
	private boolean isAvailable;
	private double nightlyRate; 
	
	//constructors
	public Room() {
		this(1, "Single", true, 1 );   //THIS IS THE DEFAULT!
	}
	public Room(int roomNumber, String roomType, double nightlyRate) {
		this(roomNumber, roomType, true, nightlyRate ); 
	}
	public Room(String roomType, double nightlyRate) {
		this(1, roomType, true, nightlyRate ); 
	}
	public Room(Room r) {
		this(r.roomNumber,r.roomType, r.isAvailable,r.nightlyRate);
	}
	public Room(int roomNumber, String roomType, boolean isAvailable, double nightlyRate) {
		if(roomNumber<1) {
			throw new IllegalArgumentException("Room numbers range from 1 thru 100. PLease enter a valid room number.");
		}
		if(roomType==null)
			throw new IllegalArgumentException("RoomType cant be null");
		if(nightlyRate<1) {
		throw new InvalidRateException("Invalid Rate. Rooms are never cheaper than $1 a night");
		}
		
		this.roomNumber=roomNumber;
		this.roomType=roomType;
		this.isAvailable= isAvailable;
		this.nightlyRate=nightlyRate;
	}
	//setters
	public void setRoomNumber(int roomNumber) {
		if(roomNumber<1) {
			throw new IllegalArgumentException("Room numbers cant be lower than 1.");
		}
		this.roomNumber=roomNumber;
	}
	public void setRoomType(String roomType) {
		if(roomType==null)
			throw new IllegalArgumentException("RoomType cant be null");
		this.roomType=roomType;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable= isAvailable;
	}
	public void setNightlyRate(double nightlyRate) {
		if(nightlyRate<1) {
			throw new InvalidRateException("Invalid Rate. Rooms are never cheaper than $1 a night");
		}
		this.nightlyRate=nightlyRate;
	}
	public void setAllRoomInfo(int roomNumber, String roomType, boolean isAvailable, double nightlyRate) {
		if(roomNumber<1) {
			throw new IllegalArgumentException("Room numbers cant be lower than 1.");
		}
		if(roomType==null)
			throw new IllegalArgumentException("RoomType cant be null");
		
		if(nightlyRate<1) {
			throw new InvalidRateException("Invalid Rate. Rooms are never cheaper than $1 a night");
		}
		
		this.roomNumber=roomNumber;
		this.roomType=roomType;
		this.isAvailable= isAvailable;
		this.nightlyRate=nightlyRate;
	}
	//getters
	public int getRoomNumber() {
		return roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public double getNightlyRate() {
		return nightlyRate;
	}
	//toString()
	
	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append(String.format("RoomNumber: %d  RoomType: %-10s  IsAvailable: %-5s  NightlyRate: $%,.2f%n",
	                             roomNumber, roomType, isAvailable, nightlyRate));
	    return str.toString();
	}

	

	//equals()
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Room other= (Room) obj;
		if(this.roomNumber != other.roomNumber)
			return false;
		return true;
	}
	
	
}
