**Problem statement:**
Given two words `beginWord` and `endWord`, and a dictionary `wordList`, return **all the shortest transformation sequences** from `beginWord` to `endWord`. Each sequence is a list of words where:
- Every adjacent pair of words differs by exactly one letter.
- Every intermediate word must exist in `wordList`.

Return an empty list if no such sequence exists.

## Examples:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
(endWord "cog" not in wordList)

**Algorithmic Steps**
This problem is solved using **BFS to find shortest path distances** combined with **DFS backtracking** to reconstruct all shortest paths. A `parents` map records every valid parent for each word at its BFS level. The algorithmic approach can be summarized as follows:

1. Create the main function `findLadders(beginWord, endWord, wordList)`.

2. Load all words into a `wordSet` (HashSet). Return empty list if `endWord` is not in `wordSet`.

3. Initialize:
   - `parents` map (word → list of its BFS parents).
   - `visited` set — words seen in prior BFS levels.
   - `queue` — seeded with `beginWord`.

4. BFS level-by-level:
   1. Track `levelVisited` set for the current level only.
   2. For each word in the current level, try replacing each character with `'a'`–`'z'`.
   3. If the new word exists in `wordSet` and has NOT been seen in a previous level (`!visited.contains(nextWord)`), add it to the queue and `levelVisited`.
   4. Always record the parent: `parents.get(nextWord).add(word)` (handles multiple parents for same shortest path).
   5. If `nextWord.equals(endWord)`, set `found = true`.
   6. After processing the full level, add `levelVisited` to `visited`.
   7. Stop BFS once `found` is true.

5. DFS backtracking from `endWord` to `beginWord` using `parents` map:
   1. Start with path `[endWord]`.
   2. At each step, retrieve all parents from `parents.get(word)` and recurse.
   3. When `beginWord` is reached, reverse the path and add to result.

6. Return the result list.

**Time and Space complexity:**
This algorithm has a time complexity of `O(N × M × 26)` for BFS, where `N` is the number of words in the word list and `M` is the word length. The DFS backtracking adds a cost proportional to the number of shortest paths.

The space complexity is `O(N × M)` for the `parents` map, visited sets, and queue.
