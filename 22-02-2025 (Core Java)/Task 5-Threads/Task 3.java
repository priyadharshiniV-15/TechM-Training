import java.util.Arrays;

class MultiThreadedSort extends Thread {
    private int[] array;
    private int left, right;
    
    public MultiThreadedSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }
    
    public void run() {
        Arrays.sort(array, left, right + 1);
    }
    
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array: " + Arrays.toString(array));
        
        MultiThreadedSort sorter1 = new MultiThreadedSort(array, 0, array.length / 2);
        MultiThreadedSort sorter2 = new MultiThreadedSort(array, array.length / 2 + 1, array.length - 1);
        
        sorter1.start();
        sorter2.start();
        
        try {
            sorter1.join();
            sorter2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
