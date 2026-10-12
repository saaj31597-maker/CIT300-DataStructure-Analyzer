// Author / Responsibility: Member 1 - S.M. Sajith (23DA2-0875)
/** Console menu for the Linked List component. */
public class LinkedListMenu {
    private final MyLinkedList list;
    private final PerformanceLog log;

    public LinkedListMenu(MyLinkedList list, PerformanceLog log) {
        this.list = list;
        this.log = log;
    }

    public void run() {
        while (true) {
            System.out.println("\n------------- LINKED LIST OPERATIONS --------");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at Tail");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Delete First Node");
            System.out.println("6. Search for a Value");
            System.out.println("7. Display List");
            System.out.println("8. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 8);
            try {
                switch (choice) {
                    case 1:
                        int a = InputHelper.readInt("Enter value: ");
                        long t = System.nanoTime();
                        list.insertAtHead(a);
                        log.add("Linked List", "Insert at Head", list.getLastSteps(), System.nanoTime() - t, "value " + a);
                        System.out.println("  Inserted " + a + " at the head.");
                        break;
                    case 2:
                        int b = InputHelper.readInt("Enter value: ");
                        long t2 = System.nanoTime();
                        list.insertAtTail(b);
                        log.add("Linked List", "Insert at Tail", list.getLastSteps(), System.nanoTime() - t2, "value " + b);
                        System.out.println("  Inserted " + b + " at the tail (" + list.getLastSteps() + " steps).");
                        break;
                    case 3:
                        int pos = InputHelper.readInt("Enter position (0 to " + list.size() + "): ", 0, list.size());
                        int c = InputHelper.readInt("Enter value: ");
                        long t3 = System.nanoTime();
                        list.insertAt(pos, c);
                        log.add("Linked List", "Insert at Position", list.getLastSteps(), System.nanoTime() - t3, "value " + c + " at " + pos);
                        System.out.println("  Inserted " + c + " at position " + pos + ".");
                        break;
                    case 4:
                        if (list.isEmpty()) {
                            System.out.println("  ! List is empty. Nothing to delete.");
                            break;
                        }
                        int d = InputHelper.readInt("Enter value to delete: ");
                        long t4 = System.nanoTime();
                        boolean ok = list.deleteValue(d);
                        log.add("Linked List", "Delete by Value", list.getLastSteps(), System.nanoTime() - t4, "value " + d);
                        System.out.println(ok ? "  Deleted " + d + "." : "  Value " + d + " was not found.");
                        break;
                    case 5:
                        long t5 = System.nanoTime();
                        int first = list.deleteFirst();
                        log.add("Linked List", "Delete First", list.getLastSteps(), System.nanoTime() - t5, "value " + first);
                        System.out.println("  Deleted first node (" + first + ").");
                        break;
                    case 6:
                        if (list.isEmpty()) {
                            System.out.println("  ! List is empty. Nothing to search.");
                            break;
                        }
                        int key = InputHelper.readInt("Enter value to search: ");
                        long t6 = System.nanoTime();
                        int at = list.search(key);
                        log.add("Linked List", "Search", list.getLastSteps(), System.nanoTime() - t6, "key " + key);
                        System.out.println(at == -1
                                ? "  Value " + key + " not found (" + list.getLastSteps() + " nodes checked)."
                                : "  Value " + key + " found at position " + at + " (" + list.getLastSteps() + " nodes checked).");
                        break;
                    case 7:
                        list.display();
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
