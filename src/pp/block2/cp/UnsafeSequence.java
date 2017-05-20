package pp.block2.cp;

//@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public UnsafeSequence(int value) {
        this.value = value;
    }
    /** Returns a unique value. */
    public int getNext() {
        return value++;
    }

    public int getValue() {
        return value;
    }
}