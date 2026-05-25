**Problem statement:**
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the one number missing from the array.

## Examples:
Input: nums = [3,1,0]
Output: 2

Input: nums = [5,9,7,1,2,4,0,6,8,3]
Output: 10

**Algorithmic Steps**

Approach 1 — Sum Difference O(1) space:
1. Initialize `missing = n` (accounts for the largest possible missing value).
2. For each index `i`, add `i - nums[i]` to `missing`.
3. This accumulates `(0+1+...+(n-1)) - sum(nums)`, which equals the missing number.
4. Return `missing`.

Approach 2 — XOR O(1) space:
1. Initialize `missing = n`.
2. For each index `i`, XOR `missing` with both `i` and `nums[i]`.
3. Every number that appears in both `[0..n]` and `nums` cancels out; only the missing number remains.
4. Return `missing`.

Approach 3 — HashSet O(n) space:
1. Add all elements of `nums` to a HashSet.
2. Iterate `i` from `0` to `n`; return the first `i` not in the set.

**Time and Space complexity:**
| | Time | Space |
|---|---|---|
| Approach 1 (sum) | O(n) | O(1) |
| Approach 2 (XOR) | O(n) | O(1) |
| Approach 3 (set) | O(n) | O(n) |

Here, we don't use any additional datastructure other than variable to store missing number. Hence, the space complexity will be `O(1)`.