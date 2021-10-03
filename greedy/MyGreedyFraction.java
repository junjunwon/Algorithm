package greedy;

import java.util.Arrays;


public class MyGreedyFraction {

    public static class Object implements Comparable<Object>{
        public Integer w;
        public Integer v;
        public double result;

        public Object(Integer w, Integer v, double result){
            this.w = w;
            this.v = v;
            this.result = result;       
        }

        public Object(Integer w, Integer v){
            this.w = w;
            this.v = v;
            
        }

        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }

        // @Override
        // public int compareTo(Object o) {
            
        //     return this.w-o.w; 
        // }

        
    }

    public static void find(int totalW, int[][] array){
        int finalValue = 0;
        double[] result = new double[array[0].length];
        for(int i =0; i<result.length; i++){
            result[i]=((double)(array[1][i])/(double)(array[0][i]));
        }
        Arrays.sort(result);
        String a = "abc";
           
        while(totalW>=0){
            
        }
    }

    public static void main(String[]args){
        // FractionalKnapsackP fP = new FractionalKnapsackP();
        
        // ArrayList<int[]> array = new ArrayList<>();
        int[][] array = {{10,10},{15,12},{40,2},{20,10},{25,8},{30,5}};

        int totalW = 30;
        find(totalW, array);
        //무게가 30인 
    }
}
