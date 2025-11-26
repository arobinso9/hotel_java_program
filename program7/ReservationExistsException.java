package program7;

public class ReservationExistsException extends RuntimeException {

	public ReservationExistsException() {
		super("Reservation already exists.");
	}
	public ReservationExistsException(String message) {
		super(message);
	}
}
