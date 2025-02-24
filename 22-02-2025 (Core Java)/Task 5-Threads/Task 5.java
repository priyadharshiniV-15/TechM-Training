import java.util.concurrent.*;

public class PrimeSum {
    public static void main(String[] args) throws Exception {
        int limit = 100000, threads = 4, chunk = limit / threads;
        ExecutorService exec = Executors.newFixedThreadPool(threads);
        Future<Long>[] results = new Future[threads];

        for (int i = 0; i < threads; i++) 
            results[i] = exec.submit(new PrimeTask(i * chunk + 1, (i + 1) * chunk));

        long sum = 0;
        for (Future<Long> res : results) sum += res.get();

        exec.shutdown();
        System.out.println("Sum of primes up to " + limit + " is: " + sum);
    }
}

class PrimeTask implements Callable<Long> {
    int start, end;
    PrimeTask(int s, int e) { start = s; end = e; }
    public Long call() {
        long sum = 0;
        for (int i = start; i <= end; i++) if (isPrime(i)) sum += i;
        return sum;
    }
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
}
