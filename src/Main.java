// Author / Responsibility: Member 1 - S.M. Sajith (23DA2-0875)
/**
 * DATA STRUCTURE & GRAPH ANALYZER  (CIT300 Graded Practical Assignment 2)
 * Main console application - integrates all components.
 */
public class Main {

    public static void main(String[] args) {
        // Shared data structures (one instance each, used by the menus)
        PerformanceLog log = new PerformanceLog();
        ArrayManager array = new ArrayManager(50);
        ArrayStack stack = new ArrayStack(10);
        ArrayQueue queue = new ArrayQueue(10);
        MyLinkedList list = new MyLinkedList();
        Graph graph = new Graph();

        ArrayMenu arrayMenu = new ArrayMenu(array, log);
        StackMenu stackMenu = new StackMenu(stack, log);
        QueueMenu queueMenu = new QueueMenu(queue, log);
        LinkedListMenu listMenu = new LinkedListMenu(list, log);
        SearchMenu searchMenu = new SearchMenu(array, log);
        GraphMenu graphMenu = new GraphMenu(graph, log);
        PerformanceMenu perfMenu = new PerformanceMenu(graph, log);

        while (true) {
            System.out.println("\n=============================================");
            System.out.println("     DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 9);
            switch (choice) {
                case 1: arrayMenu.run(); break;
                case 2: stackMenu.run(); break;
                case 3: queueMenu.run(); break;
                case 4: listMenu.run(); break;
                case 5: searchMenu.run(); break;
                case 6: graphMenu.run(); break;
                case 7: perfMenu.run(); break;
                case 8: displayAll(log, array, stack, queue, list, graph); break;
                default:
                    System.out.println("\nThank you for using the Data Structure & Graph Analyzer. Goodbye!");
                    return;
            }
        }
    }

    /** Shows the current content of every structure and the full results log. */
    private static void displayAll(PerformanceLog log, ArrayManager array, ArrayStack stack,
                                   ArrayQueue queue, MyLinkedList list, Graph graph) {
        System.out.println("\n=============================================");
        System.out.println("     CURRENT DATA STRUCTURES");
        System.out.println("=============================================");
        System.out.println("[Array]");
        array.display();
        System.out.println("[Stack]");
        stack.display();
        System.out.println("[Queue]");
        queue.display();
        System.out.println("[Linked List]");
        list.display();
        System.out.println("[Graph]");
        graph.display();

        System.out.println("\n=============================================================================");
        System.out.println("     ALL RESULTS (" + log.size() + " operations recorded)");
        System.out.println("=============================================================================");
        if (log.size() == 0) {
            System.out.println("  No operations have been performed yet.");
            return;
        }
        System.out.printf("%-4s %-16s %-20s %8s %12s  %s%n", "No.", "Operation", "Algorithm", "Steps", "Time (ns)", "Details");
        System.out.println("-----------------------------------------------------------------------------");
        int i = 1;
        for (PerformanceLog.Entry e : log.getEntries()) {
            System.out.printf("%-4d %-16s %-20s %8d %12.0f  %s%n", i++, e.operation, e.algorithm, e.steps, e.nanos, e.note);
        }
    }
}
