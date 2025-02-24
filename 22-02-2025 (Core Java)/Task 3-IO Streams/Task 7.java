//Write a Java program to read input from the Java console.
package Task3;
import java.util.Scanner;
public class Task7 {
	

	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter your name:");
	        String name = scanner.nextLine(); 
	        System.out.println("Enter the name:");
	        System.out.println("The entered name is:"+name);
	        scanner.close();
	        
	    }
	}

}
