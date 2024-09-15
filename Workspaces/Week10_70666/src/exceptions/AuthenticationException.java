package exceptions;

public class AuthenticationException  extends Exception{
	public AuthenticationException() {
		super("Username / Password salah");
	}
	
	public AuthenticationException(String message) {
		super(message);
	}
}
