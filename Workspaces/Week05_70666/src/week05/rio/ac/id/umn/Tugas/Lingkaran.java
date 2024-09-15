package week05.rio.ac.id.umn.Tugas;

public class Lingkaran {
	private double radius;
	private String color;
	
	public Lingkaran() {}
	public Lingkaran(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getLuas() {
		return Math.PI * radius * radius;
	}
	
	public double getKeliling() {
		return Math.PI * 2 * radius;
	}
	
	public String getColor() {
		return color;
	}

}
