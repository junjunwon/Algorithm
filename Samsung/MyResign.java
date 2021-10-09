package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyResign {

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] time = new int[n+1];
        int[] price = new int[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+2];

        for(int i =1; i<=n; i++){
            if(i + time[i] <= n+1){
                dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i]+price[i]);
            }
            dp[i+1]=Math.max(dp[i], dp[i+1]);
            
        }
        System.out.println(dp[n+1]);
    }
    
}
