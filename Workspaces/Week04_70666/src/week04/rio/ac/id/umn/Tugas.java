package week04.rio.ac.id.umn;

import java.util.Scanner;
import java.util.ArrayList;

public class Tugas {
	static Barang[] items = new Barang[5];
	static ArrayList<Order> orders = new ArrayList<>();
	public static void inputItem() {
		items[0] = new Barang(1, "Pulpen Easy Gel 0.5mm", 120, 2000);
		items[1] = new Barang(2, "Penggaris 30cm", 30, 5000);
		items[2] = new Barang(3, "Tipe-x Roller", 30, 7000);
		items[3] = new Barang(4, "Pensil Mekanik", 50, 5000);
		items[4] = new Barang(5, "Buku Tulis", 100, 6000);
	}
	
	public static void showItem() {
        System.out.println("Daftar Barang Toko Multiguna");
        for (Barang item: items) {
        	System.out.println("ID		: "+item.getId());
        	System.out.println("Nama	: "+item.getNama());
        	System.out.println("Stock	: "+item.getStock());
        	System.out.println("Harga	: "+item.getHarga());
        	System.out.println("----------------------------------");
        }
   }
	
	public static void showOrder() {
	    System.out.println("Daftar Pesanan Toko Multiguna");
	    for (Order order : orders) {
	        System.out.println("ID		: " + order.getId());
	        System.out.println("Nama	: " + order.getBarang().getNama());
	        System.out.println("Jumlah	: " + order.getJumlah());
	        int total = order.getJumlah()*order.getBarang().getHarga();
	        System.out.println("Total	: " + total);
	        System.out.println("----------------------------------");
	    }
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		inputItem();
		int menuchoice;
		for(;;) {
			System.out.println("-----------Menu Toko Multiguna-----------");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("0. Exit");
			System.out.print("Pilihan : ");
			menuchoice = scanner.nextInt();
			switch(menuchoice) {
				case 1:
					showItem();
					System.out.println("Ketik 0 untuk batal");
					System.out.print("Pesan Barang (ID): ");
					int itemid = scanner.nextInt();
					if(itemid == 0 || itemid < 1 || itemid > 5) {
						break;
					} else {
					    int qty;
					    int availableStock = items[itemid - 1].getStock();
					    do {
					    	System.out.print("Jumlah Barang: ");
					        qty = scanner.nextInt();
					    } while (qty <= 0 || qty > availableStock);
					    int totalHarga = items[itemid-1].getHarga()*qty;
					    System.out.println(qty + " @ " + items[itemid-1].getNama() + " dengan total harga " + totalHarga);
					    System.out.print("Masukkan jumlah uang: ");
					    int uang = scanner.nextInt();
					    if (uang >= totalHarga) {
					        Order order = new Order(itemid, items[itemid - 1], qty);
					        orders.add(order);
					        items[itemid - 1].minusStock(qty);
					        System.out.println("Berhasil dipesan");
					        System.out.println();
					    } else {
					        System.out.println("Jumlah uang tidak mencukupi");
					        System.out.println();
					    }
					    break;
					}
				case 2:
					showOrder();
					break;
				case 0:
					scanner.close();
				    System.exit(0);
				    break;
				default:
					System.out.println("Invalid");
			}
		}
	}
}
