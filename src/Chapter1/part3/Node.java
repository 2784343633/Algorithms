package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

public class Node<Item> {
    Item item;
    Node<Item> next = null;
    public Node<Item> reverse(Node<Item> head){
        Node<Item> first = head;
        Node<Item> reverse = null;
        while(first != null){
            Node<Item> second = first.next;
            first.next =  reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }
    public static void main(String[] args){
        Node<Integer> head = new Node<>();
        Node<Integer> p = head;
        head.item = 0;
        for(int i=1; i<5; i++){
            Node<Integer> node = new Node<>();
            node.item = i;
            p.next = node;
            p = node;
        }
        head = head.reverse(head);
        Node<Integer> current = head;
        while(current != null){
            StdOut.println(current.item);
            current = current.next;
        }
    }
}
