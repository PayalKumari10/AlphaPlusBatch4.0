import java.util.*;

public class Main {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Method to create the graph
    static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 2, 2));
        graph.add(new Edge(4, 1, -1));
    }

    // Bellman-Ford algorithm
    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges (V-1) times
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : graph) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge e : graph) {
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }

        // Print the final shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        bellmanFord(graph, 0, V);
    }
}

=== Code Output ===

Shortest distances from source 0:
Vertex 0 -> 0
Vertex 1 -> 2
Vertex 2 -> -2
Vertex 3 -> 0
Vertex 4 -> INF

=== Code Execution Successful ===
