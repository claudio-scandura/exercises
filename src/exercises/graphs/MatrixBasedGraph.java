package exercises.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBasedGraph {

    boolean[][] matrix;
    int edges;

    public MatrixBasedGraph(int size) {
        matrix = new boolean[size + 1][size + 1];
    }

    public MatrixBasedGraph addEdge(int i, int j) {
        if (!matrix[i][j]) {
            matrix[i][j] = true;
            matrix[j][i] = true;
            edges++;
        }
        return this;
    }

    public MatrixBasedGraph removeEdge(int i, int j) {
        if (matrix[i][j]) {
            matrix[i][j] = false;
            matrix[j][i] = false;
            edges--;
        }
        return this;
    }

    public boolean areConnected(int i, int j) {
        return matrix[i][j];
    }

    public void BFS(int initialVertex) {
        Queue<Integer> verticesToVisit = new LinkedList<Integer>();
        boolean[] visits = new boolean[matrix.length];
        verticesToVisit.add(initialVertex);
        visits[initialVertex] = true;
        visit(initialVertex);
        while (!verticesToVisit.isEmpty()) {
            int visiting = verticesToVisit.remove();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[visiting][i] && !visits[i]) {
                    visit(i);
                    visits[i] = true;
                    verticesToVisit.add(i);
                }
            }
        }
    }

    public void DFS(int initialVertex, boolean[] visits) {
        visits[initialVertex] = true;
        visit(initialVertex);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[initialVertex][i] && !visits[i]) DFS(i, visits);
        }

    }

    public void visit(int i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        MatrixBasedGraph graph = new MatrixBasedGraph(10)
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
        graph.DFS(1, new boolean[graph.matrix.length]);

        System.out.println("\nBFS traversal of a disconnected graph: ");
        graph.removeEdge(6, 5);
        graph.BFS(1);

        System.out.println("\nDFS traversal of a disconnected graph: ");
        graph.DFS(1, new boolean[graph.matrix.length]);

        graph = new MatrixBasedGraph(10)
                .addEdge(1, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(3, 5)
                .addEdge(4, 6)
                .addEdge(6, 7);

        System.out.println("\nBFS traversal of a tree (equivalent to level-order visit): ");
        graph.BFS(1);

        System.out.println("\nDFS traversal of a tree (equivalent to pre-order visit): ");
        graph.DFS(1, new boolean[graph.matrix.length]);
    }
}
