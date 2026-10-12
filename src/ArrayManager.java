// Author / Responsibility: Member 2 - A. Muaath (23DA2-0791)
import java.util.Arrays;
import java.util.Random;

/**
 * Fixed-capacity array with Insert, Delete, Search and Display operations.
 * Insert/Delete shift elements, so they take O(n) time in the worst case.
 */
public class ArrayManager {
    private int[] data;
    private int size;
    private long lastSteps;

    public ArrayManager(int capacity) {
        data = new int[capacity];
    }

    public int size() { return size; }
    public int capacity() { return data.length; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }
    public long getLastSteps() { return lastSteps; }

    /** Inserts value at index (0..size). Elements to the right are shifted. */
    public boolean insertAt(int index, int value) {
        if (isFull() || index < 0 || index > size) {
            return false;
        }
        lastSteps = 0;
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
            lastSteps++;
        }
        data[index] = value;
        size++;
        lastSteps++;
        return true;
    }

    public boolean insertEnd(int value) {
        return insertAt(size, value);
    }

    /** Deletes the element at index (0..size-1). Elements to the right are shifted left. */
    public boolean deleteAt(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        lastSteps = 0;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            lastSteps++;
        }
        size--;
        lastSteps++;
        return true;
    }

    /** Deletes the first occurrence of value. Returns the index it was found at, or -1. */
    public int deleteValue(int value) {
        int found = -1;
        long compares = 0;
        for (int i = 0; i < size; i++) {
            compares++;
            if (data[i] == value) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            lastSteps = compares;
            return -1;
        }
        deleteAt(found);
        lastSteps += compares;
        return found;
    }

    /** Returns a copy of the stored elements (length == size). */
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public void clear() {
        size = 0;
    }

    /** Replaces the content with 'count' random values between 1 and maxValue. */
    public void fillRandom(int count, int maxValue) {
        clear();
        Random r = new Random();
        for (int i = 0; i < count && !isFull(); i++) {
            data[size++] = r.nextInt(maxValue) + 1;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  Index : ");
        StringBuilder vals = new StringBuilder("  Value : ");
        for (int i = 0; i < size; i++) {
            sb.append(String.format("%5d", i));
            vals.append(String.format("%5d", data[i]));
        }
        System.out.println(sb);
        System.out.println(vals);
        System.out.println("  (size " + size + " / capacity " + data.length + ")");
    }
}
