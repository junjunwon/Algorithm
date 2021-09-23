package array;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleArray {
    /**
     * 시간 복잡도 O(n의 제곱)
     * @param dataList
     * @return
     */
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        
        for(int index = 0; index<dataList.size()-1; index++){
            boolean swap = false;
            for(int index2 = 0; index2<dataList.size()-1-index; index2++){
                if(dataList.get(index2)>dataList.get(index2+1)){
                    Collections.swap(dataList, index2, index2+1);
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
        return dataList;
    }

    public static void main(String[]args){
        
        BubbleArray bubble = new BubbleArray();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i = 0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }
        ArrayList<Integer> result = bubble.sort(dataList);
        
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
        
    }
}
