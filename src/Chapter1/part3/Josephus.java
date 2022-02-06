package Chapter1.part3;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args){
        LinkQueue<Integer> queue = new LinkQueue<>();
        for(int i=0; i < 7; i ++){
            queue.push(i);
        }
        int cnt = 1;
        while(!queue.isEmpty()){
            if(cnt != 2){
                queue.push(queue.pop());
                cnt ++;
            }
            else{
                StdOut.print(queue.pop());
                StdOut.print(" ");
                cnt = 1;
            }
        }
    }
}
