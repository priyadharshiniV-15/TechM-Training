import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class IterateFromPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");
        list.add("Purple");

        System.out.println("LinkedList: " + list);
        System.out.print("Enter the starting index (0 to " + (list.size() - 1) + "): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < list.size()) {
            ListIterator<String> iterator = list.listIterator(index);
            System.out.println("Iterating from index " + index + ":");
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } else {
            System.out.println("Invalid index! Please enter a value between 0 and " + (list.size() - 1
