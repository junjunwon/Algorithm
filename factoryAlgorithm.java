public class factoryAlgorithm {
    

    public static int factory(int n){
        int result =1;
        for(int i=n; i>=1; i--){
            result*=i;
        }

        return result;
    }

    public static void main(String[]args){
        
        int n =4;
        int result = factory(n);
        System.out.println(result);
    }
}
