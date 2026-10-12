// Author / Responsibility: Member 4 - M.N.M. Najil (23DA2-0856)
import java.util.ArrayList;

/**
 * Undirected, unweighted graph stored as an ADJACENCY LIST.
 * BFS uses our own ArrayQueue and DFS (iterative) uses our own ArrayStack.
 * BFS and DFS both run in O(V + E) time.
 */
public class Graph {

    /** Result of a traversal/search: visiting order, steps and time. */
    public static class TraversalResult {
        public final ArrayList<String> order = new ArrayList<>();
        public long steps;
        public long nanos;
        public boolean found;
    }

    private final ArrayList<String> vertices = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();
    private int edgeCount;

    public int vertexCount() { return vertices.size(); }
    public int edgeCount() { return edgeCount; }
    public boolean isEmpty() { return vertices.isEmpty(); }
    public String vertexName(int i) { return vertices.get(i); }

    public int indexOf(String name) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addVertex(String name) {
        if (indexOf(name) != -1) {
            return false;
        }
        vertices.add(name);
        adjacency.add(new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge. Returns an error message, or null on success. */
    public String addEdge(String a, String b) {
        int i = indexOf(a), j = indexOf(b);
        if (i == -1) return "Vertex '" + a + "' does not exist.";
        if (j == -1) return "Vertex '" + b + "' does not exist.";
        if (i == j) return "Self-loops are not allowed.";
        if (adjacency.get(i).contains(j)) return "Edge " + a + " - " + b + " already exists.";
        adjacency.get(i).add(j);
        adjacency.get(j).add(i);
        edgeCount++;
        return null;
    }

    public void clear() {
        vertices.clear();
        adjacency.clear();
        edgeCount = 0;
    }

    /** Loads a small demo graph (A..F). */
    public void loadSample() {
        clear();
        String[] names = {"A", "B", "C", "D", "E", "F"};
        for (String n : names) addVertex(n);
        String[][] edges = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"C", "D"}, {"C", "E"}, {"D", "F"}, {"E", "F"}};
        for (String[] e : edges) addEdge(e[0], e[1]);
    }

    public void display() {
        if (vertices.isEmpty()) {
            System.out.println("  Graph is empty.");
            return;
        }
        System.out.println("  Adjacency list (" + vertices.size() + " vertices, " + edgeCount + " edges):");
        for (int i = 0; i < vertices.size(); i++) {
            StringBuilder sb = new StringBuilder("   " + vertices.get(i) + " -> ");
            ArrayList<Integer> nbrs = adjacency.get(i);
            if (nbrs.isEmpty()) {
                sb.append("(no neighbours)");
            }
            for (int k = 0; k < nbrs.size(); k++) {
                sb.append(vertices.get(nbrs.get(k)));
                if (k < nbrs.size() - 1) sb.append(", ");
            }
            System.out.println(sb);
        }
    }

    /** Breadth-First Search from start. If target != null, stops when target is found. */
    public TraversalResult bfs(String startName, String target) {
        int s = indexOf(startName);
        if (s == -1) return null;
        long t0 = System.nanoTime();
        TraversalResult r = new TraversalResult();
        boolean[] visited = new boolean[vertices.size()];
        ArrayQueue queue = new ArrayQueue(vertices.size());
        visited[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int u = queue.dequeue();
            r.steps++;                              // visiting a vertex
            r.order.add(vertices.get(u));
            if (target != null && vertices.get(u).equalsIgnoreCase(target)) {
                r.found = true;
                break;
            }
            for (int v : adjacency.get(u)) {
                r.steps++;                          // examining an edge
                if (!visited[v]) {
                    visited[v] = true;
                    queue.enqueue(v);
                }
            }
        }
        r.nanos = System.nanoTime() - t0;
        return r;
    }

    /** Depth-First Search (iterative, using a stack) from start. */
    public TraversalResult dfs(String startName) {
        int s = indexOf(startName);
        if (s == -1) return null;
        long t0 = System.nanoTime();
        TraversalResult r = new TraversalResult();
        boolean[] visited = new boolean[vertices.size()];
        ArrayStack stack = new ArrayStack(vertices.size());
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            r.steps++;                              // visiting (popping) a vertex
            if (visited[u]) continue;
            visited[u] = true;
            r.order.add(vertices.get(u));
            ArrayList<Integer> nbrs = adjacency.get(u);
            for (int k = nbrs.size() - 1; k >= 0; k--) {   // reverse so first neighbour is visited first
                r.steps++;                          // examining an edge
                if (!visited[nbrs.get(k)]) {
                    stack.push(nbrs.get(k));
                }
            }
        }
        r.nanos = System.nanoTime() - t0;
        return r;
    }
}
