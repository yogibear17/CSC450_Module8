// Simple Java program demonstrating concurrency with two threads
public class ConcurrencyCounter {
    public static void main(String[] args) {
        // Create threads for counting up and down
        Thread countUpThread = new Thread(new CountUp());
        Thread countDownThread = new Thread(new CountDown());

        // Start the first thread and wait for it to finish before starting the second one
        countUpThread.start();
        try {
            countUpThread.join(); // Waits for countUpThread to finish before moving on
        } catch (InterruptedException e) {
            e.printStackTrace(); // Print any interruptions to the console
        }

        // Start the second thread after the first one finishes
        countDownThread.start();
    }
}

// Runnable class to count up from 0 to 20
class CountUp implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Counting Up: " + i); // Print each count
            try {
                Thread.sleep(100); // Pause for a bit to simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interruptions
            }
        }
    }
}

// Runnable class to count down from 20 to 0
class CountDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Counting Down: " + i); // Print each count
            try {
                Thread.sleep(100); // Pause for a bit to simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interruptions
            }
        }
    }
}
