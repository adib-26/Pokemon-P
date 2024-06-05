package src.kanto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.graph.Djikstra;
import src.graph.Edge;
import src.graph.Graph;

public class RivalRace {

    public static boolean doneRace = false;

    Graph graph;
    Djikstra djikstra;
    List<String> vert;
    boolean isRacing;
    String targetDest;

    public RivalRace() {
        graph = new Graph(initMap());
        djikstra = new Djikstra();
        vert = initVert();
        isRacing = false;
        targetDest = "";
    }

    public void startRivalRace() {
        this.isRacing = true;
        String randDest = djikstra.chooseRandomDestination(vert);
        this.targetDest = randDest;
        String outcomePath = Djikstra.findShortestPath("Saffron City", randDest,  vert, graph);
        System.out.println("The battle has begun! Your rival Gary has challenge you to a race to " + randDest);
        System.out.println("\nShortest path: " + outcomePath);
        System.out.println("Goodluck on your race!");
    }

    public void checkWin(String currLoc) {
        if(currLoc.equals(this.targetDest)) {
            System.out.println("Congratulations! You won the race!");
            this.isRacing = false;
            doneRace = true;
        }
    }

    public List<String> initVert() {
        List<String> vert = new ArrayList<>();
        vert.add("Saffron City");
        vert.add("Celadon City");
        vert.add("Fuschia City");
        vert.add("Vermillion City");
        vert.add("Lavender City");
        vert.add("Cerulean City");
        vert.add("Pewter City");
        vert.add("Viridian City");
        vert.add("Pallet Town");
        vert.add("Cinnabar Island");
        return vert;
    }

    public List<Edge> initMap() {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 4), new Edge(0, 3, 3), new Edge(0, 4, 3), new Edge(0, 5, 6),
                new Edge(1, 0, 4), new Edge(1, 2, 10), 
                new Edge(2, 1, 10), new Edge(2, 3, 7), new Edge(2, 4, 11), new Edge(2, 9, 5),
                new Edge(3, 0, 3), new Edge(3, 2, 7), new Edge(3, 4, 5), 
                new Edge(4, 0, 3), new Edge(4, 2, 11), new Edge(4, 3, 5), new Edge(4, 5, 9),
                new Edge(5, 4, 9), new Edge(5, 0, 6), new Edge(5, 6, 12), 
                new Edge(6, 7, 8), new Edge(6, 5, 12), 
                new Edge(7, 6, 8), new Edge(7, 8, 5), 
                new Edge(8, 7, 5), new Edge(8, 9, 7), 
                new Edge(9, 8, 7), new Edge(9, 2, 5) 
                );
        return edges;
    }

    public String getTargetDest() {
        return targetDest;
    }

    public boolean isRacing() {
        return isRacing;
    }
}
