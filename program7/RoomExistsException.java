package program7;

public class RoomExistsException extends RuntimeException {

	public RoomExistsException() {
		super("Room already exists");
	}
	public RoomExistsException(String message) {
		super(message);
	}
}
