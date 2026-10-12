// Author / Responsibility: Member 3 - M.T.M. Rasath (23DA2-0815)
/**
 * Queue (FIFO) implemented as a circular array. enqueue/dequeue are O(1)
 * (enqueue is amortised O(1) because the array doubles when full).
 */
public class ArrayQueue {
    private int[] data;
    private int head = 0;
    private int count = 0;

    public ArrayQueue(int capacity) {
        data = new int[Math.max(capacity, 2)];
    }

    public void enqueue(int value) {
        if (count == data.length) {
            grow();
        }
        data[(head + count) % data.length] = value;
        count++;
    }

    /** Removes and returns the front element. Throws if the queue is empty (underflow). */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow: cannot dequeue from an empty queue.");
        }
        int value = data[head];
        head = (head + 1) % data.length;
        count--;
        return value;
    }

    /** Returns the front element without removing it. */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty: there is no front element.");
        }
        return data[head];
    }

    public boolean isEmpty() { return count == 0; }
    public int size() { return count; }
    public void clear() { head = 0; count = 0; }

    private void grow() {
        int[] bigger = new int[data.length * 2];
        for (int i = 0; i < count; i++) {
            bigger[i] = data[(head + i) % data.length];
        }
        data = bigger;
        head = 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  FRONT -> ");
        for (int i = 0; i < count; i++) {
            sb.append("[").append(data[(head + i) % data.length]).append("] ");
        }
        sb.append("<- REAR");
        System.out.println(sb);
    }
}
