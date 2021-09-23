package heap;

import java.util.ArrayList;
import java.util.Collections;

public class MyHeap {
    
    ArrayList<Integer> heapArray = null;

    public MyHeap(Integer data){
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
        Integer returnedData, poppedIdx , leftChildNodeIdx, rightChildNodeIdx;

        if(this.heapArray == null){
           return null; 
        } else{
            returnedData = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
            this.heapArray.remove(this.heapArray.size()-1);
            poppedIdx = 1;

            while(moveDown(poppedIdx)){
                leftChildNodeIdx = poppedIdx *2;
                rightChildNodeIdx = poppedIdx *2 +1;
                //오른쪽 자식만 없을때
                if(rightChildNodeIdx >= this.heapArray.size()){
                    Collections.swap(this.heapArray, poppedIdx, leftChildNodeIdx);
                    poppedIdx = leftChildNodeIdx;
                }
                //오른쪽 왼쪽 자식이 둘 다 있을때
                else {
                    if(this.heapArray.get(leftChildNodeIdx) > this.heapArray.get(rightChildNodeIdx)){
                        Collections.swap(this.heapArray, poppedIdx, leftChildNodeIdx);
                        poppedIdx = leftChildNodeIdx;
                    } else if(this.heapArray.get(leftChildNodeIdx) < this.heapArray.get(rightChildNodeIdx)){
                        Collections.swap(this.heapArray, poppedIdx, rightChildNodeIdx);
                        poppedIdx = rightChildNodeIdx;
                    }
                }
            }


            return returnedData;
        }
    }
    public boolean moveDown(int poppedIdx){
        Integer leftChildNodeIdx, rightChildNodeIdx;
        leftChildNodeIdx = poppedIdx *2;
        rightChildNodeIdx = poppedIdx *2+1;

        //왼쪽이 없을 경우 (왼쪽이 없으면 오른쪽 child도 없다.)
        if(leftChildNodeIdx >= this.heapArray.size()){
            return false;
        }
        //오른쪽 노드만 없을때
        else if(rightChildNodeIdx >= this.heapArray.size()){
            if(this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildNodeIdx)){
                return true;
            } else{
                return false;
            }
        }
        else{
            //왼쪽 오른쪽 다 있을때
            if(this.heapArray.get(leftChildNodeIdx) > this.heapArray.get(rightChildNodeIdx)){
                if(this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildNodeIdx)){
                    return true;
                } else{
                    return false;
                }
            } 
            else{
                if(this.heapArray.get(poppedIdx) < this.heapArray.get(rightChildNodeIdx)){
                    return true;
                } else{
                    return false;
                }
            } 
        }
    }
    public static void main(String[] args){
        MyHeap heaptest = new MyHeap(15);
        heaptest.insertData(10);
        heaptest.insertData(8);
        heaptest.insertData(5);
        heaptest.insertData(4);
        heaptest.insertData(20);
        heaptest.pop();
        System.out.println(heaptest.heapArray);
    }
}
