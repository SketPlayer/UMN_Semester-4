package week02.rio.ac.id.umn;

import java.util.Scanner;

public class Soal2 {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Masukkan angka : ");
		int number = myObj.nextInt();
		boolean flag = false;
		
		if (number <= 1) {
			System.out.println("Angka " + number + " adalah bukan angka prima");
        }
		else if (number <= 3) {
        	System.out.println("Angka " + number + " adalah angka prima");
        }
		
		else {
        
			for (int i = 2; i <= number/2; i++) {
				if (number % i == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("Angka " + number + " adalah angka prima");
			}
			else {
				System.out.println("Angka " + number + " adalah bukan angka prima");
			}
		}
        myObj.close();
	}
	
}
