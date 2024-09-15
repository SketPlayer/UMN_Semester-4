import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        int input = scanner.nextInt();
        if (input == 1) {
            Parent obj = new Child1();
            obj.message();
        }
        else if (input == 2) {
            Parent obj = new Child2();
            obj.message();
        }
        else {
            System.out.println("Invalid");
        }
        scanner.close();
    }
}