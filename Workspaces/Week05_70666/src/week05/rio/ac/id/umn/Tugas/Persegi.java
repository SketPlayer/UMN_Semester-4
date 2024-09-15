package week05.rio.ac.id.umn.Tugas;

public class Persegi {
	private int sisi;
	private String color;
	
	public Persegi() {}
	public Persegi(int sisi, String color) {
		this.sisi = sisi;
		this.color = color;
	}
	
	public int getSisi() {
		return sisi;
	}
	
	public double getLuas() {
		return sisi*sisi;
	}
	
	public double getKeliling() {
		return 4*sisi;
	}
	
	public String getColor() {
		return color;
	}
	
}
