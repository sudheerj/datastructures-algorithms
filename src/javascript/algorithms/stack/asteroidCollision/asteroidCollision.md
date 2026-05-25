**Problem statement:**
You are given an array `asteroids` of integers representing asteroids in a row. For each asteroid, the absolute value represents its size, and the sign represents its direction (`+` = moving right, `-` = moving left). All asteroids move at the same speed.

Find the state of the asteroids after all collisions. When two asteroids meet, the smaller one explodes. If both are the same size, both explode. Two asteroids moving in the same direction never meet.

## Examples:
Input: asteroids = [5, 10, -5]
Output: [5, 10]
(-5 collides with 10; 10 is larger so -5 is destroyed)

Input: asteroids = [8, -8]
Output: []
(Equal size — both destroyed)

Input: asteroids = [10, 2, -5]
Output: [10]
(-5 destroys 2, then collides with 10 but is destroyed since |-5| < 10)

Input: asteroids = [-2, -1, 1, 2]
Output: [-2, -1, 1, 2]
(No collisions: left-movers are already to the left of right-movers)

**Algorithmic Steps**

1. Create an empty array `stack`.
2. For each asteroid `a` in the array:
   1. While `stack` is not empty AND `stack[top] > 0` AND `a < 0` (collision):
      - If `stack[top] < -a`: top is smaller → pop and continue.
      - If `stack[top] === -a`: equal → pop top, set `a = 0`, break.
      - Else: current is smaller → set `a = 0`, break.
   2. If `a !== 0`, push `a` onto the stack.
3. Return the stack.

**Time and Space complexity:**
Time complexity: `O(n)` — each asteroid is pushed and popped at most once.

Space complexity: `O(n)` — the stack holds at most `n` asteroids.
