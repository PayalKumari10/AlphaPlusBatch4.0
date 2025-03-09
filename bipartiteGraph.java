import java.util.*;

public class Main {    
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {  // Check only unvisited nodes
                q.add(i);
                col[i] = 0; // Color it pink (0)

                while (!q.isEmpty()) { // Fixed `isEmpty()` check
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) { // Changed `i` to `j`
                        Edge e = graph[curr].get(j);

                        if (col[e.dest] == -1) {
                            col[e.dest] = 1 - col[curr]; // Flip color
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) { // Fixed `col(curr)` issue
                            return false; // Not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; // Fixed unchecked conversion
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}

=== Code Output ===


false

=== Code Execution Successful ===
