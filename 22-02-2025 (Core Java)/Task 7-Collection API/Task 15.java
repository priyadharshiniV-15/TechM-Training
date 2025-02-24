import java.util.LinkedList;
import java.util.Scanner;

public class InsertElementInLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");
        list.add("Purple");

        System.out.println("Original LinkedList: " + list);
        System.out.print("Enter the element to insert: ");
        String newElement = scanner.nextLine();
        
        System.out.print("Enter the position (0 to " + list.size() + "): ");
        int position = scanner.nextInt();
        if (position >= 0 && position <= list.size()) {
            list.add(position, newElement);
            System.out.println("Updated LinkedList: " + list);
        } else {
            System.out.println("Invalid position! Please enter a value between 0 and " + list.size());
        }

        scanner.close();
    }
}
