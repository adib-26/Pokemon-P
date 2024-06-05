package src.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Djikstra {
    List<Integer> shortestPath = new ArrayList<>();
    List<String> previousVert = new ArrayList<>();

    
    public static String findShortestPath(String src, String dest, List<String> vert, Graph graph) {

        Djikstra djikstra = new Djikstra();
        List<String> visited = new ArrayList<>() ;
        List<String> unvisited = new ArrayList<>();
        djikstra.prepareUnvisited(unvisited, vert);
        int currVisited = vert.indexOf(src);
    
        djikstra.initShortestPath(djikstra.shortestPath, currVisited, vert.size());
        djikstra.initPreviousVert(djikstra.previousVert, vert.size());
        int minWeight = 0;
        do {
            List<Vertex> currList = graph.getAdjList().get(currVisited);
                        for(Vertex node: currList) {
                int currVal = node.value;
                int currWeight = node.weight;
                String currValString = vert.get(currVal);
                int currVisitedDist = djikstra.shortestPath.get(currVisited); // first loop this is A

                if(!visited.contains(currValString)) {
                    int shortestDist = currVisitedDist + currWeight;
                    int currShortestDist = djikstra.shortestPath.get(currVal);
                    //System.out.println("Current Visited: " + currVisited + "  Current Value: " + currVal
                    //        + "  Current Weight: " + currWeight + "  Current String: " + currValString);

                    //System.out.println("Shortest Distance: " + shortestDist);
                    //System.out.println("Current Shortest Distance: " + currShortestDist);
                    if(shortestDist < currShortestDist) {
                        djikstra.shortestPath.set(currVal, shortestDist);
                        djikstra.previousVert.set(currVal, vert.get(currVisited));
                    }
                    minWeight = djikstra.getMinWeight(djikstra.shortestPath, visited, vert);
                }
            }
            
            String visiting = vert.get(currVisited);
            if(unvisited.remove(visiting)) {
                visited.add(visiting);
            }

            //System.out.println("Min weight: " + minWeight);
            //System.out.println("Unvisited: " + unvisited.toString());
            //System.out.println("Visited: " + visited.toString());

            //System.out.println(djikstra.shortestPath.toString());
            //System.out.println(djikstra.previousVert.toString());
            //System.out.println();
            int nextVisitIndex = djikstra.shortestPath.indexOf(minWeight);
            String visitedSameItem = vert.get(nextVisitIndex);
            if(visited.contains(visitedSameItem)) {
                for (int i = nextVisitIndex + 1; i < djikstra.shortestPath.size(); i++) {
                    if(djikstra.shortestPath.get(i) == minWeight) {
                        nextVisitIndex = i;
                    }
                }
            }
            currVisited = nextVisitIndex;

        } while(unvisited.size() > 0);
        return djikstra.getPath(dest, vert, djikstra.previousVert);
    }

    private String getPath(String dest, List<String> vert, List<String> prevVert) {
        String outcomePath = dest;
        while(!dest.equals(vert.get(0))) {
            int index = vert.indexOf(dest);
            String prev = prevVert.get(index);
            outcomePath = prev + " > " + outcomePath;
            dest = prev;
        }
        return outcomePath;
    }

    public List<String> getPreviousVert() {
        return previousVert;
    }

    public List<Integer> getShortestPath() {
        return shortestPath;
    }

    public String chooseRandomDestination(List<String> vert) {
        Random random = new Random();
        int randIndex = random.nextInt(1, vert.size());
        return vert.get(randIndex);
    }


    private int getMinWeight(List<Integer> shortestPath, List<String> visited,
            List<String> vert) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < shortestPath.size(); i++) {
            int currPath = shortestPath.get(i);
            String currVert = vert.get(i);
            if(currPath < min && !visited.contains(currVert)) {
                min = currPath;
            }
        }
        return min;
    }
    

    private void prepareUnvisited(List<String> unvisited, List<String> vert) {
        for(String v: vert) {
            unvisited.add(v);
        }
    }

    private void initPreviousVert(List<String> prevVert, int size) {
        for(int i = 0; i < size; i++) {
            prevVert.add("");
        }
    }

    private void initShortestPath(List<Integer> shortestPath, int startVisited, int size) {
        for(int i = 0; i < size; i++) {
            if(i == startVisited) {
                shortestPath.add(i, 0);
            } else {
                shortestPath.add(i, Integer.MAX_VALUE);
            }
        }
    }
}
