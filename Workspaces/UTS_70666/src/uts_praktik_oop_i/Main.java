package uts_praktik_oop_i;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
	private static ArrayList<Rio_Artikel> listArtikel = new ArrayList<Rio_Artikel>();
	private static ArrayList<Rio_Buku> listBuku = new ArrayList<Rio_Buku>();
	private static ArrayList<Rio_Order> listOrder = new ArrayList<Rio_Order>();
	
	public static void seedData() {
	    Rio_Artikel artikel1 = new Rio_Artikel("Research Paper A", "Alice Johnson", 2022, "Artificial Intelligence", "Ceria University", 8, 3);
	    Rio_Artikel artikel2 = new Rio_Artikel("Impact of Big Data Analytics in Healthcare", "Bob White", 2023, "Artificial Intelligence", "HealthTech Institute", 12, 5);
	    Rio_Buku buku1 = new Rio_Buku("Java Programming", "John Doe", 2020, "Programming", "TechBooks", 400);
	    Rio_Buku buku2 = new Rio_Buku("Machine Learning", "Jane Smith", 2021, "Education", "EduPublish", 350);
	    
	    listArtikel.add(artikel1);
	    listArtikel.add(artikel2);
	    listBuku.add(buku1);
	    listBuku.add(buku2);
	}
	
	public static void showPublikasi() {
	    System.out.println("Daftar Artikel:");
	    for (Rio_Artikel artikel : listArtikel) {
	    	int i = 1;
	    	System.out.println(i+".");
	        System.out.println("Judul: "+artikel.getJudul());
	        System.out.println("Penulis: "+artikel.getPenulis());
	        System.out.println("Tahun Terbit: "+artikel.getTahunTerbit());
	        System.out.println("Kategori: "+artikel.getKategori());
	        System.out.println("Universitas: "+artikel.getUniversitas());
	        System.out.println("Halaman: "+artikel.getHalaman());
	        System.out.println("Volume: "+artikel.getVolume());
	        System.out.println();
	        i++;
	    }
	    System.out.println();
	    System.out.println("Daftar Buku:");
	    for (Rio_Buku buku : listBuku) {
	    	int i = 1;
	    	System.out.println(i+".");
	        System.out.println("Judul: "+buku.getJudul());
	        System.out.println("Penulis: "+buku.getPenulis());
	        System.out.println("Tahun Terbit: "+buku.getTahunTerbit());
	        System.out.println("Kategori: "+buku.getKategori());
	        System.out.println("Penerbit: "+buku.getPenerbit());
	        System.out.println("Jumlah Halaman: "+buku.getJumlahHalaman());
	        System.out.println();
	        i++;
	    }
	}

	public static void addPublikasi() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Pilih jenis publikasi (1: Buku, 2: Artikel): ");
	    int jenis = scanner.nextInt();
	    scanner.nextLine(); // Consume newline character

	    System.out.println("Judul: ");
	    String judul = scanner.nextLine();

	    System.out.println("Penulis: ");
	    String penulis = scanner.nextLine();

	    System.out.println("Tahun Terbit: ");
	    int tahunTerbit = scanner.nextInt();
	    scanner.nextLine(); // Consume newline character

	    System.out.println("Kategori: ");
	    String kategori = scanner.nextLine();

	    if (jenis == 1) {
	        System.out.println("Penerbit: ");
	        String penerbit = scanner.nextLine();

	        System.out.println("Jumlah Halaman: ");
	        int jumlahHalaman = scanner.nextInt();

	        Rio_Buku buku = new Rio_Buku(judul, penulis, tahunTerbit, kategori, penerbit, jumlahHalaman);
	        listBuku.add(buku);
	        System.out.println();
	        System.out.println("Buku berhasil ditambahkan.");
	    } else if (jenis == 2) {
	        System.out.println("Universitas: ");
	        String universitas = scanner.nextLine();

	        System.out.println("Halaman: ");
	        int halaman = scanner.nextInt();

	        System.out.println("Volume: ");
	        int volume = scanner.nextInt();

	        Rio_Artikel artikel = new Rio_Artikel(judul, penulis, tahunTerbit, kategori, universitas, halaman, volume);
	        listArtikel.add(artikel);
	        System.out.println();
	        System.out.println("Artikel berhasil ditambahkan.");
	    } else {
	        System.out.println("Pilihan tidak valid.");
	    }
	}

	public static void orderPublikasi() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Pilih jenis publikasi (1: Buku, 2: Artikel): ");
	    int jenisPublikasi = scanner.nextInt();
	    scanner.nextLine();
	    
	    if (jenisPublikasi == 1) { // Buku
	        System.out.println("Daftar Buku yang tersedia:");
	        for (int i = 0; i < listBuku.size(); i++) {
	            System.out.println((i+1) + ". " + listBuku.get(i).getJudul());
	        }
	        System.out.println("Pilih buku yang ingin dipesan: ");
	        int indexBuku = scanner.nextInt();
	        scanner.nextLine();
	        System.out.println("Masukkan nama peminjam: ");
	        String namaPeminjam = scanner.nextLine();
	        System.out.println("Masukkan tanggal mulai peminjaman (format: yyyy-mm-dd): ");
	        String tanggalMulaiString = scanner.nextLine();
	        LocalDate tanggalMulai = LocalDate.parse(tanggalMulaiString);
	        System.out.println("Masukkan tanggal selesai peminjaman (format: yyyy-mm-dd): ");
	        String tanggalSelesaiString = scanner.nextLine();
	        LocalDate tanggalSelesai = LocalDate.parse(tanggalSelesaiString);
	        
	        if (tanggalSelesai.isBefore(tanggalMulai)) {
	            System.out.println("Tanggal selesai peminjaman tidak valid. Tolak order.");
	            return;
	        }
	        
	        Rio_Order order = new Rio_Order(listBuku.get(indexBuku - 1), namaPeminjam, tanggalMulaiString, tanggalSelesaiString, "Dipesan");
	        listOrder.add(order);
	        
	        System.out.println("Buku telah berhasil dipesan.");
	    } else if (jenisPublikasi == 2) { // Artikel
	        System.out.println("Daftar Artikel yang tersedia:");
	        for (int i = 0; i < listArtikel.size(); i++) {
	            System.out.println((i+1) + ". " + listArtikel.get(i).getJudul());
	        }
	        System.out.println("Pilih artikel yang ingin dipesan: ");
	        int indexArtikel = scanner.nextInt();
	        scanner.nextLine();
	        System.out.println("Masukkan nama pemesan: ");
	        String namaPemesan = scanner.nextLine();
	        System.out.println("Masukkan tanggal mulai pemesanan (format: yyyy-mm-dd): ");
	        String tanggalMulaiString = scanner.nextLine();
	        LocalDate tanggalMulai = LocalDate.parse(tanggalMulaiString);
	        System.out.println("Masukkan tanggal selesai pemesanan (format: yyyy-mm-dd): ");
	        String tanggalSelesaiString = scanner.nextLine();
	        LocalDate tanggalSelesai = LocalDate.parse(tanggalSelesaiString);
	        
	        if (tanggalSelesai.isBefore(tanggalMulai)) {
	            System.out.println("Tanggal selesai pemesanan tidak valid. Tolak order.");
	            return;
	        }
	        
	        Rio_Order order = new Rio_Order(listArtikel.get(indexArtikel - 1), namaPemesan, tanggalMulaiString, tanggalSelesaiString, "Dipesan");
	        listOrder.add(order);
	        
	        System.out.println("Artikel telah berhasil dipesan.");
	    } else {
	        System.out.println("Pilihan tidak valid.");
	    }
	}


	public static void showOrder() {
	    System.out.println("Daftar Order:");
	    for (int i = 0; i < listOrder.size(); i++) {
	        Rio_Order order = listOrder.get(i);
	        System.out.println("OID" + (i+1));
	        System.out.println("Judul: " + order.getPublikasi().getJudul());
	        System.out.println("Nama Peminjam: " + order.getPeminjam());
	        System.out.println("Tanggal Mulai: " + order.getMulai());
	        System.out.println("Tanggal Selesai: " + order.getSelesai());
	        System.out.println("Status: " + order.getStatus());
	        System.out.println();
	    }
	}

	public static void main(String[] args) {
		seedData();
		Scanner scanner = new Scanner(System.in);
		int choice;
		for(;;) {
			System.out.println("--------------Welcome to Ceria Library--------------");
			System.out.println("1. Lihat Publikasi");
			System.out.println("2. Tambah Publikasi");
			System.out.println("3. Lakukan Order");
			System.out.println("4. Kelola Order");
			System.out.println("5. Exit Program");
			System.out.print("Pilihan : ");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				showPublikasi();
				break;
			case 2:
				addPublikasi();
				break;
			case 3:
				orderPublikasi();
				break;
			case 4:
				showOrder();
				break;
			case 5:
				System.out.println("Keluar program...");
				scanner.close();
			    System.exit(0);
			    break;
			}
		}
	}

}
