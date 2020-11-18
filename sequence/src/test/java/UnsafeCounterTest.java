import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UnsafeCounterTest {

    @Test
    void testCounter() throws InterruptedException {
        int iterations = 1_000_000;

        UnsafeSequence sequence = new UnsafeSequence();

        Runnable r = () -> {
            for (int i = 0; i < iterations; i++) {
                sequence.increment();
            }
        };

        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertNotEquals(iterations * 2, sequence.getCounter());
    }
}
