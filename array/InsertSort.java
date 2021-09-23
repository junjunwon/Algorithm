package array;

import java.util.ArrayList;
import java.util.Collections;

public class InsertSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){

        int swapped;
        for(int index = 1; index<dataList.size(); index++){
            //index부터 0까지 비교
            //본인보다 큰 값이 있으면 계속 -1
            swapped = index;
            for(int index2 = index-1; index2>=0; index2--){
                if(dataList.get(swapped) > dataList.get(index2)){
                    //본인보다 적은 값이 있을 경우 적은값+1 위치에 삽입
                    //뒤에 값들을 +1씩 밀어넣어야하는데 어떻게??
                    break;
                } else {
                    Collections.swap(dataList, swapped, index2);
                    swapped = index2;
                }
            } 
        }
        return dataList;

    }


    public static void main(String[]args){
        InsertSort insertSort = new InsertSort();

        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i = 0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }
        ArrayList<Integer> result = insertSort.sort(dataList);
        
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
    
}
