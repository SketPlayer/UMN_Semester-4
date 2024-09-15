package week05.rio.ac.id.umn.Tugas;

public class PersegiPanjang {
	private int panjang;
	private int lebar;
	private String color;
	
	public PersegiPanjang() {}
	public PersegiPanjang(int panjang, int lebar, String color) {
		this.panjang = panjang;
		this.lebar = lebar;
		this.color = color;
	}
	
	public int getPanjang() {
		return panjang;
	}
	
	public int getLebar() {
		return lebar;
	}
	
	public double getLuas() {
		return panjang*lebar;
	}
	
	public double getKeliling() {
		return 2*panjang + 2*lebar;
	}
	
	public String getColor() {
		return color;
	}
	
}
