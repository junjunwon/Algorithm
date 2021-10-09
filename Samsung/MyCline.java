package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MyCline {
  
    /**
     * 내가 처음부터 끝까지 다 푼 문제!!!!!!!!!!! 정답율은 54프로지만
     * 예외 조건을 전부 확인해야했고,
     * 세분화하는 과정에서 문제가 많았다. 아무것도 안보고 풀었던 구현문제였기에 조금 뿌듯...
     * 소요시간은....1시간반..? 안걸린거 같다.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i = 0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j =0; j<N; j++){
                map[i][j]=Integer.parseInt(temp[j]);
            }
        }
        int result = 0;
        //행 기준
        for(int i =0; i<N; i++){
            boolean check = true;
            int[] multiChk = new int[N]; //마지막부분은 어떻게 넣어줌? N-1이라...
            for(int j =0; j<N-1; j++){
                //행기준이니까 j++
                if(!check) break;
                if(map[i][j+1]==map[i][j]+1){ //1만 큰 수를 만났을때
                    for(int k=1; k<=L; k++){
                        if(j-L+k>=0){
                            if(map[i][j]!=map[i][j-L+(k)]){ // 길이만큼 같은 크기일때    
                                check = false;
                                break;
                            }
                            multiChk[j-L+k]=multiChk[j-L+k]+1; //
                            if(multiChk[j-L+k]>1){
                                check = false;
                                break;
                            }
                        }
                        else {
                            //범위 밖일 경우
                            check=false;
                            break;
                        }

                    }
                    
                } else if(map[i][j+1]==map[i][j]-1){ //1만큼 작을때
                    for(int k=1; k<=L; k++){
                        if(j+k<N){ //범위 체크
                            if(map[i][j+1]!=map[i][j+k]){ //경사면의 크기가 다를 경우.
                                check=false;
                                break;
                            }
                            multiChk[j+k]=multiChk[j+k]+1; //
                            if(multiChk[j+k]>1){
                                check = false;
                                break;
                            }
                        }else {
                           //범위 밖일 경우
                           check=false;
                           break; 
                        }
                        
                    }
                } else if(map[i][j+1]==map[i][j]){ //동일할때
                    continue;
                } else{
                    //2이상 클거나 작을때
                    check = false;
                    break;
                }
            }
            if(check){
                result++;
            }
        }

        //열 기준
        for(int j=0; j<N; j++){
            boolean check = true;
            int[] multiChk = new int[N];
            for(int i=0; i<N-1; i++){
                if(!check) break;
                if(map[i+1][j]==map[i][j]+1){ //1만 큰 수를 만났을때
                    for(int k=1; k<=L; k++){
                        if(i-L+k>=0){
                            if(map[i][j]!=map[i-L+k][j]){ // 길이만큼 같은 크기일때    
                                check = false;
                                break;
                            }
                            multiChk[i-L+k]=multiChk[i-L+k]+1; //
                            if(multiChk[i-L+k]>1){
                                check = false;
                                break;
                            }
                        }
                        else {
                            //범위 밖일 경우
                            check=false;
                            break;
                        }

                    }
                    
                }
                else if(map[i+1][j]==map[i][j]-1){ //1만큼 작을때
                    for(int k=1; k<=L; k++){
                        if(i+k<N){ //범위 체크
                            if(map[i+1][j]!=map[i+k][j]){ //경사면의 크기가 다를 경우.
                                check=false;
                                break;
                            }
                            multiChk[i+k]=multiChk[i+k]+1; //
                            if(multiChk[i+k]>1){
                                check = false;
                                break;
                            }
                        }else {
                           //범위 밖일 경우
                           check=false;
                           break; 
                        }
                        
                    }
                } else if(map[i+1][j]==map[i][j]){ //동일할때
                    continue;
                } else{
                    //2이상 크거나 작을 경우.
                    check = false;
                    break;
                }
            }
            if(check){
                result++;
            }
        }
        System.out.println(result);
    }
}
