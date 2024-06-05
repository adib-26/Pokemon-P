package src.graph;

public class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
        this.weight = 0;
    }

}

