package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class queueBasic0905 {

    static Queue<Integer> queue_int = new LinkedList<>(); 
    static Queue<String> queue_str = new LinkedList<>(); 
    
    static CustomQueue<Integer> CQ = new CustomQueue<>();

    public static void main(String[]args){
        CQ.add(1);
        CQ.add(2);
    
        System.out.println(CQ.remove());
        System.out.println(CQ.remove());
    }

}