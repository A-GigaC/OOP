import org.example.AdjacencyMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * tests for adj Matrix.
 */
public class AdjMatrixTest {

    /**
     * test add vertex.
     */
    @Test
    public void addVertex() {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix();
        Assertions.assertEquals(0, adjMatrix.addVertex());
    }

    /**
     * test remove vertex.
     */
    @Test
    public void removeVertex() {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix();
        adjMatrix.addVertex();
        adjMatrix.removeVertex(0);
        Assertions.assertEquals(0, adjMatrix.addVertex());
    }

    /**
     * test add edge.
     */
    @Test
    public void addDeleteEdgeAndGetNeighbours() {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix();
        adjMatrix.addVertex();
        adjMatrix.addVertex();
        adjMatrix.setEdge(0, 1);
        Assertions.assertEquals(adjMatrix.getNeighbors(0).get(0), 1);
        Assertions.assertEquals(adjMatrix.getNeighbors(1).get(0), 0);

        adjMatrix.removeEdge(1, 0);
        Assertions.assertTrue(adjMatrix.getNeighbors(0).isEmpty());
        Assertions.assertTrue(adjMatrix.getNeighbors(1).isEmpty());
    }

    /**
     * test read from file.
     */
    @Test
    public void readFromFile() {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix();
        adjMatrix.readFromFile("src/test/graph.grph");
        ArrayList<Integer> alInt = adjMatrix.getNeighbors(0);
        Assertions.assertEquals(alInt.get(0), 1);
    }

//    /**
//     * test topsort.
//     */
//    @Test
//    public void topSort() {
//        
//    }
}