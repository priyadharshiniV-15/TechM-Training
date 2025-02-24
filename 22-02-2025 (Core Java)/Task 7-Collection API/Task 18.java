import java.util.LinkedList;
import java.util.Scanner;

public class InsertAtEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");

        System.out.println("Original LinkedList: " + list);
        System.out.print("Enter the element to insert at the end: ");
        String newElement = scanner.nextLine();
        list.addLast(newElement); 

        System.out.println("Updated LinkedList: " + list);

        scanner.close();
    }
}
