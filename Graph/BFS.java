package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {


    public void Bfs(HashMap<String, ArrayList<String>> graph){
        
        //방문할 큐, 방문한 큐 정의
        Queue<String> needVisit = new LinkedList<>();
        Queue<String> visited = new LinkedList<>();

        //첫번째 A 키값을 찾아본다. 
        needVisit.add("A");
        //A키의 값이 있다면 if문 안으로 들어감.
        while(!needVisit.isEmpty()){
            //A를 needvisit -> visited에 넣어줌.
            String visitedData = needVisit.poll();
            visited.add(visitedData);
            
            //해쉬맵에 values의 크기 구함
            int size = graph.get(visitedData).size();

            //visited에 있는 값에 연결된 values를 needVisit에 넣어줌.
            for(int i = 0; i<size; i++){
                
                if(visited.contains(graph.get(visitedData).get(i))){
                    continue;
                }
                needVisit.add(graph.get(visitedData).get(i));
            }
        }
        while(!visited.isEmpty()){
            System.out.print(visited.poll()+" ");
        }
        
        
    }

    public static void main(String[]args){

        BFS bfs = new BFS();
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A","D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A","G","H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B","E","F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C","J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));

        bfs.Bfs(graph);
    }
}
