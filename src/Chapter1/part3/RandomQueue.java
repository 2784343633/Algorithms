package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> {
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
        while(!queue.isEmpty()){
            StdOut.println(queue.dequeue());
        }
    }
}
