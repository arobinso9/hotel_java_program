package program7;

public class InvalidDateException extends RuntimeException {

	InvalidDateException(){
		super("Invalid Date.");
	}
	InvalidDateException(String message){
		super(message);
	}
}
