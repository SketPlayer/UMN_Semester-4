package week11.Tugas;

import java.util.ArrayList;
import java.util.List;

public class Kandidat extends User{
	private String education;
	List<String> submissions;
	public boolean isPassed;
	
	public Kandidat(String name, String email, String password) {
		super(name, email, password);
		this.education = education;
		submissions = new ArrayList<>();
	}
	
	public void applyJob(String jobID) {
        submissions.add(jobID);
        System.out.println("Submission status: Success!");
        System.out.println("Thank you for applying.");
    }

	public String getSubmissionDetail(String submission) {
		return "Pending";
	}
}
