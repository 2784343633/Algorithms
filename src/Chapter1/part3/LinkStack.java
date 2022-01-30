package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkStack<Item> implements Iterable<Item>{
    private Node First;
    private int N;
    @Override
    public Iterator<Item> iterator() {
        return new LinkStackIterator();
    }
    private class LinkStackIterator implements Iterator<Item>{
        private Node current = First;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    private class Node {
        Item item;
        Node next;
        public Node(Item item){
            this.item = item;
        }
    }
    public boolean isEmpty(){
        return First == null;
    }
    public void push(Item item){
        Node oldFirst = First;
        First = new Node(item);
        First.next = oldFirst;
        N ++;
    }
    public Item pop(){
        Item item = First.item;
        First = First.next;
        N--;
        return item;
    }
    public Item peek(){
        return First.item;
    }
    public int size(){
        return N;
    }
    public boolean Parentheses(String s, LinkStack<Character> charStack){
        for(int i=0; i < s.length(); i ++){
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                charStack.push(c);
            } else {
                if (c == ')' && charStack.peek() == '(') {
                    charStack.pop();
                }
                else if(c == ']' && charStack.peek() == '['){
                    charStack.pop();
                }
                else if(c == '}' && charStack.peek() == '{'){
                    charStack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
    public static String FixExpression(String exp){
        LinkStack<String> unit = new LinkStack<>();
        LinkStack<Character> index = new LinkStack<>();
        LinkStack<Character> operator = new LinkStack<>();
        for(int i=0; i < exp.length(); i ++){
            char temp = exp.charAt(i);
            if(temp >= '0' && temp <= '9'){
                index.push(temp);
            }
            else if(temp == '+' || temp == '-' || temp == '*' || temp == '/'){
                operator.push(temp);
            }
            else if(temp == ')'){
                StringBuilder s = new StringBuilder();
                s.append('(');
                if(!index.isEmpty()){
                    s.append(index.pop());
                }
                else
                {
                    s.append(unit.pop());
                }
                s.insert(1, operator.pop());
                if(!index.isEmpty()){
                    s.insert(1, index.pop());
                }
                else
                {
                    s.insert(1, unit.pop());
                }
                s.append(')');
                unit.push(s.toString());
            }
        }
        return unit.pop();
    }
    public  static LinkStack<String> copy(LinkStack<String> orin){
        Iterator<String> iterator = orin.iterator();
        LinkStack<String> temp = new LinkStack<>();
        while(iterator.hasNext()){
            temp.push(iterator.next());
        }
        iterator = temp.iterator();
        while(!temp.isEmpty()){
            temp.pop();
        }
        while(iterator.hasNext()){
            temp.push(iterator.next());
        }
        return temp;
    }
    public static void main(String[] args){
        LinkStack<String> orin = new LinkStack<>();
        for(int i=0; i < 5; i ++){
            orin.push(String.valueOf(i));
        }
        for(String s: orin){
            StdOut.println(s);
        }
        LinkStack<String> another = LinkStack.copy(orin);
        for(String s: another){
            StdOut.println(s);
        }
       }
}
