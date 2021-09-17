import java.util.Random;

public class RandomPassword {
    public static void main(String[]args){
        int count = 0;
        int len = 4; 
        while(count<100){
            Random rand = new Random();
            String numStr = ""; //난수가 저장될 변수.
            for(int i=0; i<len; i++){
                String ran = Integer.toString(rand.nextInt(10));
                if(!numStr.contains(ran)){
                    numStr+=ran;
                }else{
                    i-=1;
                }
            }
            System.out.println(numStr);
            count++;
        }
        
    }
    
}
