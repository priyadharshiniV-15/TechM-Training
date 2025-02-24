import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RetrieveElement {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");
      System.out.println("Color List: " + colors);
       
        System.out.print("Enter the index to retrieve the element: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < colors.size()) {
            System.out.println("Element at index " + index + ": " + colors.get(index));
        } else {
            System.out.println("Invalid index! Please enter a valid index between 0 and " + (colors.size() - 1));
        }

        scanner.close();
    }
}
