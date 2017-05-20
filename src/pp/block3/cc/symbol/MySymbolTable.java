package pp.block3.cc.symbol;

import java.util.*;

public class MySymbolTable implements SymbolTable {
    private Deque<Set<String>> queue;

    public MySymbolTable() {
        this.queue = new ArrayDeque<>();
        openScope();
    }

    @Override
    public void openScope() {
        this.queue.addLast(new HashSet<>());
    }

    @Override
    public void closeScope() {
        if (this.queue.size() == 1) {
            throw new RuntimeException();
        }
        this.queue.removeLast();
    }

    @Override
    public boolean add(String id) {
        if (this.queue.isEmpty() || this.queue.getLast().contains(id)) {
            return false;
        }
        Set<String> temp = this.queue.removeLast();
        temp.add(id);
        this.queue.addLast(temp);
        return true;
    }

    @Override
    public boolean contains(String id) {
        Iterator<Set<String>> iterator = queue.iterator();
        while (iterator.hasNext()) {
           if (iterator.next().contains(id)) return true;
        }
        return false;
    }
}
