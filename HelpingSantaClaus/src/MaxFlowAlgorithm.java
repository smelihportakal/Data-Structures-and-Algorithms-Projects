import java.util.ArrayList;
import java.util.List;

public class MaxFlowAlgorithm {

    List<Edge>[] graph;

    public class Edge {
        public int from,to,capacity,flow;

        public Edge(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
        }
    }

    public void newGraph(int vertixes){
        graph = new List[vertixes];
        for (int i = 0; i < vertixes; i++)
            graph[i] = new ArrayList<>();
    }
/*
    public void createEdge(int from, int to, int capacity){
        new Edge
        graph[from].add()
    }
*/

}
