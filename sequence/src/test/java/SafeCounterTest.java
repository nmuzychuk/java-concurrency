import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SafeCounterTest {

    @Test
    void testCounter() throws InterruptedException {
        int iterations = 1_000_000;

        SafeSequence sequence = new SafeSequence();

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

        assertEquals(iterations * 2, sequence.getCounter());
    }
}
