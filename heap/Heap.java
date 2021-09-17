package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    
    ArrayList<Integer> heapArray = null;

    public Heap(Integer data){
        heapArray = new ArrayList<Integer>();
        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insertData(int data){
        Integer insertedIdx, parentIdx;
        if(heapArray == null){
            heapArray = new ArrayList<Integer>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        } 
        this.heapArray.add(data);
        insertedIdx = this.heapArray.size()-1;

        while(this.moveUp(insertedIdx)){
            parentIdx = insertedIdx /2;
            Collections.swap(heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }

    private boolean moveUp(Integer insertedIdx) {
        if(insertedIdx <= 1){
            return false;
        }
        Integer parentIdx = insertedIdx/2;
        if(this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx)){
            return true;
        } else{
            return false;
        }
        
    }
    public Integer pop(){
        if(this.heapArray == null){
           return null; 
        } else{
            return this.heapArray.get(1);
        }
    }

    public static void main(String[] args){
        Heap heaptest = new Heap(15);
        heaptest.insertData(10);
        heaptest.insertData(8);
        heaptest.insertData(5);
        heaptest.insertData(4);
        heaptest.insertData(20);
        System.out.println(heaptest.heapArray);
    }
}
