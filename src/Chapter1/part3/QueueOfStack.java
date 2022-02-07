package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;

public class QueueOfStack<Item> {
    private LinkStack<Item> one;
    private LinkStack<Item> two;
    private int flag = 1;
    public QueueOfStack(){
        one = new LinkStack<>();
        two = new LinkStack<>();
    }
    public void push(Item item){
        if(flag == 1){
            one.push(item);
        }
        else if(flag == 2)
        {
            while(!two.isEmpty()){
                one.push(two.pop());
            }
            flag = 1;
            one.push(item);
        }
    }
    public Item pop(){
        if(flag == 1){
            while(!one.isEmpty()){
                two.push(one.pop());
            }
            flag = 2;
            return two.pop();
        }
        else{
           return two.pop();
        }
    }
    public static void main(String[] args){
        QueueOfStack<Integer> queue = new QueueOfStack<>();
        for(int i=1; i<=8; i++){
            if(i % 4 == 0){
                StdOut.println(queue.pop());
            }else{
                queue.push(i);
            }
        }
    }
}
