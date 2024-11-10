**Description:**
Given an array of integers `flowerbed` in which some of the plots are planted, and others are not considering the fact that flowers cannot be planted in adjacent plots. Here, the number `0` represent an empty plot and `1` represent non-empty plot. Return `true` if `n` new flowers can be planted inside flowerbed without violating the adjaceny plots rule.

### Examples
Example 1:

Input: flowerbed = [1,0,0,1], n = 1
Output: false

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 3:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

**Algorithmic Steps**
This problem is solved with the help of iteration over an array and compare adjacent elements. The algorithmic approach can be summarized as follows:

1. Create a function(`canPlaceFolowers`) by accepting flower bed array(`flowerbed`) and number of flowers to plant(`n`).

2. Initialize the counting variable(`count`) to determine number of flowers can be planted.

3. Iterate over the array and compare each value with their adjacent values if the current value is 0. 
    1. If either the adjancent value is zero or a boundary value(i.e, first or last element in an array), the flower bed can be planted with a flower by updating it's value to 1. The counter can be incremented. 

    2. Perform a early exit by returning `true` if the count is greater than or equal to given number `n`.
   
    3. Skip the next iteration by incrementing index variable(`i`). Since the flower is planted at the current position, it won't be planted for next adjacent position.
   
 4. After completion of iteration, return expression `count >=n` to indicate given number of flowers can be planted or not.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most once.
 
It takes constant time complexity of `O(1)` due to no additional datastructure been used other than counting variable.