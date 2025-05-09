package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Graph implementation by adjList.
 */
public class AdjacencyList implements Graph {
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private int countOfVertexes;

    /**
     * Constructor.
     */
    public AdjacencyList() {
        adjacencyList = new ArrayList<>();
        countOfVertexes = 0;
    }
    
    /**
     * adds vertex.
     */
    public int addVertex() {
        adjacencyList.add(new ArrayList<>());
        countOfVertexes++;
        return countOfVertexes - 1;
    }

    /**
     * removes vertex.
     */
    public void removeVertex(int vertexId) {
        adjacencyList.remove(vertexId);
        for (int i = 0; i < adjacencyList.size(); i++) {
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                if (adjacencyList.get(i).get(j) == vertexId) {
                    adjacencyList.remove(j);
                }
            }
        }
        countOfVertexes--;
    }

    /**
     * sets edge btw two vertex1 and vertex2.
     */
    public void setEdge(int vertexId1, int vertexId2) {
        adjacencyList.get(vertexId1).add(vertexId2);
        adjacencyList.get(vertexId2).add(vertexId1);
    }
    
    //TODO: СДЕЛАТЬ ЭТО ЕБУЧЕЕ ГОВНО!!!
    /**
     * removes edge btw vertex1 and vertex 2.
     */
    public void removeEdge(int vertexId1, int vertexId2) {
        ArrayList<Integer> newArrList = new ArrayList();
        for (int i = 0; i < adjacencyList.get(vertexId1).size(); i++) {
            if (adjacencyList.get(vertexId1).get(i) != vertexId2) {
                newArrList.add(i);
            }
        }
        adjacencyList.set(vertexId1, newArrList);

        newArrList = new ArrayList();
        for (int i = 0; i < adjacencyList.get(vertexId2).size(); i++) {
            if (adjacencyList.get(vertexId2).get(i) != vertexId1) {
                newArrList.add(i);
            }
        }
        adjacencyList.set(vertexId2, newArrList);
    }

    /**
     * returns all neighbours of vertex.
     */
    public ArrayList<Integer> getNeighbors(int vertexId) {
        return adjacencyList.get(vertexId);
    }

    /**
     * reads new graph from file.
     */
    public void readFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            List<Integer> splittedLines = new ArrayList<>();
            for (String line : lines) {
                String[] splittedLine = line.split(" ");
                splittedLines.add(Integer.parseInt(splittedLine[0]));
                splittedLines.add(Integer.parseInt(splittedLine[1]));
            }

            int vertexCount = splittedLines.get(0), edgesCount = splittedLines.get(1);
            // Init new adjList
            ArrayList<ArrayList<Integer>> newAdjacencyList = new ArrayList<>();
            for (int i = 0; i < vertexCount; i++) {
                newAdjacencyList.add(new ArrayList<>());
            }
            // Fill the new adjList
            for (int i = 2; i < edgesCount; i += 2) {
                newAdjacencyList.get(
                        splittedLines.get(i)
                ).add(splittedLines.get(i + 1));
                newAdjacencyList.get(
                        splittedLines.get(i + 1)
                ).add(splittedLines.get(i));
            }
            // Change matrixes
            this.adjacencyList = newAdjacencyList;
            this.countOfVertexes = vertexCount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * returns sorted list of vertexes.
     */
    public ArrayList<Integer> topologicalSort() {
        HashMap<Integer, Integer> colors = new HashMap<>();
        ArrayList<Integer> sort = new ArrayList<>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            colors.put(i, 0);
        }
        for (int i = 0; i < adjacencyList.size(); i++) {
            boolean res = dfs(colors, sort, i);
            if (!res) {
                return null;
            }
        }
        Collections.reverse(sort);
        return sort;
    }

    /**
     * util func to use in topological sort.
     */
    private boolean dfs(
            HashMap<Integer, Integer> colors, ArrayList<Integer> sort, Integer vertex
    ) {
        if (colors.get(vertex) != 0) {
            return true;
        }
        colors.put(vertex, 1);
        for (Integer vert : adjacencyList.get(vertex)) {
            if (colors.get(vert) == 1) {
                return false;
            } else if (colors.get(vert) == 0) {
                boolean res = dfs(colors, sort, vert);
                if (!res) {
                    return false;
                }
            }
        }
        colors.put(vertex, 2);
        sort.add(vertex);

        return true;
    }
}
