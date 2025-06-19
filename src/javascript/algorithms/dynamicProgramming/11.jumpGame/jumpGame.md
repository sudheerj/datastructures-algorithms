**Description:**

Given an array `nums` where each element represents your maximum jump length at that position, return `true` if you can reach the last index starting from the first index, or `false` otherwise.

**Edge Cases:**
- Single element: Always true.
- First element is 0 and length > 1: False.
- All zeros except first: Only true if length is 1.
- Large arrays: Use greedy for efficiency.

## Examples

**Example 1:**
```
Input: nums = [2,3,1,1,4]
Output: true
Explanation: You can reach the end.
```

**Example 2:**
```
Input: nums = [3,2,1,0,4]
Output: false
Explanation: Stuck at index 3.
```

**Example 3 (Edge):**
```
Input: nums = [0]
Output: true
```

**Example 4 (Edge):**
```
Input: nums = [1,2,0,1]
Output: true
```

## Algorithm steps
This problem can be solved using **dynamic programming** or a more efficient **greedy** approach.

#### 1. Dynamic Programming (DP)

1. (DP) Use a boolean array `dp` where `dp[i]` is true if index `i` is reachable.
2. For each index, check if it can be reached from any previous index with a valid jump.
3. Return `dp[nums.length - 1]`.

#### 2. Greedy Approach

1. Track the furthest index you can reach.
2. For each index, if it's within the furthest reach, update the reach.
3. If you reach or pass the last index, return true.
4. If you finish the loop without reaching the end, return false.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n ^ 2)`, where `n` is the number of elements. This is because we need to traverse each element and find the jump status from the starting position.

Here, we are using `dp` array to store the jump status for each element. Hence, the space complexity will be `O(n)`.


| Approach | Time Complexity | Space Complexity | Notes                |
| -------- | --------------- | ---------------- | -------------------- |
| DP       | O(n^2)          | O(n)             | Simple, not optimal  |
| Greedy   | O(n)            | O(1)             | Best for large input |

