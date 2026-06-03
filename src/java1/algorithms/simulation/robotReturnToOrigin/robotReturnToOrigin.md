**Problem statement:** There is a robot starting at the position `(0, 0)`, the origin, on a 2D plane. Given a sequence of its moves `moves`, judge if this robot ends up at `(0, 0)` after it completes its moves. The move sequence is represented by a string, and the moves are represented by characters: `'U'` (up), `'D'` (down), `'L'` (left), and `'R'` (right).

### Examples
```
Input: moves = "UD"
Output: true
Explanation: The robot moves up once, then down once → returns to origin.
```
```
Input: moves = "LL"
Output: false
Explanation: The robot moves left twice → ends at (-2, 0), not the origin.
```
```
Input: moves = "UDLR"
Output: true
Explanation: One move in each direction → net displacement is zero.
```

**Algorithmic Steps**
1. Initialize counters `x = 0` and `y = 0` representing the robot's position.
2. Iterate over each character in `moves`:
   - `'U'` → increment `y`
   - `'D'` → decrement `y`
   - `'L'` → decrement `x`
   - `'R'` → increment `x`
3. Return `true` if `x == 0 && y == 0`, otherwise `false`.

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |

> n = length of `moves`.
