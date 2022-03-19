package BruteForce;

import java.util.Scanner;

public class Bf15651 {

    public static int N, M;
    public static int[] selected;
    public static StringBuilder sb= new StringBuilder();


    public static void dfs(int k){
        if(k==M+1){
            for(int i = 1; i<=M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i = 1; i<=N; i++){
                selected[k]=i;
                dfs(k+1);
                selected[k]=0;
            }
        }
    }
    public static void main(String[]args){
        input();

        dfs(1);
        System.out.print(sb.toString());
    }

    public static void input(){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }
}