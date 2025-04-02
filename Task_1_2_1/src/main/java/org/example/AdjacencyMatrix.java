package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Graph represented by Adjacency.
 */
public class AdjacencyMatrix implements Graph {
    private ArrayList<ArrayList<Integer>> adjacencyMatrix;
    private int countOfVertexes;

    /**
     * create adjMatrix.
     */
    public AdjacencyMatrix() {
        adjacencyMatrix = new ArrayList<>();
        countOfVertexes = 0;
    }

    /**
     * adds vertex to adjMatrix.
     */
    public int addVertex() {
        adjacencyMatrix.add(new ArrayList<Integer>());
        countOfVertexes++;
        for (int i = 0; i < countOfVertexes; i++) {
            adjacencyMatrix.get(countOfVertexes - 1).add(0);
        }
        for (int i = 0; i < countOfVertexes; i++) {
            if (i != countOfVertexes - 1) {
                adjacencyMatrix.get(i).add(0);
            }
        }
        return countOfVertexes - 1;
    }

    /**
     * removes vertex from adjMatrix.
     */
    public void removeVertex(int vertexId) {
        for (int i = 0; i < countOfVertexes; i++) {
            adjacencyMatrix.get(i).remove(vertexId);
        }
        adjacencyMatrix.remove(vertexId);
        countOfVertexes--;
    }

    /**
     * sets edge btw.
     */
    public void setEdge(int vertexId1, int vertexId2) {
        adjacencyMatrix.get(vertexId1).set(vertexId2, 1);
        adjacencyMatrix.get(vertexId2).set(vertexId1, 1);
    }

    /**
     * removes edge.
     */
    public void removeEdge(int vertexId1, int vertexId2) {
        adjacencyMatrix.get(vertexId1).set(vertexId2, 0);
        adjacencyMatrix.get(vertexId2).set(vertexId1, 0);
    }

    /**
     * returns list of neighbours.
     */
    public ArrayList<Integer> getNeighbors(int vertexId) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < countOfVertexes; i++) {
            if (adjacencyMatrix.get(vertexId).get(i) == 1) {
                neighbors.add(i);
            }
        }
        return neighbors;
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
            // Init new AdjMatrix
            ArrayList<ArrayList<Integer>> newAdjacencyMatrix = new ArrayList<>();
            for (int i = 0; i < vertexCount; i++) {
                newAdjacencyMatrix.add(new ArrayList<>());
                for (int p = 0; p < vertexCount; p++) {
                    newAdjacencyMatrix.get(i).add(0);
                }
            }
            // Fill the new AdjMatrix
            for (int i = 2; i < (edgesCount * 2) + 2; i += 2) {
                newAdjacencyMatrix.get(
                        splittedLines.get(i)
                ).set(splittedLines.get(i + 1), 1);
                newAdjacencyMatrix.get(
                        splittedLines.get(i + 1)
                ).set(splittedLines.get(i), 1);
            }
            // Change matrixes
            this.adjacencyMatrix = newAdjacencyMatrix;
            this.countOfVertexes = vertexCount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * returns sorted list of edges.
     */
    public ArrayList<Integer> topologicalSort() {
        HashMap<Integer, Integer> colors = new HashMap<>();
        ArrayList<Integer> sort = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            colors.put(i, 0);
        }
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            boolean res = dfs(colors, sort, i);
            if (!res) {
                return null;
            }
        }
        Collections.reverse(sort);
        return sort;
    }

    /**
     * util func to implement topologicalSort.
     */
    private boolean dfs(
            HashMap<Integer, Integer> colors, ArrayList<Integer> sort, Integer vertex
    ) {
        if (colors.get(vertex) != 0) {
            return true;
        }
        colors.put(vertex, 1);
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            if (adjacencyMatrix.get(vertex).get(i) > 0) {
                if (colors.get(i) == 1 && i != vertex) {
                    return false;
                } else if (colors.get(i) == 0) {
                    boolean res = dfs(colors, sort, i);
                    if (!res) {
                        return false;
                    }
                }
            }
        }
        colors.put(vertex, 2);
        sort.add(vertex);

        return true;
    }
}