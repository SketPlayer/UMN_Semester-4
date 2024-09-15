package week05.rio.ac.id.umn.Tugas;

public class Segitiga {
	private int alas;
	private int tinggi;
	private String color;
	
	public Segitiga() {}
	public Segitiga(int alas, int tinggi, String color) {
		this.alas = alas;
		this.tinggi = tinggi;
		this.color = color;
	}
	
	public int getAlas() {
		return alas;
	}
	
	public int getTinggi() {
		return tinggi;
	}
	
	public double getLuas() {
		return (alas*tinggi)/2;
	}
	
	public double getKeliling() {
		double miring = Math.sqrt(alas*alas + tinggi*tinggi);
		return alas+tinggi+miring;
	}
	
	public String getColor() {
		return color;
	}
}
