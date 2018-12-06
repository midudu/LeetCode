import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class ProducerThread implements Runnable {

    private final Queue<Integer> buffer;
    private final int maxSize;

    public ProducerThread(final Queue<Integer> buffer, final int maxSize) {

        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (this.buffer) {

                while (this.buffer.size() == maxSize) {

                    System.out.println("Producer " + Thread.currentThread().getName()
                            + " is blocked");

                    try {
                        this.buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Random random = new Random();
                int item = random.nextInt(100);
                this.buffer.offer(item);

                System.out.print("Producer " + Thread.currentThread().getName() + ": ");
                for (Integer element : this.buffer) {
                    System.out.print(element + " ");
                }
                System.out.println();

                if (this.buffer.size() == 1) {
                    this.buffer.notifyAll();
                }
            }
        }
    }
}

class ConsumerThread implements Runnable {

    private final Queue<Integer> buffer;
    private final int maxSize;

    public ConsumerThread(final Queue<Integer> buffer, int maxSize) {

        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (this.buffer) {

                while (this.buffer.size() == 0) {

                    System.out.println("Consumer " + Thread.currentThread().getName()
                            + " is blocked");

                    try {
                        this.buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                this.buffer.poll();

                System.out.print("Consumer " + Thread.currentThread().getName() + ": ");
                for (Integer element : this.buffer) {
                    System.out.print(element + " ");
                }
                System.out.println();

                if (this.buffer.size() == this.maxSize - 1) {
                    this.buffer.notifyAll();
                }
            }
        }
    }
}

class TimeThread implements Runnable {

    private long sleepTime;

    public TimeThread(long sleepTime) {

        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestProducerAndConsumer {

    static private final int producerNumbers = 5;
    static private final int consumerNumbers = 3;
    static private final int maxBufferSize = 10;
    static private final long sleepTime = 300;

    public static void main(String[] args) {

        Queue<Integer> buffer = new LinkedList<>();

        Thread timeThread = new Thread(new TimeThread(sleepTime));

        for (int i = 0; i < producerNumbers; i++) {

            Thread producerThread = new Thread(
                    new ProducerThread(buffer, maxBufferSize), "p" + i);
            producerThread.setDaemon(true);

            producerThread.start();
        }

        for (int i = 0; i < consumerNumbers; i++) {

            Thread consumerThread = new Thread(
                    new ConsumerThread(buffer, maxBufferSize), "c" + i);
            consumerThread.setDaemon(true);

            consumerThread.start();
        }

        timeThread.start();

        try {
            timeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nTime expired!");

    }
}

