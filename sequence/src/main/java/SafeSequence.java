public class SafeSequence {
    private long counter;

    public long getCounter() {
        return counter;
    }

    public synchronized long increment() {
        return ++counter;
    }
}
