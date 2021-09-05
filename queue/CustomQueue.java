package queue;

import java.util.ArrayList;
import java.util.List;

public class CustomQueue<T> { // <T> 제네릭 타입의 KEY값.
    
    private List<T> queue = new ArrayList<>();
    
    public void add(T item){
        queue.add(item);
    }

    public T remove(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0);
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
