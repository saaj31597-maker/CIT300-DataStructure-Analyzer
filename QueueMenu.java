// Author / Responsibility: Member 3 - M.T.M. Rasath (23DA2-0815)
/** Console menu for the Queue component. */
public class QueueMenu {
    private final ArrayQueue queue;
    private final PerformanceLog log;

    public QueueMenu(ArrayQueue queue, PerformanceLog log) {
        this.queue = queue;
        this.log = log;
    }

    public void run() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display Queue");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        int v = InputHelper.readInt("Enter value to enqueue: ");
                        long t = System.nanoTime();
                        queue.enqueue(v);
                        log.add("Queue", "Enqueue", 1, System.nanoTime() - t, "value " + v);
                        System.out.println("  Enqueued " + v + ".");
                        break;
                    case 2:
                        long t2 = System.nanoTime();
                        int removed = queue.dequeue();
                        log.add("Queue", "Dequeue", 1, System.nanoTime() - t2, "value " + removed);
                        System.out.println("  Dequeued " + removed + ".");
                        break;
                    case 3:
                        System.out.println("  Front element: " + queue.peek());
                        break;
                    case 4:
                        queue.display();
                        break;
                    default:
                        return;
                }
            } catch (IllegalStateException e) {
                System.out.println("  ! " + e.getMessage());
            }
        }
    }
}
