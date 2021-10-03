package array;

import java.util.ArrayList;

public class MyMergeSort {
    

    public ArrayList<Integer> splitMerge(ArrayList<Integer> dataList){

        if(dataList.size()<=1){
            return dataList;
        }
        //왼쪾 오른쪽 함수로 나누고
        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        //반을 나눠주는 index를 찾는다.
        int medium = dataList.size()/2;

        //이걸 반복하는 재귀함수를 추가한다. 재귀함수 안에는 왼쪽/오른쪽으로 분할된 dataList들을 넣어준다.
        leftArr = splitMerge(new ArrayList<Integer>(dataList.subList(0, medium)));
        rightArr = splitMerge(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        //반복적으로 dataList가 전부 잘린다음 잘린 데이터끼리 단계별로 합쳐서 return해준다.
        return mergeFunc(leftArr, rightArr);
    }

    private ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        
        //합칠 arraylist, 왼쪽 포인트, 오른쪽 포인트 선언 및 초기화
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        //왼쪽 오른쪽 배열에 값이 남아 있을떄
        while(leftPoint<leftArr.size() && rightPoint<rightArr.size()){
            if(leftArr.get(leftPoint)<=rightArr.get(rightPoint)){
                mergedList.add(leftArr.get(leftPoint));
                leftPoint++;
            }else{
                mergedList.add(rightArr.get(rightPoint));
                rightPoint++;
            }
        }

        //왼쪽 배열의 값을 모두 mergedList에 넣었을때
        while(rightPoint<rightArr.size()){
            mergedList.add(rightArr.get(rightPoint));
            rightPoint++;
        }


        //오른쪽 배열의 값을 모두 mergedList에 넣었을때
        while(leftPoint<leftArr.size()){
            mergedList.add(leftArr.get(leftPoint));
            leftPoint++;
        }
        
        return mergedList;
    }

    public static void main(String[]args){
        MyMergeSort mSort = new MyMergeSort();
        
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i=0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }
        ArrayList<Integer> result=mSort.splitMerge(dataList);
        System.out.println(result.toString());
        
    }





    private void split(Integer[] dataList) {
        //내가 split하는 법을 생각나는대로 해본건데, 결과적으론 최악의 로직이였다는 것..!
        Integer[] left = new Integer[dataList.length/2];
        Integer[] right = new Integer[dataList.length/2];
        for(int i=0; i<dataList.length; i++){
            if(dataList.length%2==0){ //6일때 
                
                if(i<(dataList.length)/2){ //3보다 작으면
                    left[i]=dataList[i];
                }else{
                    right[i-(dataList.length/2)]=dataList[i];
                }
            }
            else { //7일때
                
                if(i<(dataList.length)/2+1){ //3보다 작으면
                    left[i]=dataList[i];
                }else{
                    right[i]=dataList[i];
                }
            }
        }
        for(int i=0; i<left.length; i++){
            System.out.print(left[i]+" ");
        }
        System.out.println();
        for(int i=0; i<right.length; i++){
            System.out.print(right[i]+" ");
        }
    }
}
