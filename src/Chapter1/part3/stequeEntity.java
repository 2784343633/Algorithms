package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

public class stequeEntity<Item> implements Steque<Item>{
    private Node<Item> top;
    private Node<Item> bottom;
    public stequeEntity(){
        top = null;
        bottom = null;
    }
    public boolean isEmpty(){
        return top == bottom && top == null;
    }
    @Override
    public void push(Item item) {
        Node<Item> node = new Node<>(item);
        if(this.isEmpty()){
            top = node;
            bottom = node;
        }
        else{
            node.next = top;
            top = node;
        }
    }

    @Override
    public Item pop() {
        Item item = top.item;
        Node<Item> node = top.next;
        top.next = null;
        top = node;
        if(top == null){
            bottom = null;
        }
        return item;
    }

    @Override
    public void enqueue(Item item) {
        Node<Item> node = new Node<>(item);
        if(this.isEmpty()){
            bottom = node;
            top = node;
        }
        else {
            bottom.next = node;
            bottom = node;
        }
    }
    public static void main(String[] args){
        stequeEntity<Integer> stack = new stequeEntity<>();
        for(int i=0; i<5; i ++){
            stack.enqueue(i);
        }
        for(int i=5; i>0; i --){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            StdOut.println(stack.pop());
        }
    }
}