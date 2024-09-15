package week08.rio.ac.id.umn.Tugas;

import java.util.Scanner;
import week08.rio.ac.id.umn.Tugas.Model.*;

public class Main {
	static Barang[] barangs = new Barang[100];
	static Order[] orders = new Order[100];
	static int hCount = 0;
    static int vCount = 0;
    static int oCount = 0;
    static int hOrder = 0;
    static int vOrder = 0;
	
    public static void pesanBarang() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Daftar Barang Toko Voucher & HP");
        if (hCount == 0 && vCount == 0) {
            System.out.println("Barang Tidak Tersedia.");
        } else {
        	// Daftar Barang
        	for (int i = 0; i < hCount + vCount; i++) {
        	    if (barangs[i] instanceof Handphone) {
        	        Handphone handphone = (Handphone) barangs[i];
        	        System.out.println("ID    	: " + handphone.getId());
        	        System.out.println("Nama  	: " + handphone.getNama() + " " + handphone.getWarna());
        	        System.out.println("Stock 	: " + handphone.getStok());
        	        System.out.println("Harga 	: " + handphone.getHarga());
        	        System.out.println("---------------------------------------------");
        	    }
        	    else if (barangs[i] instanceof Voucher) {
        	        Voucher voucher = (Voucher) barangs[i];
        	        System.out.println("ID      : " + voucher.getId());
        	        System.out.println("Nama    : " + voucher.getNama());
        	        System.out.println("Nominal : " + voucher.getHarga());
        	        System.out.println("Stock   : " + voucher.getStok());
        	        System.out.println("Harga   : " + voucher.gethargaJual());
        	        System.out.println("---------------------------------------------");
        	    }
        	}
            // Pemesanan
            System.out.println("Ketik 0 untuk batal");
            System.out.print("Pesan Barang (ID)  : ");
            String id = input1.next().toUpperCase();
            if (id.equals("0")) {
                System.out.println("Pemesanan dibatalkan");
                return;
            }

            Barang orderedItem = null;
            for (Barang barang : barangs) {
                if (barang != null && barang.getId().equals(id)) {
                    orderedItem = barang;
                    break;
                }
            }

            if (orderedItem == null) {
                System.out.println("Barang tidak ditemukan");
                return;
            }

            if (orderedItem instanceof Handphone) {
                pesanHandphone((Handphone) orderedItem);
            } else if (orderedItem instanceof Voucher) {
                pesanVoucher((Voucher) orderedItem);
            }
        }
    }

    public static void pesanHandphone(Handphone handphone) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Masukkan jumlah    : ");
        int jml = input1.nextInt();
        input1.nextLine();
        if (jml <= 0 || jml > handphone.getStok()) {
            System.out.println("Invalid");
            return;
        }
        double totalHarga = handphone.getHarga() * jml;
        System.out.println(jml + " @ " + handphone.getNama() + " " + handphone.getWarna()
        	+ " dengan total harga " + totalHarga);
        System.out.print("Masukkan jumlah uang    : ");
        double uang = input1.nextDouble();
        if (uang < totalHarga) {
            System.out.println("Jumlah uang tidak mencukupi");
            return;
        }
        hOrder++;
        orders[oCount++] = new Order("OH" + hOrder, handphone, jml);
        handphone.minusStok(jml);
        System.out.println("Berhasil dipesan");
    }

    public static void pesanVoucher(Voucher voucher) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Masukkan jumlah    : ");
        int jml = input1.nextInt();
        input1.nextLine();
        if (jml <= 0 || jml > voucher.getStok()) {
            System.out.println("Invalid");
            return;
        }
        double totalHarga = voucher.gethargaJual() * jml;
        System.out.println(jml + " @ " + voucher.getNama() + " dengan total harga " + totalHarga);
        System.out.print("Masukkan jumlah uang    : ");
        double uang = input1.nextDouble();
        if (uang < totalHarga) {
            System.out.println("Jumlah uang tidak mencukupi");
            return;
        }
        vOrder++;
        orders[oCount++] = new Order("OV" + vOrder, voucher, jml);
        voucher.minusStok(jml);
        System.out.println("Berhasil dipesan");
    }
	
	public static void lihatOrder() {
		System.out.println("Daftar Pesanan Toko Voucher & HP");
		if (oCount == 0) {
            System.out.println("Tidak ada pesanan");
        } else {
        	for (int i = 0; i < oCount; i++) {
        		if (orders[i].getId().startsWith("OH")) {
        			System.out.println("ID	: " + orders[i].getId() + "-" + i);
            		System.out.println("Nama	: " + orders[i].getHandphone().getNama() + " " + orders[i].getHandphone().getWarna());
            		System.out.println("Jumlah	: " + orders[i].getJumlah());
            		System.out.println("Total	: " + orders[i].getHandphone().getHarga()*orders[i].getJumlah());
            		System.out.println("---------------------------------------------");
        		}
        		else if (orders[i].getId().startsWith("OV")) {
        			System.out.println("ID	: " + orders[i].getId() + "-" + i);
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
            String id = "V" + (vCount + 1);
            System.out.print("Nama   : ");
            String nama = input3.nextLine();
            System.out.print("Harga  : ");
            double harga = input3.nextDouble();
            System.out.print("Stock  : ");
            int stok = input3.nextInt();
            input3.nextLine();
            System.out.print("PPN    : ");
            double pajak = input3.nextDouble();
            barangs[hCount + vCount] = new Voucher(id, nama, harga, stok, pajak);
            vCount++;
            System.out.println("Voucher telah berhasil diinput");
        }
        else if (type.equals("H")) {
            String id = "H" + (hCount + 1);
            System.out.print("Nama   : ");
            String nama = input3.nextLine();
            System.out.print("Harga  : ");
            double harga = input3.nextDouble();
            System.out.print("Stock  : ");
            int stok = input3.nextInt();
            input3.nextLine();
            System.out.print("Warna  : ");
            String warna = input3.nextLine();
            barangs[hCount + vCount] = new Handphone(id, nama, harga, stok, warna);
            hCount++;
            System.out.println("Handphone telah berhasil diinput");
        } else {
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
