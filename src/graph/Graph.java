package graph;

import java.util.ArrayList;
import java.util.List;


public class Graph {
    private List<List<Vertex>> adjList = new ArrayList<>();
    private int nodeCount;

    public Graph(List<Edge> edges) {
        nodeCount = getNumberOfNode(edges);

        for(int i = 0; i < nodeCount; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for(Edge e: edges) {
            List<Vertex> curr = adjList.get(e.src);
            curr.add(new Vertex(e.dest, e.weight));
        }
    }

    public int getNumberOfNode(List<Edge> edges) {
        int maxNum = Integer.MIN_VALUE;
        for(Edge e: edges) {
            int currSrc = e.src;
            if(currSrc > maxNum) {
                maxNum = currSrc;
            }
        }
        return maxNum + 1;
    }

    public int[] getNeighbors(int from) {
        List<Vertex> curr = adjList.get(from);
        int[] neighborsIndex = new int[curr.size()];
        int index = 0;
        for(Vertex node: curr) {
            int dest = node.value;
            neighborsIndex[index] = dest;
            index++;
        }
        return neighborsIndex;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public int getListSize() {
        return adjList.size();
    }

    public List<List<Vertex>> getAdjList() {
        return adjList;
    }

    public static void printGraph(Graph graph) {
        int vertexSrc = 0;

        int nodeCount = graph.getNodeCount();

        System.out.println("The graph content: ");
        while(vertexSrc < nodeCount) {
            for(Vertex node: graph.adjList.get(vertexSrc)) {
                System.out.print("Vertex: " + vertexSrc + " ==> " + node.value
                        + " (" + node.weight + ")\t");
            }
            System.out.println();
            vertexSrc++;
        }
    }
}
