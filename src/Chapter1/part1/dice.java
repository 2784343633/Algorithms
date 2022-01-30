package Chapter1.part1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class dice{
    static int SIDES = 6;
    static double[] dist = new double[2*SIDES+1];
    static {
        for(int i=1; i <= SIDES; i ++){
            for(int j =1; j <= SIDES; j++){
                dist[i+j] += 1.0;
            }
        }
        for(int k = 2; k <= 2*SIDES; k ++)
            dist[k] /= 36.0;
    }

    public static int getIndex(){
        return StdRandom.uniform(1,SIDES + 1);
    }
    public static int timesSum(int times){
        int total = 0;
        for(int i=0; i < times; i ++){
            total += getIndex();
        }
        return total;
    }

    public static void demo(int times){
        double[] result = new double[2*SIDES + 1];
        for(int i=1; i <= times; i ++){
            int index = timesSum(2);
            result[index] += 1;
        }
        for(int k=2; k <= 2*SIDES; k ++){
            result[k] /= times;
            StdOut.printf("[%d]--%.3f\t", k, result[k]);
        }
        StdOut.printf("\n");
        for(int k=2; k <= 2*SIDES; k ++){
            StdOut.printf("[%d]--%.3f\t", k, dist[k]);
        }
    }

    public static void main(String[] args){
        dice.demo(1000000);
    }
}
