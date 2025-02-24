package Task3;

//1. Write a Java program to get a list of all file/directory names in the given directory
  import java.io.File;

public class Task1 {
public static void main(String[] args)
{
	
	String path="C:\\Program Files\\MySQL";
	File f=new File(path);
	String[] a=f.list();
	if(a!=null)
	{
		System.out.println("The files in "+path+" are ");
	for (String name : a) {
        System.out.println(name);
	}
    }
	else
		System.out.println("The directory is Empty");
	
	
	}
}
