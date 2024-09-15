package week11.Tugas;

public class Job {
	private int id;
	private String title;
	private String type;
	private String category;
	private String qualification;
	private String location;
	
	public Job(int id, String title, String type, String category,
			String qualification, String location) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.category = category;
		this.qualification = qualification;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getCategory() {
		return category;
	}

	public String getQualification() {
		return qualification;
	}

	public String getLocation() {
		return location;
	}
	
}
