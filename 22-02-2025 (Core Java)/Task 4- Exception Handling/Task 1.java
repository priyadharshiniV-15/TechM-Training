//Write a Java program that throws an exception and catch it using a try-catch block
public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception occured");
        }

        System.out.println("Program continues....");
    }
}
