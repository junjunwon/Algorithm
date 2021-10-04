package shortestRoute;

import java.util.PriorityQueue;

public class Test {
    

    public static void main(String[]args) {
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
        pQ.add(new Edge(2, "A"));
        pQ.add(new Edge(5, "B"));
        pQ.add(new Edge(1, "C"));
        pQ.add(new Edge(7, "D"));
        pQ.poll();
        System.out.println(pQ.toString());
    }
    

    public static class Edge implements Comparable<Edge>{
        public int distance;
        public String vertex;

        public Edge(int distnace, String vertex){
            this.distance=distance;
            this.vertex=vertex;
        }

        public String toString(){
            return "vertext : "+this.vertex + ", distance : "+this.distance;
        }

        @Override
        public int compareTo(Edge edge){
            return this.distance-edge.distance;
        }

    }
}
