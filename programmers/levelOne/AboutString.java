package programmers.levelOne;

public class AboutString {
    public static void main(String[]args){
        String newId = "...!@BaT#*..y.abcdefghijklm";
        newId= newId.toLowerCase();
        newId=newId.replaceAll("[^0-9-_.a-z]", "");
        newId=newId.replaceAll("[.+]", ".");

        System.out.print(newId);
    }
}
