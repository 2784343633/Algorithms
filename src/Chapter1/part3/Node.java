package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

public class Node<Item> {
    Item item;
    Node<Item> next = null;
    Node<Item> prior = null;
    public Node(Item item){
        this.item = item;
    }
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
        DoubleNode dn = new DoubleNode();
        dn.head = new Node<>(0);
        for(int i=4; i >= 0; i --){
            DoubleNode.insertBehind(dn.head, new Node<>(i));
        }
        Node p = dn.head;
        while(p!=null){
            StdOut.println(p.item);
            p = p.next;
        }
    }
}

class DoubleNode{
    Node head = null;
    public static void insertBefore(Node orin, Node ins){
        ins.next = orin;
        ins.prior = orin.prior;
        orin.prior = ins;
    }
    public static void insertBehind(Node orin, Node ins) {
        ins.next = orin.next;
        ins.prior = orin;
        orin.next = ins;
    }
}
