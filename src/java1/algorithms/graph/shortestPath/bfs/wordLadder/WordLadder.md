# Word Ladder

## Problem
Given two words `beginWord` and `endWord`, and a dictionary `wordList`, return the **number of words in the shortest transformation sequence** from `beginWord` to `endWord`, or `0` if no such sequence exists.

Rules:
- Every adjacent pair of words differs by exactly one letter.
- Every intermediate word must be in `wordList`.

LeetCode: https://leetcode.com/problems/word-ladder/

---

## Approach

**BFS (level-by-level) — O(n × m × 26) / O(n)**

Each BFS level represents one transformation step. For each word dequeued, try replacing every character with `'a'`–`'z'`. If the new word is in the dictionary set, enqueue it and remove it from the set (to avoid revisiting). Increment `steps` after each full level.

---

## Steps

1. Return `0` if `endWord` is not in `wordList`.
2. Add all words to a `HashSet`. Enqueue `beginWord`. `steps = 1`.
3. BFS level by level:
   - For each word in the current level, if it equals `endWord` return `steps`.
   - Try all single-char substitutions; enqueue and remove valid neighbors.
   - After processing the full level, `steps++`.
4. Return `0` (no path found).

---

## Example

```
beginWord="hit", endWord="cog"
wordList=["hot","dot","dog","lot","log","cog"]

Level 1 (steps=1): hit
  → hot ✓
Level 2 (steps=2): hot
  → dot ✓, lot ✓
Level 3 (steps=3): dot, lot
  → dog ✓, log ✓
Level 4 (steps=4): dog, log
  → cog ✓
Level 5 (steps=5): cog == endWord → return 5
```

---

## Test Cases

| beginWord | endWord | wordList                              | output |
|-----------|---------|---------------------------------------|--------|
| "hit"     | "cog"   | ["hot","dot","dog","lot","log","cog"] | 5      |
| "hit"     | "cog"   | ["hot","dot","dog","lot","log"]       | 0      |
| "hot"     | "hot"   | ["hot"]                               | 1      |
| "ab"      | "cb"    | ["cb"]                                | 2      |
| "hit"     | "xyz"   | ["hot","dot","dog"]                   | 0      |

---

## Complexity

| | Time | Space |
|-|------|-------|
| BFS | O(n × m × 26) | O(n) |

`n` = number of words, `m` = word length
