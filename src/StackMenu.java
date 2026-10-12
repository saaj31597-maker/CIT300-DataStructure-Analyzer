// Author / Responsibility: Member 3 - M.T.M. Rasath (23DA2-0815)
/** Console menu for the Stack component. */
public class StackMenu {
    private final ArrayStack stack;
    private final PerformanceLog log;

    public StackMenu(ArrayStack stack, PerformanceLog log) {
        this.stack = stack;
        this.log = log;
    }

    public void run() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        int v = InputHelper.readInt("Enter value to push: ");
                        long t = System.nanoTime();
                        stack.push(v);
                        log.add("Stack", "Push", 1, System.nanoTime() - t, "value " + v);
                        System.out.println("  Pushed " + v + ".");
                        break;
                    case 2:
                        long t2 = System.nanoTime();
                        int popped = stack.pop();
                        log.add("Stack", "Pop", 1, System.nanoTime() - t2, "value " + popped);
                        System.out.println("  Popped " + popped + ".");
                        break;
                    case 3:
                        System.out.println("  Top element: " + stack.peek());
                        break;
                    case 4:
                        stack.display();
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
