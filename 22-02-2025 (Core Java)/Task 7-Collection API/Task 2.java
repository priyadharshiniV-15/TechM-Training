import java.util.ArrayList;
import java.util.List;

public class IterateArrayList {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();

    
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");

        // Iterating using a for-each loop
        System.out.println("Using for-each loop:");
        for (String color : colors) {
            System.out.println(color);
        }

        // Iterating using a for loop
        System.out.println("\nUsing for loop:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }

        // Iterating using an iterator
        System.out.println("\nUsing Iterator:");
        var iterator = colors.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
