**Problem statement:** Given a source point `(sx, sy)` and a target point `(tx, ty)`, return `true` if you can reach `(tx, ty)` from `(sx, sy)` using any sequence of moves where each move transforms `(x, y)` into either `(x + y, y)` or `(x, x + y)`.

LeetCode #780

### Examples

```
Input:  sx=1, sy=1, tx=3, ty=5
Output: true
Explanation: (1,1) → (1,2) → (1,3) → (1,4) → (1,5)? No. Backward: (3,5) → (3,2) → (1,2) → (1,1) ✓
```

```
Input:  sx=1, sy=1, tx=2, ty=2
Output: false
Explanation: No path exists from (1,1) to (2,2)
```

```
Input:  sx=2, sy=3, tx=8, ty=3
Output: true
Explanation: Backward: ty==sy=3 is fixed; (8-2)%3 == 0 ✓
```

**Algorithmic Steps (Backward Simulation)**

1. Work backwards from `(tx, ty)` toward `(sx, sy)`.
2. While `tx >= sx` and `ty >= sy`:
   - If `tx == sx` and `ty == sy`, return `true`.
   - If `tx > ty`:
     - If `ty == sy` (y is already at source), return `(tx - sx) % ty == 0`.
     - Otherwise `tx = tx % ty`.
   - Else:
     - If `tx == sx` (x is already at source), return `(ty - sy) % tx == 0`.
     - Otherwise `ty = ty % tx`.
3. Return `false`.

| Complexity | Value |
|------------|-------|
| Time       | O(log(max(tx, ty))) |
| Space      | O(1)  |
