// Author / Responsibility: Member 2 - A. Muaath (23DA2-0791)
/** Console menu for the Searching component (Linear Search vs Binary Search). */
public class SearchMenu {
    private final ArrayManager array;
    private final PerformanceLog log;

    public SearchMenu(ArrayManager array, PerformanceLog log) {
        this.array = array;
        this.log = log;
    }

    public void run() {
        while (true) {
            System.out.println("\n-------------- SEARCHING OPERATIONS ---------");
            System.out.println("1. Linear Search (on the Array data)");
            System.out.println("2. Binary Search (on a sorted copy of the Array data)");
            System.out.println("3. Compare Linear vs Binary on the Array data");
            System.out.println("4. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 4);
            if (choice == 4) {
                return;
            }
            if (array.isEmpty()) {
                System.out.println("  ! The array is empty. Add data first (Array Operations -> Load Random Sample Data).");
                continue;
            }
            int[] data = array.toArray();
            int[] sorted = SearchManager.sortedCopy(data);
            int key = InputHelper.readInt("Enter value to search: ");
            if (choice == 1 || choice == 3) {
                SearchManager.Result r = SearchManager.linearSearch(data, key);
                log.add("Search", "Linear Search", r.steps, r.nanos, "n=" + data.length + ", key " + key);
                System.out.println("  Linear Search : " + describe(r, key));
            }
            if (choice == 2 || choice == 3) {
                SearchManager.Result r = SearchManager.binarySearch(sorted, key);
                log.add("Search", "Binary Search", r.steps, r.nanos, "n=" + sorted.length + ", key " + key);
                System.out.println("  Binary Search : " + describe(r, key) + "   (on sorted data)");
            }
        }
    }

    private String describe(SearchManager.Result r, int key) {
        String where = r.index == -1 ? "not found" : "found at index " + r.index;
        return "value " + key + " " + where + ", " + r.steps + " comparisons, " + r.nanos + " ns";
    }
}
