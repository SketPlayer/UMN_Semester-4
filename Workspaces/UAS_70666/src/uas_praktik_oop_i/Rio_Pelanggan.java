package uas_praktik_oop_i;

public class Rio_Pelanggan {
	private int customerId;
	private String nama;
	private String email;
	private String noHp;
	
	public Rio_Pelanggan(int customerId, String nama, String email, String noHp) {
		this.customerId = customerId;
		this.nama = nama;
		this.email = email;
		this.noHp = noHp;
	}
	
	public String getDetailPelanggan() {
		return nama;
	}
}
