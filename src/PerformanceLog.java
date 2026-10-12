// Author / Responsibility: Member 1 - S.M. Sajith (23DA2-0875)
import java.util.ArrayList;

/**
 * Stores the result (steps, time) of every operation performed in the system.
 * Used by "Performance Comparison" and "Display All Results".
 */
public class PerformanceLog {

    public static class Entry {
        final String operation;
        final String algorithm;
        final long steps;
        final double nanos;
        final String note;

        Entry(String operation, String algorithm, long steps, double nanos, String note) {
            this.operation = operation;
            this.algorithm = algorithm;
            this.steps = steps;
            this.nanos = nanos;
            this.note = note;
        }
    }

    private final ArrayList<Entry> entries = new ArrayList<>();

    public void add(String operation, String algorithm, long steps, double nanos, String note) {
        entries.add(new Entry(operation, algorithm, steps, nanos, note));
    }

    public int size() {
        return entries.size();
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    /** Returns the most recent entry with the given operation and algorithm, or null. */
    public Entry latest(String operation, String algorithm) {
        for (int i = entries.size() - 1; i >= 0; i--) {
            Entry e = entries.get(i);
            if (e.operation.equals(operation) && e.algorithm.equals(algorithm)) {
                return e;
            }
        }
        return null;
    }
}
