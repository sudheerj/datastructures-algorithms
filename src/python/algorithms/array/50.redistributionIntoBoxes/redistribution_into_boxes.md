**Description:**
You have `n` packs of apples. You are given an integer array `apples` where `apples[i]` is the number of apples in the `i`th pack. You are also given an integer array `capacity` where `capacity[j]` is the maximum number of apples that the `j`th box can hold. Return the minimum number of boxes you need to redistribute all the apples into boxes.

### Examples
**Example 1:**
Input: apples = [1, 3, 2], capacity = [4, 3, 1, 5, 2]

Output: 2

**Example 2:**
Input: apples = [5, 5, 5], capacity = [5, 5, 5]

Output: 3

**Example 3:**
Input: apples = [2, 3, 1], capacity = [10, 1, 1]

Output: 1

**Algorithmic Steps:**

This problem is solved with a **greedy approach** by always filling the largest capacity boxes first. The algorithmic approach can be summarized as follows:

1. Calculate the total number of apples using `sum(apples)`.

2. Sort the `capacity` list in descending order using `sort(reverse=True)`.

3. Initialize a counter `min_boxes` to `0` and iterate through the sorted capacity list.

4. At each step, subtract the current box's capacity from the remaining total and increment the box counter.

5. Break early once the total remaining apples is less than or equal to `0`.

6. Return `min_boxes` as the minimum number of boxes needed.

**Time and Space complexity:**

This algorithm has a time complexity of `O(m log m + n)`, where `m` is the number of boxes and `n` is the number of apple packs. Sorting the capacity list takes `O(m log m)` and summing the apples takes `O(n)`.

The space complexity is `O(1)` (excluding the space used by the sorting algorithm), as we only use a few extra variables.
