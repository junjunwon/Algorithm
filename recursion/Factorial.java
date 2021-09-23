package recursion;

import java.util.ArrayList;

public class Factorial {
    
    public int factorial(int n){
        if(n>1){
            return n*factorial(n-1);
        }else{
            return 1;
        }
    }
    public int factorial2(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial2(n-1);
        
    }
    public int factorialArray(ArrayList<Integer> dataList){
        if(dataList.size() <= 0){
            return 0;
        }
        
        return dataList.get(0)+ factorialArray(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
    }

    public static void main(String[]args){
        Factorial fac = new Factorial();
        int result = fac.factorial2(5);
        System.out.println(result);
    }
}
