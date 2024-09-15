package week12.Tugas;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static ArrayList<MediaPromosi> listOfMedia = new ArrayList<MediaPromosi>();
	static ArrayList<Order> listOfOrder = new ArrayList<Order>();
	
	public static void seedData() {
		MediaPromosi aktor1 = new Aktor("Chris Evans", 2000*100000, 30, 170, 60, 100000, "Captain America Lovers");
		listOfMedia.add(aktor1);
		MediaPromosi aktor2 = new Aktor("Robert Downey Jr", 2000*120000, 31, 171, 61, 120000, "Ironman Lovers");
		listOfMedia.add(aktor2);
		MediaPromosi aktor3 = new Aktor("Chris Hemsworth", 2000*140000, 32, 172, 62, 140000, "Thor Lovers");
		listOfMedia.add(aktor3);
		
		MediaPromosi celebgram1 = new Celebgram("Awkarin", 1000*100000, 25, 165, 45, 100000, "Instagram", "Furnitur");
		listOfMedia.add(celebgram1);
		MediaPromosi celebgram2 = new Celebgram("Anya Geraldine", 1000*120000, 26, 166, 46, 120000, "Twitter", "Makanan");
		listOfMedia.add(celebgram2);
		MediaPromosi celebgram3 = new Celebgram("Devina Aurel", 1000*140000, 27, 167, 47, 140000, "Youtube", "Tanaman");
		listOfMedia.add(celebgram3);
		
		MediaPromosi baliho1 = new Baliho("Baliho Jakarta Pusat", 3000000*6, 6, "Jakarta Pusat");
		listOfMedia.add(baliho1);
		MediaPromosi baliho2 = new Baliho("Baliho Jakarta Barat", 3000000*8, 8, "Jakarta Barat");
		listOfMedia.add(baliho2);
		MediaPromosi baliho3 = new Baliho("Baliho Jakarta Utara", 3000000*9, 9, "Jakarta Utara");
		listOfMedia.add(baliho3);
		
		MediaPromosi majalah1 = new Majalah("Home Decor", 50000*15, 15,"Halaman 2", "Furnitur");
		listOfMedia.add(majalah1);
		MediaPromosi majalah2 = new Majalah("Sedap", 50000*18, 18,"Halaman 3", "Makanan");
		listOfMedia.add(majalah2);
		MediaPromosi majalah3 = new Majalah("Otomotif", 50000*21, 21,"Halaman 4", "Tanaman");
		listOfMedia.add(majalah3);
	}
	
	public static void addMedia() {
		Scanner input1 = new Scanner(System.in);
		System.out.println("=================================================");
		System.out.println("              Wemen Marketing Agent              ");
		System.out.println("=================================================");
		System.out.println("1. Celebgram");
		System.out.println("2. Majalah");
		System.out.println("=================================================");
		System.out.print("Pilih Media (1-2) : ");
		int choose1 = input1.nextInt();
		System.out.println("=================================================");
		System.out.println("1. Furnitur");
		System.out.println("2. Makanan");
		System.out.println("3. Tanaman");
		System.out.println("4. Otomotif");
		System.out.println("5. Musik");
		System.out.println("=================================================");
		switch (choose1) {
		case 1:
			addCelebgram();
			break;
		case 2:
			addMajalah();
			break;
		default:
			System.out.println("Invalid");
			break;
		}
	}
	
	public static void addCelebgram() {
		Scanner inputCelebgram = new Scanner(System.in);
		System.out.print("Pilih Kategori (1-5) : ");
		int kategori = inputCelebgram.nextInt();
		inputCelebgram.nextLine();
		String bidang = null;
		if (kategori == 1) {
			bidang = "Furnitur";
		}
		else if (kategori == 2) {
			bidang = "Makanan";
		}
		else if (kategori == 3) {
			bidang = "Tanaman";
		}
		else if (kategori == 4) {
			bidang = "Otomotif";
		}
		else if (kategori == 5) {
			bidang = "Musik";
		}
		else {
			System.out.println("Invalid");
		}
		System.out.print("Masukkan nama : ");
		String nama = inputCelebgram.nextLine();
		System.out.print("Masukkan umur : ");
		int umur = inputCelebgram.nextInt();
		System.out.print("Masukkan tinggi badan : ");
		int tinggi = inputCelebgram.nextInt();
		System.out.print("Masukkan berat badan : ");
		int berat = inputCelebgram.nextInt();
		System.out.print("Masukkan jumlah followers : ");
		int foll = inputCelebgram.nextInt();
		System.out.print("Masukkan media sosial yang digunakan : ");
		String medsos = inputCelebgram.next();
		MediaPromosi newMedia = new Celebgram(nama, 1000*foll, umur, tinggi, berat, foll, medsos, bidang);
		listOfMedia.add(newMedia);
		System.out.println("Media baru telah dimasukkan");
	}
	
	public static void addMajalah() {
		Scanner inputMajalah = new Scanner(System.in);
		System.out.print("Pilih Kategori (1-5) : ");
		int kategori = inputMajalah.nextInt();
		inputMajalah.nextLine();
		String bidang = null;
		if (kategori == 1) {
			bidang = "Furnitur";
		}
		else if (kategori == 2) {
			bidang = "Makanan";
		}
		else if (kategori == 3) {
			bidang = "Tanaman";
		}
		else if (kategori == 4) {
			bidang = "Otomotif";
		}
		else if (kategori == 5) {
			bidang = "Musik";
		}
		else {
			System.out.println("Invalid");
		}
		System.out.print("Masukkan nama : ");
		String nama = inputMajalah.nextLine();
		System.out.print("Masukkan luas : ");
		int luas = inputMajalah.nextInt();
		System.out.print("Masukkan letak halaman promosi : ");
		String letak = inputMajalah.next();
		MediaPromosi newMedia = new Majalah(nama, 50000*luas, luas, letak, bidang);
		listOfMedia.add(newMedia);
		System.out.println("Media baru telah dimasukkan");
	}
	
	public static void rentMedia() {
		Scanner input2 = new Scanner (System.in);
		System.out.println("=================================================");
		System.out.println("              Wemen Marketing Agent              ");
		System.out.println("=================================================");
		System.out.println("1. Furnitur");
		System.out.println("2. Makanan");
		System.out.println("3. Tanaman");
		System.out.println("4. Otomotif");
		System.out.println("5. Musik");
		System.out.println("=================================================");
		System.out.print("Pilih Kategori (1-5) : ");
		int kategori = input2.nextInt();
		if (kategori < 1 || kategori > 5) {
			System.out.println("Invalid");
			return;
		}
		System.out.print("Tanggal Mulai (DDMMYYYY) : ");
		String tanggal = input2.next();
		System.out.print("Banyak hari penyewaan : ");
		int jangkaWaktu = input2.nextInt();
		System.out.println("=================================================");
		for (int i = 0; i < listOfMedia.size(); i++) {
			MediaPromosi media = listOfMedia.get(i);
			if (media instanceof Aktor) {
				Aktor aktor = (Aktor) media;
				System.out.println("No			: " + (i+1));
				System.out.println("Media			: Aktor");
				System.out.println("Nama			: " + aktor.getNama());
				System.out.println("Umur			: " + aktor.getUmur());
				System.out.println("Tinggi Badan		: " + aktor.getTinggiBadan());
				System.out.println("Berat Badan		: " + aktor.getBeratBadan());
				System.out.println("Jumlah Fans		: " + aktor.getFans());
				System.out.println("Nama Fansclub		: " + aktor.getFanClub());
				System.out.println("Harga			: " + aktor.getHarga());
				System.out.println("=================================================");
			}
			else if (media instanceof Celebgram) {
				Celebgram celebgram = (Celebgram) media;
				if (kategori == 1) {
					if (celebgram.getBidang() == "Furnitur") {
						printCelebgram(i, celebgram);
					}
				}
				else if (kategori == 2) {
					if (celebgram.getBidang() == "Makanan") {
						printCelebgram(i, celebgram);
					}
				}
				else if (kategori == 3) {
					if (celebgram.getBidang() == "Tanaman") {
						printCelebgram(i, celebgram);
					}
				}
				else if (kategori == 4) {
					if (celebgram.getBidang() == "Otomotif") {
						printCelebgram(i, celebgram);
					}
				}
				else if (kategori == 5) {
					if (celebgram.getBidang() == "Musik") {
						printCelebgram(i, celebgram);
					}
				}
			}
			else if (media instanceof Baliho) {
				Baliho baliho = (Baliho) media;
				System.out.println("No			: " + (i+1));
				System.out.println("Media			: Baliho");
				System.out.println("Nama			: " + baliho.getNama());
				System.out.println("Luas			: " + baliho.getLuas());
				System.out.println("Letak			: " + baliho.getLetak());
				System.out.println("Harga			: " + baliho.getHarga());
				System.out.println("=================================================");
			}
			else if (media instanceof Majalah) {
				Majalah majalah = (Majalah) media;
				if (kategori == 1) {
					if (majalah.getBidang() == "Furnitur") {
						printMajalah(i, majalah);
					}
				}
				else if (kategori == 2) {
					if (majalah.getBidang() == "Makanan") {
						printMajalah(i, majalah);
					}
				}
				else if (kategori == 3) {
					if (majalah.getBidang() == "Tanaman") {
						printMajalah(i, majalah);
					}
				}
				else if (kategori == 4) {
					if (majalah.getBidang() == "Otomotif") {
						printMajalah(i, majalah);
					}
				}
				else if (kategori == 5) {
					if (majalah.getBidang() == "Musik") {
						printMajalah(i, majalah);
					}
				}
			}
		}
		System.out.print("Masukkan nomor media : ");
		int num = input2.nextInt(); input2.nextLine();
		System.out.print("Masukkan uang untuk pembayaran : ");
		int money = input2.nextInt(); input2.nextLine();
		MediaPromosi selectedMedia = listOfMedia.get(num-1);
		if (money < selectedMedia.getHarga()) {
			System.out.println("Uang tidak mencukupi.");
			return;
		}
		String bidang = "";
	    if (kategori == 1) {
	    	bidang = "Furnitur";
		}
		else if (kategori == 2) {
			bidang = "Makanan";
		}
		else if (kategori == 3) {
			bidang = "Tanaman";
		}
		else if (kategori == 4) {
			bidang = "Otomotif";
		}
		else if (kategori == 5) {
			bidang = "Musik";
		}
	    Order newOrder = new Order(selectedMedia, bidang, tanggal, jangkaWaktu);
	    listOfOrder.add(newOrder);
		System.out.println("Pemesanan anda sukses.");
		System.out.println("=================================================");
	}
	
	public static void printCelebgram(int i, Celebgram celebgram) {
		System.out.println("No			: " + (i+1));
		System.out.println("Media			: Celebgram");
		System.out.println("Nama			: " + celebgram.getNama());
		System.out.println("Umur			: " + celebgram.getUmur());
		System.out.println("Tinggi Badan		: " + celebgram.getTinggiBadan());
		System.out.println("Berat Badan		: " + celebgram.getBeratBadan());
		System.out.println("Jumlah Follower		: " + celebgram.getFollowers());
		System.out.println("Akun Media		: " + celebgram.getAkunMedia());
		System.out.println("Bidang			: " + celebgram.getBidang());
		System.out.println("Harga			: " + celebgram.getHarga());
		System.out.println("=================================================");
	}
	
	public static void printMajalah(int i, Majalah majalah) {
		System.out.println("No			: " + (i+1));
		System.out.println("Media			: Majalah");
		System.out.println("Nama			: " + majalah.getNama());
		System.out.println("Luas			: " + majalah.getLuas());
		System.out.println("Letak			: " + majalah.getLetak());
		System.out.println("Bidang			: " + majalah.getBidang());
		System.out.println("Harga			: " + majalah.getHarga());
		System.out.println("=================================================");
	}
	
	public static void checkOrder(Scanner input) {
		System.out.println("=================================================");
		System.out.println("              Wemen Marketing Agent              ");
		System.out.println("=================================================");
		if (listOfOrder.size() == 0) {
			System.out.println("Tidak ada order.");
		} else {
			for (int i = 0; i < listOfOrder.size(); i++) {
				String jenisMedia = null;
				Order order = listOfOrder.get(i);
				if (order.getMediaPromosi() instanceof Aktor) {
					jenisMedia = "Aktor";
	            } else if (order.getMediaPromosi() instanceof Celebgram) {
	            	jenisMedia = "Celebgram";
	            } else if (order.getMediaPromosi() instanceof Majalah) {
	            	jenisMedia = "Majalah";
	            } else if (order.getMediaPromosi() instanceof Baliho) {
	            	jenisMedia = "Baliho";
	            }
				System.out.println("No			: " + (i+1));
				System.out.println("Media			: " + jenisMedia);
				System.out.println("Nama			: " + order.getMediaPromosi().getNama());
				System.out.println("Bidang			: " + order.getBidang());
				System.out.println("Tanggal			: " + order.getTanggal());
				System.out.println("Durasi Kontrak		: " + order.getJangkaWaktu());
				System.out.println("Harga			: " + order.getMediaPromosi().getHarga());
				System.out.println("=================================================");
			}
			System.out.println("1. Batalkan Order");
			System.out.println("2. Kembali ke menu utama");
			System.out.println("=================================================");
			System.out.print("Pilih menu (1-2) : ");
			int choice3 = input.nextInt(); input.nextLine();
			switch (choice3) {
			case 1:
				// Pembatalan order
				System.out.print("Masukkan nomor yang ingin dibatalkan : ");
                int orderNumber = input.nextInt(); input.nextLine();
                if (orderNumber > 0 && orderNumber <= listOfOrder.size()) {
                    listOfOrder.remove(orderNumber-1);
                    System.out.println("Pesanan berhasil dibatalkan.");
                } else {
                    System.out.println("Invalid.");
                }
				break;
			case 2:
				break;
			default:
				System.out.println("Invalid");
				break;
			}
		}
	}
	
	public static void credits() {
		System.out.println("=================================================");
		System.out.println("              Wemen Marketing Agent              ");
		System.out.println("=================================================");
		System.out.println("Name	: Rio Ferdinan");
		System.out.println("NIM	: 00000070666");
		System.out.println("=================================================");
	}
	
	public static void main(String[] args) {
		seedData();
		Scanner input = new Scanner(System.in);
		for(;;) {
			System.out.println("=================================================");
			System.out.println("              Wemen Marketing Agent              ");
			System.out.println("=================================================");
			System.out.println("1. Penambahan Media");
			System.out.println("2. Penyewaan Media");
			System.out.println("3. Check Employment / Rental");
			System.out.println("4. Credits");
			System.out.println("5. Exit");
			System.out.println("=================================================");
			System.out.print("Pilih Menu (1-5) : ");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				addMedia();
				break;
			case 2:
				rentMedia();
				break;
			case 3:
				checkOrder(input);
				break;
			case 4:
				credits();
				break;
			case 5:
				System.out.println("Keluar program...");
				input.close();
			    System.exit(0);
				break;
			default:
				System.out.println("Invalid");
				break;
			}
		}
	}

}
