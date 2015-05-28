package exercises.graphs;

import java.util.*;

/**
 * Created by cls on 11/03/15.
 */
public class ListsBasedGraph {

    Map<Integer, List<WeightedEdge>> vertices;
    int edges;
    int[] distanceVector;
    int[] parent;

    public ListsBasedGraph() {
        this.vertices = new HashMap<Integer, List<WeightedEdge>>();
    }

    public ListsBasedGraph(int vertices) {
        this.vertices = new HashMap<>();
        for (int i = 1; i <= vertices; i++) this.vertices.put(i, new ArrayList<WeightedEdge>());
    }

    public ListsBasedGraph addEdge(int i, int j) {
        return addEdge(i, j, 1);
    }

    public ListsBasedGraph addEdge(int i, int j, int weight) {
        if (addEdgeToOne(i, j, weight)) edges++;
        addEdgeToOne(j, i, weight);
        return this;
    }

    public ListsBasedGraph addEdge(WeightedEdge edge) {
        return addEdge(edge.from, edge.to, edge.weight);
    }

    private boolean addEdgeToOne(int i, int j, int weight) {
        List<WeightedEdge> iNeighbours = vertices.get(i);
        if (iNeighbours == null) {
            iNeighbours = new ArrayList<WeightedEdge>();
            vertices.put(i, iNeighbours);
        }
        WeightedEdge edge = new WeightedEdge(i, j, weight);
        if (!iNeighbours.contains(edge)) {
            iNeighbours.add(edge);
            return true;
        }
        return false;
    }

    public ListsBasedGraph removeEdge(int i, int j) {
        if (removeOneEdge(i, j, 1)) edges--;
        removeOneEdge(j, i, 1);
        return this;
    }

    public boolean removeOneEdge(int i, int j, int weight) {
        List<WeightedEdge> iNeighbours = vertices.get(i);
        if (iNeighbours != null) return iNeighbours.remove(new WeightedEdge(i, j, weight));
        return false;
    }

    public void visit(int vertex) {
        System.out.println(vertex);
    }

    private PriorityQueue<WeightedEdge> getAllEdges() {
        PriorityQueue<WeightedEdge> edges = new PriorityQueue<WeightedEdge>();
        Set<WeightedEdge> uniqueEdges = new HashSet<WeightedEdge>();
        for (List<WeightedEdge> vertexEdges : vertices.values()) {
            uniqueEdges.addAll(vertexEdges);
        }
        edges.addAll(uniqueEdges);
        return edges;
    }

    public ListsBasedGraph minimumSpanningTree() {
        PriorityQueue<WeightedEdge> edges = getAllEdges();
        Set<WeightedEdge> edgesOfResultingTree = new HashSet<WeightedEdge>();
        DisjointSets dset = new DisjointSets(vertices.keySet().size());
        while (!edges.isEmpty()) {
            WeightedEdge edge = edges.remove();
            if (dset.find(edge.from) != dset.find(edge.to)) {
                dset.union(edge.from, edge.to);
                edgesOfResultingTree.add(edge);
            }
        }
        ListsBasedGraph result = new ListsBasedGraph();
        for (WeightedEdge edge : edgesOfResultingTree) result.addEdge(edge);
        return result;
    }


    public void BFS(int initialVertex) {
        Queue<Integer> vertexToBeVisited = new LinkedList<Integer>();
        Set<Integer> verticesAlreadyVisited = new HashSet<Integer>();

        vertexToBeVisited.add(initialVertex);
        visit(initialVertex);
        verticesAlreadyVisited.add(initialVertex);
        while (!vertexToBeVisited.isEmpty()) {
            int v = vertexToBeVisited.remove();
            List<WeightedEdge> vNeighbours = vertices.get(v);
            if (vNeighbours != null) {
                for (WeightedEdge edge : vNeighbours) {
                    if (!verticesAlreadyVisited.contains(edge.to)) {
                        visit(edge.to);
                        verticesAlreadyVisited.add(edge.to);
                        vertexToBeVisited.add(edge.to);
                    }
                }
            }
        }
    }


    public void DFS(int initialVertex, Set<Integer> verticesAlreadyVisited) {
        visit(initialVertex);
        verticesAlreadyVisited.add(initialVertex);
        List<WeightedEdge> neighbours = vertices.get(initialVertex);
        if (neighbours != null) {
            for (WeightedEdge v : neighbours)
                if (!verticesAlreadyVisited.contains(v.to)) DFS(v.to, verticesAlreadyVisited);
        }
    }

    public static void main(String[] args) {
        ListsBasedGraph graph = new ListsBasedGraph()
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 3)
                .addEdge(2, 6)
                .addEdge(4, 8)
                .addEdge(4, 6)
                .addEdge(8, 6)
                .addEdge(6, 5)
                .addEdge(5, 7)
                .addEdge(9, 10)
                .addEdge(7, 10);
        System.out.println("BFS traversal of big graph: ");
        graph.BFS(1);

        System.out.println("\nDFS traversal of a big graph: ");
        graph.DFS(1, new HashSet<Integer>());

        System.out.println("\nBFS traversal of a disconnected graph: ");
        graph.removeEdge(6, 5);
        graph.BFS(1);

        System.out.println("\nDFS traversal of a disconnected graph: ");
        graph.DFS(1, new HashSet<Integer>());

        graph = new ListsBasedGraph()
                .addEdge(1, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(3, 5)
                .addEdge(4, 6)
                .addEdge(6, 7);

        System.out.println("\nBFS traversal of a tree (equivalent to level-order visit): ");
        graph.BFS(1);

        System.out.println("\nDFS traversal of a tree (equivalent to pre-order visit): ");
        graph.DFS(1, new HashSet<Integer>());
    }

    public void dijkstra(int source) {
        distanceVector = new int[vertices.size()];
        parent = new int[vertices.size()];

        //init
        Arrays.fill(distanceVector, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        distanceVector[source] = 0;

        Set<Integer> nodesWithShortestPath = new HashSet<>();
        List<Integer> allNodes = new ArrayList<>();
        allNodes.addAll(vertices.keySet());

        while (!allNodes.isEmpty()) {
            Integer u = extractMin(allNodes, distanceVector);
            nodesWithShortestPath.add(u);
            List<WeightedEdge> uNeighbours = vertices.get(u);
            if (uNeighbours != null) {
                for (WeightedEdge edge : uNeighbours) {
                    if (distanceVector[u] + edge.weight < distanceVector[edge.to]) {
                        distanceVector[edge.to] = distanceVector[u] + edge.weight;
                        parent[edge.to] = u;
                    }
                }
            }
        }
    }

    private Integer extractMin(List<Integer> queue, int[] distanceVector) {
        Integer min = Integer.MAX_VALUE;
        for (Integer elem : queue) {
            if (distanceVector[elem] <= min) min = elem;
        }
        queue.remove(min);
        return min;
    }

    public boolean areConnected(int i, int j) {
        return areConnected(i, j, new HashSet<>());
    }

    private boolean areConnected(int i, int j, Set<WeightedEdge> visitedEdges) {
        List<WeightedEdge> neighbours = vertices.get(i);
        if (neighbours == null) return false;
        if (neighbours.contains(new WeightedEdge(i, j, 1))) return true;
        for (WeightedEdge edge : neighbours) {
            if (!visitedEdges.contains(edge)) {
                visitedEdges.add(edge);
                if (areConnected(edge.to, j, visitedEdges)) return true;
            }
        }
        return false;
    }
}
