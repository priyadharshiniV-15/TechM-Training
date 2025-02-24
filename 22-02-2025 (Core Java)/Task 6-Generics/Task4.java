import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AlternateMerge {
    public static <T> List<T> mergeAlternating(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int size1 = list1.size(), size2 = list2.size();
        int i = 0, j = 0;

        while (i < size1 || j < size2) {
            if (i < size1) mergedList.add(list1.get(i++));
            if (j < size2) mergedList.add(list2.get(j++));
        }

        return mergedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        System.out.print("Enter number of elements in first list: ");
        int n1 = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter elements for first list:");
        for (int i = 0; i < n1; i++) {
            list1.add(scanner.nextLine());
        }

        System.out.print("Enter number of elements in second list: ");
        int n2 = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter elements for second list:");
        for (int i = 0; i < n2; i++) {
            list2.add(scanner.nextLine());
        }

        List<String> mergedList = mergeAlternating(list1, list2);
        System.out.println("Merged Alternating List: " + mergedList);

        scanner.close();
    }
}
