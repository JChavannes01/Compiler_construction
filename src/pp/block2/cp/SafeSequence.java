package pp.block2.cp;

//@NotThreadSafe
public class SafeSequence {
    private int value;

    public SafeSequence(int value) {
        this.value = value;
    }
    /** Returns a unique value. */
    public synchronized int getNext() {
        return value++;
    }

    public int getValue() {
        return value;
    }
}