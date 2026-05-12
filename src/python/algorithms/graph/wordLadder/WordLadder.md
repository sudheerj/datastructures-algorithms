# Word Ladder

## Problem
Given two words `begin_word` and `end_word`, and a dictionary `word_list`, return the **number of words in the shortest transformation sequence**, or `0` if none exists.

LeetCode: https://leetcode.com/problems/word-ladder/

---

## Approach

**BFS level-by-level — O(n × m × 26) / O(n)**

Each BFS level = one transformation step. For each word, try replacing every character with `a`–`z`. Enqueue valid neighbors and remove from the set to prevent revisiting. Increment `steps` after each level.

---

## Steps

1. Return `0` if `end_word` not in `word_set`.
2. BFS from `begin_word`, `steps = 1`.
3. Per level: if word == `end_word` return `steps`; try all substitutions; enqueue & remove valid ones.
4. `steps += 1` after each level. Return `0` if queue empties.

---

## Example

```
begin="hit", end="cog", list=["hot","dot","dog","lot","log","cog"]

steps=1: hit → hot
steps=2: hot → dot, lot
steps=3: dot→dog, lot→log
steps=4: dog→cog  → found! return 5
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
