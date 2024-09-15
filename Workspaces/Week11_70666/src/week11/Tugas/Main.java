package week11.Tugas;

import java.util.Scanner;

import exceptions.AuthenticationException;
import exceptions.ExcessiveFailedLoginException;
import exceptions.InvalidPropertyException;

import java.util.ArrayList;

public class Main {
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Job> jobs = new ArrayList<Job>();
	
	public static void seedData() {
		jobs.add(new Job(1, "Manager E-commerce", "Full Time", "Sales",
				"to 2 years of experience in Ecommerce Organization", "Jakarta, Indonesia"));
		jobs.add(new Job(2, "Tax Manager", "Full Time", "Finance",
				"Minimum of bachelor's degree in Accounting", "Jakarta, Indonesia"));
		jobs.add(new Job(3, "Business Intelligence Analyst", "Part Time", "Marketing & Advertising",
				"Minimum of bachelor's degree in IT, Math, or Business", "Jakarta, Indonesia"));
	}
	
	public static void printJob(Job job) {
		System.out.println("ID		: " + job.getId());
		System.out.println("Job Title	: " + job.getTitle());
		System.out.println("Job Type	: " + job.getType());
		System.out.println("Job Category	: " + job.getCategory());
		System.out.println("Qualification	: " + job.getQualification());
		System.out.println("Location	: " + job.getLocation());
		System.out.println("_________________________________________________________________________________");
	}
	
