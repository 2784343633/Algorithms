package Chapter1.part2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class ExampleOfPoint2D {
    
    public static void main(String[] args){
        int N = 100;
        Point2D p;
        List<Point2D> points = new ArrayList<>(N);
        for(int i=0; i<N; i ++){
            p = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            points.add(p);
        }
        points.sort(points.get(0).distanceToOrder());
        points.get(0).draw();
        StdOut.print(points.get(0).toString());
        points.get(1).draw();
        StdOut.print(points.get(1).toString());
    }
}
