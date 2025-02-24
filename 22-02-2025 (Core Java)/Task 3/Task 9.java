//Write a Java program to read the contents of a file into a byte array
package Task3;

import java.io.*;
import java.util.Scanner;

public class Filereader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = sc.nextLine(); // Read the file path

        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Invalid path. File does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[(int) file.length()]; // Create byte array of file size
            fis.read(byteArray); // Read file content into byte array

            // Display the byte array content as a string
            String content = new String(byteArray);
            System.out.println("File content:\n" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
