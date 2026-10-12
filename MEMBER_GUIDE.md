# Member Guide: what each person must know, show and say in the video

Every member must be able to explain their OWN part. The video section for each person follows:
**face visible -> introduction -> responsibility -> show code -> run demo -> explain concept ->
complexity/performance -> integration with the complete system.** (Total video < 15 minutes: about 3 minutes each.)

Introduction line: *"Hi, I'm <name>, student ID <ID>. My responsibility was <component>."*

---
## Member 1 - S.M. Sajith (23DA2-0875): Linked List + Main menu + Performance + Integration
**Files:** `MyLinkedList`, `LinkedListMenu`, `Main`, `InputHelper`, `PerformanceLog`, `PerformanceMenu`
**Concept:** A singly linked list is a chain of nodes (`value`, `next`). No shifting is needed, but you must walk the chain to reach a position.
**Show/demo:** menu 4: insert at head (10), insert at tail (20), insert at position 1 (15), search 20, delete by value, delete first, display. Then menu 7 -> run both benchmarks -> show table -> "Explain the Results". Then menu 8 (Display All Results).
**Complexity:** insert at head O(1); insert at tail, delete by value, search O(n). Linear search O(n) vs binary search O(log n); BFS/DFS O(V+E).
**Explain:** `InputHelper` validates input so wrong input never crashes the program. `PerformanceLog` stores steps/time for every operation. `Main` creates one object of each structure and passes it to the menus (integration).
**Likely questions:** Why is insert at head O(1) but at tail O(n)? Why do the step counts of linear and binary search differ so much? Why is measured time noisy but step count exact?

## Member 2 - A. Muaath (23DA2-0791): Array + Searching
**Files:** `ArrayManager`, `SearchManager`, `ArrayMenu`, `SearchMenu`
**Concept:** Array = contiguous fixed-size block; insert/delete in the middle must SHIFT elements. Linear search checks one by one; binary search needs SORTED data and halves the range each step.
**Show/demo:** menu 1: load random data, insert at end, insert at position, delete by position/value, linear search (found + not found), display. Menu 5: option 3 (compare linear vs binary on the same array and key).
**Complexity:** access O(1); insert/delete O(n) (shifting); linear search O(n); binary search O(log n) (sorted only).
**Likely questions:** Why does binary search use a sorted copy? What happens when the array is full? What is the worst case of linear search?

## Member 3 - M.T.M. Rasath (23DA2-0815): Stack + Queue
**Files:** `ArrayStack`, `ArrayQueue`, `StackMenu`, `QueueMenu`
**Concept:** Stack = LIFO (last in, first out) using an array and a `top` index. Queue = FIFO (first in, first out) using a CIRCULAR array with `head` and `count`, so dequeue does not shift elements.
**Show/demo:** menu 2: pop on empty stack (show the Underflow message), push 5, 7, 9, peek, pop, display. Menu 3: dequeue on empty queue (message), enqueue 4, 9, 2, peek/front, dequeue, display.
**Complexity:** push, pop, peek, enqueue, dequeue are O(1) (amortised O(1) when the array doubles). Real uses: undo/browser history (stack), print/task scheduling (queue).
**Integration:** the graph uses these classes: BFS uses `ArrayQueue`, DFS uses `ArrayStack`.
**Likely questions:** Why a circular queue? What happens when the stack/queue is full (array doubles)? Why is the order of removal different?

## Member 4 - M.N.M. Najil (23DA2-0856): Graph
**Files:** `Graph`, `GraphMenu`
**Concept:** Graph = vertices + edges. This one is undirected and stored as an ADJACENCY LIST (each vertex has a list of neighbours), which uses less memory than a matrix for sparse graphs. BFS (queue) explores level by level; DFS (stack) goes deep first then backtracks.
**Show/demo:** menu 6: option 7 (load sample graph), display, BFS from A (A B C D E F), DFS from A (A B D C E F), search vertex F, add vertex G and edge G-A, try invalid input (missing vertex, duplicate edge).
**Complexity:** BFS and DFS O(V+E); add vertex O(1)-O(V) (duplicate check), add edge O(degree). Steps = vertices visited + edges examined.
**Integration:** uses `ArrayQueue` and `ArrayStack` from Member 3; the performance menu runs BFS vs DFS on this graph.
**Likely questions:** Why different orders for BFS and DFS? Adjacency list vs matrix? How do you avoid infinite loops in cycles (visited array)?

---
## Video checklist
- Each member's FACE visible during their section (not only screen/code/voice).
- One merged video, less than 15 minutes.
- Show the GitHub repository briefly (branches, commits, pull requests).
