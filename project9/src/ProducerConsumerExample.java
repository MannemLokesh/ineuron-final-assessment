import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerExample {
    private static final int MAX_QUEUE_SIZE = 10;
    private static final int MAX_NUMBERS = 100;
    
    private static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());
        
        producerThread.start();
        consumerThread.start();
    }
    
    static class Producer implements Runnable {
        private Random random = new Random();
        
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_QUEUE_SIZE) {
                        try {
                            queue.wait(); // Wait for the consumer to consume items
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    int number = random.nextInt(MAX_NUMBERS);
                    queue.offer(number);
                    System.out.println("Produced: " + number);
                    
                    queue.notifyAll(); // Notify the consumer that items are available
                }
                
                try {
                    Thread.sleep(1000); // Sleep for some time before producing the next number
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    static class Consumer implements Runnable {
        private int sum = 0;
        
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait(); // Wait for the producer to produce items
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    int number = queue.poll();
                    sum += number;
                    System.out.println("Consumed: " + number + ", Sum: " + sum);
                    
                    queue.notifyAll(); // Notify the producer that space is available
                    
                    try {
                        Thread.sleep(1000); // Sleep for some time before consuming the next item
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
