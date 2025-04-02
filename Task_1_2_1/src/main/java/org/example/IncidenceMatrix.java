package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Graph implemented by incidence matrix.
 */
public class IncidenceMatrix implements Graph {
    private ArrayList<ArrayList<Integer>> incidenceMatrix;
    private int countOfVertexes;
    private int countOfEdges;
    /**
     * create adjMatrix.
     */
    public IncidenceMatrix() {
        incidenceMatrix = new ArrayList<>();
        countOfVertexes = 0;
        countOfEdges = 0;
    }

    /**
     * adds vertex.
     */
    public int addVertex() {
        incidenceMatrix.add(new ArrayList<>());
        for (int i = 0; i < countOfEdges; i++) {
            incidenceMatrix.get(countOfVertexes).add(0);
        }
        countOfVertexes++;
        return countOfVertexes - 1;
    }

    /**
     * removes vertex.
     */
    public void removeVertex(int vertexId) {
        // Create new Incidence Matrix
        ArrayList<ArrayList<Integer>> newIncMatrix = new ArrayList<>();
        for (int i = 0; i < countOfVertexes; i++) {
            newIncMatrix.add(new ArrayList<Integer>());
        }
        // Fill new Inc matrix
        int deletedEdges = 0;
        for (int i = 0; i < countOfEdges; i++) {
            if (incidenceMatrix.get(vertexId).get(i) == 0) {
                for (int j = 0; j < countOfVertexes - 1; j++) {
                    newIncMatrix.get(j).add(incidenceMatrix.get(j).get(i));
                }
            }
        }
        countOfEdges -= deletedEdges;
        countOfVertexes--;
    }

    /**
     * sets edge btw two vertex1 and vertex2.
     */
    public void setEdge(int vertexId1, int vertexId2) {
        for (int i = 0; i < countOfVertexes; i++) {
            if (i == vertexId1 || i == vertexId2) {
                incidenceMatrix.get(i).add(1);
            } else {
                incidenceMatrix.get(i).add(0);
            }
        }
        countOfEdges++;
    }

    /**
     * removes edge btw vertex1 and vertex 2.
     */
    public void removeEdge(int vertexId1, int vertexId2) {
        for (int i = 0; i < countOfEdges; i++) {
            if (incidenceMatrix.get(vertexId1).get(i) == 1
                    && incidenceMatrix.get(vertexId2).get(i) == 1
            ) {
                incidenceMatrix.get(vertexId1).set(i, 0);
                incidenceMatrix.get(vertexId2).set(i, 0);
            }
        }
        countOfEdges--;
    }

    /**
     * returns all neighbours of vertex.
     */
    public ArrayList<Integer> getNeighbors(int vertexId) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < countOfEdges; i++) {
            if (incidenceMatrix.get(vertexId).get(i) == 1) {
                for (int j = 0; j < countOfVertexes; j++) {
                    if (incidenceMatrix.get(j).get(i) == 1 && j != vertexId) {
                        neighbors.add(j);
                    }
                }
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
            // Init new incidenceMatrix
            ArrayList<ArrayList<Integer>> newIncidenceMatrix = new ArrayList<>();
            for (int i = 0; i < vertexCount; i++) {
                newIncidenceMatrix.add(new ArrayList<>());
            }
            // Fill the new incidenceMatrix
            for (int i = 2; i < edgesCount; i ++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (j == i) {
                        newIncidenceMatrix.get(j).add(1);
                    } else {
                        newIncidenceMatrix.get(j).add(0);
                    }
                }
            }
            // Change matrixes
            this.incidenceMatrix = newIncidenceMatrix;
            this.countOfVertexes = vertexCount;
            this.countOfEdges = edgesCount;
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
        for (int i = 0; i < incidenceMatrix.size(); i++) {
            colors.put(i, 0);
        }
        for (int i = 0; i < incidenceMatrix.size(); i++) {
            boolean res = dfs(colors, sort, i);
            if (!res) {
                return null;
            }
        }
        Collections.reverse(sort);
        return sort;
    }

    private boolean dfs(HashMap<Integer, Integer> colors,
                                ArrayList<Integer> sort, Integer vertex) {
        if (colors.get(vertex) != 0) {
            return true;
        }
        colors.put(vertex, 1);
        for (int i = 0; i < incidenceMatrix.size(); i++) {
            if (incidenceMatrix.get(vertex).get(i) != 1) {
                continue;
            }
            for (int j = 0; j < incidenceMatrix.size(); j++) {
                if (incidenceMatrix.get(j).get(i) == -1) {
                    if (colors.get(j) == 1) {
                        return false;
                    } else if (colors.get(j) == 0) {
                        boolean res = dfs(colors, sort, j);
                        if (!res) {
                            return false;
                        }
                    }
                    break;
                }
            }
        }
        colors.put(vertex, 2);
        sort.add(vertex);

        return true;
    }
}
