import java.util.ArrayList;
import java.util.List;

public class InsertElement {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");

        System.out.println("Original List: " + colors);
        colors.add(0, "Red"); 

        System.out.println("Updated List: " + colors);
    }
}
