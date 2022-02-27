package Chapter1.part5;

import java.util.Scanner;

public class quick_union {
    private int[] Ids;
    private int cnt;
    private int timer;

    public void construct(int len){
        this.Ids = new int[len];
        cnt = len;
        for(int i=0; i<Ids.length; i ++){
            Ids[i] = i;
        }
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

    public boolean connected(int x, int y){
        int xId = find(x);
        int yId = find(y);
        return xId == yId;
    }
    public void union(int x, int y){
        int xId = find(x);
        int yId = find(y);
        if(xId == yId) return ;
        Ids[yId] = xId;
        cnt --;
    }
    public static void main(String[] args){
        quick_union qu = new quick_union();
        qu.construct(10);
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        while(first != -1){
            int second = scan.nextInt();
            int old_timer = qu.timer;
            qu.union(first, second);
            System.out.printf("timer add: %d\n", qu.timer-old_timer);
            for(int i=0; i<qu.Ids.length; i ++){
                System.out.print(qu.Ids[i]);
                if(i != qu.Ids.length-1){
                    System.out.print(",");
                }else{
                    System.out.println();
                }
            }
            first = scan.nextInt();
        }
        System.out.printf("cnt: %d, timer: %d\n", qu.cnt, qu.timer);
    }
}
