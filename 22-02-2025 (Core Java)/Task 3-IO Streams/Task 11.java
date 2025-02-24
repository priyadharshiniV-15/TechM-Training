//Write a Java program to read a plain text file.

package Task3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Filereader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = sc.nextLine();
        
        File file = new File(path);
        
        // Check if the file exists and is a valid text file
        if (!file.exists() || !file.isFile()) {
            System.out.println("Invalid path. File does not exist or is not a file.");
            return;
        }

        // Check if the file is a text file
        if (!file.getName().endsWith(".txt")) {
            System.out.println("The specified file is not a text file.");
            return;
        }

        // Read and print file contents
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
