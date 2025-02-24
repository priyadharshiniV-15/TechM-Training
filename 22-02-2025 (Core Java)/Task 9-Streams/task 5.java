import java.util.Arrays;
import java.util.List;

public class CountStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");
        char specificLetter = 'a';

        long count = words.stream().filter(word -> word.startsWith(String.valueOf(specificLetter))).count();

        System.out.println("Count of words starting with '" + specificLetter + "': " + count);
    }
}
