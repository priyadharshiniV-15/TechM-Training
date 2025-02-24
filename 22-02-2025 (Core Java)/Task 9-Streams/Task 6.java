import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> sortedAscending = words.stream().sorted().collect(Collectors.toList());
        List<String> sortedDescending = words.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

        System.out.println("Sorted Ascending: " + sortedAscending);
        System.out.println("Sorted Descending: " + sortedDescending);
    }
}
