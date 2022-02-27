package Chapter1.part4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
    public static double timerTrial(int N){
        int MAX  = 1000000;
        int[] a = new int[N];
        for(int i=0; i<N; i ++){
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args){
        double x = 0;
        double y = 0;
        StdDraw.setYscale(0, 50);
        StdDraw.setXscale(0, 50000);
        for(int N=250;true; N+=N){
            double time = timerTrial(N);
//            StdDraw.setXscale(250, N*1.5);
//            StdDraw.setYscale(0, time*1.5 + 1);
            if(x == y && x == 0){
                x = N;
                y = time;
                StdDraw.point(N, time);
            }else{
                StdDraw.line(x, y, N, time);
                x = N;
                y = time;
            }
        }
    }
}
