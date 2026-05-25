**Problem statement:** Design a data structure that supports `insert(val)`, `remove(val)`, and `getRandom()` — all in average O(1) time. `getRandom` must return each element with equal probability. (LeetCode 380)

## Examples:

```
insert(1) → true   // 1 added; set = {1}
insert(1) → false  // duplicate; set = {1}
insert(2) → true   // set = {1, 2}
insert(3) → true   // set = {1, 2, 3}
remove(2) → true   // 2 removed; set = {1, 3}
remove(2) → false  // 2 not in set
remove(99)→ false  // 99 never in set
getRandom()→ 1 or 3  // equal probability from {1, 3}
```

**Algorithmic Steps:**

1. Maintain a `HashMap<val → index>` and an `ArrayList<val>` in sync.
2. **insert(val):** If val exists in the map return false. Otherwise append val to the list, store its index in the map, return true.
3. **remove(val):** If val is not in the map return false. Otherwise:
   - Get the index of val from the map.
   - Swap val with the last element in the list (overwrite index with last element).
   - Update the map to point last element to val's old index.
   - Remove the last element from the list and delete val from the map.
   - Return true.
4. **getRandom():** Return `list.get(random index in [0, list.size()))`.

**Time and Space complexity:**

| Operation | Time Complexity | Space Complexity |
|---|---|---|
| insert | O(1) average | O(n) |
| remove | O(1) average | O(n) |
| getRandom | O(1) | O(n) |
