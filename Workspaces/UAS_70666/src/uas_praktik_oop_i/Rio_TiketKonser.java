package uas_praktik_oop_i;

import java.util.Date;

public class Rio_TiketKonser extends Rio_Item{
	private String namaArtis;
	private Date tanggalKonser;
	private String venue;
	
	public Rio_TiketKonser(String nama, float harga, int stok, String namaArtis,
			Date tanggalKonser, String venue) {
		super(nama, harga, stok);
		this.namaArtis = namaArtis;
		this.tanggalKonser = tanggalKonser;
		this.venue = venue;
	}
	
	public String getDataTiket() {
		return "Nama: " + getNama() + ", Harga: " + getHarga() + ", Stok: " + getStok();
	}
	
	public int HitungJarakTanggalDenganHariIni() {
		Date hariIni = new Date();
	    long selisihMilidetik = tanggalKonser.getTime() - hariIni.getTime();
	    long selisihHari = selisihMilidetik / (24 * 60 * 60 * 1000);
	    return (int) selisihHari;
	}
	
	public String getNamaArtis() {
		return namaArtis;
	}

	public Date getTanggalKonser() {
		return tanggalKonser;
	}

	public String getVenue() {
		return venue;
	}
	
}
