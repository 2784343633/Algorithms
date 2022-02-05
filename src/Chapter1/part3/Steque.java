package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

public interface Steque<Item>{
    void push(Item item);
    Item pop();
    void enqueue(Item item);
}