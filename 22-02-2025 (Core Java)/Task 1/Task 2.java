//Write a java programto acceptthe students name andmarksin subjects and find the total and averageofthe
//marks and sort the list accordingly.
package TASK1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task2 {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the name of the student:");
	String sname=sc.next();
	ArrayList<Integer> Marks=new ArrayList<Integer>();
	System.out.println("Enter the Tamil mark:");
	Marks.add(sc.nextInt());
	System.out.println("Enter the English mark:");
	Marks.add(sc.nextInt());
	System.out.println("Enter the Maths mark:");
	Marks.add(sc.nextInt());
	System.out.println("Enter the Science mark:");
	Marks.add(sc.nextInt());
	System.out.println("Enter the Social mark:");
	Marks.add(sc.nextInt());
	int total=0;
	double average=0;
	for(int i=0;i<Marks.size();i++)
	{
		total=total+Marks.get(i);
	}
	System.out.println("The total marks  of "+sname+" is: "+total+".");
	average=(double)total/Marks.size();
	System.out.println("The average of "+sname+" is: "+average+".");
	Collections.sort(Marks);
	System.out.println("The sorted list of mark is:"+Marks);
	sc.close();
}
}
