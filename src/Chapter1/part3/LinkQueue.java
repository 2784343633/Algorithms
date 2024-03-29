package Chapter1.part3;

import edu.princeton.cs.algs4.StdOut;
import java.io.File;

public class LinkQueue<Item>{
    private Node Last;
    private class Node{
        Item item;
        Node next;
    }
    public LinkQueue(){
        Last = new Node();
        Last.item = null;
        Last.next = Last;
    }
    public LinkQueue(LinkQueue<Item> queue){
        Last = new Node();
        Last.item = null;
        Last.next = Last;

        Item flag = queue.pop();
        queue.push(flag);
        this.push(flag);
        while(queue.Last.next.item != flag){
            Item item = queue.pop();
            queue.push(item);
            this.push(item);
        }
    }
    public boolean isEmpty(){
        return Last.item == null;
    }
    public void push(Item item){
        if(this.isEmpty()){
            Last.item = item;
        }
        else {
            Node temp = new Node();
            temp.item = item;
            temp.next = Last.next;
            Last.next = temp;
            Last = temp;
        }
    }
    public Item pop(){
        Item temp = Last.next.item;
        Last.next.item = null;
        Last.next = Last.next.next;
        return temp;
    }

    public static void main(String[] args){
        LinkQueue<Integer> queue = new LinkQueue<>();
        for(int i=0; i < 5; i ++){
            queue.push(i);
        }
        LinkQueue<Integer> copy = new LinkQueue<>(queue);
        while(!copy.isEmpty()){
            StdOut.println(copy.pop());
        }
    }

}
class FileList {
    static LinkQueue<File> FileQueue;
    static int tabTime = 0;
    public static void Solution(){
        if(!FileQueue.isEmpty()){
            File file = FileQueue.pop();
            if(file != null){
                if(file.isDirectory()){
                    printDir(file);
                    tabTime ++;
                    File[] fs = file.listFiles();
                    if(fs != null){
                        for(File f: fs){
                            FileQueue.push(f);
                            Solution();
                        }
                    }else{
                        ;
                    }
                    tabTime --;
                }else{
                    printFile(file);
                }
            }else{
                ;
            }
        }else{
            ;
        }
    }
    public static void printFile(File file){
        for(int i=0; i<tabTime; i ++){
            StdOut.printf("\t");
        }
        StdOut.printf("|__ %s\n", file.getName());
    }
    public static void printDir(File file){
        for(int i=0; i<tabTime; i ++){
            StdOut.printf("\t");
        }
        StdOut.printf("%s:\n", file.getName());
    }
    public static void main(String[] args){
        FileQueue = new LinkQueue<>();
        File orin = new File("");
        FileQueue.push(orin);
        Solution();
    }
}