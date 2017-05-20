package pp.block2.cp.queue;

/**
 * Created by Janko on 5/4/2017.
 */
public class LinkedQueue implements Queue {
    private Node root;

    /** Create a new empty LinkedQueue */
    public LinkedQueue () {
        root = null;
    }

    /** Create a new LinkedQueue with the given node at the root.*/
    public LinkedQueue (Node root) {
        this.root = root;
    }

    /** Returns the last node in the queue. */
    public Node getLastNode() {
        if (root == null) return null;
        Node node = root;
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

    /** Add new node to the back of the queue */
    public synchronized void addNode (Node node) {
        Node temp = getLastNode();
        if (temp == null) root = node;
        else temp.setNext(node);
    }

    public void clearQueue () {
        root = null;
    }
    /** Takes the first node (root) in the queue */
    public Node takeFirst () {
        if (root == null) return null;
        else {
            Node result = root;
            root = (root.hasNext()) ? root.getNext() : null;
            return result;
        }
    }

    @Override
    public void push(Object x) {
        if (root == null || root.getValue() == x) return;

        Node start = root;
        Node prev = null;

        while (start != null && start.getValue() != x) {
            prev = start;
            start = start.getNext();
        }

        if (start == null) return;
        prev.setNext(start.getNext());
        start.setNext(root);
        root = start;
    }

    @Override
    public Object pull() throws QueueEmptyException {
        Node last = getLastNode();
        if (last == null) throw new QueueEmptyException();
        push(last.getValue());
        return takeFirst();
    }

    @Override
    public int getLength() {
        int result = (root==null) ? 0 : 1;
        Node node = root;
        while (node.getNext() != null) {
            node = node.getNext();
            result++;
        }
        return result;
    }

    @Override
    public String toString() {
        String rs = (root==null) ? "null" : root.toString();
        String result = "LinkedQueue{" +
                "root=" + rs +
                ", Queue = [" + rs;
        Node node = root;
        if (node==null) return result + "])";

        while (node.hasNext()) {
            node = node.getNext();  // add next nodes to the list
            result += ", " + node;
        }
        result += "])";
        return result;
    }
}