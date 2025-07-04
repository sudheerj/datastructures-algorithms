**Description:**
Given `n` counters, perform a sequence of operations. Each operation is either an increase of a specific counter by 1, or a 'max counter' operation that sets all counters to the maximum value of any counter. Return the state of the counters after all operations.

**Note:** The counters are initially set to 0. Operations are given as an array of integers. If the value is between 1 and n, increment that counter. If the value is n+1, perform the 'max counter' operation.

### Examples
Example 1:

Input: n = 4, operations = [1, 4, 4, 5, 2, 4, 4]
Output: [2, 3, 2, 4]

Example 2:

Input: n = 3, operations = [1, 2, 1, 3]
Output: [2, 1, 1]

Example 3:

Input: n = 2, operations = [3, 3, 3]
Output: [0, 0]

**Algorithmic Steps**
This problem is solved efficiently using a lazy update strategy:

1. Initialize an array `counters` of size `n` with zeros.
2. Track the current maximum value and the last update value.
3. For each operation:
   - If the operation is between 1 and n, update the corresponding counter, applying any deferred max updates.
   - If the operation is n+1, defer the update by recording the current max value.
4. After all operations, update any counters that are below the last deferred max value.
5. Return the counters array.

**Time and Space complexity:**
- Time complexity: `O(m + n)`, where `m` is the number of operations and `n` is the number of counters.
- Space complexity: `O(n)`.

