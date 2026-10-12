// Author / Responsibility: Member 3 - M.T.M. Rasath (23DA2-0815)
import java.util.Arrays;

/**
 * Stack (LIFO) implemented with an array. push/pop/peek are O(1)
 * (push is amortised O(1) because the array doubles when full).
 */
public class ArrayStack {
    private int[] data;
    private int top = -1;

    public ArrayStack(int capacity) {
        data = new int[Math.max(capacity, 2)];
    }

    public void push(int value) {
        if (top == data.length - 1) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[++top] = value;
    }

    /** Removes and returns the top element. Throws if the stack is empty (underflow). */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow: cannot pop from an empty stack.");
        }
        return data[top--];
    }

    /** Returns the top element without removing it. */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty: there is nothing to peek.");
        }
        return data[top];
    }

    public boolean isEmpty() { return top == -1; }
    public int size() { return top + 1; }
    public void clear() { top = -1; }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Stack is empty.");
            return;
        }
        System.out.println("  Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("   | " + String.format("%6d", data[i]) + " |" + (i == top ? "  <- TOP" : ""));
        }
        System.out.println("   +--------+");
    }
}
