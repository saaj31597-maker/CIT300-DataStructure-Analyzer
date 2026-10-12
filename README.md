# Data Structure & Graph Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2 (Week 12), 10% of final grade
**Language:** Java (console-based application)

## Project Description
A single integrated console application that demonstrates the Array, Stack, Queue,
Linked List, Searching (Linear and Binary), and Graph (BFS / DFS) components, with a
performance/complexity comparison. All data structures are implemented from scratch
(no `java.util` collections are used for Stack, Queue, Linked List or traversal logic).

## Team Members

### Member 1
- **Student Name:** S.M. Sajith (Group Leader)
- **Student ID:** 23DA2-0875
- **Assigned Responsibility:** Linked List implementation, performance comparison, main menu, integration and testing
- **Individual Contribution:**
  - Implemented `MyLinkedList` (insert at head/tail/position, delete by value / first node, search, display)
  - Implemented `LinkedListMenu`
  - Implemented `Main` (main menu and integration) and `InputHelper` (input validation)
  - Implemented `PerformanceLog` and `PerformanceMenu` (steps and time comparison, complexity explanation)
  - Implemented "Display All Results"
  - Set up the GitHub repository, merged pull requests and tested the integrated system

### Member 2
- **Student Name:** A. Muaath
- **Student ID:** 23DA2-0791
- **Assigned Responsibility:** Array and Searching implementation
- **Individual Contribution:**
  - Implemented `ArrayManager` (insert at end/position, delete by position/value, display, random sample data)
  - Implemented `SearchManager` (linear search and binary search with step counting and timing)
  - Implemented `ArrayMenu` and `SearchMenu`
  - Tested the array and searching functionality and integrated it with the main application

### Member 3
- **Student Name:** M.T.M. Rasath
- **Student ID:** 23DA2-0815
- **Assigned Responsibility:** Stack and Queue implementation
- **Individual Contribution:**
  - Implemented `ArrayStack` (push, pop, peek, display, underflow handling on an empty stack)
  - Implemented `ArrayQueue` (circular queue: enqueue, dequeue, peek/front, display, underflow handling on an empty queue)
  - Implemented `StackMenu` and `QueueMenu`
  - Tested the stack and queue functionality and integrated it with the main application

### Member 4
- **Student Name:** M.N.M. Najil
- **Student ID:** 23DA2-0856
- **Assigned Responsibility:** Graph implementation and traversal
- **Individual Contribution:**
  - Implemented `Graph` (adjacency list, add vertex, add edge, display)
  - Implemented BFS traversal (using the queue) and DFS traversal (using the stack), plus vertex search
  - Implemented `GraphMenu`
  - Tested the graph functionality and integrated it with the main application

> The integration responsibility (main menu, performance comparison, integration, testing) is combined with the
> Linked List responsibility because the group has four members. All required components are implemented.

## Technologies Used
- Java (JDK 11 or newer)
- Git and GitHub for collaboration

## Main System Features
- **Array:** insert (end / position), delete (position / value), linear search, display, random sample data
- **Stack:** push, pop, peek, display; handles underflow on an empty stack
- **Queue:** enqueue, dequeue, peek/front, display; handles underflow on an empty queue (circular array)
- **Linked List:** insert (head / tail / position), delete (value / first), search, display
- **Searching:** linear search, binary search (on a sorted copy), side-by-side comparison
- **Graph:** add vertex, add edge, display (adjacency list), BFS, DFS, vertex search, sample graph
- **Performance Comparison:** steps and execution time for Linear vs Binary search and BFS vs DFS, with an explanation of the results using Big-O complexity
- **Display All Results:** current content of every structure plus the log of all operations
- Input validation and handling of empty structures

## Project Structure
```
src/
  Main.java              main menu + integration
  InputHelper.java       validated console input
  PerformanceLog.java    stores steps/time of every operation
  ArrayManager.java      array component
  ArrayStack.java        stack component
  ArrayQueue.java        queue component
  MyLinkedList.java      linked list component
  SearchManager.java     linear and binary search
  Graph.java             graph (adjacency list, BFS, DFS)
  ArrayMenu.java  StackMenu.java  QueueMenu.java  LinkedListMenu.java
  SearchMenu.java  GraphMenu.java  PerformanceMenu.java
```

## How to Run
Requires a JDK (11+) installed (`java -version` and `javac -version` should work).

**Windows (Command Prompt / PowerShell):**
```
javac -d out src\*.java
java -cp out Main
```
Or double-click `run.bat`.

**Linux / macOS:**
```
javac -d out src/*.java
java -cp out Main
```
Or run `./run.sh`.

In VS Code: open the folder, open `src/Main.java`, and click **Run** above `main`.
