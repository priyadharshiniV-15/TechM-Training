//Write a Java program to create a method that takes an integer as a parameter and throws an exception if
//the number is odd.
package Task4;

import java.util.Scanner;

public class Task1 {
	    public static void checkEven(int number) throws OddNumberException {
	        if (number % 2 != 0) {
	            throw new OddNumberException("The number " + number + " is odd.");
	        } else {
	            System.out.println("The number " + number + " is even.");
	        }
	    }

	    public static void main(String[] args) {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter a number:");
	        int Number = sc.nextInt(); 
	        try {
	            checkEven(Number);
	        } catch (OddNumberException e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
}
	    class OddNumberException extends Exception {
	        public OddNumberException(String message) {
	            super(message);
	        }
	    }


