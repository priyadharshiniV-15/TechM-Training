//. Write a Java program to determine the last modified date of a file
package Task3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path:");
		String path = sc.next();
		File f = new File(path);
		 if (!f.exists()) {
	            System.out.println("Invalid path. File or directory does not exist.");
	        } 
		 else {
		long date=f.lastModified();
		SimpleDateFormat sdf=new SimpleDateFormat();
		System.out.println("Last modified date:"+sdf.format(new Date(date)));
	}
}
}
