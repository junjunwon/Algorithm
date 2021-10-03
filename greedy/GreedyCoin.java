package greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GreedyCoin {
    

    


    //지불해야하는 총 금액받고, 동전 목록받아서
    //동전 크기가 큰 것부터
    //총금액 / 동전목록의 나머지가 남은 금액
    //제일 작은 금액보다 작을 경우 제일 작은 금액에 +1

    public static void countCoin(int total, ArrayList<Integer> coinList){
        Collections.sort(coinList);
        int remained = total;
        int index = coinList.size()-1;
        int totalCount = 0;
        ArrayList<Integer> countList = new ArrayList<Integer>();

        while(remained >=coinList.get(0) && index>=0){
            // countList.add(remained / coinList.get(index));
            totalCount += remained / coinList.get(index);
            remained = remained % coinList.get(index);
            index--;
        }
        
        if(remained < coinList.get(0) && remained !=0){
            totalCount+=1;
        }
        System.out.println(totalCount);
    }


    public static void main(String[]args){
        GreedyCoin gCoin = new GreedyCoin();
        int total = 4720;
        ArrayList<Integer> coinList = new ArrayList<Integer>();
        coinList.add(50);
        coinList.add(100);
        coinList.add(500);
        coinList.add(1);
        
        gCoin.countCoin(total, coinList);
    }
}
