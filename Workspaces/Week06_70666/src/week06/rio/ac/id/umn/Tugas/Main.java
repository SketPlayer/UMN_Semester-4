package week06.rio.ac.id.umn.Tugas;

import java.util.Scanner;

public class Main {
	static Handphone[] handphones = new Handphone[100];
	static Voucher[] vouchers = new Voucher[100];
	static Order[] orders = new Order[100];
	static int hCount = 0;
    static int vCount = 0;
    static int oCount = 0;
	
	public static void pesanBarang() {
		Scanner input1 = new Scanner(System.in);
		System.out.println("Daftar Barang Toko Voucher & HP");
		System.out.println("1. Handphone");
		System.out.println("2. Voucher");
		System.out.print("Pilihan : ");
		int jenis = input1.nextInt();
			if (jenis == 1) {
				if (hCount == 0) {
		            System.out.println("Barang Tidak Tersedia.");
		        } else {
		        	for (int i = 0; i < hCount; i++) {
		        		System.out.println("ID	: " + handphones[i].getId());
		        		System.out.println("Nama	: " + handphones[i].getNama() + " " + handphones[i].getWarna());
		        		System.out.println("Stock	: " + handphones[i].getStok());
		        		System.out.println("Harga	: " + handphones[i].getHarga());
		        		System.out.println("---------------------------------------------");
		        	}
		        	// Pemesanan
		        	System.out.println("Ketik 0 untuk batal");
		        	System.out.print("Pesan Barang (ID)	: ");
		        	int id = input1.nextInt();input1.nextLine();
		        	if (id == 0) {
		                System.out.println("Pemesanan dibatalkan");
		                return;
		            } else {
		            	Handphone orderHP = null;
		                for (Handphone handphone : handphones) {
		                    if (handphone != null && handphone.getId() == id) {
		                        orderHP = handphone;
		                        break;
		                    }
		                }
		                if (orderHP == null) {
		                    System.out.println("Handphone tidak ditemukan");
		                    return;
		                }
		            	System.out.print("Masukkan jumlah	: ");
			        	int jml = input1.nextInt();input1.nextLine();
			        	if (jml <= 0 || jml > orderHP.getStok()) {
			                System.out.println("Invalid");
			                return;
			            }
			        	System.out.println(jml + " @ " + orderHP.getNama() + " "
			        			+ orderHP.getWarna() + " dengan total harga " + orderHP.getHarga()*jml);
			        	System.out.print("Masukkan jumlah uang	: ");
			        	double uang = input1.nextDouble();
			        	if (uang < orderHP.getHarga()*jml) {
			        		System.out.println("Jumlah uang tidak mencukupi");
			        		return;
			        	}
			        	orders[oCount++] = new Order("OH"+oCount, orderHP, jml);
			        	orderHP.minusStok(jml);
			            System.out.println("Berhasil dipesan");
		            }
		        }
			}
			else if (jenis == 2) {
				if (vCount == 0) {
		            System.out.println("Barang Tidak Tersedia.");
		        } else {
		        	for (int i = 0; i < vCount; i++) {
		        		System.out.println("ID	: " + vouchers[i].getId());
		        		System.out.println("Nama	: " + vouchers[i].getNama());
		        		System.out.println("Nominal	: " + vouchers[i].getHarga());
		        		System.out.println("Stock	: " + vouchers[i].getStok());
		        		System.out.println("Harga	: " + vouchers[i].gethargaJual());
		        		System.out.println("---------------------------------------------");
		        	}
		        	// Pemesanan
		        	System.out.println("Ketik 0 untuk batal");
		        	System.out.print("Pesan Barang (ID)	: ");
		        	int id = input1.nextInt();input1.nextLine();
		        	if (id == 0) {
		                System.out.println("Pemesanan dibatalkan");
		                return;
		            } else {
		            	Voucher orderVC = null;
		                for (Voucher voucher : vouchers) {
		                    if (voucher != null && voucher.getId() == id) {
		                        orderVC = voucher;
		                        break;
		                    }
		                }
		                if (orderVC == null) {
		                    System.out.println("Voucher tidak ditemukan");
		                    return;
		                }
		            	System.out.print("Masukkan jumlah	: ");
			        	int jml = input1.nextInt();input1.nextLine();
			        	if (jml <= 0 || jml > orderVC.getStok()) {
			                System.out.println("Invalid");
			                return;
			            }
			        	System.out.println(jml + " @ " + orderVC.getNama() + " "
			        			+ orderVC.getHarga() + " dengan total harga " + orderVC.gethargaJual()*jml);
			        	System.out.print("Masukkan jumlah uang	: ");
			        	double uang = input1.nextDouble();
			        	if (uang < orderVC.gethargaJual()*jml) {
			        		System.out.println("Jumlah uang tidak mencukupi");
			        		return;
			        	}
			        	orders[oCount++] = new Order("OV"+oCount, orderVC, jml);
			        	orderVC.minusStok(jml);
			            System.out.println("Berhasil dipesan");
		            }
		        }
			}
			else {
				System.out.println("Invalid");
				System.out.println();
			}
	}
	
