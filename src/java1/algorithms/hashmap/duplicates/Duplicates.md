**Problem statement:**
Given an integer array `nums`, find all the duplicates in the array(i.e, numbers which appear more than once). Return an empty array if there are no duplicate numbers.

## Examples:
Example 1:

Input: nums = [6, 5, 5 , 4, 3, 2, 1]
Output: [5]

Example 2: 

Input: nums = [5, 4, 4, 4, 3, 2, 1, 4, 2]
Output: [4, 2]

Example 3: 

Input: nums = [6, 5, 4, 3, 2, 1]
Output: []

**Algorithmic Steps**
This problem is solved with hashtable with elements as keys and number of occurrences as values. The algorithmic approach can be summarized as follows: 

1. Create an empty map(`numsCount`) to store the elements and their respective counts.

2. Create an empty duplicates array(`duplicates`) to list the duplicated elements.
    
3. Iterate an input array using for-each loop and update the count of an element using `put` method of map.
4. Iterate over a map which is filled with elements and their occurences. If an element appears more than once(i.e, the occurence of an element is more than 1), add it to the duplicate list.

5. Return `duplicates` as an output list with all duplicates of a given array.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where n is the number of elements in an array. This is because populating the map by iterating through an array takes `O(n)` and finding duplicates from occurences map (incase of no duplicates) takes `O(n)` time complexity. Hence, the overall time complexity is `O(n)`.

Here, we use map datastructure which is used to store upto `n` unique elements and duplicates array can store upto `n/2` elements in the worst case(if each element has duplicate). Hence, the space complexity will be `O(n)`.
