package pp.block2.cp.queue;

public interface Queue<T> {
    /** Push an element at the head of the queue. */
    public void push(T x);
    
    /** Obtain and remove the tail of the queue. */
    public T pull() throws QueueEmptyException;

    /** Returns the number of elements in the queue. */
    public int getLength();
}
