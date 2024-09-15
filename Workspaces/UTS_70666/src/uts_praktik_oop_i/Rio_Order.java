package uts_praktik_oop_i;

public class Rio_Order {
	private Rio_Publikasi namaPublikasi;
	private String namaPeminjam;
	private String tanggalMulai;
	private String tanggalSelesai;
	private String status;
	
	public Rio_Order(Rio_Publikasi namaPublikasi, String namaPeminjam
			, String tanggalMulai, String tanggalSelesai, String status) {
		this.namaPublikasi = namaPublikasi;
		this.namaPeminjam = namaPeminjam;
		this.tanggalMulai = tanggalMulai;
		this.tanggalSelesai = tanggalSelesai;
		this.status = status;
	}
	
	// Getter
	public Rio_Publikasi getPublikasi() {
		return namaPublikasi;
	}
	
	public String getPeminjam() {
		return namaPeminjam;
	}
	
	public String getMulai() {
		return tanggalMulai;
	}
	
	public String getSelesai() {
		return tanggalSelesai;
	}
	
	public String getStatus() {
		return status;
	}
	
	// Setter
	public void setPeminjam(String namaPeminjam) {
		this.namaPeminjam = namaPeminjam;
	}
	
	public void setMulai(String tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}
	
	public void setSelesai(String tanggalSelesai) {
		this.tanggalSelesai = tanggalSelesai;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
