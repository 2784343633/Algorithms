package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkQueue<Item>{
    private Node Last;
    private class Node{
        Item item;
        Node next;
    }
    public LinkQueue(){
        Last = new Node();
        Last.item = null;
        Last.next = Last;
    }
    public boolean isEmpty(){
        return Last.item == null;
    }
    public void push(Item item){
        if(this.isEmpty()){
            Last.item = item;
        }
        else {
            Node temp = new Node();
            temp.item = item;
            temp.next = Last.next;
            Last.next = temp;
            Last = temp;
        }
    }
    public Item pop(){
        Item temp = Last.next.item;
        Last.next.item = null;
        Last.next = Last.next.next;
        return temp;
    }
    public static void main(String[] args){
        LinkQueue<Integer> queue = new LinkQueue<>();
        for(int i=0; i<5; i ++){
            queue.push(i);
        }
        while(!queue.isEmpty()){
            StdOut.println(queue.pop());
        }
    }

}
