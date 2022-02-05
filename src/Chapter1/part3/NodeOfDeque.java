package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class NodeOfDeque<Item> implements Deque<Item>, Iterable<Item>{
    private Node<Item> left;
    private Node<Item> right;
    private int size;
    public NodeOfDeque(){
        left = null;
        right = null;
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        return left == right && left == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void pushLeft(Item item) {
        Node<Item> node = new Node<>(item);
        if(this.isEmpty()){
            left = node;
            right = node;
        }
        else{
            node.next = left;
            left.prior = node;
            left = node;
        }
        this.size ++;
    }

    @Override
    public void pushRight(Item item) {
        Node<Item> node = new Node<>(item);
        if(this.isEmpty()){
            left = node;
            right = node;
        }
        else{
            right.next = node;
            node.prior = right;
            right = node;
        }
        this.size ++;
    }

    @Override
    public Item popLeft() {
        Item item = left.item;
        Node<Item> node = left.next;
        if(node != null){
            node.prior = null;
        }
        left.next = null;
        left = node;
        if(left == null){
            right = null;
        }
        this.size --;
        return item;
    }

    @Override
    public Item popRight() {
        Item item = right.item;
        Node<Item> node = right.prior;
        if(node != null){
            node.next = null;
        }
        right.prior = null;
        right = node;
        if(right == null){
            left = null;
        }
        this.size --;
        return item;
    }
    public static void main(String[] args){
        NodeOfDeque<Integer> deque = new NodeOfDeque<>();
        for(int i=0; i<10;i ++){
            if(i%2 == 0){
                deque.pushRight(i);
            }
            else{
                deque.pushLeft(i);
            }
        }
        for(Integer i:deque){
            StdOut.println(i);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item>{
        private Node<Item> current = left;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
