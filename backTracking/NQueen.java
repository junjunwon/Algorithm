package backTracking;

import java.util.ArrayList;

public class NQueen {
    

    //Promising
    public boolean isAvailable(ArrayList<Integer> currCandiData, int CurrCol){
        Integer currRow = currCandiData.size();
        for(int i = 0; i<currRow; i++){
            if(currCandiData.get(i) == CurrCol || (Math.abs(currCandiData.get(i)-CurrCol)==currRow-i)){
                return false;
            }
        }
        return true;
    }

    public void dfsFunc(Integer N, Integer currRow, ArrayList<Integer> currCandiData){
        if(currRow == N){
            System.out.println(currCandiData);
            return;
        }

        for(int i = 0; i<N; i++){
            if(this.isAvailable(currCandiData, i)==true){
                currCandiData.add(i);
                this.dfsFunc(N, currRow+1, currCandiData);
                //만약 만족하는 열이 하나도 없다면 이전 루트까지 계속 가지치기 -> Prunning
                currCandiData.remove(currCandiData.size()-1);
            }
        }
    }

    public static void main(String[]args){
        NQueen nQ = new NQueen();
        nQ.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
