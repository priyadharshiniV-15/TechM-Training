import java.util.LinkedList;
import java.util.Scanner;

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");

        System.out.println("Original LinkedList: " + list);
        System.out.print("Enter the element to insert at the first position: ");
        String firstElement = scanner.nextLine();
        list.addFirst(firstElement);

        System.out.print("Enter the element to insert at the last position: ");
        String lastElement = scanner.nextLine();
        list.addLast(lastElement);

        System.out.println("Updated LinkedList: " + list);

        scanner.close();
    }
}
