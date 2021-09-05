package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class gas_Station_greedy{

    private static int doMath(int n, int[] lengths, int[] cities) {

        int result = 0;
        int i=0;
        
        while(i<cities.length-1){
            
            
                //cities i > i+1일 경우 j=j+1
                if(cities[i] > cities[i+1]){
                    result += cities[i] * lengths[i];
                    i++;
                } 
                //i<= i+1일 경우 j=j+2
                else if(cities[i] <= cities[i+1]){
                    if(i==cities.length-2){
                        result += cities[i] * lengths[i];
                        i++;
                        break;
                    }
                    result += cities[i] * (lengths[i]+lengths[i+1]);
                    i+=2;
                }
        }

        return result;
    }



    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int[] lengths = new int[n-1];
        int[] cities  = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<lengths.length; i++){
            lengths[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<cities.length; i++){
            cities[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = doMath(n, lengths, cities);
        System.out.println(result);
    }

    
}