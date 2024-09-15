package week03.rio.ac.id.umn;

import java.util.Scanner;

public class Tugas2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Masukkan Nama Anda : ");
		String name = scanner.nextLine();
		System.out.println("----------------------------------------");
		System.out.println("String anda : " + name);
		System.out.println("1. charAt \t\t 2. length");
		System.out.println("3. substring(n) \t 4. substring(m,n)");
		System.out.println("5. contains \t\t 6. concat");
		System.out.println("7. replace \t\t 8. split");
		System.out.println("9. lowerCase \t\t 10. upperCase");
		System.out.println("Pilih menu : ");
		int choice = scanner.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("------charAt------");
				System.out.println("Nama : " + name);
				System.out.println("Input : ");
				int opt1 = scanner.nextInt();
				System.out.println("Hasil : " + name.charAt(opt1));
				break;
		case 2:
				System.out.println("------length------");
				System.out.println("Nama : " + name);
				System.out.println("Hasil : " + name.length());
				break;
			case 3:
				System.out.println("------substring(n)------");
				System.out.println("Nama : " + name);
				System.out.println("Input : ");
				int opt3 = scanner.nextInt();
				System.out.println("Hasil : " + name.substring(opt3));
				break;
			case 4:
				System.out.println("------substring(m,n)------");
				System.out.println("Nama : " + name);
				System.out.println("Input mulai : ");
				int opt4m = scanner.nextInt();
				System.out.println("Input akhir : ");
				int opt4n = scanner.nextInt();
				System.out.println("Hasil : " + name.substring(opt4m,opt4n));
				break;
			case 5:
				System.out.println("------contains------");
				System.out.println("Nama : " + name);
				System.out.println("Input : ");
				String opt5 = scanner.nextLine();
				System.out.println("Hasil : " + name.contains(opt5));
				break;
			case 6:
				System.out.println("------concat------");
				System.out.println("Nama : " + name);
				System.out.println("Input : ");
				String opt6 = scanner.nextLine();
				System.out.println("Hasil : " + name.concat(opt6));
				break;
			case 7:
				System.out.println("------replace------");
				System.out.println("Nama : " + name);
				System.out.println("Input kata yang diganti : ");
				String opt7m = scanner.nextLine();
				System.out.println("Input kata pengganti : ");
				String opt7n = scanner.nextLine();
				System.out.println("Hasil : " + name.replace(opt7m, opt7n));
				break;
			case 8:
				System.out.println("------split------");
				System.out.println("Nama : " + name);
				System.out.println("Input : ");
				String opt8 = scanner.nextLine();
				String[] arrStr = name.split(opt8);
				for (String split : arrStr) {
					System.out.println("Hasil: " + split);
				}
				break;
			case 9:
				System.out.println("------lowerCase------");
				System.out.println("Nama : " + name);
				System.out.println("Hasil : " + name.toLowerCase());
				break;
			case 10:
				System.out.println("------upperCase------");
				System.out.println("Nama : " + name);
				System.out.println("Hasil : " + name.toUpperCase());
				break;
			default:
				System.out.println("Invalid Input");
		}
		
		scanner.close();
	}

}
