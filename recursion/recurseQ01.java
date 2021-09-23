package recursion;

public class recurseQ01 {
    /**
     * 문제
     * 정수 4를 1,2,3의 조합으로 나타내는 방법은 다음과 같이 총 7가지가 있다.
     * 정수 n이 입력으로 주어졌을때 n을 1,2,3의 합으로 나타낼 수 있는 방법의 수를 구해라.
     * 방법의 수에 초점을 맞추는 것이 포인트!!
     *  
     */

    public int factorial(int n){
        if(n == 1){
            return 1;
        } else if(n ==2 ){
            return 2;
        } else if(n==3){
            return 4;
        }
        return this.factorial(n-1)+this.factorial(n-2)+this.factorial(n-3);
    }

     public static void main(String[]args){
         recurseQ01 recurseQ01 = new recurseQ01();
         int result = recurseQ01.factorial(6);
         System.out.println(result);
     }
}
