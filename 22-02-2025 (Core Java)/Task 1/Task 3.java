//Demonstrate with an example with the difference between equals() vs deepEquals() method
package TASK1;
import java.util.Arrays;
public class Task3 {
	  //The return type of both method is boolean
	    public static void main(String[] args) {
	        
	       //equals() method is used for comparing single dimensional array
	        int[] ar1 = {1,2,3,4 };
	        int[] ar2= {1,2,3,4};
	        int[] ar3= {3,4,5,6};
	        System.out.println(Arrays.equals(ar1, ar2));
	        System.out.println(Arrays.equals(ar1, ar3));
	        System.out.println(Arrays.equals(ar2, ar3));
	       // System.out.println(Arrays.deepEquals(ar2, ar3)); //"It throws error since the comparision is between two single dimensional arrays"
	      
	        System.out.println();
	        //deepEquals() method is used for comparing two dimensional array
	        int[][] arr1= {{1,2},{3,4}};
	        int[][] arr2= {{3,4},{1,2}};
	        int[][] arr3= {{1,2},{3,4}};
	        System.out.println(Arrays.deepEquals(arr1, arr2));
	        System.out.println(Arrays.deepEquals(arr1, arr3));
	        System.out.println(Arrays.deepEquals(arr2, arr3));
	        
	      System.out.println(Arrays.equals(arr1, arr3)); //This compares only the reference addresses, not the inner arrays.
	        }
	    }
	
