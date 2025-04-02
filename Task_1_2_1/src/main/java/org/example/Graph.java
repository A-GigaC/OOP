package org.example;

import java.util.ArrayList;

/**
 * Default graph interface.
 */
public interface Graph {
    /**
     * adds vertex.
     */
    int addVertex();

    /**
     * removes vertex.
     */
    void removeVertex(int vertexId);

    /**
     * sets edge btw two vertex1 and vertex2.
     */
    void setEdge(int vertexId1, int vertexId2);

    /**
     * removes edge btw vertex1 and vertex 2.
     */
    void removeEdge(int vertexId1, int vertexId2);

    /**
     * returns all neighbours of vertex.
     */
    ArrayList<Integer> getNeighbors(int vertexId);

    /**
     * reads new graph from file.
     */
    void readFromFile(String filename);

    /**
     * returns sorted list of vertexes.
     */
    ArrayList<Integer> topologicalSort();
}
