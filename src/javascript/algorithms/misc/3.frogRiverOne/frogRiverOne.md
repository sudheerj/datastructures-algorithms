**Description:**
Given a destination position and a list of positions where leaves fall over time, find the earliest time when the frog can jump to the other side of the river by stepping on leaves at every position from 1 to destinationPosition.

### Examples
Example 1:

Input: destinationPosition = 5, positionsList = [1, 3, 1, 4, 2, 3, 5, 4]
Output: 6

Example 2:

Input: destinationPosition = 3, positionsList = [1, 3, 1, 1]
Output: -1

Example 3:

Input: destinationPosition = 1, positionsList = [1]
Output: 0

Example 4:

Input: destinationPosition = 3, positionsList = [3, 2, 1]
Output: 2

Example 5:

Input: destinationPosition = 2, positionsList = [1, 1, 1, 2]
Output: 3

**Algorithmic Steps**
This problem is solved using a set to track unique positions:

1. Initialize an empty set to store positions where leaves have fallen.
2. Iterate through the positionsList:
   - Add the current position to the set.
   - If the set size equals destinationPosition, return the current time (index).
3. If the loop ends without covering all positions, return -1.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the length of positionsList.
- Space complexity: `O(destinationPosition)`. 