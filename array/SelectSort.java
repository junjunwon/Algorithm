package array;

import java.util.ArrayList;
import java.util.Collections;

public class SelectSort {
    /**
     * 알고리즘 분석
     * 시간복잡도 : 반복문이 두 개로 O(n의 제곱)
     * 상세한 시간복잡도 계산법 : n(n-1)/2 
     * @param dataList
     * @return
     */
    //3개일 경우
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
     
        for(int index = 0; index<dataList.size()-1; index++){
            int lowest = index;
            for(int index2 = index+1; index2<dataList.size(); index2++){
                //찾은 데이터가 있으면 index 위치에 삽입한다.
                if(dataList.get(lowest) > dataList.get(index2)){
                    lowest = index2;
                }
            }
            
            Collections.swap(dataList, lowest, index); 
        }
        return dataList;
    }

    public static void main(String[]args){
        SelectSort sort = new SelectSort();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i = 0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }

        // -> 9,2, 7 -> 2, 7, 9

        ArrayList<Integer> result = sort.sort(dataList);
        for(int i =0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
