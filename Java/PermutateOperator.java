package Java;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    
    static ArrayList<Integer> numbers = new ArrayList<>();
    static ArrayList<String> op = new ArrayList<>();
    
    static int[] target = new int[]{1,2,3};
    static int[] result = new int[3];
    static boolean[] visited = new boolean[3];
    static ArrayList<int[]> listMap = new ArrayList<>();
    static HashMap<Integer,String> map = new HashMap<Integer,String>(){{//초기값 지정
        put(1,"*");
        put(2,"+");
        put(3,"-");
    }};
    static int max = -9999;
    

    public static long solve(String statement) {
        
        
        StringBuffer sb = new StringBuffer();
        String[] temp = statement.split("");
        for(int i = 0; i < temp.length; i++) {
            if(temp[i].equals("*") || temp[i].equals("+") || temp[i].equals("-")) {
                op.add(temp[i]);
                numbers.add(Integer.parseInt(sb.toString()));
                sb = new StringBuffer();
                continue;
            }
            sb.append(temp[i]);
        }
        System.out.println("numbers");
        for(int i = 0; i<numbers.size(); i++){
            System.out.println(numbers.get(i));
        }
        System.out.println("operator");
        for(int i = 0; i<op.size(); i++){
            System.out.println(op.get(i));
        }
    
        perm(target, result, visited, 0, 3, 3, statement);
        
        
        return max;
        
    }
    
    static int calc(int[] operator, String statement) {
			System.out.println("get into calc function");
        for(int i = 0; i<3; i++) {

				}
        
        return Math.abs(1);
    }
    
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, String statement) {
        if (depth == r) {
            //output 배열로 연산
            for(int i = 0; i<3; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            max = Math.max(max, calc(output, statement));
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r, statement);       
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }

		public static void main(String[] args) {
			solve("100-200*300-500+20");
		}
}