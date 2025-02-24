//Write a Java program to create a method that reads a file and throws an exception if the file is not found.
package Task4;

import java.util.Scanner;

import java.io.*;

public class Task1 {
    
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        
        try (FileReader fr = new FileReader(file)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
    	System.out.println("Enter the path:");
    	Scanner sc=new Scanner(System.in);
        String Path =sc.nextLine() ;
        try {
            readFile(Path);
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
