//Write a Java program to check if a file or directory specified by pathname exists or not
package Task3;

import java.io.File;
import java.util.Scanner;

public class Task3 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String path=sc.next();
		File f=new File(path);
		if(f.exists())
		{
			if(f.isFile())
			System.out.println("file exists in the specified path");
			else if(f.isDirectory())
				System.out.println("Directory exists in the specified path");
		}
		else
			System.out.println("File does not exist.");
		sc.close();
	}
}
