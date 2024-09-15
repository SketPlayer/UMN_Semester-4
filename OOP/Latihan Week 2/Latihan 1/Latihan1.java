import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
		System.out.println("Input: ");
		
		String str = myObj.nextLine();
		String reverseStr = "";
	    
	    int strLength = str.length();

	    for (int i = (strLength - 1); i >=0; i--) {
	      reverseStr = reverseStr + str.charAt(i);
	    }

	    if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
	      System.out.println("Palindrome");
	    }
	    else {
	      System.out.println("Bukan Palindrome");
	    }

        myObj.close();
    }
}