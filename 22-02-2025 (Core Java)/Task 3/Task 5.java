//Write a Java program to check if the given pathname is a directory or a file
package Task3;

import java.io.File;
import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path:");
		String path = sc.next();
		File f = new File(path);
		if (!f.exists()) {
			System.out.println("Invalid path. File or directory does not exist.");
		}
		else {
			if (f.isFile())

				System.out.println("The given Path is a File.");

			else if (f.isDirectory())

				System.out.println("The given Path is a directory.");
		}
}
}
