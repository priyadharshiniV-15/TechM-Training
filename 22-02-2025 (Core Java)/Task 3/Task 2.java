//Write a Java program to get specific files with extensions from a specified folder.
package Task3;

import java.io.File;

public class Task2 {
	public static void main(String[] args)
	{
		String path="C:\\Users\\ADMIN\\Desktop\\html";
		File f=new File(path);
		String[] a=f.list();
		if(a!=null)
		{
			System.out.println("The files in "+path+" are ");
		for (String name : a) {
			
		if(name.endsWith(".html"))
			System.out.println(name);
	}
}
		else
			System.out.println("The directory is empty!");
	}
}
