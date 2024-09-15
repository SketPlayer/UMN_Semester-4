package week10.rio.ac.id.umn.Tugas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.AuthenticationException;
import exceptions.ExcessiveFailedLoginException;
import exceptions.InvalidPropertyException;

public class Main {
    private static List<User> listOfUser = new ArrayList<>();

    public static void initialize() {
        User newUser = new User("John", "Doe", 'L', "Jl. Merpati No. 1 RT 1 RW 1, Banten", "admin", "admin");
        listOfUser.add(newUser);
    }

    public static void handleLogin() throws AuthenticationException {
        boolean isLoggedIn = false;
        Scanner inputLogin = new Scanner(System.in);
	    System.out.print("Username: ");
	    String username = inputLogin.nextLine();
	    System.out.print("Password: ");
	    String password = inputLogin.nextLine();
        for (User user : listOfUser) {
            try {
                isLoggedIn = user.login(username, password);
                if (isLoggedIn) {
                    System.out.println(user.greeting());
                    System.exit(0);
                    break;
                }
            } catch (ExcessiveFailedLoginException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        if (!isLoggedIn) {
            throw new AuthenticationException();
        }
    }
    
    public static void handleSignUp() throws InvalidPropertyException {
    	Scanner inputSignUp = new Scanner(System.in);
        System.out.print("Nama Depan : ");
        String firstName = inputSignUp.nextLine();
        System.out.print("Nama Belakang : ");
        String lastName = inputSignUp.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        char gender = inputSignUp.nextLine().charAt(0);
        System.out.print("Alamat : ");
        String address = inputSignUp.nextLine();
        System.out.print("Username : ");
        String username = inputSignUp.nextLine();
	        if (username.length() < 8) {
	        	throw new InvalidPropertyException("Username harus lebih dari 8 karakter");
	        }
	        for (User user : listOfUser) {
	            if (user.getUserName().equals(username)) {
	                throw new InvalidPropertyException("Username sudah digunakan");
	            }
	        }
        System.out.print("Password : ");
        String password = inputSignUp.nextLine();
	        if (!isValidPassword(password)) {
	            throw new InvalidPropertyException("Password harus mengandung huruf besar, angka, minimum 6 karakter, dan maksimum 16 karakter");
	        }
    	
        if (firstName == null || lastName == null || address == null || username == null || password == null) {
            throw new InvalidPropertyException("Semua properti pengguna harus diisi");
        }

        User newUser = new User(firstName, lastName, gender, address, username, password);
        listOfUser.add(newUser);
        System.out.println("User telah berhasil didaftarkan");
    }
    
    public static boolean isValidPassword(String password) {
        if (password.length() < 6 || password.length() > 16) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUpperCase && hasDigit;
    }
    
    public static void main(String[] args) {
        initialize();
        Scanner input = new Scanner(System.in);
        for(;;) {
	        System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.print("Pilihan	: ");
			int choice = input.nextInt();
			if (choice == 1) {
			    try {
			        handleLogin();
			    } catch (AuthenticationException e) {
			        System.out.println(e.getMessage());
			    }
			}
			else if (choice == 2) {
				try {
					handleSignUp();
				} catch (InvalidPropertyException e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("Invalid");
			    System.exit(0);
			    break;
			}
        }
    }
}
