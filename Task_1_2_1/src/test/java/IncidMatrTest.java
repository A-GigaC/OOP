import org.example.IncidenceMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * tests for incidence matr.
 */
public class IncidMatrTest {
    /**
     * test add vertex.
     */
    @Test
    public void addVertex() {
        IncidenceMatrix incList = new IncidenceMatrix();
        Assertions.assertEquals(0, incList.addVertex());
    }

    /**
     * test remove vertex.
     */
    @Test
    public void removeVertex() {
        IncidenceMatrix incList = new IncidenceMatrix();
        incList.addVertex();
        incList.removeVertex(0);
        Assertions.assertEquals(0, incList.addVertex());
    }

    /**
     * test add edge.
     */
    @Test
    public void addDeleteEdgeAndGetNeighbours() {
        IncidenceMatrix incList = new IncidenceMatrix();
        incList.addVertex();
        incList.addVertex();
        incList.setEdge(0, 1);
        Assertions.assertEquals(1, incList.getNeighbors(0).get(0));
        incList.removeEdge(0, 1);
        Assertions.assertTrue(incList.getNeighbors(0).isEmpty());
    }

    /**
     * test read from file.
     */
    @Test
    public void readFromFile() {
        IncidenceMatrix incList = new IncidenceMatrix();
        incList.readFromFile("src/test/graph.grph");
        Assertions.assertEquals(3, incList.addVertex());
    }
}