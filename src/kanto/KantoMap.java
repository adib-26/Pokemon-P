package src.kanto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.graph.Edge;
import src.graph.Graph;

public class KantoMap {

    private Graph graph;
    private List<String> vert;

    public KantoMap() {
        createMapConnection();
    }

    public void createMapConnection() {

        vert = new ArrayList<>();
        vert.add("Saffron City");
        vert.add("Celadon City");
        vert.add("Fuschia City");
        vert.add("Vermilion City");
        vert.add("Lavender Town");
        vert.add("Cerulean City");
        vert.add("Pewter City");
        vert.add("Viridian City");
        vert.add("Pallet Town");
        vert.add("Cinnabar Island");


        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 3), new Edge(0, 4), new Edge(0, 5),
                new Edge(1, 0), new Edge(1, 2), 
                new Edge(2, 1), new Edge(2, 3), new Edge(2, 4), new Edge(2, 9),
                new Edge(3, 0), new Edge(3, 2), new Edge(3, 4), 
                new Edge(4, 0), new Edge(4, 2), new Edge(4, 3), new Edge(4, 5),
                new Edge(5, 4), new Edge(5, 0), new Edge(5, 6), 
                new Edge(6, 7), new Edge(6, 5), 
                new Edge(7, 6), new Edge(7, 8), 
                new Edge(8, 7), new Edge(8, 9), 
                new Edge(9, 8), new Edge(9, 2) 
                );

        graph = new Graph(edges);
    }

    public String[] getNeighborsString(int src) {
        int[] indexNbrs = graph.getNeighbors(src);
        String[] neighbors = new String[indexNbrs.length];

        int index = 0;
        for(int i: indexNbrs) {
            neighbors[index] = vert.get(i);
            index++;
        }

        return neighbors;
    }

    public int getCityIndex(String city) {
        return vert.indexOf(city);
    }

    public void displayNeighbors(int src) {
        int[] neighbors = graph.getNeighbors(src);

        System.out.println("From " + vert.get(src) + ", There are:");

        int index = 0;
        for(int i: neighbors) {
            System.out.println("[" + (index++) + "]" + "Neighbors: " + vert.get(i));
        }
    }

    public Graph getGraph() {
        return graph;
    } 
}