	public static void lihatOrder() {
		System.out.println("Daftar Pesanan Toko Voucher & HP");
		if (oCount == 0) {
            System.out.println("Tidak ada pesanan");
        } else {
        	for (int i = 0; i < oCount; i++) {
        		if (orders[i].getId().equals("OH"+(i+1))) {
        			System.out.println("ID	: " + orders[i].getId());
            		System.out.println("Nama	: " + orders[i].getHandphone().getNama() + " " + orders[i].getHandphone().getWarna());
            		System.out.println("Jumlah	: " + orders[i].getJumlah());
            		System.out.println("Total	: " + orders[i].getHandphone().getHarga()*orders[i].getJumlah());
            		System.out.println("---------------------------------------------");
        		}
        		else if (orders[i].getId().equals("OV"+(i+1))) {
        			System.out.println("ID	: " + orders[i].getId());
            		System.out.println("Nama	: " + orders[i].getVoucher().getNama() + " " + orders[i].getVoucher().getHarga());
            		System.out.println("Jumlah	: " + orders[i].getJumlah());
            		System.out.println("Total	: " + orders[i].getVoucher().gethargaJual()*orders[i].getJumlah());
            		System.out.println("---------------------------------------------");
        		}
        	}
        	System.out.println();
        }
	}
			
	public static void newBarang() {
		Scanner input3 = new Scanner(System.in);
		System.out.print("Voucher / Handphone (V/H): ");
		String type = input3.nextLine().toUpperCase();
		if (type.equals("V")) {
			int id = vCount + 1;
			System.out.print("Nama	: ");
			String nama = input3.nextLine();
			System.out.print("Harga	: ");
			double harga = input3.nextDouble();
			System.out.print("Stock	: ");
			int stok = input3.nextInt();
            input3.nextLine();
            System.out.print("PPN	: ");
			double pajak = input3.nextDouble();
			vouchers[vCount] = new Voucher(id, nama, harga, stok, pajak);
            vCount++;
			System.out.println("Voucher telah berhasil diinput");
        }
		else if (type.equals("H")) {
			int id = hCount + 1;
			System.out.print("Nama	: ");
			String nama = input3.nextLine();
			System.out.print("Harga	: ");
			double harga = input3.nextDouble();
			System.out.print("Stock	: ");
			int stok = input3.nextInt();
            input3.nextLine();
            System.out.print("Warna	: ");
			String warna = input3.nextLine();
			handphones[hCount] = new Handphone(id, nama, harga, stok, warna);
            hCount++;
			System.out.println("Handphone telah berhasil diinput");
        }
		else {
            System.out.println("Invalid");
        }
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		for(;;) {
			System.out.println("--------------Menu Toko Voucher & HP--------------");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("3. Barang Baru");
			System.out.println("4. Keluar");
			System.out.print("Pilihan : ");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				pesanBarang();
				break;
			case 2:
				lihatOrder();
				break;
			case 3:
				newBarang();
				break;
			case 4:
				System.out.println("Keluar program...");
				scanner.close();
			    System.exit(0);
			    break;
			}
		}
	}
}
