package etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class missing_blacket {
    
    
    private static int minimum(List<String> nums, List<Character> calc) {
        int result = Integer.parseInt(nums.get(0));

        for(int i = 0; i<calc.size(); i++){
            if(calc.get(i)=='-'){
                result-=Integer.parseInt(nums.get(i+1));
                for(int j=i+1; j<calc.size(); j++){

                    if(calc.get(j)=='-') break;
                    result-=Integer.parseInt(nums.get(j+1));
                    i++;
                }

                
            } else if(calc.get(i) == '+'){
                result += Integer.parseInt(nums.get(i+1));
            }
        }

        return result;
    }

    public static void main(String[]args){
        
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<String> nums = new ArrayList<>();
        List<Character> calc = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if((input.length()-1)==i){
                sb.append(input.charAt(i));
                nums.add(sb.toString());
                sb.delete(0,sb.length());
            }
            else if(input.charAt(i)=='+' || input.charAt(i)=='-'){
                calc.add(input.charAt(i));
                nums.add(sb.toString());
                sb.delete(0,sb.length());
            } else{
                sb.append(input.charAt(i));
            }
        }

        
        int result = minimum(nums, calc);
        System.out.println(result);
    }

   
}
