package program7;

public class EmployeeExistsException extends RuntimeException {

	public EmployeeExistsException () {
		super("Employee already exists");
	}
	public EmployeeExistsException (String message) {
		super(message);
	}
}
