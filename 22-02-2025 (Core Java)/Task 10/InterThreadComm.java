import java.util.LinkedList;

class SharedQueue {
    private final LinkedList<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    // Producer method
    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            System.out.println("Queue is full. Producer waiting...");
            wait();
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notify(); 
    }

    // Consumer method
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Consumer waiting...");
            wait(); 
        }
        int item = queue.removeFirst();
        System.out.println("Consumed: " + item);
        notify(); 
        return item;
    }
}

// Producer Thread
class Producer extends Thread {
    private final SharedQueue sharedQueue;

    public Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        int item = 1;
        while (true) {
            try {
                sharedQueue.produce(item++);
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    private final SharedQueue sharedQueue;

    public Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while (true) {
            try {
                sharedQueue.consume();
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main Class
public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);

        producer.start();
        consumer.start();
    }
}
