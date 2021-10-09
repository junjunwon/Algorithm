package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class resign {
    /**
     * N+1 퇴사일
     * N일동안 상담
     * Ti : 상담을 완료하는데 걸리는 기간
     * Pi : 받을 수 있는 금액
     * 다음 상담에 걸리는 시간이 N보다 클경우 현재 상담까지만 진행.
     * t = t+t[i];
     * total
     * 최대 이익 -> dfs로 풀어보자. dp공식도 있다는데 잘 모르겠음.
     * @throws IOException
     */

    public static int [] t, p, d;
    public static int n, result;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        n = Integer.parseInt(br.readLine());

        // n + 1일 까지 계산합니다.
        t = new int[n + 2];
        p = new int[n + 2];
        d = new int[n + 2];

        for(int i=1; i<=n; i++){
            String[] s = br.readLine().split(" ");
            t[i] = Integer.parseInt(s[0]);
            p[i] = Integer.parseInt(s[1]);
        }

        // 2. DP (bottom-up) 수행
		// i번째 날 일을하면 i + t[j]날 돈을 받기 때문에,
		// n+1번째 날까지 진행해줍니다.      
        for(int i=1; i<=n + 1; i++){
            for(int j=1; j<i; j++){
                // 1) j 번째 날에서 일을 안하고 i 번째 날까지 온 경우(j < i)
                d[i] = max(d[i], d[j]);

                // 2) j 번째 날에서 t[j] 기간 동안 일을하고 보상을 p[j] 받은 경우
                // 그 보상은 j + t[j] 날 받습니다.
                if(j + t[j] == i){
                    d[i] = max(d[i], d[j] + p[j]);
                }
            }

            // 3) 최대값을 갱신해줍니다.
            result = max(result, d[i]);
        }

        // 3. 출력
        System.out.println(result);
    }

    // 두수 a, b에서 최대값을 구하는 함수 (삼항 연산자 사용)
    public static int max(int a, int b){
        return a > b ? a : b;
    }
}
