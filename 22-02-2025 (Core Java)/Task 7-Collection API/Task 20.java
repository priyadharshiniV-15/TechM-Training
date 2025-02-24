import java.util.LinkedList;
import java.util.Scanner;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");
        list.add("Blue");
        list.add("Purple");
        list.add("Blue");

        System.out.println("LinkedList: " + list);
        System.out.print("Enter the element to find: ");
        String element = scanner.nextLine();
        int firstIndex = list.indexOf(element);
        int lastIndex = list.lastIndexOf(element);

        if (firstIndex != -1) {
            System.out.println("First occurrence of '" + element + "' is at index: " + firstIndex);
            System.out.println("Last occurrence of '" + element + "' is at index: " + lastIndex);
        } else {
            System.out.println("Element '" + element + "' not found in the list.");
        }

        scanner.close();
    }
}
