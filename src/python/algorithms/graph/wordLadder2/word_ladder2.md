**Problem statement:**
Given two words `begin_word` and `end_word`, and a dictionary `word_list`, return **all the shortest transformation sequences** from `begin_word` to `end_word`. Each sequence is a list of words where:
- Every adjacent pair of words differs by exactly one letter.
- Every intermediate word must exist in `word_list`.

Return an empty list if no such sequence exists.

## Examples:
Input: begin_word = "hit", end_word = "cog", word_list = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]

Input: begin_word = "hit", end_word = "cog", word_list = ["hot","dot","dog","lot","log"]
Output: []
(end_word "cog" not in word_list)

**Algorithmic Steps**
This problem is solved using **BFS to find shortest path distances** combined with **DFS backtracking** to reconstruct all shortest paths. A `parents` defaultdict records every valid parent for each word at its BFS level. The algorithmic approach can be summarized as follows:

1. Create the main function `find_ladders(begin_word, end_word, word_list)`.

2. Load all words into a `word_set` (set). Return empty list if `end_word` is not in `word_set`.

3. Initialize:
   - `parents` — `defaultdict(list)` mapping word → list of its BFS parents.
   - `visited` set — words seen in prior BFS levels.
   - `queue` — `deque` seeded with `begin_word`.

4. BFS level-by-level:
   1. Track `level_visited` set for the current level only.
   2. For each word in the current level, try replacing each character with `'a'`–`'z'`.
   3. If the new word exists in `word_set` and has NOT been seen in a previous level, add it to the queue and `level_visited`.
   4. Always record the parent: `parents[next_word].append(word)` (handles multiple parents for same shortest path).
   5. If `next_word == end_word`, set `found = True`.
   6. After processing the full level, union `level_visited` into `visited`.
   7. Stop BFS once `found` is true.

5. DFS backtracking from `end_word` to `begin_word` using `parents`:
   1. Start with path `[end_word]`.
   2. At each step, retrieve all parents from `parents.get(word, [])` and recurse.
   3. When `begin_word` is reached, reverse the path and append to result.

6. Return the result list.

**Time and Space complexity:**
This algorithm has a time complexity of `O(N × M × 26)` for BFS, where `N` is the number of words in the word list and `M` is the word length. The DFS backtracking adds a cost proportional to the number of shortest paths.

The space complexity is `O(N × M)` for the `parents` map, visited sets, and deque.
