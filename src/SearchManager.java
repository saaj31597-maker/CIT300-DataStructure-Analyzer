// Author / Responsibility: Member 2 - A. Muaath (23DA2-0791)
import java.util.Arrays;

/**
 * Searching algorithms. Each method counts the number of comparisons (steps)
 * and measures the execution time so the algorithms can be compared.
 */
public class SearchManager {

    public static class Result {
        public final int index;      // position found, or -1
        public final long steps;     // number of comparisons
        public final long nanos;     // execution time in nanoseconds

        Result(int index, long steps, long nanos) {
            this.index = index;
            this.steps = steps;
            this.nanos = nanos;
        }
    }

    /** Linear search: checks every element one by one. Time O(n). */
    public static Result linearSearch(int[] arr, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) {
                found = i;
                break;
            }
        }
        return new Result(found, steps, System.nanoTime() - start);
    }

    /** Binary search: requires a SORTED array; halves the range every step. Time O(log n). */
    public static Result binarySearch(int[] sorted, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int low = 0, high = sorted.length - 1, found = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sorted[mid] == key) {
                found = mid;
                break;
            } else if (sorted[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new Result(found, steps, System.nanoTime() - start);
    }

    public static int[] sortedCopy(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }
}
