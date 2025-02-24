import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateElement {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println("Original List: " + colors);
       
        System.out.print("Enter the index to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index >= 0 && index < colors.size()) {
            System.out.print("Enter the new element: ");
            String newElement = scanner.nextLine();

            colors.set(index, newElement);
            System.out.println("Updated List: " + colors);
        } else {
            System.out.println("Invalid index! Please enter a valid index between 0 and " + (colors.size() - 1));
        }

        scanner.close();
    }
}
