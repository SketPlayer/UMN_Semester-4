import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        int input = scanner.nextInt();
        if (input == 1) {
            Bank obj = new BankA();
            System.out.println("$" + obj.getBalance());
        }
        else if (input == 2) {
            Bank obj = new BankB();
            System.out.println("$" + obj.getBalance());
        }
        else if (input == 3) {
            Bank obj = new BankC();
            System.out.println("$" + obj.getBalance());
        }
        else {
            System.out.println("Bank Tidak Terdaftar");
        }
        scanner.close();
    }
}
