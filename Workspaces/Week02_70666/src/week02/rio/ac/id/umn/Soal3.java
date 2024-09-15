package week02.rio.ac.id.umn;

import java.util.Scanner;

public class Soal3 {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Masukkan nilai terkecil : ");
		int lownum = myObj.nextInt();
		
		System.out.println("Masukkan nilai terbesar : ");
		int highnum = myObj.nextInt();
		
		int sum = 0;
		
		for (int num = lownum; num <= highnum; num++) {
			boolean flag = true;
			
			if (num <= 1) {
				flag = false;
			}
			else {
				for (int i = 2; i <= Math.sqrt(num); i++) {
					if (num % i == 0) {
						flag = false;
						break;
					}
				}
			}
			
			if (flag) {
				sum += num;
			}
		}
		
		System.out.println("Jumlah dari semua nilai prima dari " + lownum + " sampai " + highnum + " adalah " + sum);
		
		myObj.close();
	}

}
