**Problem statement:**
Given a string `str`, find the first non-repeating character in it and return its index position. If it does not exist, return -1.

## Examples:
Example 1:

Input: str = "abcdefgh"
Output: a

Example 2: 

Input: str = "abccddefgggh"
Output: a

Example 3: 

Input: str = "aabbccdddeeeff"
Output: null

Example 4: 

Input: str = ""
Output: null

**Algorithmic Steps**
This problem is solved with hashtable with elements as keys and number of occurrences as values. The algorithmic approach can be summarized as follows: 

**Approach 1**
1. Add a base case check, returning `null` if the given string is empty.
   
2. Create an empty map(`charCountsMap`) to store the elements and their respective counts.
    
3. Iterate an input array using for-of loop and update the count of an element using `set` method of map.
4. Iterate over a map which is filled with elements and their occurences. If an element appears only once(i.e, the occurence of an element is equals to 1), return its key as first unique character in the string.

5. Return `null` at the end of the function indicating that there are no unique characters.

**Approach 2**
1. Add a base case check, returning `null` if the given string is empty.

2. Create an empty object(`charCountsObj`) to store the elements and their respective counts.

3. Create an empty duplicates array(`duplicates`) to list the duplicated elements.
    
3. Iterate an input array using for-of loop and update the count of an element in an object.
   
4. Iterate over an object which is filled with elements and their occurences. If an element appears more than once(i.e, the occurence of an element is equals to 1), return object's property as first unique character in the string.

5. Return `null` at the end of the function indicating that there are no unique characters.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where n is the number of elements in an array. This is because populating the map by iterating through an array takes `O(n)` and finding unique character from occurences map(incase of no duplicates) takes `O(n)` time complexity. Hence, the overall time complexity is `O(n)`.

Here, we use map datastructure which is used to store upto `n` unique elements. Hence, the space complexity will be `O(n)`.
