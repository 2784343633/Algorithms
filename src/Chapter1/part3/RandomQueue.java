package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item>{
    private Item[] items;
    private int N;
    public RandomQueue(){
        items = (Item[]) new Object[5];
        N = 0;
    }
    public RandomQueue(int cap){
        items = (Item[]) new Object[cap];
        N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public void enqueue(Item item){
        if(N == items.length){
            Item[] temp = (Item[]) new Object[N*2];
            for(int i=0; i<N; i ++){
                temp[i] = items[i];
            }
            items = temp;
        }
        items[N++] = item;
    }
    public void swap(int x, int y){
        Item temp = items[x];
        items[x] = items[y];
        items[y] = temp;
    }
    public Item dequeue(){
        int index = StdRandom.uniform(0, N);
        swap(index, N-1);
        Item item = items[N-1];
        items[N-1] = null;
        N--;
        if(N == items.length/4){
            Item[] temp = (Item[])new Object[N*2];
            for(int i=0; i<N; i ++){
                temp[i] = items[i];
            }
            items = temp;
        }
        return item;
    }
    public Item sample(){
        int index = StdRandom.uniform(0, N);
        return items[index];
    }

    public static void main(String[] args){
        RandomQueue<Integer> queue = new RandomQueue<>();
        for(int i=0; i<10; i ++){
            queue.enqueue(i);
        }
        for(Integer i: queue){
            StdOut.println(i);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }
    private class RandomQueueIterator implements Iterator<Item>{
        private Item[] copy;
        private int n;
        public RandomQueueIterator(){
            copy = (Item[]) new Object[N];
            for(int i=0; i<N; i ++){
                copy[i] = items[i];
            }
            n = N;
        }
        public void swap(int x, int y){
            Item temp = copy[x];
            copy[x] = copy[y];
            copy[y] = temp;
    }
        @Override
        public boolean hasNext() {
            return n != 0;
        }

        @Override
        public Item next() {
            int index = StdRandom.uniform(0, n);
            swap(index, n-1);
            Item item = copy[n-1];
            copy[n-1] = null;
            n --;
            return item;
        }
    }
}
