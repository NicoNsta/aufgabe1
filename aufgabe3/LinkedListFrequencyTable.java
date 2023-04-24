package aufgabe3;

import java.util.Iterator;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {

    private Node begin;
    private int size;
    public LinkedListFrequencyTable() {
        clear();
    }

    private void moveToLeft(int fc) {
        Node current = this.begin.next;

        if (fc > 1) {
            for (int i = 1; i < fc; i++) {
                current = current.next;
            }
            Element<T> wF = current.data;

            for (int j = 0; j < fc; j++) {
                current.data = current.prev.data;
                current = current.prev;
            }
            current = this.begin.next;
            current.data = wF;
        }


        Node sort = begin.next;
        Element<T> w = sort.data;

        int i = 0;
        while (i < size && sort.next.data != null && w.getFrequency() < sort.next.data.getFrequency()) {
            sort.data = sort.next.data;
            sort = sort.next;
            i++;
        }
        sort.data = w;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public void clear() {
        this.begin = new Node (null,null, null);
        Node end = new Node(null, begin, null);
        this.begin.setNext(end);
        this.size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(T w, int f) {

        if (this.isEmpty()) {
            Node firstNode = new Node ((T) new Element<>(w, f), this.begin.next, this.begin);
            firstNode.next.prev = firstNode;
            this.begin.next = firstNode;
            this.size++;
            return;
        }

        Node current = this.begin.next;
        for (int i = 1; i <= size; i++) {
            if (current.data != null && current.data.getElement().equals(w)) {
                current.data.addFrequency(f);
                moveToLeft(i);
                return;
            } else {
                current = current.next;
            }
        }

        Node nextNode = new Node ((T) new Element<>(w, f), this.begin.next, this.begin);
        nextNode.next.prev = nextNode;
        this.begin.next = nextNode;
        this.size++;
        moveToLeft(0);
    }

    @Override
    public Element<T> get(int pos) {
        Node current = this.begin.next;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int get(T w) {
        Node current = this.begin.next;
        for (int i = 0; i < size; i++) {
            if (w.equals(current.data.getElement())) {
                return current.data.getFrequency();
            } else {
                current = current.next;
            }
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    private class Node {
        Node next;
        Node prev;
        Element<T> data;

        public Node(T data, Node n, Node p) {
            this.data = (Element<T>) data;
            this.next = n;
            this.prev = p;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("{");
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != null) {
                s.append(this.get(i)).append(", ");
            }
        }
        s.append ("}");
        s.append(" size = ").append(this.size());


        return s.toString();
    }

    public Iterator<Element<T>> iterator() {
            return new LinkedListFrequencyTableIterator();
    }
    public class LinkedListFrequencyTableIterator implements Iterator<Element<T>> {
        private Node current = begin.next;
        private int i = 0;


        public boolean hasNext() {
            return i < size;
        }

        public Element<T> next() {
            T w = current.data.getElement();
            int f = current.data.getFrequency();
            current = current.next;
            i++;

            return new Element<>(w, f);

        }
    }
}