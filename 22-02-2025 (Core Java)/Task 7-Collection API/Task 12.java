import java.util.Iterator;
import java.util.LinkedList;

public class IterateLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");
        list.add("Purple");

        System.out.println("Iterating using for-each loop:");
        for (String color : list) {
            System.out.println(color);
        }

        System.out.println("\nIterating using Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nIterating using for loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
     
