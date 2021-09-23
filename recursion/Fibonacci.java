package recursion;

public class Fibonacci {
    public int fibonacci(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[]args){
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fibonacci(3);
        System.out.println(result);
    }
}
