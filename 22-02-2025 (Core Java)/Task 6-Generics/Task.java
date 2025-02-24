import java.util.Scanner;

public class ArrayComparator {
    public static <T> boolean areArraysEqual(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of the arrays: ");
        int size = scanner.nextInt();
        Integer[] arr1 = new Integer[size];
        Integer[] arr2 = new Integer[size];

        System.out.println("Enter elements for first array:");
        for (int i = 0; i < size; i++) {
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Enter elements for second array:");
        for (int i = 0; i < size; i++) {
            arr2[i] = scanner.nextInt();
        }
        if (areArraysEqual(arr1, arr2)) {
            System.out.println("Arrays are equal.");
        } else {
            System.out.println("Arrays are not equal.");
        }

        scanner.close();
    }
}
