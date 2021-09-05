import java.util.Scanner;

public class baggage {
    /*
    물품 수 : N
    버틸 수 있는 무게 : k
    각각 W, V : 1개의 무게(W)에 따른 가치(V)

    output : 한정된 무게에 최대 가치를 구해라.
    */
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[][] wV = new int[n][2];
        for(int i=0; i<n; i++){
            wV[i][0] = scan.nextInt();
            wV[i][1] = scan.nextInt();
        }
        int temp = 1;
    }
}
