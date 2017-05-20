package pp.block2.cp.queue;

/**
 * Created by Janko on 5/4/2017.
 */
public class Node {
    private Object value;
    private Node next;

    /** Create a new Node with the given value */
    public Node (Object value) {
        this.value = value;
        next = null;
    }

    /** Returns the next Node in the LinkedQueue */
    public Node getNext() {
        return next;
    }

    /** Checks whether there is a next Node in the LinkedQueue */
    public boolean hasNext() {
        return getNext() != null;
    }

    /** Set a new next value in the Queue */
    public void setNext(Node next) {
        this.next = next;
    }

    /** Returns the value of the Node */
    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}