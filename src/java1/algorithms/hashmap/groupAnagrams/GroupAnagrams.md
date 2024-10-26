**Problem statement:**
Given an array of strings `strs`, group the anagrams together into sublists. You can return the output in any order.

**Note:** An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Examples:
Example 1:

Input: strs = ['eat', 'tea', 'tan', 'ate', 'nat', 'bat']
Output:  [ [ 'eat', 'tea', 'ate' ], [ 'tan', 'nat' ], [ 'bat' ] ]

Example 2: 

Input: strs = ['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']
Output:  [ [ 'Eat' ], [ 'Tea' ], [ 'Tan' ], [ 'Ate' ], [ 'Nat' ], [ 'Bat' ] ]

Example 3: 

Input: strs = ['apple', 'orange', 'banana']
Output: [ [ 'apple' ], [ 'orange' ], [ 'banana' ] ]

**Algorithmic Steps**
This problem is solved with hashtable with sorted strings as keys and list of anagrams as values. The algorithmic approach can be summarized as follows: 

1. Create an empty map(`anagramGroups`) to store the list of anagrams.
    
2. Iterate an input array using for-each loop and find the sorted string for each string in an array. 
   
3. Add an empty list to the anagram map if the derived sorted string doesn't exist as a key. 
   
4. Add the current string to anagram list for the respective sorted string key.

5. Return `anagramGroups` values as list of anagram groups.


**Time and Space complexity:**
This algorithm has a time complexity of `O(K N*log N)`, where `N` is the average length of each string and `K` is the number of strings in an array. This is because sorting an each string takes `O(N*log N)` and it needs to be repeated for `K` strings. Hence, the overall complexity is `O(K N*log N)`.

Here, we use map datastructure which is used to store upto `K` strings and each string with average length of `N`. Hence, the space complexity will be `O(K * N)`.
