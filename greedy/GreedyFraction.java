package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyFraction {
    

    public void knapsackFunc(Integer[][] objectList, double capacity){
        double totalValue = 0.0; //최대 가치
        double fraction = 0.0; //해당 물건의 몇프로가 들어갔는지?

        Arrays.sort(objectList, new Comparator<Integer[]>(){
            
            @Override
            public int compare(Integer[] object1, Integer[] object2){

                return (object2[1]/object2[0])-(object1[1]/object1[0]);
            }
        });
        for(int i =0; i<objectList.length; i++){
            System.out.println(objectList[i][0]+"  "+objectList[i][1]);
        } 
        for(int index=0; index<objectList.length; index++){
            if(capacity-(double)objectList[index][0]>0){
                capacity-=(double)objectList[index][0];
                totalValue+=(double)objectList[index][1];
                System.out.println("무게는 : "+objectList[index][0]+"  가치는 : "+objectList[index][1]);
            }
            else {
                fraction = capacity / (double)objectList[index][0];
                totalValue += (double)objectList[index][1]*fraction;
                System.out.println("무게는 : "+objectList[index][0]+"  가치는 : "+objectList[index][1]+"비율은 : "+fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치는 : "+totalValue);
    }

    public static void main(String[]args){
        GreedyFraction gFraction = new GreedyFraction();
        Integer[][] objectList = {{10,10},{15,12},{20,10},{25,8},{30,5}};
        double capacity = 30.0;
        gFraction.knapsackFunc(objectList, capacity);
    }
}
