import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class EvenOddSumCalculator {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        int evenSum = 0, oddSum = 0;

        for (T num : numbers) {
            int value = num.intValue(); 
            if (value % 2 == 0) evenSum += value;
            else oddSum += value;
        }

        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        sumEvenOdd(numbers);
        scanner.close();
    }
}
