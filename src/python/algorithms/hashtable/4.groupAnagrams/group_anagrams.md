**Problem statement:**
Given an array of strings `strs`, group the anagrams together into sublists. You can return the output in any order.

**Note:** An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Examples:
Example 1:

Input: strs = ['eat', 'tea', 'tan', 'ate', 'nat', 'bat']
Output:  [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']]

Example 2: 

Input: strs = ['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']
Output:  [['Eat'], ['Tea'], ['Tan'], ['Ate'], ['Nat'], ['Bat']]

Example 3: 

Input: strs = ['apple', 'orange', 'banana']
Output: [['apple'], ['orange'], ['banana']]

**Algorithmic Steps**
This problem is solved with the help of dictionary using sorted strings as keys and list of anagrams as values. The algorithmic approach can be summarized as follows: 

1. Create an empty dictionary (`anagram_groups`) to store the list of anagrams.
    
2. Iterate through input array using for loop and find the sorted string for each string in an array. Thereafter, fetch the anagram group from the dictionary based on sorted string as a key. 
   
3. If the group has sorted string as a key, append the current string as a new anagram to the dictionary. Otherwise, set the anagram dictionary with a new group of anagram.

4. Return `anagram_groups` values as list of anagram groups.


**Time and Space complexity:**
This algorithm has a time complexity of `O(K * N log N)`, where `N` is the length of longest string and `K` is the number of strings in an array. This is because sorting each string takes `O(N log N)` and it needs to be repeated for `K` strings. Hence, the overall complexity is `O(K * N log N)`.

Here, we use dictionary data structure which is used to store up to `K` strings and each string with average length of `N`. Hence, the space complexity will be `O(K * N)`.
