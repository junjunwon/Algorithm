package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ATM_greedy {
    
    public static int ATM(int[] array){

        int result = 0;

        Arrays.sort(array);

        for(int i=0; i<array.length; i++){
            for(int j =0; j<=i; j++){
                result+=array[j];
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = scan.nextInt();
        }

        int result = ATM(array);
        System.out.println(result);
    }
}
