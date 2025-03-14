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

    // 📌 Method 1: Create Graph Using Adjacency List Representation
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // Initialize each list
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 2, 2));  

        graph[4].add(new Edge(4, 1, -1));
    }

    // 📌 Method 2: Create Graph Using Edge List Representation
    static void createGraph2(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 2, 2));
        graph.add(new Edge(4, 1, -1));
    }

    // 📌 Bellman-Ford Algorithm
    public static void bellmanFord(ArrayList<Edge> edges, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance to source is 0

        // Relax all edges |V-1| times
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : edges) {
                int u = e.src, v = e.dest, wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Print final shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " -> INF");
            } else {
                System.out.println("Vertex " + i + " -> " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        // ✅ Using Adjacency List
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graphList = (ArrayList<Edge>[]) new ArrayList[V];
        createGraph(graphList);

        // Convert adjacency list to edge list
        ArrayList<Edge> graphEdges = new ArrayList<>();
        for (ArrayList<Edge> edges : graphList) {
            graphEdges.addAll(edges);
        }

        // ✅ Alternatively, use the direct edge list
        // createGraph2(graphEdges);

        // Run Bellman-Ford Algorithm
        bellmanFord(graphEdges, 0, V);
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
