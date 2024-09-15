package uts_praktik_oop_i;

public class Rio_Artikel extends Rio_Publikasi{
	private String universitas;
	private int halaman;
	private int volume;
	
	public Rio_Artikel(String judul, String penulis, int tahunTerbit, String kategori
			, String universitas, int halaman, int volume) {
		super(judul, penulis, tahunTerbit, kategori);
		this.universitas = universitas;
		this.halaman = halaman;
		this.volume = volume;
	}
	
	// Getter
	public String getUniversitas() {
		return universitas;
	}
	
	public int getHalaman() {
		return halaman;
	}
	
	public int getVolume() {
		return volume;
	}
	
	// Setter
	public void setUniversitas(String universitas) {
		this.universitas = universitas;
	}
	
	public void setHalaman(int halaman) {
		this.halaman = halaman;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
