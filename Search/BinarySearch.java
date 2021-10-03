package Search;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    

    public boolean search(ArrayList<Integer> dataList, int sData){
        //전체 데이터의 가운데를 찾는다.

        if(dataList.size()==1 && dataList.get(0)==sData){
            return true;
        }
        if(dataList.size()==1 && dataList.get(0)!=sData){
            return false;
        }
        if(dataList.size()==0){
            return false;
        }
        int medium = dataList.size()/2; //인덱스 위치
        int mData = dataList.get(medium);//인덱스 위치의 데이터
        //가운데보다 큰지 작은지 확인하고 해당 부분 배열을 부분배열로 저장한다.
        ArrayList<Integer> subList;


        if(mData == sData){
            return true;
        }

        //예외처리 다 뒤져도 데이터가 없을때
        if(dataList.size()==1 && mData != sData){
            return false;
        }
        if(dataList.size()==0){
            return false;
        }

        if(sData > mData){
            //가운데보다 오른쪽에 있음.
            subList = new ArrayList<Integer>(dataList.subList(medium+1, dataList.size()));
            return search(subList, sData);
        }else{
            //가운데보다 왼쪽에 있음.
            subList = new ArrayList<Integer>(dataList.subList(0, medium));
            return search(subList, sData);
        }
        
        
    }

    public static void main(String[]args){
        BinarySearch bSearch = new BinarySearch();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i =0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }
        //이진탐색은 정렬된 배열에서만 탐색이 가능하다.
        Collections.sort(dataList);
        System.out.println(dataList.toString());
        System.out.println(bSearch.search(dataList, 101));
        
    }
}
