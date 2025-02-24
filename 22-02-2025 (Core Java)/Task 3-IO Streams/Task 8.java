//Write a Java program to get the file size in bytes, KB, MB.
package Task3;

import java.io.File;
import java.util.Scanner;

public class Task8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path:");
		String path = sc.next();
		File f = new File(path);
		 if (!f.exists()) {
	            System.out.println("Invalid path. File or directory does not exist.");
	        } 
		 else {
			 long fileSizeInBytes = f.length(); // Get file size in bytes
	            
	            double fileSizeInKB = fileSizeInBytes / 1024.0; // Convert to KB
	            double fileSizeInMB = fileSizeInKB / 1024.0; //convert to MB
	            
	            System.out.println("Bytes: " + fileSizeInBytes);
	            System.out.printf("KB: ", fileSizeInKB);
	            System.out.printf("MB: ", fileSizeInMB);
		 }
	}
	
}
