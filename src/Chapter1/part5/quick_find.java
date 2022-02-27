package Chapter1.part5;

import java.util.Scanner;

public class quick_find {
    private int[] Ids;
    private int timer;
    private int cnt;
    public void construct(int len){
        this.Ids = new int[len];
        for(int i = 0; i< Ids.length; i ++){
            Ids[i] = i;
        }
        this.cnt = len;
        this.timer = 0;
    }
    public int find(int pos){
        return Ids[pos];
    }
    public void union(int x, int y){
        int xId = find(x);
        int yId = find(y);
        this.timer += 2;
        if(xId == yId) return ;
        for(int i=0; i<Ids.length;i ++){
            if(Ids[i] == xId)
            {
                Ids[i] = yId;
                timer ++;
            }
            timer ++;
        }
        this.cnt --;
    }
    public static void main(String[] args){
        quick_find qf = new quick_find();
        qf.construct(10);
        int first;
        Scanner scan = new Scanner(System.in);
        first = scan.nextInt();
        while(first!=-1){
            int second = scan.nextInt();
            int old_timer = qf.timer;
            qf.union(first, second);
            for(int i =0; i < qf.Ids.length; i ++){
                System.out.print(qf.find(i));
                if(i != qf.Ids.length-1){
                    System.out.print(",");
                }else{
                    System.out.println();
                }
            }
            System.out.printf("timer add: %d\n", qf.timer - old_timer);
            first = scan.nextInt();
        }
        System.out.printf("cnt: %d, timer: %d\n", qf.cnt, qf.timer);
    }
}
