package Task4;
class evenThread extends Thread {
    @Override
    public void run() {
    	 System.out.print("Even: ");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(  i+" ");
                
            }
        }
       

    }
}
class OddThread extends Thread {
    @Override
    public void run() {
    	 System.out.println();
    	System.out.print("Odd: ");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.print( i+" ");
            }
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        evenThread t1 = new evenThread();
        OddThread t2 = new OddThread();
        
        t1.start();
        t2.start();
    }
}


