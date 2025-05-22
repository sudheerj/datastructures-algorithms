**Description:**
Given an array of integers, find the third largest element in the array. If there are fewer than three unique elements, return a message indicating that there are not enough unique elements.

### Examples
Example 1:

Input: [33, 90, 10, 50, 33, 77, 90, 4]
Output: 50

Example 2:

Input: [1, 2]
Output: "There are no 3 unique elements in an array"

**Algorithmic Steps**
This problem can be solved using two different approaches:

**Approach 1: Single Pass Tracking**
1. Initialize three variables to track the first, second, and third largest elements, all set to negative infinity.
2. Iterate through each number in the array:
   - Skip if the number is equal to any of the three largest elements (to handle duplicates)
   - If the number is greater than the first largest, update all three variables accordingly
   - If the number is greater than the second largest but less than the first, update the second and third largest
   - If the number is greater than the third largest but less than the second, update only the third largest
3. After the iteration, if the third largest is still negative infinity, return a message indicating there are not enough unique elements
4. Otherwise, return the third largest element

**Approach 2: Using Set and Sort**
1. Create a Set from the array to remove duplicates
2. Convert the Set back to an array
3. If the array length is less than 3, return a message indicating there are not enough unique elements
4. Sort the array in descending order
5. Return the element at index 2 (third element)

**Time and Space complexity:**
**Approach 1 (Single Pass Tracking):**
- Time Complexity: O(n), where n is the length of the array, as we only need to iterate through the array once.
- Space Complexity: O(1), as we only use three variables regardless of the input size.

**Approach 2 (Using Set and Sort):**
- Time Complexity: O(n log n), dominated by the sorting operation.
- Space Complexity: O(n) for storing the unique elements in the Set.
