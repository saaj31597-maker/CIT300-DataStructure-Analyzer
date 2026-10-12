// Author / Responsibility: Member 1 - S.M. Sajith (23DA2-0875)
/**
 * Singly linked list of integers with Insert, Delete, Search and Display.
 * Insert at head is O(1); insert at tail, delete and search are O(n).
 */
public class MyLinkedList {

    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size;
    private long lastSteps;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public long getLastSteps() { return lastSteps; }

    public void insertAtHead(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;
        lastSteps = 1;
    }

    public void insertAtTail(int value) {
        Node n = new Node(value);
        lastSteps = 0;
        if (head == null) {
            head = n;
        } else {
            Node cur = head;
            lastSteps++;
            while (cur.next != null) {
                cur = cur.next;
                lastSteps++;
            }
            cur.next = n;
        }
        size++;
    }

    /** Inserts at position (0..size). Returns false if the position is invalid. */
    public boolean insertAt(int position, int value) {
        if (position < 0 || position > size) {
            return false;
        }
        if (position == 0) {
            insertAtHead(value);
            return true;
        }
        Node cur = head;
        lastSteps = 1;
        for (int i = 0; i < position - 1; i++) {
            cur = cur.next;
            lastSteps++;
        }
        Node n = new Node(value);
        n.next = cur.next;
        cur.next = n;
        size++;
        return true;
    }

    /** Deletes the first node holding value. Returns false if not found. */
    public boolean deleteValue(int value) {
        lastSteps = 0;
        if (head == null) {
            return false;
        }
        lastSteps++;
        if (head.value == value) {
            head = head.next;
            size--;
            return true;
        }
        Node cur = head;
        while (cur.next != null) {
            lastSteps++;
            if (cur.next.value == value) {
                cur.next = cur.next.next;
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /** Deletes the first node. Throws if the list is empty. */
    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("Linked list is empty: nothing to delete.");
        }
        int v = head.value;
        head = head.next;
        size--;
        lastSteps = 1;
        return v;
    }

    /** Returns the 0-based position of value, or -1. */
    public int search(int value) {
        lastSteps = 0;
        Node cur = head;
        int pos = 0;
        while (cur != null) {
            lastSteps++;
            if (cur.value == value) {
                return pos;
            }
            cur = cur.next;
            pos++;
        }
        return -1;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void display() {
        if (head == null) {
            System.out.println("  Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  HEAD -> ");
        Node cur = head;
        while (cur != null) {
            sb.append("[").append(cur.value).append("] -> ");
            cur = cur.next;
        }
        sb.append("null   (size ").append(size).append(")");
        System.out.println(sb);
    }
}
