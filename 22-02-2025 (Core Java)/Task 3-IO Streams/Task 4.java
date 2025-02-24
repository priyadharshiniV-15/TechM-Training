//Write a Java program to check if a file or directory has read and write permissions.
package Task3;

import java.io.File;
import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
			
			
			if (f.canRead() && f.canWrite())
				System.out.println("The specified path has both read and write permissions.");
			else if (f.canRead())
				System.out.println("The specified path has  only  permission to read.");
			else if (f.canWrite())
				System.out.println("The specified path has  only  permission to write.");
			else
				System.out.println("The specified path has no permission to access.");
		}
		

	}

}
