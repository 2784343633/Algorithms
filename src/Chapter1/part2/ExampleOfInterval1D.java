package Chapter1.part2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class ExampleOfInterval1D {
    public static void main(String[] args){
        int N = 4;
        Interval1D t;
        List<Interval1D> i = new ArrayList<>(N);
        for(int j=0; j<N; j++){
            t = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
            i.add(t);
        }
        for(int k=0; k<N-1; k ++){
            Interval1D t1 = i.get(k);
            for(int n=k+1; n<N; n++){
                Interval1D t2 = i.get(n);
                if(t1.intersects(t2)){
                    StdOut.printf("%s,%s相交\n", t1.toString(), t2.toString());
                }
            }
        }
    }
}
