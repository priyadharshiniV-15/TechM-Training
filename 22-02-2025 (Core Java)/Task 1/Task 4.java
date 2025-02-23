//Use ArrayCopyRange() function to demonstrate and example such that you copy the range of valuesin an
//array.
package TASK1;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter the array size:");
     int size=sc.nextInt();
     System.out.println("Enter the array elements:");
     int[] ar=new int[size];
     for(int i=0;i<size;i++)
     {
    	 ar[i]=sc.nextInt();
     }
    
     System.out.println("Enter the starting index of element to copy: ");
     int starting_index=sc.nextInt();
     System.out.println("Ending index:");
     int ending_index=sc.nextInt();
	int[] nar=Arrays.copyOfRange(ar, starting_index, ending_index);
	
	System.out.println("New array:"+Arrays.toString(nar));
	sc.close();
	}

}

