import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {
    private static final int MAX_VERTICES = 20;

    private final Vertex[] vertexList = new Vertex[MAX_VERTICES];
    private final int[][] adjMat = new int[MAX_VERTICES][MAX_VERTICES];
    private int nVerts;

    public void addVertex(String label) {
        if (nVerts == MAX_VERTICES) {
            throw new IllegalStateException("El grafo alcanzó su capacidad máxima.");
        }
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        validateVertex(start);
        validateVertex(end);
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void dfs(int start) {
        validateVertex(start);
        resetVisited();
        dfsVisit(start);
        System.out.println();
    }

    private void dfsVisit(int vertex) {
        vertexList[vertex].visited = true;
        displayVertex(vertex);

        for (int neighbor = 0; neighbor < nVerts; neighbor++) {
            boolean hasEdge = adjMat[vertex][neighbor] == 1;
            boolean notVisited = !vertexList[neighbor].visited;
            if (hasEdge && notVisited) {
                dfsVisit(neighbor);
            }
        }
    }

    public void bfs(int start) {
        validateVertex(start);
        resetVisited();
        Queue<Integer> queue = new ArrayDeque<>();

        vertexList[start].visited = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            displayVertex(current);

            for (int neighbor = 0; neighbor < nVerts; neighbor++) {
                boolean hasEdge = adjMat[current][neighbor] == 1;
                boolean notVisited = !vertexList[neighbor].visited;
                if (hasEdge && notVisited) {
                    vertexList[neighbor].visited = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    private void displayVertex(int vertex) {
        System.out.print(vertexList[vertex].label + " ");
    }

    private void resetVisited() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].visited = false;
        }
    }

    private void validateVertex(int vertex) {
        if (vertex < 0 || vertex >= nVerts) {
            throw new IndexOutOfBoundsException("Índice de vértice inválido: " + vertex);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.print("DFS desde A: ");
        graph.dfs(0);
        System.out.print("BFS desde A: ");
        graph.bfs(0);
    }

    private static class Vertex {
        private final String label;
        private boolean visited;

        private Vertex(String label) {
            this.label = label;
        }
    }
}