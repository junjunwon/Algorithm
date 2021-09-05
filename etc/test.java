package etc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test{

    public static int confCount(int[][] map){
        int count = 0;
        Arrays.sort(map, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        int lastOut = map[0][1];
        count++;
        for(int i = 1; i<map.length; i++){
            if(lastOut > map[i][0]) continue;
            lastOut = map[i][1];
            count++;
        }

        return count;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] map = new int[n][2];

        for(int i =0; i<n; i++){
            map[i][0] = scan.nextInt();
            map[i][1] = scan.nextInt();            
        }

        int result = confCount(map);
        System.out.println(result);
    }
}