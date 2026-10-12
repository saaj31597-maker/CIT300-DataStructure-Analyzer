// Author / Responsibility: Member 4 - M.N.M. Najil (23DA2-0856)
/** Console menu for the Graph component. */
public class GraphMenu {
    private final Graph graph;
    private final PerformanceLog log;

    public GraphMenu(Graph graph, PerformanceLog log) {
        this.graph = graph;
        this.log = log;
    }

    public void run() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Search for a Vertex (BFS)");
            System.out.println("7. Load Sample Graph");
            System.out.println("8. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 8);
            switch (choice) {
                case 1:
                    String name = InputHelper.readText("Enter vertex name: ");
                    System.out.println(graph.addVertex(name)
                            ? "  Vertex '" + name + "' added."
                            : "  ! Vertex '" + name + "' already exists.");
                    break;
                case 2:
                    if (graph.vertexCount() < 2) {
                        System.out.println("  ! Add at least two vertices first.");
                        break;
                    }
                    String a = InputHelper.readText("Enter first vertex: ");
                    String b = InputHelper.readText("Enter second vertex: ");
                    String err = graph.addEdge(a, b);
                    System.out.println(err == null ? "  Edge " + a + " - " + b + " added." : "  ! " + err);
                    break;
                case 3:
                    graph.display();
                    break;
                case 4:
                    traverse(true);
                    break;
                case 5:
                    traverse(false);
                    break;
                case 6:
                    search();
                    break;
                case 7:
                    graph.loadSample();
                    System.out.println("  Sample graph loaded.");
                    graph.display();
                    break;
                default:
                    return;
            }
        }
    }

    private void traverse(boolean bfs) {
        if (graph.isEmpty()) {
            System.out.println("  ! Graph is empty. Add vertices or load the sample graph.");
            return;
        }
        String start = InputHelper.readText("Enter start vertex: ");
        Graph.TraversalResult r = bfs ? graph.bfs(start, null) : graph.dfs(start);
        if (r == null) {
            System.out.println("  ! Vertex '" + start + "' does not exist.");
            return;
        }
        String algo = bfs ? "BFS" : "DFS";
        log.add("Graph Traversal", algo, r.steps, r.nanos, "start " + start);
        System.out.println("  " + algo + " order : " + String.join(" -> ", r.order));
        System.out.println("  Steps (vertices visited + edges examined): " + r.steps + ", time " + r.nanos + " ns");
    }

    private void search() {
        if (graph.isEmpty()) {
            System.out.println("  ! Graph is empty. Add vertices or load the sample graph.");
            return;
        }
        String start = InputHelper.readText("Enter start vertex: ");
        String target = InputHelper.readText("Enter vertex to search for: ");
        Graph.TraversalResult r = graph.bfs(start, target);
        if (r == null) {
            System.out.println("  ! Vertex '" + start + "' does not exist.");
            return;
        }
        log.add("Graph Search", "BFS Search", r.steps, r.nanos, start + " to " + target);
        System.out.println(r.found
                ? "  Vertex '" + target + "' found. Visited: " + String.join(" -> ", r.order)
                : "  Vertex '" + target + "' is not reachable from '" + start + "'.");
        System.out.println("  Steps: " + r.steps + ", time " + r.nanos + " ns");
    }
}
