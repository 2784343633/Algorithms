package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizeArrayStack<Item> implements Iterable<Item>{
    private Item[] a;
    private int N;
    public ResizeArrayStack(int cap){
        a = (Item[]) new Object[cap];
        N = 0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void push(Item item){
        if(N == a.length){
            Item[] temp = (Item[]) new Object[2*N];
            for(int i=0; i < N; i ++){
                temp[i] = a[i];
            }
            a = temp;
        }
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if(N == a.length/4){
            Item[] temp = (Item[]) new Object[2*N];
            for(int i=0; i < N; i ++){
                temp[i] = a[i];
            }
            a = temp;
        }
        return item;
    }
    public int size(){
        return a.length;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }
    public class ReverseIterator implements Iterator<Item>{
        private int i;
        public ReverseIterator(){
            i = N;
        }
        public boolean hasNext(){
            return i > 0;
        }
        public Item next(){
            return a[--i];
        }
    }
    public static void main(String[] args){
        ResizeArrayStack<Integer> stack = new ResizeArrayStack<>(1);
        for(int i=0; i < 10; i ++){
            stack.push(i);
        }
        for(Integer i:stack){
            StdOut.println(i);
        }
    }
}