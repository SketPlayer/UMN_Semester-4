package uas_praktik_oop_i;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Rio_Main {
	static ArrayList<Rio_Item> listOfItems = new ArrayList<Rio_Item>();
	static ArrayList<Rio_Pelanggan> listOfCustomers = new ArrayList<Rio_Pelanggan>();
	static ArrayList<Rio_Order> listOfOrders = new ArrayList<Rio_Order>();

	public static void tambahItem(Rio_Item item) {
		if (item instanceof Rio_TiketKonser) {
			tambahTiketKonser((Rio_TiketKonser) item);
		}
		else if (item instanceof Rio_Merchandise) {
			tambahMerchandise((Rio_Merchandise) item);
		}
		else if (item instanceof Rio_RekamanKonser) {
			tambahRekamanKonser((Rio_RekamanKonser) item);
		}
	}
	
	public static void tambahTiketKonser(Rio_TiketKonser tiketKonser) {
		listOfItems.add(tiketKonser);
	}
	
	public static void tambahRekamanKonser(Rio_RekamanKonser rekamanKonser) {
		listOfItems.add(rekamanKonser);
	}
	
	public static void tambahMerchandise(Rio_Merchandise merchandise) {
		listOfItems.add(merchandise);
	}
	
	public static void tambahPelanggan(Rio_Pelanggan pelanggan) {
		
	}
	
	public static void buatOrder(int customerId, int itemId, int qty) {
		
	}
	
	public static void cetakSemuaOrder() {
		System.out.println("=================================================");
		System.out.println("              Daftar Semua Pesanan               ");
		System.out.println("=================================================");
		if (listOfOrders.size() == 0) {
			System.out.println("Tidak ada pesanan yang terdaftar");
			return;
		}
		for (int i = 0; i < listOfItems.size(); i++) {
			Rio_Order order = listOfOrders.get(i);
			order.printDetailOrder();
			System.out.println();
		}
	}
	
	public static void lihatItem() {
		System.out.println("=================================================");
		System.out.println("             Menu Lihat Semua Barang             ");
		System.out.println("=================================================");
		if (listOfItems.size() == 0) {
			System.out.println("Tidak ada barang yang terdaftar");
			return;
		}
		for (int i = 0; i < listOfItems.size(); i++) {
			Rio_Item item = listOfItems.get(i);
			if (item instanceof Rio_TiketKonser) {
				Rio_TiketKonser tiket = (Rio_TiketKonser) item;
				System.out.println((i+1) + ". Tiket Konser: " + tiket.getDataTiket());
			}
			else if (item instanceof Rio_Merchandise) {
				Rio_Merchandise merchandise = (Rio_Merchandise) item;
				System.out.println((i+1) + ". Merchandise: " + merchandise.getDataMerch());
			}
			else if (item instanceof Rio_RekamanKonser) {
				Rio_RekamanKonser rekaman = (Rio_RekamanKonser) item;
				System.out.println((i+1) + ". Rekaman Konser: " + rekaman.getDataRekaman());
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(;;) {
			System.out.println("=================================================");
			System.out.println("            Menu Kasir Festival Musik            ");
			System.out.println("=================================================");
			System.out.println("1. Tambah Barang");
			System.out.println("2. Lihat Semua Barang");
			System.out.println("3. Daftar Pelanggan Baru");
			System.out.println("4. Buat Pesanan");
			System.out.println("5. Lihat Semua Pesanan");
			System.out.println("6. Keluar");
			System.out.println("=================================================");
			System.out.print("Pilih Menu (1-6) : ");
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				System.out.println("=================================================");
				System.out.println("               Menu Tambah Barang                ");
				System.out.println("=================================================");
				System.out.println("1. Tiket Konser");
				System.out.println("2. Merchandise");
				System.out.println("3. Rekaman Konser");
				System.out.println("4. Kembali ke Menu Utama");
				System.out.print("Pilihan: ");
				int choose = input.nextInt();
				input.nextLine();
				if (choose == 1) {
					System.out.print("Nama Tiket: ");
					String nama = input.nextLine();
					System.out.print("Harga Tiket: ");
					float harga = input.nextFloat();
					input.nextLine();
					System.out.print("Nama Artis: ");
					String namaArtis = input.nextLine();
					System.out.print("Tanggal Konser (dd/mm/yyyy): ");
					String tanggalKonserStr = input.nextLine();
					System.out.print("Venue: ");
					String venue = input.nextLine();
					System.out.print("Stok: ");
					int stok = input.nextInt();
					input.nextLine();
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			        Date tanggalKonser = null;
			        try {
			            tanggalKonser = dateFormat.parse(tanggalKonserStr);
			        } catch (ParseException e) {
			            System.out.println("Format tanggal tidak valid. Pastikan menggunakan format dd/mm/yyyy.");
			            return;
			        }
					Rio_Item newItem = new Rio_TiketKonser(nama, harga, stok, namaArtis, tanggalKonser, venue);
					tambahItem(newItem);
					System.out.println("Berhasil");
				}
				else if (choose == 2) {
					System.out.print("Nama Barang: ");
					String nama = input.nextLine();
					System.out.print("Harga Barang: ");
					float harga = input.nextFloat();
					input.nextLine();
					System.out.print("Nama Merek: ");
					String namaMerk = input.nextLine();
					System.out.print("Kategori: ");
					String kategori = input.nextLine();
					System.out.print("Stok: ");
					int stok = input.nextInt();
					input.nextLine();
					Rio_Item newItem = new Rio_Merchandise(nama, harga, stok, namaMerk, kategori);
					tambahItem(newItem);
					System.out.println("Berhasil");
				}
				else if (choose == 3) {
					System.out.print("Nama Rekaman: ");
					String nama = input.nextLine();
					System.out.print("Harga: ");
					float harga = input.nextFloat();
					input.nextLine();
					System.out.print("Tanggal Konser (dd/mm/yyyy): ");
					String tanggalKonserStr = input.nextLine();
					System.out.print("Venue: ");
					String venue = input.nextLine();
					System.out.print("Stok: ");
					int stok = input.nextInt();
					input.nextLine();
					System.out.print("Link: ");
					String link = input.nextLine();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			        Date tanggalKonser = null;
			        try {
			            tanggalKonser = dateFormat.parse(tanggalKonserStr);
			        } catch (ParseException e) {
			            System.out.println("Format tanggal tidak valid. Pastikan menggunakan format dd/mm/yyyy.");
			            return;
			        }
					Rio_Item newItem = new Rio_RekamanKonser(nama, harga, stok, tanggalKonser, venue, link);
					tambahItem(newItem);
					System.out.println("Berhasil");
				}
				else if (choose == 4) {
					System.out.println();
					break;
				}
				else {
					System.out.println("Pilihan tidak valid. Silahkan pilih opsi yang sesuai.");
					break;
				}
			case 2:
				lihatItem();
				break;
			case 3:
				System.out.println("=================================================");
				System.out.println("              Menu Daftar Pelanggan              ");
				System.out.println("=================================================");
				System.out.print("Nama Pelanggan: ");
				String nama = input.nextLine();
				System.out.print("Email: ");
				String email = input.nextLine();
				System.out.print("Nomor Telepon: ");
				String noHp = input.nextLine();
				int iP = 0;
				Rio_Pelanggan newCustomer = new Rio_Pelanggan(iP+1, nama, email, noHp);
				break;
			case 4:
				System.out.println("=================================================");
				System.out.println("                Menu Buat Pesanan                ");
				System.out.println("=================================================");
				System.out.print("ID Pelanggan: ");
				int customerId = input.nextInt();
				input.nextLine();
				System.out.print("ID Barang: ");
				int itemId = input.nextInt();
				input.nextLine();
				System.out.print("Jumlah Barang: ");
				int qty = input.nextInt();
				input.nextLine();
				buatOrder(customerId, itemId, qty);
				break;
			case 5:
				cetakSemuaOrder();
				break;
			case 6:
				System.out.println("Keluar program...");
				input.close();
			    System.exit(0);
				break;
			default:
				System.out.println("Pilihan tidak valid. Silahkan pilih opsi yang sesuai.");
				break;
			}
		}
	}

}
