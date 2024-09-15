package week05.rio.ac.id.umn.Tugas;

import java.util.Scanner;

public class Main {
	public static void hitungLingkaran() {
		Scanner input = new Scanner(System.in);
		System.out.println("------------------Lingkaran------------------");
		System.out.print("Masukkan jari-jari		: ");
		double r = input.nextDouble();
		System.out.print("Warna				: ");
		String color = input.next();
		Lingkaran lingkaran = new Lingkaran(r,color);
		System.out.println("Jari-jari			: " + lingkaran.getRadius());
		System.out.println("Keliling Lingkaran		: " + lingkaran.getKeliling());
		System.out.println("Luas Lingkaran			: " + lingkaran.getLuas());
		System.out.println();
	}
	
	public static void hitungPersegi() {
		Scanner input = new Scanner(System.in);
		System.out.println("--------------------Persegi--------------------");
		System.out.print("Masukkan panjang sisi		: ");
		int s = input.nextInt();
		System.out.print("Warna				: ");
		String color = input.next();
		Persegi persegi = new Persegi(s,color);
		System.out.println("Panjang Sisi			: " + persegi.getSisi());
		System.out.println("Keliling Persegi		: " + persegi.getKeliling());
		System.out.println("Luas Persegi			: " + persegi.getLuas());
		System.out.println();
	}
	
	public static void hitungPPanjang() {
		Scanner input = new Scanner(System.in);
		System.out.println("------------------Persegi Panjang------------------");
		System.out.print("Masukkan panjang		: ");
		int p = input.nextInt();
		System.out.print("Masukkan lebar			: ");
		int l = input.nextInt();
		System.out.print("Warna				: ");
		String color = input.next();
		PersegiPanjang ppanjang = new PersegiPanjang(p,l,color);
		System.out.println("Panjang & Lebar			: " + ppanjang.getPanjang() + " & " + ppanjang.getLebar());
		System.out.println("Keliling Persegi Panjang	: " + ppanjang.getKeliling());
		System.out.println("Luas Persegi Panjang		: " + ppanjang.getLuas());
		System.out.println();
	}
	
	public static void hitungSegitiga() {
		Scanner input = new Scanner(System.in);
		System.out.println("------------------Segitiga Siku-Siku------------------");
		System.out.print("Masukkan alas			: ");
		int a = input.nextInt();
		System.out.print("Masukkan tinggi			: ");
		int t = input.nextInt();
		System.out.print("Warna				: ");
		String color = input.next();
		Segitiga segitiga = new Segitiga(a,t,color);
		System.out.println("Alas & Tinggi			: " + segitiga.getAlas() + " & " + segitiga.getTinggi());
		System.out.println("Keliling Segitiga		: " + segitiga.getKeliling());
		System.out.println("Luas Segitiga			: " + segitiga.getLuas());
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		for(;;) {
			System.out.println("---------Program Menghitung Bangun Datar---------");
			System.out.println("1. Lingkaran");
			System.out.println("2. Persegi");
			System.out.println("3. Persegi Panjang");
			System.out.println("4. Segitiga");
			System.out.println("5. Keluar");
			System.out.print("Pilihan : ");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				hitungLingkaran();
				break;
			case 2:
				hitungPersegi();
				break;
			case 3:
				hitungPPanjang();
				break;
			case 4:
				hitungSegitiga();
				break;
			case 5:
				System.out.println("Keluar program...");
				scanner.close();
			    System.exit(0);
			    break;
			default:
				System.out.println("Input tidak valid");
			}
		}
	}

}
