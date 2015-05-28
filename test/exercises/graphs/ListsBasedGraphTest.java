package exercises.graphs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ListsBasedGraphTest {

    @Test
    public void minimumSpanningTreeShouldWorkOnSmallCyclicGraph() {
        ListsBasedGraph graph = new ListsBasedGraph();
        graph
                .addEdge(new WeightedEdge(0, 1, 4))
                .addEdge(new WeightedEdge(1, 2, 2))
                .addEdge(new WeightedEdge(2, 0, 1));

        graph = graph.minimumSpanningTree();

        assertEquals(2, graph.edges);
        assertTrue(graph.vertices.get(1).contains(new WeightedEdge(1, 2, 2)));
        assertTrue(graph.vertices.get(2).contains(new WeightedEdge(2, 0, 1)));
    }

    @Test
    public void areConnectedShouldReturnTrueIfThereIsARouteConnectingTwoVertices() {
        ListsBasedGraph graph = new ListsBasedGraph();
        graph
                .addEdge(0, 1)
                .addEdge(1, 2);

        assertTrue(graph.areConnected(0, 2));
    }

    @Test
    public void areConnectedShouldReturnTrueIfThereIsARouteConnectingTwoVerticesInAComplexGraph() {
        ListsBasedGraph graph = new ListsBasedGraph();
        graph
                .addEdge(0, 1)
                .addEdge(1, 3)
                .addEdge(3, 0)
                .addEdge(2, 5)
                .addEdge(2, 7)
                .addEdge(5, 6)
                .addEdge(1, 2);

        assertTrue(graph.areConnected(0, 6));
    }

    @Test
    public void areConnectedShouldReturnFalseIfThereIsNoRouteConnectingTwoVerticesInAComplexGraph() {
        ListsBasedGraph graph = new ListsBasedGraph();
        graph
                .addEdge(0, 1)
                .addEdge(1, 3)
                .addEdge(3, 0)
                .addEdge(2, 5)
                .addEdge(2, 7)
                .addEdge(5, 6)
                .addEdge(9, 8)
                .addEdge(1, 2);

        assertFalse(graph.areConnected(6, 8));
    }

    @Test
    public void dijkstraShouldComputeShortestPathAndPopulateDistancesAndParentsArraysProperly() {
        ListsBasedGraph graph = new ListsBasedGraph();
        graph
                .addEdge(0, 1, 4)
                .addEdge(1, 3, 2)
                .addEdge(0, 2, 1)
                .addEdge(1, 2, 2)
                .addEdge(2, 3, 9);

        graph.dijkstra(0);

        assertEquals(0, graph.distanceVector[0]);
        assertEquals(-1, graph.parent[0]);

        assertEquals(1, graph.distanceVector[2]);
        assertEquals(0, graph.parent[2]);

        assertEquals(3, graph.distanceVector[1]);
        assertEquals(2, graph.parent[1]);

        assertEquals(5, graph.distanceVector[3]);
        assertEquals(1, graph.parent[3]);
    }
}