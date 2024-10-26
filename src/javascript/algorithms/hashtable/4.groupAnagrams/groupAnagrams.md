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
This problem is solved with the help of hashtable using sorted strings as keys and list of anagrams as values. The algorithmic approach can be summarized as follows: 

**Approach 1**
1. Create an empty map(`anagramGroups`) to store the list of anagrams.
    
2. Iterate an input array using for-of loop and find the sorted string for each string in an array. Thereafter, fetch the angram group from the map based on sorted string as a key. 
   
3. If the group has sorted string as a key, push the current string as a new anagram to the map. Otherwise, set the anagram map with a new group of anagram.

4. Return `anagramGroups` values as array of anagram groups.

**Approach 2**
1. Create an empty object(`anagramGroups`) to store the list of anagrams.
    
2. Iterate an input array using for-of loop and find the sorted string for each string in an array. Thereafter, fetch the angram group from an object based on sorted string as a property. 
   
3. If the group contains sorted string as a object property, push the current string as a new anagram to the object. Otherwise, set the anagram map with a new group of anagram.

4. Return `anagramGroups` values as array of anagram groups.


**Time and Space complexity:**
This algorithm has a time complexity of `O(K N*log N)`, where `N` is the length of longest string and `K` is the number of strings in an array. This is because sorting an each string takes `O(N*log N)` and it needs to be repeated for `K` strings. Hence, the overall complexity is `O(K N*log N)`.

Here, we use map datastructure which is used to store upto `K` strings and each string with average length of `N`. Hence, the space complexity will be `O(K * N)`.
