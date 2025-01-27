public class Edge {
    public int from,to;
    public int flow;
    public int capacity;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
    }
}
