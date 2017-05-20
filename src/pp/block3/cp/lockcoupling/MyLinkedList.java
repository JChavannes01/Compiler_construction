package pp.block3.cp.lockcoupling;

import pp.block2.cp.queue.LinkedQueue;

import java.util.LinkedList;

/**
 * Created by Janko on 5/12/2017.
 */
public class MyLinkedList implements List{
    private final LinkedList list = new LinkedList();
    private final Object lock = new Object();

    public MyLinkedList() {
    }

    @Override
    public void insert(int pos, Object val) {

    }

    @Override
    public void add(Object val) {
        synchronized (lock) {
            list.add(val);
        }
    }

    @Override
    public void remove(Object item) {

    }

    @Override
    public void delete(int pos) {

    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        long before = System.currentTimeMillis();
        int cycles = 1000;

        for (int i = 0; i < cycles; i++) {
            list.add(i);
        }
        long elapsed = System.currentTimeMillis() - before;
        System.out.println("Running add *" + cycles + "* times took *" + elapsed + "* milliseconds.");
    }
}
