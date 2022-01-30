package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class bag<Item> implements Iterable<Item>{
    private Node first;
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        Node OldFirst = first;
        first = new Node();
        first.item = item;
        first.next = OldFirst;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args){
        bag<Integer> b = new bag<>();
        for(int i=0; i < 5; i ++){
            b.add(i);
        }
        Iterator<Integer> iterator = b.iterator();
        while(iterator.hasNext()){
            StdOut.println(iterator.next());
        }
    }
}
