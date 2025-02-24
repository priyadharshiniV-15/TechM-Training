import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortArrayList {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            colors.add(scanner.nextLine());
        }

        System.out.println("Original List: " + colors);
        Collections.sort(colors);

        System.out.println("Sorted List: " + colors);

        scanner.close();
    }
}
