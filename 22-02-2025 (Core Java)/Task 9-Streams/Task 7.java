import java.util.Arrays;
import java.util.List;

public class MinMaxFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 5, 100);

        int maxValue = numbers.stream().max(Integer::compare).orElseThrow();
        int minValue = numbers.stream().min(Integer::compare).orElseThrow();

        System.out.println("Max value: " + maxValue);
        System.out.println("Min value: " + minValue);
    }
}
