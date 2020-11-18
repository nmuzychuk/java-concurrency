public class UnsafeSequence {
    private long counter;

    public long getCounter() {
        return counter;
    }

    public long increment() {
        return ++counter;
    }
}
