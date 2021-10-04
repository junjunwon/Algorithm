package shortestRoute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraGraph {
    
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start){
        Edge edgeNode, adjacentNode;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        ArrayList<Edge> nodeList;
        HashMap<String, Integer> distances = new HashMap<String, Integer>();
        for(String key : graph.keySet()){
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0); //ㅇㅕ기까까지  하하면  초초기  배배열  세세팅  완료. (0,lnf,lnf);

        //우선순위큐를 선언해주고 초기세팅 start distances 값을 넣어준다.
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(distances.get(start), start));
        //graph.get(A)에 연결된 vertex값을 일치하는 key의 distance hashmap에 넣어준다.
        //이때 우선순위 큐에서 pop한 key의 value+추가할 key의 value < 기존 distances hashmap value 일 경우에만 변경해준다.

        
        //위 조건을 충족해서 변경한 key들은 우선순위에 넣어준다.

        while(pQ.size() > 0){
            edgeNode = pQ.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;
            
            if(distances.get(currentNode)>currentDistance){
                continue;
            }
             nodeList = graph.get(currentNode);
             
             for(int i = 0; i<nodeList.size(); i++){
                 adjacentNode = nodeList.get(i);
                 adjacent = adjacentNode.vertex;
                 weight = adjacentNode.distance;
                 distance = currentDistance + weight;

                 if(distances.get(adjacent)>distance){
                    distances.put(adjacent, distance);
                    pQ.add(new Edge(distance, adjacent));
                 }
             }
        }

        return distances;
    }


    public static void main(String[]args){

        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8,"B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        // System.out.println(graph.toString());

        // for(String key : graph.keySet()){
        //     System.out.println(key);
        //     System.out.println(graph.get(key));
        // }

        DijkstraGraph source = new DijkstraGraph();
        HashMap<String, Integer> result = source.dijkstraFunc(graph, "A");
        System.out.println(result.toString());

    }

    public static class Edge implements Comparable<Edge>{
        
        public Integer distance;
        public String vertex;

        public Edge(Integer distance, String vertex){
            this.distance=distance;
            this.vertex=vertex;
        }

        @Override
        public int compareTo(Edge edge){
            return this.distance-edge.distance;
        }

        public String toString(){
            return "vertext : "+this.vertex + ", distance : "+this.distance;
        }
    }
}
