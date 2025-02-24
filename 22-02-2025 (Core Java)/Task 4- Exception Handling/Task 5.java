//. Write a Java program that reads a file and throws an exception if the file is empty.
package Task4;

import java.util.Scanner;

import java.io.*;

public class Task1 {
	   
	    public static void readFile(String Path) throws FileNotFoundException, IllegalArgumentException {
	        File file = new File(Path);
	        if (!file.exists()) {
	            throw new FileNotFoundException("File not found: " + Path);
	        }
	        
	        if (file.length() == 0) {
	            throw new IllegalArgumentException("File is empty: " + Path);
	        }
	        
	        try (Scanner scanner = new Scanner(file)) {
	            while (scanner.hasNext()) {
	                System.out.println(scanner.nextLine());
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading the file: " + e.getMessage());
	        }
	    }
	    
	    public static void main(String[] args) {
	    	System.out.println("Enter the path:");
	    	Scanner sc=new Scanner(System.in);
	        String Path = sc.next();
	        try {
	            readFile(Path);
	        } catch (FileNotFoundException e) {
	            System.out.println("Exception: " + e.getMessage());
	        } catch (IllegalArgumentException e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
	}
