package aufgabe3;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {

    private Node begin;
    private Node end;
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
            Element<T> wF = current.wword;

            for (int j = 0; j < fc; j++) {
                current.wword = current.prev.wword;
                current = current.prev;
            }
            current = this.begin.next;
            current.wword = wF;
        }


        Node sort = begin.next;
        Element<T> w = sort.wword;

        int i = 0;
        while (i < size && sort.next.wword != null && w.getFrequency() < sort.next.wword.getFrequency()) {
            sort.wword = sort.next.wword;
            sort = sort.next;
            i++;
        }
        sort.wword = w;
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
        this.end = new Node(null, begin, null);
        this.begin.setNext(end);
        this.size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(T w, int f) {

        if (this.isEmpty()) {
            Node firstNode = new Node ((T) new Element<T>(w, f), this.begin.next, this.begin);
            firstNode.next.prev = firstNode;
            this.begin.next = firstNode;
            this.size++;
            return;
        }

        Node current = this.begin.next;
        for (int i = 1; i <= size; i++) {
            if (current.wword != null && current.wword.getElement().equals(w)) {
                current.wword.addFrequency(f);
                moveToLeft(i);
                return;
            } else {
                current = current.next;
            }
        }

        Node nextNode = new Node ((T) new Element<T>(w, f), this.begin.next, this.begin);
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
        return current.wword;
    }

    @Override
    public int get(T w) {
        Node current = this.begin.next;
        for (int i = 0; i < size; i++) {
            if (w.equals(current.wword.getElement())) {
                return current.wword.getFrequency();
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
        Element<T> wword;

        public Node(T data, Node n, Node p) {
            this.wword = (Element<T>) data;
            this.next = n;
            this.prev = p;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}