package program7;

public class ReservationNotFoundException extends RuntimeException{

	public ReservationNotFoundException() {
		super("Reservation was not found");
	}
	public ReservationNotFoundException(String message) {
		super(message);
	}
}
