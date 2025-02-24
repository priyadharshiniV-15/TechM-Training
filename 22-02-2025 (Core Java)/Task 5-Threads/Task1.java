//Write a Java program to create a basic Java thread that prints "Hello, Java!" when executed.
package Task4;
class Task1 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
     Task1 thread = new Task1();
        thread.start();
    }
}
