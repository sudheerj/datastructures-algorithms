**Description:**
Given two strings `str` and `subStr` of lengths `m` and `n` respectively, return the minimum window 
substring of `str` such that every character in `subStr` (including duplicates) is included in the window. If there is no such substring available, just return the empty string(i.e,"").

### Examples
Example 1:

Input: str = "ADOBECODEBANC", subStr = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: str = "A", subStr = "A"
Output: "A"

Example 3:
Input: str = "a", subStr = "aa"
Output: ""

**Algorithmic Steps**
This problem is solved with the help of **sliding window** approach using two hash maps. The algorithmic approach can be summarized as follows:

1. Add a preliminary corner case condition by checking the second substring is empty or not. If it is empty, then return the empty substring as minimum window substring.

2. Initialize two HashMaps(`windowStrCount` & `subStrCount`), which store unique characters and their respective character count for their given substrings.

3. Initialize `minLength` variable with maximum integer value, which is used to store the length of the minimum window substring.

4. Initialize substring boundaries(`subStrBoundaries`) variable to [-1, -1], which is used to keep track of the minimum substring window boundaries.

5. Iterate over the second substring and count the character count using respective hashmap. 

6. Initialize second substring's required character count(i.e, `required`) to the size of second hashmap and total character count(i.e, `having`) of first substring to 0. 

7. Initialize both left and right pointers to 0, to keep track of the current window substring. 

8. Iterate through first substring using right pointer until the end of string.

9. If the current character from first substring exists in second substring hashmap, update the character count of first hashmap. Also, increment `having` variable if the character count in both hashmaps are equal.

10. Iterate a nested loop until `required` and `having` variables are equal. If the current substring's length is less than minimum substring's length which is calculated so far, just update `minLength` variable with current substring length and also the substring boundaries. Thereafter, shrink (or remove the left character) the substring window and decrement the character count in first hashmap. This logic is required to find the minimum possible substring window in the first string. If the current left character found in second hashmap and first hashmap character count is less than second one, `having` variable needs to be decremented.

11. Repeat steps 9-10 until the end of the first string.

12. Return an empty string if the minimum substring length is not a maximum value. Otherwise return the substring of first string based on substring boundary index values.


**Time and Space complexity:**
This algorithm has a time complexity of `O(m) + O(n)`, where `m` and `n` represents lengths of first and second strings. This is because we are traversing both the strings. 

Also, it requires space complexity of `O(m) + O(n)` due to two hashmaps used to store the character count.