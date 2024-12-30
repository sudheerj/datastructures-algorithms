**Problem statement:**
Given a string `str`, find the index of first non-repeating(unique) character within it. If the unique character doesn't exist, return -1.

**Note:** The given string contains only lowercase English letters.

## Examples:
Example 1:

Input: str = "zeep"

Output: 0


Example 2: 

Input: str = "mama"

Output: -1


**Algorithmic Steps**
This problem is solved using a hashing data structure to find the occurrences of each character and determine the index of the first unique character in a string.

1. Define a map variable(`charCount`) to keep track of character counts.
    
2. Iterate over the given string(`str`) and store the character count.
   
3. Iterate over the string again, return the index if the character count is equals to one
   
4. Return `-1` indicating that no unique character found.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, Where `n` is the length of the string. This is because we traverse the string twice to find the index position of first unique character.

Here, it takes time complexity of `O(1)`. This is because the character count variable holds maximum of 26 lowercase characters.
