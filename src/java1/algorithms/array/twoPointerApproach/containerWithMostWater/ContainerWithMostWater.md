**Description:**
Given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`. You have to find two lines that together with the x-axis form a container, such that the container contains the most water. Return the maximum amount of water a container can store.

### Examples
Example 1:
Input: height = [3,9,4,1,5,4,7,1,7]
Output: 49

Example 2:
Input: height = [1,1]
Output: 1

**Algorithmic Steps:**
This problem is solved with the help of two pointer technique on opposite ends. The algorithmic approach can be summarized as follows:

1. Initialize maximum capacity of the container(i.e, `maxCapacity`) to zero.

2. Initialize two pointers(i.e, `left` and `right`) to represent both ends of an array.

3. Iterate an input array until left is less than right pointer.

4. Calculate the current container capacity(i.e, `area`) by the multiplication of width(difference between two indexes) and height(minimum height of two container heights).

    **Note:** The minimum height is considered because water more than minimum of container heights spill the water.

5. Find the maximum capacity of the container by taking the maximum between maximum capacity so far and the current area.

6. If the left side height is less than right side height, increment the left pointer to result in maximum capacity.

7. If the right side height is less than left side height, decrement the right pointer to result in maximum capacity.

8. Repeat steps 4-7 until all the elements traversed.

9. Return the maximum capacity of the container.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements. This is because the left or right pointer moved towards the other until they meet in each iteration, the elements are traversed once. 

Here, we don't use any additional datastructure other than two left pointer variables. Hence, the space complexity will be O(1).