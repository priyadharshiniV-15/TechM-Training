import java.util.LinkedList;
import java.util.Scanner;

public class InsertAtFront {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");

        System.out.println("Original LinkedList: " + list);
        System.out.print("Enter the element to insert at the front: ");
        String newElement = scanner.nextLine();
        list.addFirst(newElement); 

        System.out.println("Updated LinkedList: " + list);

        scanner.close();
    }
}
