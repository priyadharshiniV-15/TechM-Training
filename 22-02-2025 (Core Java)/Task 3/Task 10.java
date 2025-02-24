//Write a Java program to read file content line by line.
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

        // Try-with-resources ensures automatic resource closing
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) { // Read each line
                System.out.println(line); // Print the line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
