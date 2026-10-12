// Author / Responsibility: Member 1 - S.M. Sajith (23DA2-0875)
import java.util.Arrays;

/**
 * Performance / complexity demonstration:
 * Linear vs Binary search on a large sorted array, and BFS vs DFS on the graph.
 */
public class PerformanceMenu {
    private final Graph graph;
    private final PerformanceLog log;

    public PerformanceMenu(Graph graph, PerformanceLog log) {
        this.graph = graph;
        this.log = log;
    }

    public void run() {
        while (true) {
            System.out.println("\n-------------- PERFORMANCE COMPARISON -------");
            System.out.println("1. Run Search Benchmark (Linear vs Binary)");
            System.out.println("2. Run Graph Benchmark (BFS vs DFS)");
            System.out.println("3. Show Comparison Table");
            System.out.println("4. Explain the Results (complexity)");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    searchBenchmark();
                    break;
                case 2:
                    graphBenchmark();
                    break;
                case 3:
                    printTable();
                    break;
                case 4:
                    explain();
                    break;
                default:
                    return;
            }
        }
    }

    private void searchBenchmark() {
        int n = InputHelper.readInt("Array size (10 to 5000000): ", 10, 5000000);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i * 2;                     // sorted even numbers
        }
        int key = data[n - 1];                   // worst case for linear search: last element
        int reps = 200;
        SearchManager.Result lin = null, bin = null;
        long linTime = 0, binTime = 0;
        for (int i = 0; i < reps; i++) {
            lin = SearchManager.linearSearch(data, key);
            linTime += lin.nanos;
            bin = SearchManager.binarySearch(data, key);
            binTime += bin.nanos;
        }
        log.add("Search", "Linear Search", lin.steps, linTime / (double) reps, "benchmark n=" + n + " (worst case)");
        log.add("Search", "Binary Search", bin.steps, binTime / (double) reps, "benchmark n=" + n + " (worst case)");
        System.out.println("  Searching for the last element in a sorted array of " + n + " items.");
        System.out.println("  Linear Search : " + lin.steps + " steps, avg " + Math.round(linTime / (double) reps) + " ns");
        System.out.println("  Binary Search : " + bin.steps + " steps, avg " + Math.round(binTime / (double) reps) + " ns");
    }

    private void graphBenchmark() {
        if (graph.vertexCount() < 2) {
            System.out.println("  Graph is too small. Loading the sample graph for the benchmark.");
            graph.loadSample();
        }
        String start = graph.vertexName(0);
        int reps = 1000;
        Graph.TraversalResult bfs = null, dfs = null;
        long bTime = 0, dTime = 0;
        for (int i = 0; i < reps; i++) {
            bfs = graph.bfs(start, null);
            bTime += bfs.nanos;
            dfs = graph.dfs(start);
            dTime += dfs.nanos;
        }
        String note = "start " + start + ", V=" + graph.vertexCount() + ", E=" + graph.edgeCount();
        log.add("Graph Traversal", "BFS", bfs.steps, bTime / (double) reps, note);
        log.add("Graph Traversal", "DFS", dfs.steps, dTime / (double) reps, note);
        System.out.println("  Graph: " + note);
        System.out.println("  BFS order : " + String.join(" -> ", bfs.order) + "  (" + bfs.steps + " steps)");
        System.out.println("  DFS order : " + String.join(" -> ", dfs.order) + "  (" + dfs.steps + " steps)");
    }

    private void printTable() {
        String[][] rows = {
                {"Search", "Linear Search"}, {"Search", "Binary Search"},
                {"Graph Traversal", "BFS"}, {"Graph Traversal", "DFS"}
        };
        System.out.println("\n=============================================================");
        System.out.println("     PERFORMANCE COMPARISON");
        System.out.println("=============================================================");
        System.out.printf("%-18s %-16s %10s %14s%n", "Operation", "Algorithm", "Steps", "Avg Time (ns)");
        System.out.println("-------------------------------------------------------------");
        boolean any = false;
        for (String[] r : rows) {
            PerformanceLog.Entry e = log.latest(r[0], r[1]);
            if (e == null) {
                System.out.printf("%-18s %-16s %10s %14s%n", r[0], r[1], "-", "-");
            } else {
                any = true;
                System.out.printf("%-18s %-16s %10d %14.0f%n", r[0], r[1], e.steps, e.nanos);
            }
        }
        System.out.println("=============================================================");
        if (!any) {
            System.out.println("  No results yet. Run options 1 and 2 first.");
        }
    }

    private void explain() {
        System.out.println("\n  Why do the results differ? (algorithmic complexity)");
        System.out.println("  - Linear Search checks elements one by one: O(n). Worst case = n comparisons.");
        System.out.println("  - Binary Search halves the sorted range each step: O(log n). About log2(n) comparisons.");
        System.out.println("    (n = 1,000,000 -> linear ~1,000,000 steps, binary ~20 steps).");
        System.out.println("  - BFS and DFS both visit every vertex and examine every edge: O(V + E),");
        System.out.println("    so their step counts are similar; they differ in ORDER:");
        System.out.println("    BFS (queue) explores level by level; DFS (stack) goes deep before backtracking.");
        System.out.println("  - Array insert/delete shift elements: O(n). Stack/Queue push/pop/enqueue/dequeue: O(1).");
        System.out.println("  - Linked list insert at head: O(1); insert at tail, delete and search: O(n).");
        System.out.println("  Note: measured time depends on the machine/JVM warm-up; step counts are exact.");
    }
}
