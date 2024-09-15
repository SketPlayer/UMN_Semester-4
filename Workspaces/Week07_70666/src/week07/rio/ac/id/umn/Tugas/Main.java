package week07.rio.ac.id.umn.Tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Item> listOfItems = new ArrayList<Item>();
	static ArrayList<Payment> listOfPayments = new ArrayList<Payment>();
	static Scanner s = new Scanner(System.in);
	
	public static void seedData() {
		listOfItems.add(new Item("Kulkas", "Electronic", 4800000));
		listOfItems.add(new Item("TV", "Electronic", 1280000));
		listOfItems.add(new Item("Laptop", "Computer", 6000000));
		listOfItems.add(new Item("PC", "Computer", 12000000));
	}
	
	public static void printItem(Item item) {
		System.out.println("Nama	: " +item.getName());
		System.out.println("Tipe	: " +item.getType());
		System.out.println("Harga	: " +item.getPrice());
	}
	
	public static void printPayment(Payment payment) {
		System.out.println("Nama		 : " +payment.getItemName());
		System.out.println("Tipe		 : " +payment.item.getType());
		System.out.println("Status		 : " +payment.getStatus());
		System.out.println("Sisa Pembayaran	 : " +payment.getRemainingAmount());
	}

	public static void main(String[] args) {
		
		int opt = 0, id = 0;
		seedData();
		do {
			System.out.println("----Program Toko Elektronik----");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("0. Keluar");
			System.out.print("Pilihan : ");
			opt = s.nextInt();
			if (opt == 1) {
			    System.out.println("----Daftar Barang----");
			    for (int i = 0; i < listOfItems.size(); i++) {
			        System.out.println("No    : " + (i + 1));
			        printItem(listOfItems.get(i));
			        System.out.println("---------------------");
			    }
			    System.out.print("Pilih : ");
			    id = s.nextInt();
			    Item selectedItem = listOfItems.get(id - 1);
			    printItem(selectedItem);
			    System.out.println("----Tipe Pembayaran----");
			    System.out.println("1. Cash");
			    System.out.println("2. Credit");
			    System.out.print("Pilih : ");
			    int payType = s.nextInt();
			    if (payType == 1) { // Pembayaran cash
			        System.out.print("Bayar (Y/N): ");
			        char payChoice = s.next().charAt(0);
			        if (payChoice == 'Y' || payChoice == 'y') {
			            System.out.println("Harga Pembayaran : " + selectedItem.getPrice());
			            System.out.print("Bayar : ");
			            int paymentAmount = s.nextInt();
			            if (paymentAmount >= selectedItem.getPrice()) {
			                listOfPayments.add(new Cash(selectedItem));
			                Payment selectedPayment = listOfPayments.get(listOfPayments.size() - 1);
			                selectedPayment.pay();
			                System.out.println("Transaksi telah dibayar lunas");
			            } else {
			                System.out.println("Transaksi gagal");
			            }
			        } else {
			            System.out.println("Transaksi telah disimpan");
			            listOfPayments.add(new Cash(selectedItem));
			        }
			    } else if (payType == 2) { // Pembayaran credit
			        System.out.print("Lama Cicilan (3/6/9/12): ");
			        int lama = s.nextInt();
			        int maxInstallmentAmount = lama;
			        if (lama == 3 || lama == 6 || lama == 9 || lama == 12) {
			            int installmentAmount = selectedItem.getPrice() / lama;
			            System.out.println("Harga Pembayaran : " + installmentAmount);
			            System.out.print("Bayar : ");
			            int paymentAmount = s.nextInt();
			            if (paymentAmount >= installmentAmount) {
			                listOfPayments.add(new Credit(selectedItem, maxInstallmentAmount));
			                Payment selectedPayment = listOfPayments.get(listOfPayments.size() - 1);
			                selectedPayment.pay();
			                System.out.println("Transaksi telah dibayar");
			            } else {
			                System.out.println("Transaksi gagal");
			            }
			        } else {
			            System.out.println("Input lama cicilan tidak valid");
			        }
			    }
			}

			else if(opt == 2) {
				System.out.println("----Daftar Pesanan----");
			    for (int i = 0; i < listOfPayments.size(); i++) {
			        System.out.println("No    		 : " + (i + 1));
			        printPayment(listOfPayments.get(i));
			        System.out.println("----------------------");
			    }
			    System.out.print("Pilih No Transaksi : ");
			    id = s.nextInt();
			    Payment selectedPayment = listOfPayments.get(id - 1);
			    printPayment(selectedPayment);
			    int reqPayment = selectedPayment.getRemainingAmount();
			    int installmentAmount = reqPayment;
			    System.out.print("Harga Pembayaran : ");
			    if (selectedPayment instanceof Credit) {
			        Credit creditPayment = (Credit) selectedPayment;
			        installmentAmount = selectedPayment.getItem().getPrice() / creditPayment.getMaxInstallmentAmount();
			        if (reqPayment == 0) {
			        	System.out.println(reqPayment);
			        } else {
			        	System.out.println(installmentAmount);
			        }
			    } else {
			        System.out.println(reqPayment);
			    }
				if (reqPayment == 0) {
					System.out.println("Transaksi telah lunas");
				}
				else {
					System.out.print("Bayar : ");
					int paymentAmount = s.nextInt();
					if (paymentAmount >= reqPayment || paymentAmount >= installmentAmount) {
						selectedPayment.pay();
			            System.out.println("Transaksi telah dibayar");
			        } else {
			            System.out.println("Transaksi Gagal");
			        }
				}
			}
			else if(opt == 0) {
				System.out.println("Terima Kasih");
				System.exit(0);
			}
			else {
				System.out.println("Salah input");
			}
		}while(opt != 0);
	}

}
