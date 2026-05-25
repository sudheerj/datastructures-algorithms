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

1. Create an empty stack.
2. For each asteroid `a` in the array:
   1. While the stack is not empty AND the top of the stack is positive AND `a` is negative (collision):
      - If `stack.top < -a`: the top asteroid is smaller → pop it and continue (current asteroid may destroy more).
      - If `stack.top == -a`: equal size → pop the top and set `a = 0`, then break.
      - If `stack.top > -a`: current asteroid is smaller → set `a = 0` and break.
   2. If `a != 0`, push `a` onto the stack (asteroid survived).
3. Convert the stack to an array (bottom → top order) and return it.

**Time and Space complexity:**
Time complexity: `O(n)` — each asteroid is pushed and popped at most once.

Space complexity: `O(n)` — the stack holds at most `n` asteroids.
