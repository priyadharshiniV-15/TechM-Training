import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ElementFinder {
    public static <T> int findFirstOccurrence(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i; 
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        System.out.print("Enter the target element: ");
        String target = scanner.nextLine();

        int index = findFirstOccurrence(list, target);
        if (index != -1) {
            System.out.println("First occurrence of '" + target + "' is at index: " + index);
        } else {
            System.out.println("'" + target + "' not found in the list.");
        }

        scanner.close();
    }
}
