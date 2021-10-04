package shortestRoute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MyDijkstraGraph {
    
    private HashMap<String, Integer> shortRoute(HashMap<String, ArrayList<Edge>> graph, String start) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        Edge currEdge, expandEdge;
        String currNode, expandNode;
        int currDistance, expandDistance;
        ArrayList<Edge> nodeList;

        for(String key : graph.keySet()){
            result.put(key, Integer.MAX_VALUE);
        }
        result.put(start, 0); //초기화 완료

        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
        pQ.add(new Edge(result.get(start), start)); //초기 우선순위큐 A,0 넣기.

        while(pQ.size()>0){
            currEdge = pQ.poll();
            currDistance = currEdge.distance;
            currNode = currEdge.vertex;

            if(result.get(currNode)<currDistance){
                continue; //우선순위큐에서 뺀 값의 노드의 distance가 더 클 경우 패스!
            }
            nodeList = graph.get(currNode); //연결된 edge정보 전부 담고, 크기 비교 후 result에 넣어줌.
            for(int i = 0; i<nodeList.size(); i++){
                expandEdge = nodeList.get(i);
                expandDistance = expandEdge.distance + currDistance;
                expandNode = expandEdge.vertex;
                if(result.get(expandNode)>expandDistance){
                    result.put(expandNode, expandDistance);
                    pQ.add(new Edge(expandDistance, expandNode));
                }
                
            }
            
        }
        
        return result;

    }

    public static void main(String[]args){
        MyDijkstraGraph mGraph = new MyDijkstraGraph();
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();

        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        HashMap<String, Integer> result = mGraph.shortRoute(graph, "A");
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
    }
}
