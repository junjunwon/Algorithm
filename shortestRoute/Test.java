package shortestRoute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Test {
    
    public HashMap<String, Integer> shortest(HashMap<String, ArrayList<Edge>> edgeList, String start){

        HashMap<String, Integer> result = new HashMap<>();
        Edge currEdge, expandEdge;
        String currNode, expandNode;
        int currDist, expandDist;
        ArrayList<Edge> nodeList;

        for(String key : edgeList.keySet()){
            result.put(key, Integer.MAX_VALUE);
        }
        result.put(start, 0);

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(result.get(start),start));

        while(!pQ.isEmpty()){
            currEdge = pQ.poll();
            currNode = currEdge.vertex;
            currDist = currEdge.dist;

            if(result.get(currNode) < currDist){
                continue;
            }
            nodeList = edgeList.get(currNode);
            for(int i =0; i<nodeList.size(); i++){
                expandEdge = nodeList.get(i);
                expandNode = expandEdge.vertex;
                expandDist = expandEdge.dist + currDist;
                if(result.get(expandNode) > expandDist){
                    result.put(expandNode, expandDist);
                    pQ.add(new Edge(result.get(expandNode), expandNode));
                }
            }
        }

        return result;
    }

    public static void main(String[]args){
        HashMap<String, ArrayList<Edge>> edgeList = new HashMap<String, ArrayList<Edge>>();
        edgeList.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        edgeList.put("B", new ArrayList<Edge>());
        edgeList.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"), new Edge(2, "D"))));
        edgeList.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        edgeList.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        edgeList.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        String start = "A";

        Test test = new Test();
        HashMap<String, Integer> nodeList= test.shortest(edgeList, start);
        System.out.println(nodeList.toString());
    }

    public static class Edge implements Comparable<Edge>{
        public Integer dist;
        public String vertex;

        public Edge(Integer dist, String vertex){
            this.dist = dist;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge edge){
            return this.dist - edge.dist;
        }

    }
}
