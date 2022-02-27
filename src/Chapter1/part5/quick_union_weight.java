package Chapter1.part5;

import java.util.Scanner;

public class quick_union_weight {
    private int[] Ids;
    private int[] sz;
    private int cnt;
    private int timer;
    public void construct(int len){
        Ids = new int[len];
        sz = new int[len];
        for(int i=0; i<len; i ++){
            Ids[i] = i;
            sz[i] = 1;
        }
        cnt = len;
        timer = 0;
    }
    public int find(int pos){
        timer ++;
        while(pos != Ids[pos]) {
            pos = Ids[pos];
            timer ++;
        }
        return pos;
    }
    public void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if(yRoot == xRoot) return ;
        if(sz[xRoot] <= sz[yRoot]){
            Ids[xRoot] = yRoot;
            sz[yRoot] += sz[xRoot];
        }else{
            Ids[yRoot] = xRoot;
            sz[xRoot] += sz[yRoot];
        }
        cnt --;
    }
    public static void main(String[] args){
        quick_union_weight quw = new quick_union_weight();
        quw.construct(10);
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        while(first != -1){
            int second = scan.nextInt();
            int old_timer = quw.timer;
            quw.union(first, second);
            for(int i=0; i< quw.Ids.length; i ++){
                System.out.print(quw.Ids[i]);
                if(i!=quw.Ids.length-1){
                    System.out.print(",");
                }else{
                    System.out.println();
                }
            }
            for(int i=0; i< quw.sz.length; i ++){
                System.out.print(quw.sz[i]);
                if(i!=quw.sz.length-1){
                    System.out.print(",");
                }else{
                    System.out.println();
                }
            }
            System.out.printf("timer add: %d\n", quw.timer-old_timer);
            first = scan.nextInt();
        }
        System.out.printf("cnt: %d, timer: %d\n", quw.cnt, quw.timer);
    }

}
