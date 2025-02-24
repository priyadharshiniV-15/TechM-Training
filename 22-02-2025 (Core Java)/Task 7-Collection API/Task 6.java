import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println("Original List: " + colors);
        if (colors.size() > 2) {
            colors.remove(2);
            System.out.println("Updated List : " + colors);
        } else {
            System.out.println("List does not have enough elements to remove.");
        }
    }
}
