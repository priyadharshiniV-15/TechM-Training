import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        List<Integer> uniqueNumbers = duplicateNumbers.stream().distinct().collect(Collectors.toList());

        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}
