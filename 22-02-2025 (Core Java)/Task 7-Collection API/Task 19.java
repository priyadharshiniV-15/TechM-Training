import java.util.LinkedList;
import java.util.Scanner;

public class InsertMultipleAtPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");

        System.out.println("Original LinkedList: " + list);
        System.out.print("Enter the position to insert elements (0 to " + list.size() + "): ");
        int position = scanner.nextInt();
        scanner.nextLine(); 
        if (position < 0 || position > list.size()) {
            System.out.println("Invalid position! Enter a value between 0 and " + list.size());
        } else {
            System.out.print("Enter the number of elements to insert: ");
            int count = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                String newElement = scanner.nextLine();
                list.add(position + i, newElement); 
            }

            System.out.println("Updated LinkedList: " + list);
        }

        scanner.close();
    }
}
