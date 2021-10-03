package Compare;

import java.util.Arrays;

public class objectCompareTo {
    
    

    public static void main(String[]args){
        Object object = new Object(10, "A");
        Object object2 = new Object(12, "A");
        Object object3 = new Object(15, "A");
        Object object4 = new Object(7, "A");

        Object[] objects = new Object[]{object,object2,object3, object4};

        Arrays.sort(objects);

        for(int i =0;i<objects.length; i++){
            System.out.println(objects[i].a+"   "+objects[i].b);
        }
    }

    public static class Object implements Comparable<Object>{
        
        public Integer a;
        public String b;

        public Object(Integer a, String b){
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(Object o){

            // return this.a-o.a; //오름차순
            return o.a-this.a; //내림차순
        }


    }
}
