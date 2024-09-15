package week11.Tugas;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

import exceptions.ExcessiveFailedLoginException;

public class User {
	private String name;
	private String email;
	private String password;
	private final boolean isAdmin;
	private MessageDigest digest;
	
	private static final int maxLoginAttempts = 3;
	private static int loginAttempts;
	
	private String hash(String strToHash) {
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
			return DatatypeConverter.printHexBinary(hash);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = hash(password);
	    this.isAdmin = email.endsWith("@admin.com");
	}

	public String getName() {
		return name;
	}
	
    public boolean isAdmin() {
        return isAdmin;
    }
	
    public boolean login(String email, String password) throws ExcessiveFailedLoginException {
		if(this.email.equals(email)) {
			if(loginAttempts == maxLoginAttempts) {
				loginAttempts++;
				throw new ExcessiveFailedLoginException();
			}else if(loginAttempts > maxLoginAttempts) {
				throw new ExcessiveFailedLoginException("Anda telah mencapai batas login");
			}
			if(this.password.equals(hash(password))) {
				loginAttempts = 0;
				return true;
			}else {
				loginAttempts++;
			}
		}
		return false;
	}
	
}
