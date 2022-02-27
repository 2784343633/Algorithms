import edu.princeton.cs.algs4.StdOut;

public class demo{
    public static void main(String[] args){
        String orin = new String("Hello Java!");
        String sub = orin.substring(0, 5);
        StdOut.printf("%s\n%s\n", orin, sub);
    }
}