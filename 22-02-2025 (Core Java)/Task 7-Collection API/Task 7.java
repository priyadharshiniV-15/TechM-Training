import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchElement {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println("Color List: " + colors);
        
        System.out.print("Enter the element to search: ");
        String searchElement = scanner.nextLine();
        if (colors.contains(searchElement)) {
            int index = colors.indexOf(searchElement);
            System.out.println("'" + searchElement + "' found at index: " + index);
        } else {
            System.out.println("'" + searchElement + "' not found in the list.");
        }

        scanner.close();
    }
}
