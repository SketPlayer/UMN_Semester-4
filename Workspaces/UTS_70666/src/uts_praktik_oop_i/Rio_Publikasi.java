package uts_praktik_oop_i;

public class Rio_Publikasi {
	private String judul;
	private String penulis;
	private int tahunTerbit;
	private String kategori;
	
	public Rio_Publikasi(String judul, String penulis, int tahunTerbit, String kategori) {
		this.judul = judul;
		this.penulis = penulis;
		this.tahunTerbit = tahunTerbit;
		this.kategori = kategori;
	}
	
	// Getter
	public String getJudul() {
		return judul;
	}
	
	public String getPenulis() {
		return penulis;
	}
	
	public int getTahunTerbit() {
		return tahunTerbit;
	}
	
	public String getKategori() {
		return kategori;
	}
	
	// Setter
	public void setJudul(String judul) {
		this.judul = judul;
	}
	
	public void setPenulis(String penulis) {
		this.penulis = penulis;
	}
	
	public void setTahunTerbit(int tahunTerbit) {
		this.tahunTerbit = tahunTerbit;
	}
	
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
}
