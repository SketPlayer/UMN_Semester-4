package week09.rio.ac.id.umn.Tugas;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static ArrayList<Manager> managers = new ArrayList<Manager>();
	static ArrayList<Tetap> tetaps = new ArrayList<Tetap>();
	static ArrayList<Magang> magangs = new ArrayList<Magang>();
	
	static int iM = 0;
	static int iR = 0;
	static int iI = 0;
	
	public static void lihatKaryawan() {
		System.out.println("------------Daftar Manajer------------");
		if (iM == 0) {
			System.out.println("Tidak ada");
		}
		else {
	    	for (int i = 0; i < iM; i++) {
	    		Manager manager = managers.get(i);
	    		System.out.println("ID	: " + manager.getId());
	    		System.out.println("Nama	: " + manager.getNama());
	    		System.out.println("Gaji	: Rp." + manager.getGaji());
	    		System.out.println("--------------------------------------");
	    	}
		}
		System.out.println("----------Daftar Pegawai Tetap----------");
		if (iR == 0) {
			System.out.println("Tidak ada");
		}
		else {
	    	for (int i = 0; i < iR; i++) {
	    		Tetap tetap = tetaps.get(i);
	    		System.out.println("ID	: " + tetap.getId());
	    		System.out.println("Nama	: " + tetap.getNama());
	    		System.out.println("Gaji	: Rp." + tetap.getGaji());
	    		System.out.println("--------------------------------------");
	    	}
		}
		System.out.println("----------Daftar Pegawai Magang----------");
		if (iI == 0) {
			System.out.println("Tidak ada");
		}
		else {
	    	for (int i = 0; i < iI; i++) {
	    		Magang magang = magangs.get(i);
	    		System.out.println("ID	: " + magang.getId());
	    		System.out.println("Nama	: " + magang.getNama());
	    		System.out.println("Gaji	: Rp." + magang.getGaji());
	    		System.out.println("--------------------------------------");
	    	}
		}
		System.out.println();
	}
	
	public static void addKaryawan() {
		Scanner input = new Scanner(System.in);
		System.out.println("------------Tambah Karyawan------------");
		System.out.println("1. Manajer");
		System.out.println("2. Karyawan Tetap");
		System.out.println("3. Karyawan Magang");
		System.out.print("Pilih : ");
		int pilih = input.nextInt();
		if (pilih == 1) {
			System.out.print("Nama : ");
			String nama = input.next();
			managers.add(new Manager("M"+(iM+1), nama));
			System.out.println("Manajer baru telah ditambahkan");
			iM++;
		}
		else if (pilih == 2) {
			System.out.print("Nama : ");
			String nama = input.next();
			tetaps.add(new Tetap("R"+(iR+1), nama));
			System.out.println("Karyawan tetap baru telah ditambahkan");
			iR++;
		}
		else if (pilih == 3) {
			System.out.print("Nama : ");
			String nama = input.next();
			magangs.add(new Magang("I"+(iI+1), nama));
			System.out.println("Karyawan magang baru telah ditambahkan");
			iI++;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		for(;;) {
			System.out.println("------------Program Data Karyawan------------");
			System.out.println("1. Lihat Karyawan");
			System.out.println("2. Tambah Karyawan");
			System.out.println("3. Keluar");
			System.out.print("Pilih : ");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				lihatKaryawan();
				break;
			case 2:
				addKaryawan();
				break;
			case 3:
				System.out.println("Keluar program...");
				scanner.close();
			    System.exit(0);
			    break;
			}
		}
	}

}
