package array;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public void splitFunc(ArrayList<Integer> dataList){
        //기본을 이해하기 위한 split function;
        if(dataList.size()<=1){
            return;
        }
        int medium = dataList.size()/2; //짝수, 홀수 구분

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = new ArrayList<Integer>(dataList.subList(0, medium)); //0부터 medium -1 인덱스 번호까지 해당 배열 아이템을 서브 배열 아이템으로 추출
        rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size())); //자동으로 size()-1을 해주는거 같은데?

        System.out.println(leftArr);
        System.out.println(rightArr);
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
        //기본을 이해하기 위한 split function;
        if(dataList.size()<=1){
            return dataList;
        }
        int medium = dataList.size()/2; //짝수, 홀수 구분

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium))); //0부터 medium -1 인덱스 번호까지 해당 배열 아이템을 서브 배열 아이템으로 추출
        rightArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size()))); //자동으로 size()-1을 해주는거 같은데?

        // mergeSplitFunc(leftArr);
        // mergeSplitFunc(rightArr);
        
        
        return mergeFunc(leftArr, rightArr);
    }

    private ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        //Case1 left/right 둘 다 있을때
        while(leftPoint<leftArr.size() && rightPoint<rightArr.size()){
            if(leftArr.get(leftPoint)<=rightArr.get(rightPoint)){
                mergedList.add(leftArr.get(leftPoint));
                leftPoint++;
            } else {
                mergedList.add(rightArr.get(rightPoint));
                rightPoint++;
            }
        }
        //Case2 : right 데이터가 없을때
        while(leftPoint<leftArr.size()){
         mergedList.add(leftArr.get(leftPoint));
         leftPoint++;
        }
        //Case2 : left 데이터가 없을때
        while(rightPoint<rightArr.size()){
            mergedList.add(rightArr.get(rightPoint));
            rightPoint++;
        }
        return mergedList;
    }

    public static void main(String[]args){
        MergeSort mSort = new MergeSort();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i=0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }
        // mSort.mergeSplitFunc(new ArrayList<Integer>(Arrays.asList(4,1,2,3,5)));
        ArrayList<Integer> result = mSort.mergeSplitFunc(dataList);
        System.out.println(result.toString());
    }
}


