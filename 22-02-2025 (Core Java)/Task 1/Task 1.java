//Task 1:Writea Javaprogramto copy the alternative elementsinthe array.
package TASK1;

import java.util.Scanner;

public class Task1 {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the array size:");
	int s=sc.nextInt();
	int[] a= new int[s];
	System.out.println("Enter the array elements:");
	for(int i=0;i<s;i++)
	{
		a[i]=sc.nextInt();
	}
	int size=0;
	
	if(a.length%2==0)
	size=a.length/2;
	else
		 size=(a.length/2)+1;
	int[] b= new int[size];
	int count1=0;
	for(int i=0;i<a.length;i++)
	{
		if(i%2==0)
		{
			
			b[count1]=a[i];
			count1=count1+1;
		}
					
	}
	System.out.println("The  alternative elements in array are:");
	for(int i=0;i<size;i++)
	{
	System.out.print(b[i]+" ");
	}
	
}
}
