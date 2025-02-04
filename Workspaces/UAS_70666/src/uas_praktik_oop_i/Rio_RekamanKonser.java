package uas_praktik_oop_i;

import java.util.Date;

public class Rio_RekamanKonser extends Rio_Item{
	private String namaArtis;
	private Date tanggalKonser;
	private String venue;
	private String linkRekaman;
	
	public Rio_RekamanKonser(String nama, float harga, int stok, Date tanggalKonser, String venue, String linkRekaman) {
		super(nama, harga, stok);
		this.tanggalKonser = tanggalKonser;
		this.venue = venue;
		this.linkRekaman = linkRekaman;
	}
	
	public String getDataRekaman() {
		return "Nama: " + getNama() + ", Tanggal: " + getTanggalKonser() + ", Venue: " + getVenue() + ", Link: " + getLinkRekaman();
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

	public String getLinkRekaman() {
		return linkRekaman;
	}
}
