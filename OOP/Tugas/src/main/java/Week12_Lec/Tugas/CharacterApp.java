package Week12_Lec.Tugas;

import java.io.*;
import java.util.Scanner;

public class CharacterApp {

	public static void main(String[] args) {
		try {
			Character obj = new Character("Hero", 100, 10, 30, 40);
			
			File file = new File("sample.json");
			if(file.createNewFile()) {
				System.out.println("File berhasil dibuat");
			} else {
				System.out.println("File sudah ada");
			}
			System.out.println();
			try {
				file.setWritable(true);
				FileWriter nulis = new FileWriter("sample.json");
				nulis.write(obj.getData());
				nulis.close();
				System.out.println("Berhasil menulis pada file 'sample.json'");
				System.out.println();
				System.out.println("Isi dari 'sample.json'");
				try {
					Scanner reader = new Scanner(file);
					while (reader.hasNextLine()) {
						String data = reader.nextLine();
						System.out.println(data);
					}
					reader.close();
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
