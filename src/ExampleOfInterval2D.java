import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.List;

public class ExampleOfInterval2D {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        double max = Double.parseDouble(args[1]);
        double min = Double.parseDouble(args[2]);
        List<Interval2D> boxes = new ArrayList<>(N);
        Interval2D box;
        Interval2D box1;
        Interval1D xInterval;
        Interval1D yInterval;
        double i1;
        double i2;
        for(int i=0; i<N; i++){
            i1 = StdRandom.uniform(min, max);
            i2 = StdRandom.uniform(i1, max);
            xInterval = new Interval1D(i1, i2);
            i1 = StdRandom.uniform(min, max);
            i2 = StdRandom.uniform(i1, max);
            yInterval = new Interval1D(i1, i2);
            box = new Interval2D(xInterval, yInterval);
            box.draw();
            boxes.add(box);
        }

        Counter ic = new Counter("intersects");
        for(int i=0; i<N-1; i++){
            box = boxes.get(i);
            for(int j=i+1; j<N; j++){
                box1 = boxes.get(j);
                if(box.intersects(box1)){
                    ic.increment();
                }
            }
        }
        StdOut.print(ic.toString());
    }
}
