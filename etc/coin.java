import java.util.Scanner;

public class coin {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] input = new int[n];
        for(int i =0 ;i<n; i++){
            input[i] = scan.nextInt();
        }

        int sum = 0;   
        int count = 0;

        for(int i=n-1; i>=0; i--){
            if(input[i]>k) continue;

            while(input[i]<=k){
                sum+=input[i];
                k=k-input[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
