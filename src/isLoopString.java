import edu.princeton.cs.algs4.StdOut;

public class isLoopString {
    public static void main(String[] args){
        String s1 = args[0];
        String s2 = args[1];
        int index = s1.indexOf(s2.charAt(0));
        if(s1.length() == s2.length() && s2.equals(s1.substring(index).concat(s1.substring(0, index)))){
            StdOut.printf("yes");
        }
        else{
            StdOut.printf("no");
        }
    }
    public static String mystery(String s){
        int N = s.length();
        if(N <= 1){
            return s;
        }else{
            String a = s.substring(0, N/2);
            String b = s.substring(N/2, N);
            return mystery(b) + mystery(a);
        }
    }
}
