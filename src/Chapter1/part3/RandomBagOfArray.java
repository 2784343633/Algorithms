package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBagOfArray<Item> implements RandomBag<Item>, Iterable<Item>{
    private Item[] items;
    private int N;

    public RandomBagOfArray(){
        items = (Item[]) new Object[5];
        N = 0;
    }
    public RandomBagOfArray(int cap){
        items = (Item[]) new Object[cap];
        N = 0;
    }
    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void add(Item item) {
        if(N == items.length){
            Item[] temp = (Item[]) new Object[items.length * 2];
            for(int i=0; i<N; i ++){
                temp[i] = items[i];
            }
            items = temp;
        }
        items[N++] = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }
    private class RandomBagIterator implements Iterator<Item>{
        private Item[] copy;
        private int n;
        public RandomBagIterator(){
            copy = (Item[]) new Object[N];
            for(int i=0; i < N; i ++){
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
            int randomIndex = StdRandom.uniform(0, n);
            swap(randomIndex, n-1);
            Item item = copy[n-1];
            copy[n-1] = null;
            n --;
            return item;
        }
    }
    public static void main(String[] args){
        RandomBagOfArray<Integer> bag = new RandomBagOfArray<>();
        for(int i=0; i<5; i ++){
            bag.add(i);
        }
        for(Integer i:bag){
            StdOut.println(i);
        }
    }
}
