# GitHub Collaboration Guide (for the group)

The assignment needs EVIDENCE of genuine collaboration: separate branches, meaningful
commits, pull requests and merges from every member. Do NOT just upload the final project.

## 1. Group leader (one time)
1. Create a repository on GitHub, e.g. `CIT300-DataStructure-Analyzer` (add a README? choose "no").
2. Settings -> Collaborators -> add every group member.
3. On your computer, inside the project folder:
```
git init
git add .
git commit -m "Initial project structure and README"
git branch -M main
git remote add origin https://github.com/<leader-username>/CIT300-DataStructure-Analyzer.git
git push -u origin main
```
(Tip: for real evidence, push ONLY the skeleton first - README, .gitignore, InputHelper, PerformanceLog,
Main - and let each member add their own files on their own branch.)

## 2. Every member (own branch -> commits -> pull request)
```
git clone https://github.com/<leader-username>/CIT300-DataStructure-Analyzer.git
cd CIT300-DataStructure-Analyzer
git checkout -b feature/<your-component>      # e.g. feature/graph, feature/stack-queue
# ... add / edit YOUR files ...
git add src/Graph.java src/GraphMenu.java
git commit -m "Add Graph class with adjacency list, add vertex and add edge"
# make several small, meaningful commits as you work
git push -u origin feature/<your-component>
```
Then on GitHub: **Compare & pull request** -> write what you did -> another member reviews -> **Merge**.

## 3. Suggested branches (one per member)
| Member | Branch | Files |
|---|---|---|
| Muaath (23DA2-0791) | feature/array-searching | ArrayManager, SearchManager, ArrayMenu, SearchMenu |
| Rasath (23DA2-0815) | feature/stack-queue | ArrayStack, ArrayQueue, StackMenu, QueueMenu |
| Sajith (23DA2-0875) | feature/linked-list | MyLinkedList, LinkedListMenu |
| Najil (23DA2-0856) | feature/graph | Graph, GraphMenu |
| Sajith (23DA2-0875) | feature/integration | Main, InputHelper, PerformanceLog, PerformanceMenu, README |

Note: `Graph` uses `ArrayQueue` (BFS) and `ArrayStack` (DFS), so the graph member should merge the
stack/queue branch first (or `git pull origin main` after it is merged).

## 4. Good commit messages
"Add push and pop to ArrayStack", "Handle empty queue in dequeue", "Fix BFS visiting order",
"Add performance comparison table". Avoid "update", "final", "asdf".

## 5. Before submitting
- Everyone's name and Student ID is correct in README.md.
- `git log --oneline --graph --all` shows commits/branches from every member.
- Pull requests are merged into `main`.
- Record the demo video (every member's FACE visible), then submit via the LMS (see the assignment PDF, sections 10 and 16: Drive link TXT + Editor access for the two lecturer emails if required).
