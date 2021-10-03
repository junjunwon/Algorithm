package array;

import java.util.ArrayList;

public class MyQuickSort {
    /**
     * 시간복잡도 평균적으론 O(n*logn) 
     */
    static ArrayList<Integer> result = new ArrayList<>();
    private ArrayList<Integer> split(ArrayList<Integer> dataList) {
        
        //1개이거나 0개일 경우 dataList return
        if(dataList.size()<=1){
            return dataList;
        }

        //피봇의 위치를 정한다.
        int pivot = 0;
        
        //해당 피봇의 값보다 작은 값은 왼쪽, 큰 값은 오른쪽 배열에 넣는다. 
        //그를 위한 배열 선언이 필요
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for(int i = pivot+1; i<dataList.size(); i++){
            if(dataList.get(pivot)>dataList.get(i)){
                leftArr.add(dataList.get(i));
            } else{
                rightArr.add(dataList.get(i));
            }
        }
        
        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(this.split(leftArr));
        mergedList.add(dataList.get(pivot));
        mergedList.addAll(this.split(rightArr));
        // System.out.println(leftArr.toString());
        // System.out.println(dataList.get(pivot));
        // System.out.println(rightArr.toString());
        // System.out.println(mergedList.toString());

        return mergedList;
        
    }

    public static void main(String[]args){
        MyQuickSort qSort = new MyQuickSort();
        ArrayList<Integer> dataList = new ArrayList<>();

        for(int i=0; i<10; i++){
            dataList.add((int)(Math.random()*100));
        }
        
        ArrayList<Integer> result = qSort.split(dataList);
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }

    
}
