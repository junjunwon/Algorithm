package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
    
    private ArrayList<String> Dfs(HashMap<String, ArrayList<String>> graph, String startNode) {

        //방문한 배열
        ArrayList<String> visited = new ArrayList<>();

        //방문할 배열
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while(needVisit.size()>0){
            //add한 노드를 visited로 넣어준다.
            String visitedData = needVisit.remove(needVisit.size()-1);
            if(!visited.contains(visitedData)){
                visited.add(visitedData);
                needVisit.addAll(graph.get(visitedData));
            }
            

        }
        return visited;
    }

    public static void main(String[]args){

        DFS dfs = new DFS();
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

        String startNode = "A";

        ArrayList<String> result = dfs.Dfs(graph, startNode);
        System.out.println(result.toString());

    }

    
}
