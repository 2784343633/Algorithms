import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedStackOfString {
    private String[] a;
    private int N = 0;
    public FixedStackOfString(int cap){
        this.a = new String[cap];
    }
    private void push(String item){
        this.a[N++] = item;
    }
    private String pop(){
        return this.a[--N];
    }
    private int size(){
        return this.N;
    }
    private boolean isEmpty(){
        return this.N==0;
    }
    public static void main(String[] args){
        FixedStackOfString s = new FixedStackOfString(100);
        s.push("world!");
        s.push("Hello ");

        while(!s.isEmpty()){
            StdOut.print(s.pop());
        }
    }
}
