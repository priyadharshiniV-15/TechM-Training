import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReverseList {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
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

        List<String> reversed = reverseList(list);
        System.out.println("Reversed List: " + reversed);

        scanner.close();
    }
}
