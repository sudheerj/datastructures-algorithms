**Description:**
Given a list of `[student_id, score]` pairs, for each student compute the average of their **top 5 scores** (integer floor division). Return `[[id, avg], ...]` sorted in ascending order by student id.

Each student is guaranteed to have at least 5 scores.

### Examples

**Example 1:**
```
Input:  [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[2,100],[1,87],[1,100],[2,76]]
Output: [[1,87],[2,88]]
```
Explanation:
- Student 1 top-5: [65,87,91,92,100] → avg = 435/5 = 87
- Student 2 top-5: [76,77,93,97,100] → avg = 443/5 = 88

**Example 2:**
```
Input:  [[1,90],[1,80],[1,70],[1,60],[1,50]]
Output: [[1,70]]
```
Explanation: Only one student; sum = 350, avg = 70.

**Example 3:**
```
Input:  [[1,100],[1,100],[1,100],[1,100],[1,100],[1,1]]
Output: [[1,100]]
```
Explanation: Lowest score (1) is dropped; top-5 are all 100.

**Example 4:**
```
Input:  [[1,88],[1,89],[1,90],[1,91],[1,92]]
Output: [[1,90]]
```
Explanation: sum = 450, avg = 90.

**Example 5:**
```
Input:  [[3,80],[3,80],[3,80],[3,80],[3,80],[1,60],[1,60],[1,60],[1,60],[1,60]]
Output: [[1,60],[3,80]]
```
Explanation: Result sorted by student id regardless of input order.

**Algorithmic Steps**
This problem is solved using a **min-heap of fixed size 5** per student.

1. Iterate through all `[id, score]` pairs.
2. For each student, maintain a `PriorityQueue` (min-heap) capped at size 5:
   - Offer the current score.
   - If `pq.size() > 5`, poll — evicts the lowest score, keeping only the top 5.
3. After processing all pairs, for each student (iterated via `TreeMap` for sorted order):
   - Drain the heap and accumulate the sum.
   - Compute `sum / 5` (integer division).
4. Return `result[][]`.

**Complexity**
- Time: O(n log 5) = O(n), where n is the number of `[id, score]` pairs.
- Space: O(k), where k is the number of distinct student ids.
