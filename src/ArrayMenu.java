// Author / Responsibility: Member 2 - A. Muaath (23DA2-0791)
/** Console menu for the Array component. */
public class ArrayMenu {
    private final ArrayManager array;
    private final PerformanceLog log;

    public ArrayMenu(ArrayManager array, PerformanceLog log) {
        this.array = array;
        this.log = log;
    }

    public void run() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Position");
            System.out.println("3. Delete by Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search for a Value (Linear Search)");
            System.out.println("6. Display Array");
            System.out.println("7. Load Random Sample Data");
            System.out.println("8. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 8);
            switch (choice) {
                case 1:
                    if (array.isFull()) {
                        System.out.println("  ! Array is full (capacity " + array.capacity() + ").");
                        break;
                    }
                    int v = InputHelper.readInt("Enter value to insert: ");
                    long t = System.nanoTime();
                    array.insertEnd(v);
                    log.add("Array Insert", "Insert at End", array.getLastSteps(), System.nanoTime() - t, "value " + v);
                    System.out.println("  Inserted " + v + " at the end.");
                    break;
                case 2:
                    if (array.isFull()) {
                        System.out.println("  ! Array is full (capacity " + array.capacity() + ").");
                        break;
                    }
                    int pos = InputHelper.readInt("Enter position (0 to " + array.size() + "): ", 0, array.size());
                    int val = InputHelper.readInt("Enter value to insert: ");
                    long t2 = System.nanoTime();
                    array.insertAt(pos, val);
                    log.add("Array Insert", "Insert at Position", array.getLastSteps(), System.nanoTime() - t2,
                            "value " + val + " at " + pos);
                    System.out.println("  Inserted " + val + " at position " + pos + " (" + array.getLastSteps() + " steps).");
                    break;
                case 3:
                    if (array.isEmpty()) {
                        System.out.println("  ! Array is empty. Nothing to delete.");
                        break;
                    }
                    int dp = InputHelper.readInt("Enter position to delete (0 to " + (array.size() - 1) + "): ", 0, array.size() - 1);
                    long t3 = System.nanoTime();
                    array.deleteAt(dp);
                    log.add("Array Delete", "Delete by Position", array.getLastSteps(), System.nanoTime() - t3, "position " + dp);
                    System.out.println("  Deleted element at position " + dp + " (" + array.getLastSteps() + " steps).");
                    break;
                case 4:
                    if (array.isEmpty()) {
                        System.out.println("  ! Array is empty. Nothing to delete.");
                        break;
                    }
                    int dv = InputHelper.readInt("Enter value to delete: ");
                    long t4 = System.nanoTime();
                    int at = array.deleteValue(dv);
                    log.add("Array Delete", "Delete by Value", array.getLastSteps(), System.nanoTime() - t4, "value " + dv);
                    if (at == -1) {
                        System.out.println("  Value " + dv + " was not found.");
                    } else {
                        System.out.println("  Deleted " + dv + " (found at position " + at + ").");
                    }
                    break;
                case 5:
                    if (array.isEmpty()) {
                        System.out.println("  ! Array is empty. Nothing to search.");
                        break;
                    }
                    int key = InputHelper.readInt("Enter value to search: ");
                    SearchManager.Result r = SearchManager.linearSearch(array.toArray(), key);
                    log.add("Array Search", "Linear Search", r.steps, r.nanos, "key " + key);
                    if (r.index == -1) {
                        System.out.println("  Value " + key + " not found (" + r.steps + " comparisons).");
                    } else {
                        System.out.println("  Value " + key + " found at position " + r.index + " (" + r.steps + " comparisons).");
                    }
                    break;
                case 6:
                    array.display();
                    break;
                case 7:
                    int n = InputHelper.readInt("How many random values (1 to " + array.capacity() + ")? ", 1, array.capacity());
                    array.fillRandom(n, 100);
                    System.out.println("  Loaded " + n + " random values (1-100).");
                    array.display();
                    break;
                default:
                    return;
            }
        }
    }
}
