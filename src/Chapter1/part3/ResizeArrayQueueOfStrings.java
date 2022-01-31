package Chapter1.part3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizeArrayQueueOfStrings {
    private String[] a;
    int head;
    int rear;
    public ResizeArrayQueueOfStrings(int cap){
        a = new String[cap];
        head = -1;
        rear = -1;
    }
    public void push(String s){
        if(this.full()){
            String[] temp = new String[a.length*2];
            int index = 0;
            for(int i=head; i<=rear; i ++){
                temp[index++] = a[i];
            }
            a = temp;
            head = 0;
            rear = index - 1;
        }
        a[++rear] = s;
        if(head == -1){
            head ++;
        }
    }
    public String pop(){
        if(this.size() == a.length/4){
            String[] temp = new String[a.length/2];
            int index = 0;
            for(int i=head; i<=rear; i ++){
                temp[index++] = a[i];
            }
            a = temp;
            head = 0;
            rear = index - 1;
        }
        String s = a[head++];
        a[head-1] = null;
        return s;
    }
    public boolean isEmpty(){
        return head > rear;
    }
    public boolean full(){
        return rear == a.length-1;
    }
    public int size(){
        return rear - head + 1;
    }
    public static void demo(int k){
        ResizeArrayQueueOfStrings queue = new ResizeArrayQueueOfStrings(3);
        int cnt = 0;
        while(!StdIn.isEmpty()){
            queue.push(StdIn.readString());
            cnt++;
            if(StdIn.readChar() == '\n'){
                break;
            }
        }
        for(int i=0; i < cnt-k; i ++){
            queue.pop();
        }
        StdOut.printf("The %dth String from the bottom of input is %s\n", k, queue.pop());
    }
    public static void main(String[] args){
       ResizeArrayQueueOfStrings.demo(3);
    }
}
