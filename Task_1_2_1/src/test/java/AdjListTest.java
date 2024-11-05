import org.example.AdjacencyList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * tests for adj list.
 */
public class AdjListTest {
    /**
     * test add vertex.
     */
    @Test
    public void addVertex() {
        AdjacencyList adjList = new AdjacencyList();
        Assertions.assertEquals(0, adjList.addVertex());
    }

    /**
     * test remove vertex.
     */
    @Test
    public void removeVertex() {
        AdjacencyList adjList = new AdjacencyList();
        adjList.addVertex();
        adjList.removeVertex(0);
        Assertions.assertEquals(0, adjList.addVertex());
    }

    /**
     * test add edge.
     */
    @Test
    public void addDeleteEdgeAndGetNeighbours() {
        AdjacencyList adjList = new AdjacencyList();
        adjList.addVertex();
        adjList.addVertex();
        adjList.setEdge(0, 1);
        Assertions.assertEquals(1, adjList.getNeighbors(0).get(0));
        adjList.removeEdge(0, 1);
        Assertions.assertTrue(adjList.getNeighbors(0).isEmpty());
    }

    /**
     * test read from file.
     */
    @Test
    public void readFromFile() {
        AdjacencyList adjList = new AdjacencyList();
        adjList.readFromFile("src/test/graph.grph");
        Assertions.assertEquals(3, adjList.addVertex());
    }

//    /**
//     * test topsort.
//     */
//    @Test
//    public void topSort() {
//
//    }
}
