package program7;

public class GuestExistsException extends RuntimeException {
//professor said we are allowed to create our own exceptions if we want
	public GuestExistsException() {
		super("Guest already exists");
	}
	public GuestExistsException(String message) {
		super(message);
	}
}
