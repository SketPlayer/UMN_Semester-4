package week11.Tugas;

public class Admin extends User{

	public Admin(String name, String email, String password) {
		super(name, email, password);
	}
	
	public void sendEmail(String candidateName, boolean isPassed) {
        String status = isPassed ? "Lolos" : "Tidak Lolos";
        String message = isPassed ? "Congratulation! You being advanced to step 2: Interview process."
                : "Unfortunately, based on the result we will not be advancing your application to the next step.";
        
        System.out.println("Email sent to " + candidateName + " with status: " + status);
        System.out.println("Details: " + message);
    }
}
