import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Input: ");
        int number = myObj.nextInt(), originalNumber, remainder, result = 0, n = 0;

        myObj.close();

        originalNumber = number;

        for (;originalNumber != 0; originalNumber /= 10) {
            n++;
        }

        originalNumber = number;

        for (;originalNumber != 0; originalNumber /= 10)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
        }

        if(result == number) {
            System.out.println("Armstrong number");
        }
        else {
            System.out.println("Bukan Armstrong number");
        }
    }
}