	public static void login() throws AuthenticationException {
		Scanner inputLogin = new Scanner(System.in);
		boolean isLoggedIn = false;
		System.out.print("Email		: ");
		String email = inputLogin.nextLine();
		System.out.print("Password	: ");
		String password = inputLogin.nextLine();
		
		if (!email.endsWith("@google.com") && !email.endsWith("@admin.com")) {
	        throw new AuthenticationException("Email tidak valid. Gunakan format 'nama@google.com' atau 'nama@admin.com'");
	    }
		
		for (User user : users) {
			try {
                isLoggedIn = user.login(email, password);
                if (isLoggedIn) {
                	if (!user.isAdmin()) {
                		pageKandidat((Kandidat) user);
                		break;
                	}
                	else if (user.isAdmin()) {
                    	pageAdmin((Admin) user);
                    	break;
                	}
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
	
	public static void signUp() throws InvalidPropertyException {
		Scanner inputSignUp = new Scanner(System.in);
		System.out.print("Nama		: ");
		String name = inputSignUp.nextLine();
		System.out.print("Email		: ");
		String email = inputSignUp.nextLine();
			if (!email.endsWith("@google.com") && !email.endsWith("@admin.com")) {
				throw new InvalidPropertyException("Invalid. Gunakan format 'nama@google.com'!");
			}
		System.out.print("Password	: ");
		String password = inputSignUp.nextLine();
			if (!isValidPassword(password)) {
	            throw new InvalidPropertyException("Password harus mengandung huruf besar, angka, minimum 6 karakter, dan maksimum 16 karakter");
	        }
		if (name == null || email == null || password == null) {
            throw new InvalidPropertyException("Semua properti harus diisi");
		}
		
		if (email.endsWith("@admin.com")) {
			User newUser = new Admin(name, email, password);
			users.add(newUser);
	        System.out.println("Admin telah berhasil didaftarkan");
		}
		else if (email.endsWith("@google.com")) {
			User newUser = new Kandidat(name, email, password);
			users.add(newUser);
	        System.out.println("Kandidat telah berhasil didaftarkan");
		}
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
	
	public static void pageKandidat(Kandidat kandidat) {
		Scanner inputKandidat = new Scanner(System.in);
		boolean isLoggedOut = false;
		do {
			System.out.println("=======WELCOME=======");
			System.out.println("1. Search Job");
			System.out.println("2. Apply Now");
			System.out.println("3. Submission");
			System.out.println("4. Log Out");
			System.out.print("Pilihan	: ");
			int choose = inputKandidat.nextInt();
			switch(choose) {
			case 1:
				searchJob();
				break;
			case 2:
				applyJob(kandidat);
				break;
			case 3:
				checkSubmission(kandidat);
				break;
			case 4:
				isLoggedOut = true;
				break;
			}
		} while(!isLoggedOut);
		
	}
	
		public static void searchJob() {
			System.out.println("=======Jobs=======");
			for (Job job : jobs) {
	    		printJob(job);
	    	}
			System.out.println();
		}
		
		public static void applyJob(Kandidat kandidat) {
			Scanner inputApply = new Scanner(System.in);
			System.out.println("=======Apply Job=======");
			System.out.print("Name		: ");
			String name = inputApply.nextLine();
			System.out.print("Education	: ");
			String education = inputApply.nextLine();
			System.out.print("ID Position you want to Apply (1-3): ");
			int jobId = inputApply.nextInt();
			if (jobId >= 1 && jobId <= 3) {
		        kandidat.applyJob(String.valueOf(jobId));
		    } else {
		        System.out.println("Invalid Job ID.");
		    }
		}
		
		public static void checkSubmission(Kandidat kandidat) {
		    System.out.println("=======Submission=======");
		    if (kandidat.submissions.isEmpty()) {
		        System.out.println("You have not made any submissions yet.");
		    } else {
		        System.out.println("=== Submission ===");
		        int submissionCount = 1;
		        for (String submission : kandidat.submissions) {
		            String detail = kandidat.getSubmissionDetail(submission);
		            System.out.println(submissionCount + ". You applied for " + findJobTitle(submission));
		            System.out.println("Details: " + detail);
		            submissionCount++;
		        }
		    }
		}
	
	public static void pageAdmin(Admin admin) {
		Scanner inputAdmin = new Scanner(System.in);
		boolean isLoggedOut = false;
		do {
			System.out.println("=======WELCOME=======");
			System.out.println("1. Submissions");
			System.out.println("2. Send Email");
			System.out.println("3. Log Out");
			System.out.print("Pilihan	: ");
			int choose = inputAdmin.nextInt();
			switch(choose) {
			case 1:
				listSubmission();
				break;
			case 2:
				sendEmail(admin);
				break;
			case 3:
				isLoggedOut = true;
				break;
			}
		} while (!isLoggedOut);
	}
	
		public static void listSubmission() {
		    System.out.println("=======Submissions=======");
		    boolean foundSubmission = false;
		    for (User user : users) {
		        if (user instanceof Kandidat) {
		            Kandidat kandidat = (Kandidat) user;
		            if (!kandidat.submissions.isEmpty()) {
		                foundSubmission = true;
		                System.out.println(kandidat.getName() + "'s Submissions:");
		                for (String submission : kandidat.submissions) {
		                	 System.out.println(kandidat.getName() + " - " + findJobTitle(submission));
		                }
		            }
		        }
		    }
		    if (!foundSubmission) {
		        System.out.println("No submissions available.");
		    }
		}

			public static String findJobTitle(String jobId) {
			    for (Job job : jobs) {
			        if (Integer.toString(job.getId()).equals(jobId)) {
			            return job.getTitle();
			        }
			    }
			    return "Invalid Job";
			}
		
			public static void sendEmail(Admin admin) {
			    Scanner inputSend = new Scanner(System.in);
			    System.out.println("=======Send Email=======");
			    System.out.print("To : ");
			    String candidateName = inputSend.nextLine();
			    boolean isValidCandidate = false;
			    for (User user : users) {
			        if (user.getName().equals(candidateName) && user instanceof Kandidat) {
			            isValidCandidate = true;
			            Kandidat kandidat = (Kandidat) user;
			            System.out.print("Add Details (Lolos / Tidak Lolos): ");
			            String statusInput = inputSend.nextLine().trim().toLowerCase();
			            boolean isPassed = statusInput.equals("lolos");
			            admin.sendEmail(kandidat.getName(), isPassed);
			            break;
			        }
			    }
			    if (!isValidCandidate) {
			        System.out.println("Invalid");
			    }
			}


	public static void main(String[] args) {
		seedData();
		Scanner input = new Scanner(System.in);
		for(;;) {
			System.out.println("------------Program Lowongan Pekerjaan------------");
			System.out.println("1. Login");
			System.out.println("2. Signup");
			System.out.println("3. Keluar");
			System.out.print("Pilih : ");
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				try {
					login();
				} catch (AuthenticationException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					signUp();
				} catch (InvalidPropertyException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Keluar program...");
				input.close();
			    System.exit(0);
			    break;
			}
		}
	}

}
