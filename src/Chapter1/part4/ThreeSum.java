package Chapter1.part4;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.io.*;
public class ThreeSum {
    static int cnt = 0;
    static File file = new File("C:\\Users\\admin\\Desktop\\test.txt");
    public static void createRandomInts(int times) throws IOException {
        FileWriter fw = new FileWriter(file);
        for(int i=0; i<times; i ++){
            String str = StdRandom.uniform(-1000, 1000) + "\n";
            fw.write(str);
        }
        fw.flush();
        fw.close();
    }
    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        for(int i=0; i < N; i ++){
            for(int j=i+1; j<N; j ++){
                if(BinarySearch.indexOf(a, -a[i]-a[j]) > j){
                    cnt ++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        createRandomInts(100);
        int[] a = In.readInts("C:\\Users\\admin\\Desktop\\test.txt");
        StdOut.println(count(a));
    }
}
